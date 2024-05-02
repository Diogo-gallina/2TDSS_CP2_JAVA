package br.com.fiap.eventmanager.controller;

import br.com.fiap.eventmanager.dto.participant.CreateParticipantDTO;
import br.com.fiap.eventmanager.dto.participant.ParticipantDetailsDTO;
import br.com.fiap.eventmanager.services.ParticipantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class ParticipantController {

    @Autowired
    ParticipantService participantService;

    @PostMapping
    public ResponseEntity<ParticipantDetailsDTO> create(@RequestBody @Valid CreateParticipantDTO participantDTO,
                                                        UriComponentsBuilder uri){
        var participant = participantService.create(participantDTO);
        var url = uri.path("/posts/{post_id}").buildAndExpand(participant.getId()).toUri();

        return ResponseEntity.created(url).body(new ParticipantDetailsDTO(participant));
    }

    @GetMapping
    public ResponseEntity<List<ParticipantDetailsDTO>> findAll(Pageable pageable){
        var participantList = participantService.getAll(pageable);
        return ResponseEntity.ok(participantList);
    }

    @GetMapping("/{participant_id}")
    public ResponseEntity<ParticipantDetailsDTO> findOne(@PathVariable("participant_id") Long participantId){
        var participant = participantService.getOne(participantId);
        return ResponseEntity.ok(participant);
    }

    @DeleteMapping("{participant_id}")
    public ResponseEntity<Void> delete(@PathVariable("participant_id") Long participantId){
        participantService.delete(participantId);
        return ResponseEntity.noContent().build();
    }

}
