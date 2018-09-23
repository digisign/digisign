package com.example.digital.exception;

import java.util.UUID;

public class ErrorDetails {

        private UUID id;
        private String timestamp;
        private String requestURL;
        private String requestMethod;
        private String error;

        public ErrorDetails(UUID id, String timestamp, String requestURL, String requestMethod, String error) {
            super();
            this.id = id;
            this.timestamp = timestamp;
            this.requestURL = requestURL;
            this.requestMethod = requestMethod;
            this.error = error;
        }

        public UUID getId() {
            return id;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public String getRequestURL() {
            return requestURL;
        }

        public String getRequestMethod() {
            return requestMethod;
        }

        public String getError() {
            return error;
        }
}

