package com.FileCloud.FileCloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@Entity
@Table(name = "tbl_uploadfile")
@NoArgsConstructor
@AllArgsConstructor
public class tbl_uploadfile {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "grp_data")
    private byte[] grpData;


}
