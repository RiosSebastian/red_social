package com.example.ApisRest.repository;

import com.example.ApisRest.entity.Comentarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {
    public List<Comentarios> findByPublicacionId(long publicacionid);
}
