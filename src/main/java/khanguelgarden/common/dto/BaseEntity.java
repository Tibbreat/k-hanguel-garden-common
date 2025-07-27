package khanguelgarden.common.dto;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;

import static khanguelgarden.common.util.SecurityContextHolderUtils.getCurrentUser;

@Getter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = null;

        this.createdBy = getCurrentUser();
        this.updatedBy = null;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
        this.updatedBy = getCurrentUser();
    }
}
