package com.insoft.helpdesk.control.index;

import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@Slf4j
public class IndexController {

    final
    IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }


    @GetMapping(value = "/")
    public ModelAndView mainPage() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Redis", indexService.redisIsConnection());
        modelAndView.addObject("Postgresql", indexService.getTestModel());
        modelAndView.addObject("Minio", indexService.getMinio());
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView fileUpload(@RequestParam("file") MultipartFile multipartFile) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        indexService.uploadMinio(multipartFile);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Redis", indexService.redisIsConnection());
        modelAndView.addObject("Postgresql", indexService.getTestModel());
        modelAndView.addObject("Minio", indexService.getMinio());
        modelAndView.setViewName("/index");
        return modelAndView;
    }

}
