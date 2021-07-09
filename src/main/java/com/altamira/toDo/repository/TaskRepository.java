package com.altamira.toDo.repository;

import com.altamira.toDo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Task t " +
            "SET t.isFinished = TRUE ,t.finishedOn = ?1 ,t.actualWorkTime = ?2 " +
            "WHERE t.id = ?3 ")
    void finishTask(Date date, int actualWorkDays, Long id);

}
