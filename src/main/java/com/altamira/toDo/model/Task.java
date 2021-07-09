package com.altamira.toDo.model;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(	name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date deadline = new Date();

    private Integer estimatedWorkTime;

    private Boolean isFinished = false;

    @Nullable
    private Integer actualWorkTime;

    @Nullable
    @Temporal(TemporalType.DATE)
    private Date finishedOn;
}
