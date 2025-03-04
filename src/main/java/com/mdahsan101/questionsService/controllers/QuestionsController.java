package com.mdahsan101.questionsService.controllers;

import com.mdahsan101.questionsService.DTO.QuestionDTO;
import com.mdahsan101.questionsService.models.Options;
import com.mdahsan101.questionsService.models.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/questions")
public class QuestionsController
{
    @PostMapping(value = "/create_question")
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody Question ques){

        System.out.println(ques.toString());

        List<Options> optionsList = ques.getOptions();
        for (Options opt : optionsList) {
            System.out.println("Option Number: " + opt.getOptionNumber());
            System.out.println("Option Description: " + opt.getOptionDescription());
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new QuestionDTO(
                        ques.getQId(),
                        ques.getOptions(),
                        ques.getQDescription(),
                        ques.getQCategory(),
                        ques.getQMarks()
                        )
                );
    }
}
