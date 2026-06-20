package com.example.ApisRest.servis.impl;

import com.example.ApisRest.dto.LikeResponseDto;
import com.example.ApisRest.entity.Publicacion;
import com.example.ApisRest.entity.PublicationLike;
import com.example.ApisRest.entity.User;
import com.example.ApisRest.repository.PublicacionRepository;
import com.example.ApisRest.repository.PublicationLikeRepository;
import com.example.ApisRest.repository.UserRepository;
import com.example.ApisRest.servis.LikeService;
import com.example.ApisRest.servis.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private UserRepository userRepository;
    private PublicationLikeRepository likeRepository;
    private final NotificationService notificationService;
    private  final PublicacionRepository publicacionRepository;


    @Override
    public LikeResponseDto likePublication(Long publicationId) {

        String username =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        User user =
                userRepository
                        .findByUsername(username)
                        .orElseThrow();

        Publicacion publicacion =
                publicacionRepository
                        .findById(publicationId)
                        .orElseThrow();

        if(likeRepository.existsByUserAndPublicacion(
                user,
                publicacion
        )){
            throw new RuntimeException(
                    "Ya diste like"
            );
        }

        PublicationLike like =
                new PublicationLike();

        like.setUser(user);
        like.setPublicacion(publicacion);
        like.setCreatedAt(LocalDateTime.now());

        likeRepository.save(like);

        notificationService.createLikeNotification(
                user,
                publicacion
        );

        return getLikes(publicationId);
    }

    @Override
    public LikeResponseDto unlikePublication(Long publicationId) {

        String username =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        User user =
                userRepository
                        .findByUsername(username)
                        .orElseThrow();

        Publicacion publicacion =
                publicacionRepository
                        .findById(publicationId)
                        .orElseThrow();

        PublicationLike like =
                likeRepository
                        .findByUserAndPublicacion(
                                user,
                                publicacion
                        )
                        .orElseThrow();

        likeRepository.delete(like);

        return getLikes(publicationId);
    }

    @Override
    public LikeResponseDto getLikes(Long publicationId) {

        String username =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        User user =
                userRepository
                        .findByUsername(username)
                        .orElseThrow();

        Publicacion publicacion =
                publicacionRepository
                        .findById(publicationId)
                        .orElseThrow();

        return LikeResponseDto.builder()
                .publicationId(publicationId)
                .likesCount(
                        likeRepository
                                .countByPublicacion(
                                        publicacion
                                )
                )
                .likedByCurrentUser(
                        likeRepository
                                .existsByUserAndPublicacion(
                                        user,
                                        publicacion
                                )
                )
                .build();
    }


}
