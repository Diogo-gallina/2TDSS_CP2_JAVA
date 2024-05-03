package br.com.fiap.eventmanager.services;

import br.com.fiap.eventmanager.dto.address.AddressDetailsDTO;
import br.com.fiap.eventmanager.dto.address.CreateAddressDTO;
import br.com.fiap.eventmanager.models.Address;
import br.com.fiap.eventmanager.models.Event;
import br.com.fiap.eventmanager.models.Participant;
import br.com.fiap.eventmanager.repository.AddressRepository;
import br.com.fiap.eventmanager.repository.EventRepository;
import br.com.fiap.eventmanager.repository.ParticipantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ParticipantRepository participantRepository;

    //Events methods
    @Transactional
    public Address createAddressToEvent(Long eventId, CreateAddressDTO addressDTO){
        Event event = eventRepository.getReferenceById(eventId);
        Address address = new Address(addressDTO, event);
        return addressRepository.save(address);
    }

    public List<AddressDetailsDTO> getAllEventAddresses(Long eventId){
        Event event = eventRepository.getReferenceById(eventId);
        return event.getAddresses().stream().map(AddressDetailsDTO::new).toList();
    }


    //Participants methods
    @Transactional
    public Address createAddressToParticipant(Long participantId, CreateAddressDTO addressDTO){
        Participant participant = participantRepository.getReferenceById(participantId);
        Address address = new Address(addressDTO, participant);
        return addressRepository.save(address);
    }

    public List<AddressDetailsDTO> getAllParticipantAddresses(Long participantId){
        Participant participant = participantRepository.getReferenceById(participantId);
        return participant.getAddresses().stream().map(AddressDetailsDTO::new).toList();
    }

}
