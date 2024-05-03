package br.com.fiap.eventmanager.services;

import br.com.fiap.eventmanager.dto.address.CreateAddressDTO;
import br.com.fiap.eventmanager.models.Address;
import br.com.fiap.eventmanager.models.Event;
import br.com.fiap.eventmanager.models.Participant;
import br.com.fiap.eventmanager.repository.AddressRepository;
import br.com.fiap.eventmanager.repository.EventRepository;
import br.com.fiap.eventmanager.repository.ParticipantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ParticipantRepository participantRepository;

    @Transactional
    public Address createAddressToEvent(Long eventId, CreateAddressDTO addressDTO){
        Event event = eventRepository.getReferenceById(eventId);
        Address address = new Address(addressDTO, event);
        return addressRepository.save(address);
    }

    @Transactional
    public Address createAddressToParticipant(Long participantId, CreateAddressDTO addressDTO){
        Participant participant = participantRepository.getReferenceById(participantId);
        Address address = new Address(addressDTO, participant);
        return addressRepository.save(address);
    }

}
