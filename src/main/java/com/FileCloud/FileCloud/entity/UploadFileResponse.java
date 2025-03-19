package com.FileCloud.FileCloud.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileResponse {

    private boolean isError;
    private String fileName;
    private String fileLink;


}
