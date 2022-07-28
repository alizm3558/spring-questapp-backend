package com.example.questapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {

    Long id,userId;
    String text,title;

}
