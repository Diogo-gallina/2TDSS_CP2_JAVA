package br.com.fiap.eventmanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "JV_CP2_EVENT_DETAILS")
public class EventDetail {

    @Id
    @GeneratedValue
    @Column(name = "event_details_id")
    private Long id;

    @Column(name = "organization_name", nullable = false, length = 100)
    private String organizationName;

    @Column(name = "organization_email", nullable = false, length = 100)
    private String organizationEmail;

    @Column(name = "event_type", nullable = false, length = 60)
    private EventTypeEnum eventType;

}
