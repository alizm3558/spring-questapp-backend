package com.example.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name="post")
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)//user nesnesi hemen gelmesin.
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)//user silinirse onun tüm postları da silinecektir.
    @JsonIgnore
    User user;


    String title;

    @Lob
    @Column(columnDefinition = "text") //hibernate mysqlde stringi text olarak algılaması için
    String text;
}
