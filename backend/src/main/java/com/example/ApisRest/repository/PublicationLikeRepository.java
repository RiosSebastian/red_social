package com.example.ApisRest.repository;

import com.example.ApisRest.entity.Publicacion;
import com.example.ApisRest.entity.PublicationLike;
import com.example.ApisRest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicationLikeRepository extends JpaRepository<PublicationLike, Long> {

    boolean existsByUserAndPublicacion(
            User user,
            Publicacion publicacion
    );

    Optional<PublicationLike> findByUserAndPublicacion(
            User user,
            Publicacion publicacion
    );

    long countByPublicacion(
            Publicacion publicacion
    );
}