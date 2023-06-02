package com.example.web_app.woker;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
@Table(name = "_workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int job_id;
    private String firstname;
    private String lastname;
    private String birth_date;
    private String phone;
    private String salary;
    private LocalDateTime done_time;
}
