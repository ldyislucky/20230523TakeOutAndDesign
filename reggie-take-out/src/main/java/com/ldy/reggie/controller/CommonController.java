package com.ldy.reggie.controller;

import cn.hutool.core.lang.UUID;
import com.ldy.reggie.common.R;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${reggie.path}")
    private String path;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){//自定义传参名称必须与前端name名称一致
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        fileName = fileName + suffix;
        File route = new File(path);
        if (!route.exists()){
            route.mkdirs();
        }
        try {
            file.transferTo(new File(path+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return R.success(fileName);
    }
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        FileInputStream inputStream = null;
        ServletOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(new File(path + name));
            outputStream = response.getOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes);
                outputStream.flush();
            }
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream!=null){
                    outputStream.close();
                }
                if (inputStream!=null){
                    inputStream.close();
                }
            }catch (Exception e){
                new RuntimeException(e);
            }
        }
    }
}
