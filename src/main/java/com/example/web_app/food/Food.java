package com.example.web_app.food;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
@Table(name = "_foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int menu_id;
    private String title;
    private int price;
    private String image_link;
    private LocalDateTime done_time;

}
