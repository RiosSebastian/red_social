package com.example.ApisRest.servis.impl;

import com.example.ApisRest.dto.NotificationDto;
import com.example.ApisRest.entity.Notification;
import com.example.ApisRest.entity.User;
import com.example.ApisRest.repository.NotificationRepository;
import com.example.ApisRest.repository.UserRepository;
import com.example.ApisRest.servis.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private UserRepository userRepository;

    @Override
    public void createFollowNotification(User follower, User recipient) {

        Notification notification =
                Notification.builder()
                        .recipient(recipient)
                        .message(
                                follower.getUsername()
                                        + " comenzó a seguirte"
                        )
                        .type("FOLLOW")
                        .read(false)
                        .createdAt(LocalDateTime.now())
                        .build();

        notificationRepository.save(notification);
    }

    @Override
    public List<NotificationDto> getMyNotifications() {

        String username =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        User user =
                userRepository
                        .findByUsername(username)
                        .orElseThrow();

        return notificationRepository
                .findByRecipientOrderByCreatedAtDesc(user)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public long getUnreadCount() {

        String username =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        User user =
                userRepository
                        .findByUsername(username)
                        .orElseThrow();

        return notificationRepository
                .countByRecipientAndReadFalse(user);
    }

    @Override
    public void markAsRead(Long notificationId) {

        Notification notification =
                notificationRepository
                        .findById(notificationId)
                        .orElseThrow();

        notification.setRead(true);

        notificationRepository.save(notification);
    }
}