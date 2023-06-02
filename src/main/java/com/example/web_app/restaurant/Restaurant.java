package com.example.web_app.restaurant;

import javax.persistence.*;

import com.example.web_app.order.OrderedFood;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
@Table(name = "_restaurants")
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class,
        defaultForType = PhoneNumber.class)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<PhoneNumber> phone;
    private String address;
    private String image_link;
    private LocalDateTime done_time;

}
