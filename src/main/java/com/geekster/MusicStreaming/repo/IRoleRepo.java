package com.geekster.MusicStreaming.repo;


import com.geekster.MusicStreaming.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Long> {

}
