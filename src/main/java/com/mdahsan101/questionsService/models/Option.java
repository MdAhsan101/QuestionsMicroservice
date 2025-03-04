package com.mdahsan101.questionsService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="options_table")
@NoArgsConstructor
@Data
public class Option {

    public Option(Integer optionNumber, String optionDescription) {
        this.optionNumber = optionNumber;
        this.optionDescription = optionDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public Integer optionNumber;

    @NotEmpty
    public String optionDescription;

    @ManyToOne
    @JoinColumn(name="qId")
    @JsonIgnore
    public Question question;

    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", optionNumber=" + optionNumber +
                ", optionDescription='" + optionDescription + '\'' +
                '}';
    }
}
