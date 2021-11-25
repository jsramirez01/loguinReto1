package com.reto1Ciclo4.demo.model;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import lombok.Data;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user" , indexes = @Index(name="indx_email", columnList="user_email", unique = true))
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false, length = 11)
    private Integer id;
    @NonNull
    @Column (name = "user_email", nullable = false, length = 50)
    private String email;
    @NonNull
    @Column (name = "user_password", nullable = false, length = 50)
    private String password;
    @NonNull
    @Column (name = "user_name", nullable = false, length = 80)
    private String name;


}
