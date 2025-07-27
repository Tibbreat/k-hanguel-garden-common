package khanguelgarden.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private int status;
    private String msg;
    private T data;
    private Instant timestamp;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder().
                status(HttpStatus.OK.value()) // 200
                .msg("Success")
                .data(data)
                .timestamp(Instant.now())
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String msg) {
        return ApiResponse.<T>builder().
                status(HttpStatus.OK.value()) // 200
                .msg(msg)
                .data(data)
                .timestamp(Instant.now())
                .build();
    }

    public static <T> ApiResponse<T> error(int status, String message) {
        return ApiResponse.<T>builder()
                .status(status)
                .msg(message)
                .data(null)
                .timestamp(Instant.now())
                .build();
    }

    public static <T> ApiResponse<T> error(int status, String message, T data) {
        return ApiResponse.<T>builder()
                .status(status)
                .msg(message)
                .data(data)
                .timestamp(Instant.now())
                .build();
    }
}
