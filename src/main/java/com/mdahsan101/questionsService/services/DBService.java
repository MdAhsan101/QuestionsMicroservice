package com.mdahsan101.questionsService.services;

import com.mdahsan101.questionsService.DTO.QuestionDTO;
import com.mdahsan101.questionsService.models.Option;
import com.mdahsan101.questionsService.models.Question;
import com.mdahsan101.questionsService.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DBService
{
    @Autowired
    QuestionsRepository questionsRepository;

    public void saveQuestionToDB(Question ques){
        System.out.println("Question:: "+ques.toString());
        for(Option opt:ques.getOptions()){
            opt.setQuestion(ques);
        }

        questionsRepository.save(ques);
    }

    public List<QuestionDTO> getCategoryQuestionsFromDB(String cat){
        Optional<List<Question>> dbVal= questionsRepository.findByqCategoryOrderByqMarks(cat);
        if(dbVal.isEmpty()){
            return null;
        }
        List<QuestionDTO> dtoLst= new ArrayList<>();
        for(Question ques: dbVal.get()){
            dtoLst.add(convertQuestionToDTO(ques));
        }
        return dtoLst;
    }

    private QuestionDTO convertQuestionToDTO(Question ques){
        return  new QuestionDTO(
                ques.getQId(),
                ques.getOptions(),
                ques.getQDescription(),
                ques.getQCategory(),
                ques.getQMarks()
        );
    }
}
