package com.mdahsan101.questionsService.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="options_table")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name="qId")
    Question question;

    @NotEmpty
    Integer optionNumber;

    @NotEmpty
    String optionDescription;
}
