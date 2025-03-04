package com.mdahsan101.questionsService.repositories;

import com.mdahsan101.questionsService.models.Option;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option,Integer> {

}
