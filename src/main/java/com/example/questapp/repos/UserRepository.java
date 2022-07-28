package com.example.questapp.repos;

import com.example.questapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface UserRepository extends JpaRepository<User,Long> {
    //repolar database e query atmaların metotlu halleri gibi gibi :)


}
