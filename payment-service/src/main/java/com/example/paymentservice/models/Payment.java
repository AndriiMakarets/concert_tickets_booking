package com.example.paymentservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payments") // Ensure table name is correctly set
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString // If you want to include a default toString method
@EqualsAndHashCode // If you want to include default equals and hashCode methods based on the id
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2) // Adjust precision and scale as necessary
    private BigDecimal amount;

    @Column(length = 3, nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    // Consider adding a reference to the User entity if needed
    // @ManyToOne
    // @JoinColumn(name = "user_id", nullable = false)
    // private User user;

    @Column(nullable = false)
    private String paymentMethod; // e.g., credit card, PayPal, etc.

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    public enum PaymentStatus {
        PENDING,
        COMPLETED,
        FAILED,
        REFUNDED
    }
}
