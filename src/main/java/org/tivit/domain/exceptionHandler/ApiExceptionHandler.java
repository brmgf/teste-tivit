package org.tivit.domain.exceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, WebRequest request) {

        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) ex.getCause();

            if (invalidFormatException.getTargetType().isEnum()) {
                String valoresValidos = String.join(", ",
                        Arrays.stream(invalidFormatException.getTargetType().getEnumConstants())
                                .map(Object::toString)
                                .toArray(String[]::new));

                String message = String.format("Valor inválido: '%s'. Os valores válidos para %s são: %s",
                        invalidFormatException.getValue(),
                        invalidFormatException.getTargetType().getSimpleName(),
                        valoresValidos);

                ErrorDetails errorDetails = new ErrorDetails(message, request.getDescription(false));
                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
            }
        }

        ErrorDetails errorDetails = new ErrorDetails("Erro ao processar a requisição", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDetails> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorDetails errorDetails = new ErrorDetails("Valor inválido", ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    public static class ErrorDetails {

        private String message;
        private String details;

        public ErrorDetails(String message, String details) {
            this.message = message;
            this.details = details;
        }

        public String getMessage() {
            return message;
        }

        public String getDetails() {
            return details;
        }
    }
}
