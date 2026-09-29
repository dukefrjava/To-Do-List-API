// http://localhost:8080/h2-console

package br.com.dukes.todolist.user;

import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Data 
@Entity(name="tb_user")
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    @Column(unique = true)
    private String username;
    private String password;

    @CreationTimestamp 
    private LocalDateTime createdAt;

}
