package com.mdahsan101.questionsService.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="questions_table")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer qId;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min=2,max=2)
    @NotEmpty
    List<Options> options;

    @Column(name = "description")
    @NotEmpty
    String qDescription;

    @Column(name="marks")
    @Min(1)
    @Max(5)
    @NotEmpty
    Integer qMarks;

    @Min(1)
    @Max(2)
    @NotEmpty
    Integer answer;
}
