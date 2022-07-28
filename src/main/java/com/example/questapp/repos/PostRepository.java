package com.example.questapp.repos;

import com.example.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {




    List<Post> findByUserId(Long userId);
}
