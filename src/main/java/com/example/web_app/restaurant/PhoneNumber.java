package com.example.web_app.restaurant;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneNumber {
    private String type;
    private String phone;
}
