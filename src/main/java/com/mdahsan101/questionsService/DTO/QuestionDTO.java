package com.mdahsan101.questionsService.DTO;

import com.mdahsan101.questionsService.models.Options;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    Integer qId;
    List<Options> options;
    String qDescription;
    String qCategory;
    Integer qMarks;
}
