package com.example.demo.oneTOonemap;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="answer_tbl")
@Getter
@Setter
public class Answer {
     @Id
    private int answer_id;
    private String answer;
}
