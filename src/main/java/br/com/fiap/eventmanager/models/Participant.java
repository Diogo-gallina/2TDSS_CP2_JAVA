package br.com.fiap.eventmanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "JV_CP2_ADDRESS")
@EntityListeners(AuditingEntityListener.class)
public class Participant {

    @Id
    @GeneratedValue
    @Column(name = "participant_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "cell_phone", nullable = false, length = 12)
    private String cellPhone;

    @Column(name = "created_at", nullable = false)
    @GeneratedValue
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
