package br.com.fiap.eventmanager.dto.event;

import br.com.fiap.eventmanager.models.EventTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateEventDTO(
        String title,

        String description,

        LocalDateTime initialDate,

        LocalDateTime finalDate,

        Number maxParticipantsCapacity,

        BigDecimal registrationValue,

        String organizationName,

        String organizationEmail,

        EventTypeEnum eventType

) {
}
