package com.example.e_commerce.excpetion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionReponse {
    private String message;
    private HttpStatus status;
    LocalDateTime dateTime;

}
