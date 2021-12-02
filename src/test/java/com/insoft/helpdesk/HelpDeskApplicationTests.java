package com.insoft.helpdesk;

import io.minio.MinioClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HelpDeskApplicationTests {

    @Test
    void contextLoads() {
        MinioClient minioClient = MinioClient.builder().endpoint("http://172.30.88.12:8888").credentials("minioadmin", "minioadmin").build();
    }

}
