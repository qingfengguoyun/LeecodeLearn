package com.myProject9_21.controller;

import com.myProject9_21.utils.FileTypeUtils;
import io.swagger.annotations.Api;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@Api(value = "文件类型判断")
public class FileUploadController {
    @PostMapping("/uploadType")
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            BufferedInputStream bufferedInputStream=new BufferedInputStream(file.getInputStream());
            byte[] bytes = new byte[28];
            bufferedInputStream.read(bytes, 0, 28);
            bufferedInputStream.close();
            String fileType = FileTypeUtils.getFileType(file.getInputStream());
            return "Uploaded file type: " + fileType;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error uploading file";
        }
    }
}