package br.com.empresaaleatoria.cadastrocia.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        String timestamp = LocalDateTime.now().toString();

        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("timestamp", timestamp);

        List<Map<String, String>> fieldErrors = new ArrayList<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("campo", fieldError.getField());
            errorDetails.put("Classe", fieldError.getObjectName());
            errorDetails.put("mensagem Padrão", fieldError.getDefaultMessage());
            fieldErrors.add(errorDetails);
        }

        response.put("atributos", fieldErrors);

        return ResponseEntity.status(status).body(response);
    }
}

