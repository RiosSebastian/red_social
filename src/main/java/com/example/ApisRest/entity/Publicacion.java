package com.example.ApisRest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "publicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(name= "titulo", nullable = false)
    private String titulo;
    @Column(name= "descripcion", nullable = false)
    private String descripcion;
    @Column(name= "contenido", nullable = false)
    private String contenido;
    @OneToMany(mappedBy="publicacion")
    private Set<Comentarios> comentarios;

}
