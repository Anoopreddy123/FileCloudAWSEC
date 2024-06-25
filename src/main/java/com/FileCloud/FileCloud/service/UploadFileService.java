package com.FileCloud.FileCloud.service;

import com.FileCloud.FileCloud.entity.tbl_uploadfile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadFileService {



    tbl_uploadfile saveUploadFile(MultipartFile file, Long userId) throws Exception;

    tbl_uploadfile getFileUpload(String fileName);

    List<String> getFileNamesByUserId(Long userId);
}
