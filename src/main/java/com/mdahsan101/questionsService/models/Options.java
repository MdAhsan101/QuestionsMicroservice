package com.mdahsan101.questionsService.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="options_table")
@NoArgsConstructor
@Data
public class Options {

    public Options(Integer optionNumber, String optionDescription) {
        this.optionNumber = optionNumber;
        this.optionDescription = optionDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotEmpty
    public Integer optionNumber;

    @NotEmpty
    public String optionDescription;

    @ManyToOne
    @JoinColumn(name="qId")
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
