package com.mdahsan101.questionsService.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="questions_table")
@Data
@NoArgsConstructor
public class Question {

    public Question(List<Options> options, String qDescription, @Nullable String qCategory, Integer qMarks, Integer answer) {
        this.options = options;
        this.qDescription = qDescription;
        this.qCategory = qCategory;
        this.qMarks = qMarks;
        this.answer = answer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer qId;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min=2,max=2)
    @NotEmpty
    public List<Options> options;

    @Column(name = "description")
    @NotEmpty
    public String qDescription;

    @Column(name="category")
    @Nullable
    public String qCategory;

    @Column(name="marks")
    @Min(1)
    @Max(5)
    @NotEmpty
    public Integer qMarks;

    @Min(1)
    @Max(2)
    @NotEmpty
    public Integer answer;

    @Override
    public String toString() {
        return "Question{" +
                "qId=" + qId +
                ", options=" + options +
                ", qDescription='" + qDescription + '\'' +
                ", qCategory='" + qCategory + '\'' +
                ", qMarks=" + qMarks +
                ", answer=" + answer +
                '}';
    }
}
