package br.com.fiap.eventmanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name = "JV_CP2_ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "postal_code", nullable = false, length = 8)
    private String cep;

    @Column(name = "address_number", nullable = false)
    private Number number;

}
