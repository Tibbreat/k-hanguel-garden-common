package khanguelgarden.common.exception;

import khanguelgarden.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Object>> handleApiException(ApiException ex) {
        ErrorCode code = ex.getErrorCode();

        ApiResponse<Object> response = ApiResponse.builder()
                .status(code.getHttpStatus().value())
                .msg(code.getMessage())
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(response, code.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex) {
        ex.printStackTrace(); // Logging (hoặc dùng logger)

        ApiResponse<Object> response = ApiResponse.builder()
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus().value())
                .msg("Bad Request")
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(response, ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus());
    }
}
