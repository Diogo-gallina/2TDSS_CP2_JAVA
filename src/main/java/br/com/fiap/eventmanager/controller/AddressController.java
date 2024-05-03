package br.com.fiap.eventmanager.controller;

import br.com.fiap.eventmanager.dto.address.AddressDetailsDTO;
import br.com.fiap.eventmanager.dto.address.CreateAddressDTO;
import br.com.fiap.eventmanager.models.Address;
import br.com.fiap.eventmanager.services.AddressService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("event/{event_id}")
    public ResponseEntity<AddressDetailsDTO> createAddresstoEnvent(@PathVariable("event_id") Long eventId,
                                                                   @RequestBody @Valid CreateAddressDTO addressDTO,
                                                                   UriComponentsBuilder uri){
        Address address = addressService.createAddressToEvent(eventId, addressDTO);
        var url = uri.path("/addresses/event/{event_id}").buildAndExpand(address.getId()).toUri();

        return ResponseEntity.created(url).body(new AddressDetailsDTO(address));
    }

    @PostMapping("participant/{participant_id}")
    public ResponseEntity<AddressDetailsDTO> createAddresstoParticipant(@PathVariable("participant_id") Long participantId,
                                                                   @RequestBody @Valid CreateAddressDTO addressDTO,
                                                                   UriComponentsBuilder uri){
        Address address = addressService.createAddressToParticipant(participantId, addressDTO);
        var url = uri.path("/addresses/participant/{participant_id}").buildAndExpand(address.getId()).toUri();

        return ResponseEntity.created(url).body(new AddressDetailsDTO(address));
    }

}
