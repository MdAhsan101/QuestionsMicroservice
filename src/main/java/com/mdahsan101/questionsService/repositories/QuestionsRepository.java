package com.mdahsan101.questionsService.repositories;

import com.mdahsan101.questionsService.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface QuestionsRepository extends JpaRepository<Question,Integer> {

    //Note: nativeQuery= false -> Hence name of entity and their fields are directly used
    @Query(value = "select q from Question q where q.qCategory= :cat order by q.qMarks desc")
    Optional<List<Question>> findByqCategoryOrderByqMarks(@Param("cat") String category);

    @Query(value="select qt.q_id from questions_table qt where qt.category= :cat order by random() limit :noq",nativeQuery = true)
    Optional<List<Integer>> findByCategoryWithLimitInRandomOrder(@Param("cat") String cat, @Param("noq") Integer num_of_ques);

    Optional<Question> findByqId(Integer id);
}
