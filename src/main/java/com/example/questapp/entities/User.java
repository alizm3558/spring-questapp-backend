package com.example.questapp.entities;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String userName,password;

}
