package com.FileCloud.FileCloud.repository;

import com.FileCloud.FileCloud.entity.tbl_uploadfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface UploadFileRepository extends CrudRepository<tbl_uploadfile, Integer> {

    boolean existsByfileName(String fileName);

    Optional<tbl_uploadfile> findByFileName(String fileName);

    @Query("SELECT f.fileName FROM tbl_uploadfile f WHERE f.userId = :userId")
    List<String> findFileNamesByUserId(@Param("userId")Long userId);


}
