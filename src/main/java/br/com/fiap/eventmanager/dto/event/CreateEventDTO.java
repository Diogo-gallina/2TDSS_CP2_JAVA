package br.com.fiap.eventmanager.dto.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateEventDTO(
        String title,

        String description,

        LocalDateTime initialDate,

        LocalDateTime finalDate,

        Number maxParticipantsCapacity,

        BigDecimal registrationValue,

        String categoryName,

        String description

) {
}
