package com.wath.asmapi.rest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import com.wath.asmapi.constant.ApiConstant;
import com.wath.asmapi.rest.message.SuccessMessage;
import com.wath.asmapi.rest.response.ApiResponse;
import com.wath.asmapi.rest.response.ImageResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping(ApiConstant.API_VERSION)
public class ImgRestController {

    @Value("${file.server-path}")
    String serverPath;

    @Value("${app.base-url}")
    String baseURL;

    /*
    consumes = content upload
    */
    @PostMapping(value="/upload-img",consumes = "multipart/form-data",produces = "application/json")
    public ResponseEntity<ApiResponse<ImageResponse>> uploadImg(@RequestParam("image") MultipartFile image) {

        String fileName ="";
        String orgFileName;
        String uri = "";
        ImageResponse imgResponse;
        if(!image.isEmpty()){
            orgFileName= image.getOriginalFilename();
            fileName = UUID.randomUUID() + orgFileName.substring(orgFileName.lastIndexOf("."));
            uri = baseURL + "/images/" + fileName;
            try {
                Files.copy(image.getInputStream(), Paths.get(serverPath+fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ApiResponse<ImageResponse> response = new ApiResponse<>();
        imgResponse=new ImageResponse(fileName,uri,image.getContentType(),image.getSize());
        response.setCode(HttpStatus.CREATED.value());
        response.setMessage(SuccessMessage.IS_SAVED.value());
        response.setSuccess(true);
        response.setData(imgResponse);
        return ResponseEntity.ok(response);
    }
    
}