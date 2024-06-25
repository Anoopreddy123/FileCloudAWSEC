package com.FileCloud.FileCloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FileCloud.FileCloud.entity.users;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<users, Long> {
    users findByUsername(String username);
    boolean existsByUsername(String username);




}
