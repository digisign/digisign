package com.example.digital.common;

    public enum ExcelColumns {

        EMAIL("email"),
        LASTNAME("lastname"),
        FIRSTNAME("firstname"),
        LINKEDINURL("linkedinurl"),
        PHONENUMBER("phonenumber");
       // STARTDATE("startdate"),
       // ENDDATE("enddate"),
       // BATCHNAME("batchname");

        private String colName;

        ExcelColumns(String name) {
            this.colName = name;
        }

        public String getColName() {
            return colName;
        }
    }

