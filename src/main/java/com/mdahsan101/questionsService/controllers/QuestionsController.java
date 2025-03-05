package com.mdahsan101.questionsService.controllers;

import com.mdahsan101.questionsService.DTO.QuestionDTO;
import com.mdahsan101.questionsService.models.Option;
import com.mdahsan101.questionsService.models.Question;
import com.mdahsan101.questionsService.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/questions")
public class QuestionsController
{
    @Autowired
    DBService dbService;

    @PostMapping(value = "/create_question")
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody Question ques){

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

    @GetMapping(value = "/getQuestions/{cat}")
    public ResponseEntity<List<QuestionDTO>> getCategoryQuestions(@PathVariable("cat") String category){
        List<QuestionDTO> dbVal= dbService.getCategoryQuestionsFromDB(category);
        if(dbVal==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dbVal);
    }
}
