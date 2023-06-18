package com.example.demo.oneTOonemap;

import com.example.demo.request.EmployeeRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="question_tbl")
@Getter
@Setter
public class Question {

    @Id
    private int question_id;
    private String question;
    @OneToOne
    @JoinColumn(name="answer_id")
    private Answer answer;
    public Question(String question,int question_id){
        this.question=question;
        this.question_id = question_id;
    }

}
