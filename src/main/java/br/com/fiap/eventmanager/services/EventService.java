package br.com.fiap.eventmanager.services;

import br.com.fiap.eventmanager.dto.event.EventDetailsDTO;
import br.com.fiap.eventmanager.dto.eventdetails.EventInfosDetailsDTO;
import br.com.fiap.eventmanager.models.Event;
import br.com.fiap.eventmanager.repository.EventDetailsRepository;
import br.com.fiap.eventmanager.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    EventDetailsRepository eventDetailsRepository;

    @Transactional
    public EventDetailsDTO create(Event event){
        eventRepository.save(event);
        return  new EventDetailsDTO(event);
    }

    public List<EventDetailsDTO> getAll(Pageable pageable) {
        return eventRepository.findAll(pageable).stream()
                .map(EventDetailsDTO::new).toList();
    }

}
