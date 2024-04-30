package br.com.fiap.eventmanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name = "JV_CP2_EVENT")
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Column(name = "initial_date", nullable = false)
    private LocalDateTime initialDate;

    @Column(name = "final_date", nullable = false)
    private LocalDateTime finalDate;

    @Column(name = "max_participants_capacity", nullable = false, precision = 10, scale = 2)
    private Number maxParticipantsCapacity;

    @Column(name = "registration_value", nullable = false)
    private BigDecimal registrationValue;

    @OneToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
