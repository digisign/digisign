package com.example.digital.service;

import com.example.digital.common.FileType;
import com.example.digital.entity.FilePath;
import com.example.digital.util.FileUploadUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
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

    @Value("${thumbNailsPath}")
    private String thumbNailPath ;

    public File uploadFile(MultipartFile multipartFile) throws Exception {
        String homeDir = System.getProperty("user.home");
        Path path = Paths.get(homeDir + "/" + documentsPath);
        if (!Files.exists(path)) {
            File directory = new File(String.valueOf(path));
            directory.mkdir();
        }
        String fileName= FilenameUtils.getBaseName(multipartFile.getOriginalFilename());
        String fileType=FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        File file = new File(path + "/" + fileName+ "_" + new Date().getTime()+"."+fileType);
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }


    public String getThumbNail(File sourceFile) throws IOException {
        String fileType = FilenameUtils.getExtension(sourceFile.getName());
        String homeDir = System.getProperty("user.home");

        String destinationDir = homeDir + thumbNailPath;
        File destinationFile = new File(destinationDir);
        BufferedImage bufferedImage = null;
        String fileName = FilenameUtils.getBaseName(sourceFile.getName());
        fileName=fileName.substring(0,fileName.lastIndexOf("_"));

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

    public List<FilePath> uploadFiles(MultipartFile[] multipartFiles) throws Exception {

        List<MultipartFile> multipartFileList = Arrays.asList(multipartFiles);
        List<FilePath> filePaths = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFileList) {
            FilePath  filePath=new FilePath();
            File file=uploadFile(multipartFile);
            filePath.setFilePath(file.getName());
            filePath.setThumbNailPath(getThumbNail(file));
            filePaths.add(filePath);
        }

        return filePaths;
    }

    public byte[] getDocument(String downloadLink,boolean isThumbNail) throws Exception {
        String homeDir = System.getProperty("user.home");
        String fileUpload= documentsPath;
        if(!isThumbNail){
            fileUpload= documentsPath;
        }else{
            fileUpload= thumbNailPath;
        }
        return IOUtils.toByteArray(new FileInputStream(new File(homeDir + "/" + fileUpload + "/" + downloadLink)));
    }

}