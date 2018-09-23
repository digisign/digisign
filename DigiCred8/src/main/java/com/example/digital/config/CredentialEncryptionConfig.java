package com.example.digital.config;

import com.example.digital.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Configuration
public class CredentialEncryptionConfig {

    @Autowired
    private UserRepository credentialRepository;
    private static final Random RANDOM = new SecureRandom();
    private static final Logger LOGGER = LoggerFactory.getLogger(CredentialEncryptionConfig.class);


    public static byte[] getNextSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }

    public String getHashedPassword(String salt,String username, String password) {
        String saltedPassword = salt +username+ password;
        String hashedPassword = generateHash(saltedPassword);
        return hashedPassword;
    }

    public static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'a', 'b', 'c', 'd', 'e', 'f' };
            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("error generating hash for {}", input);
        }
        return hash.toString();
    }

}

