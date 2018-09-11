package com.example.digital.common;

public enum FileType {

        PNG("png"),JPG("jpg"),PDF("pdf");

        private String fileType;
        FileType(String fileType){
            this.fileType = fileType;
        }

        public String getFileType() {
            return fileType;
        }

}
