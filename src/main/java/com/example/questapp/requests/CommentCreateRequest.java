package com.example.questapp.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    Long userId,postId,id;
    String text;
}
