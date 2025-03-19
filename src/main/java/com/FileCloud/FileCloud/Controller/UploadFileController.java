package com.FileCloud.FileCloud.Controller;

import com.FileCloud.FileCloud.entity.UploadFileResponse;
import com.FileCloud.FileCloud.service.UploadFileService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@RestController
@Builder
@RequiredArgsConstructor
@Slf4j

public class UploadFileController {

    @Autowired
    private final UploadFileService uploadFileService;

    @PostMapping("/files/uploadfile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") Long userId) {
        try {
            var uploadFile = uploadFileService.saveUploadFile(file, userId);

            return UploadFileResponse.builder()
                    .isError(false)
                    .fileName(uploadFile.getFileName())
                    .fileLink(createUploadFileLink(uploadFile.getFileName()))
                    .build();

        } catch (Exception e) {
            log.error("Upload file failed", e);
            return UploadFileResponse.builder().isError(true).fileName(file.getOriginalFilename()).build();
        }
    }

    private String createUploadFileLink(String fileName) {
       return ServletUriComponentsBuilder.fromCurrentRequest()
               .replacePath("/files/"+fileName)
               .toUriString();
    }



    @GetMapping("/files/{fileName}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable String fileName) {

        var fileUpload = uploadFileService.getFileUpload(fileName);
        var grpData = new ByteArrayResource(fileUpload.getGrpData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, fileUpload.getFileType())
                .cacheControl(CacheControl.maxAge(Duration.ofSeconds(60)).cachePrivate().mustRevalidate())
                .body(grpData);

    }

//    @PostMapping("/files/multi_uploadfile")
//    public List<UploadFileResponse> uploadMultiFiles(@RequestPart List<MultipartFile> files) {
//        return files.stream().map(this::uploadFile).collect(Collectors.toList());
//    }


    @GetMapping("/file/{userId}")
    public ResponseEntity<List<String>> getFileNames(@PathVariable Long userId, @RequestHeader("Authorization") String token) {
        // Optionally validate the token here
        List<String> fileNames = uploadFileService.getFileNamesByUserId(userId);
        return ResponseEntity.ok(fileNames);
    }
    }

