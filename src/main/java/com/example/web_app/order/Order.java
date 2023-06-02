package com.example.web_app.order;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
@DynamicUpdate
@Table(name = "_orders")
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class,
        defaultForType = OrderedFood.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String order_id;
    private String table_id;
    private int worker_id;
    private String payment_type; //CASH or CARD
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private OrderedFood ordered_food;
    private int cost;
    @Column(nullable = false)
    private boolean closed;
    private LocalDateTime opened_time;
    private LocalDateTime closed_time;

}
