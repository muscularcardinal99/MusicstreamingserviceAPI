package com.geekster.MusicStreaming.repo;


import com.geekster.MusicStreaming.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);
}
