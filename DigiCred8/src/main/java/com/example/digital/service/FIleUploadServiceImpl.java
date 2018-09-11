package com.example.digital.service;

import com.example.digital.common.FileType;
import com.example.digital.util.FileUploadUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class FIleUploadServiceImpl implements FileUploadService {


    @Value("${documenstPath}")
    private String documentsPath;

    public String uploadFile(File file) throws Exception {
        String homeDir = System.getProperty("user.home");
        Path path = Paths.get(homeDir + "/" + documentsPath);
        if (!Files.exists(path)) {
            File directory = new File(String.valueOf(path));
            directory.mkdir();
        }

        String fileName= FilenameUtils.getBaseName(file.getName());
        String fileType=FilenameUtils.getExtension(file.getName());
        Path p = Files.copy(file.toPath(),
                (new File(path + "/" + fileName+ "_" + new Date().getTime()+"."+fileType)).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        return p.getFileName().toString();
    }

    public String getThumbNail(File sourceFile) throws IOException {
        String fileType = FilenameUtils.getExtension(sourceFile.getName());
        String homeDir = System.getProperty("user.home");
        String destinationDir = homeDir + "/digisignThumdNailFiles/";
        File destinationFile = new File(destinationDir);
        BufferedImage bufferedImage = null;
        String fileName = FilenameUtils.getBaseName(sourceFile.getName());
        if (!destinationFile.exists()) {
            destinationFile.mkdir();
        }
        if (FileType.JPG.getFileType().equals(fileType) || FileType.PNG.getFileType().equals(fileType)) {
            bufferedImage = getImage(sourceFile);
        } else if (FileType.PDF.getFileType().equals(fileType)) {
            bufferedImage=getImageFromPdf(sourceFile);
        }
        File outputfile = new File(destinationDir + fileName+"_"+new Date().getTime()+ ".png");
        ImageIO.write(bufferedImage, "png", outputfile);
        System.out.println("Converted Images are saved at -> " + destinationFile.getAbsolutePath());
        return outputfile.getName();
    }

    private BufferedImage getImage(File sourceFile) throws IOException {
        BufferedImage image = ImageIO.read(new FileInputStream(sourceFile));
        image.getScaledInstance(200, 300, BufferedImage.SCALE_SMOOTH);
        return image;
    }

    private BufferedImage getImageFromPdf(File sourceFile)throws IOException{
        PDDocument document = PDDocument.load(new FileInputStream(sourceFile));
        List<PDPage> list = document.getDocumentCatalog().getAllPages();
        PDPage firstPage = list.get(0);
        BufferedImage image = firstPage.convertToImage();
        image.getScaledInstance(200, 300, BufferedImage.SCALE_SMOOTH);
        document.close();
        return image;
    }

    public Map<String,List<String>> uploadFiles(MultipartFile[] multipartFiles) throws Exception {

        List<MultipartFile> multipartFileList = Arrays.asList(multipartFiles);
        List<String> filePaths = new ArrayList<>();
        List<String> thumbNailPaths=new ArrayList<>();
        for (MultipartFile multipartFile : multipartFileList) {
            File recipientsFile = FileUploadUtil.frameFileData(multipartFile);
            filePaths.add(uploadFile(recipientsFile));
            thumbNailPaths.add(getThumbNail(recipientsFile));
            FileUploadUtil.clearTempFiles(new File[]{recipientsFile});
        }
        Map<String,List<String>> paths=new HashMap<>();
        paths.put("filePaths",filePaths);
        paths.put("thumbNailPaths",thumbNailPaths);
        return paths;
    }

}