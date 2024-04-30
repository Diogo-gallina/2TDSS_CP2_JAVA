package br.com.fiap.eventmanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "JV_CP2_CATEGORY")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 70)
    private String name;

    @Column(name = "description", nullable = false, length = 150)
    private String description;

    @OneToOne(mappedBy = "category")
    private Event event;

}
