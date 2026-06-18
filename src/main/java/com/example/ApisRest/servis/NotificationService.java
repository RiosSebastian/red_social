package com.example.ApisRest.servis;

import com.example.ApisRest.dto.NotificationDto;
import com.example.ApisRest.entity.User;

import java.util.List;

public interface NotificationService {

    void createFollowNotification(
            User follower,
            User recipient
    );

    List<NotificationDto> getMyNotifications();

    long getUnreadCount();

    void markAsRead(Long notificationId);
}