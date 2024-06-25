package com.FileCloud.FileCloud.service;

import com.FileCloud.FileCloud.entity.tbl_uploadfile;

import com.FileCloud.FileCloud.repository.UploadFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.FileCloud.FileCloud.exception.FileNotFoundException;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class UploadFileServiceImpl implements UploadFileService{

    private final UploadFileRepository uploadFileRepository;

    @Override
    public tbl_uploadfile saveUploadFile(MultipartFile file, Long userId) throws IOException {
        var uploadFile = tbl_uploadfile.builder()
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .grpData(file.getBytes())
                .userId(userId)
                .build();

        return uploadFileRepository.save(uploadFile);
    }
    @Override
    public List<String> getFileNamesByUserId(Long userId) {
        return uploadFileRepository.findFileNamesByUserId(userId);
    }


    @Override
    public tbl_uploadfile getFileUpload(String fileName) {
        return uploadFileRepository.findByFileName(fileName)
                .orElseThrow(() -> new FileNotFoundException("File not found with name: " + fileName));
    }




}
