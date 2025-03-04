package com.mdahsan101.questionsService.services;

import com.mdahsan101.questionsService.models.Option;
import com.mdahsan101.questionsService.models.Question;
import com.mdahsan101.questionsService.repositories.OptionRepository;
import com.mdahsan101.questionsService.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DBService
{
    @Autowired
    QuestionsRepository questionsRepository;

    @Autowired
    OptionRepository optionRepository;

    public void saveQuestionToDB(Question ques){
        System.out.println("Question:: "+ques.toString());
        for(Option opt:ques.getOptions()){
            opt.setQuestion(ques);
        }

        questionsRepository.save(ques);
    }
}
