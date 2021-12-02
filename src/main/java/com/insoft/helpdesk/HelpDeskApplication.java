package com.insoft.helpdesk;

import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class HelpDeskApplication {

    public static void main(String[] args){
        SpringApplication.run(HelpDeskApplication.class, args);
    }

}
