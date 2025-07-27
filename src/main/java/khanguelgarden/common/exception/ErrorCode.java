package khanguelgarden.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 4xx CLIENT ERRORS
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Request không hợp lệ"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Không có quyền truy cập"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "Bị từ chối quyền truy cập"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Không tìm thấy tài nguyên"),
    CONFLICT(HttpStatus.CONFLICT, "Dữ liệu xung đột"),

    // 5xx SERVER ERRORS
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi hệ thống"),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "Dịch vụ tạm thời không sẵn sàng");

    private final HttpStatus httpStatus;
    private final String message;
}