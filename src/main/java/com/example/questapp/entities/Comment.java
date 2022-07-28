package com.example.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table(name="comment")
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;



    @ManyToOne(fetch = FetchType.LAZY)//user nesnesi hemen gelmesin.
    @JoinColumn(name = "post_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//user silinirse onun tüm postları da silinecektir.
    @JsonIgnore
    Post post;

    @ManyToOne(fetch = FetchType.LAZY)//user nesnesi hemen gelmesin.
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//user silinirse onun tüm postları da silinecektir.
    @JsonIgnore
    User user;


    @Lob
    @Column(columnDefinition = "text") //hibernate mysqlde stringi text olarak algılaması için
    String text;
}
