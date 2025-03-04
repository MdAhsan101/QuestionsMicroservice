package com.mdahsan101.questionsService.repositories;

import com.mdahsan101.questionsService.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Question,Integer> {
}
