package br.com.fiap.eventmanager.services;

import br.com.fiap.eventmanager.dto.participant.CreateParticipantDTO;
import br.com.fiap.eventmanager.dto.participant.ParticipantDetailsDTO;
import br.com.fiap.eventmanager.models.Participant;
import br.com.fiap.eventmanager.repository.ParticipantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    @Transactional
    public Participant create(CreateParticipantDTO participantDTO){
        Participant participant = new Participant(participantDTO);
        return participantRepository.save(participant);
    }

    public List<ParticipantDetailsDTO> getAll(Pageable pageable) {
        return participantRepository.findAll(pageable).stream()
                .map(ParticipantDetailsDTO::new).toList();
    }

    public ParticipantDetailsDTO getOne(Long participantId) {
        var participant = participantRepository.getReferenceById(participantId);
        return new ParticipantDetailsDTO(participant);
    }

}
