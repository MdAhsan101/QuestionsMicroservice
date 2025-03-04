package com.mdahsan101.questionsService.controllers;

import com.mdahsan101.questionsService.DTO.QuestionDTO;
import com.mdahsan101.questionsService.models.Option;
import com.mdahsan101.questionsService.models.Question;
import com.mdahsan101.questionsService.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    DBService dbService;

    @PostMapping(value = "/create_question")
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody Question ques){

        System.out.println(ques.toString());

        List<Option> optionsList = ques.getOptions();
        for (Option opt : optionsList) {
            System.out.println("Option Number: " + opt.getOptionNumber());
            System.out.println("Option Description: " + opt.getOptionDescription());
        }

        dbService.saveQuestionToDB(ques);

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
