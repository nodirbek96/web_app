package com.example.web_app.order;

import com.example.web_app.food.Food;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderedFood {
    private int order_id;
    private List<Food> foods;
}
