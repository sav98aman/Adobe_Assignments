package com.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private User user;

    private String content;

    private LocalDateTime createAtTime;
    private LocalDateTime updateAtTime;

    private Integer likes;

}
