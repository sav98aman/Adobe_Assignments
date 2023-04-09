package com.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;
    private String userName;
    private String email;
    private String bio;
    private LocalDateTime createAtTime;
    private LocalDateTime updateAtTime;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
