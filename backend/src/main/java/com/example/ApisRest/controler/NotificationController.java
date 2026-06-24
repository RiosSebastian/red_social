package com.example.ApisRest.controler;

import com.example.ApisRest.dto.NotificationDto;
import com.example.ApisRest.servis.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<NotificationDto>> getNotifications() {

        return ResponseEntity.ok(
                notificationService.getMyNotifications()
        );
    }

    @GetMapping("/unread-count")
    public ResponseEntity<Long> unreadCount() {

        return ResponseEntity.ok(
                notificationService.getUnreadCount()
        );
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<Void> markAsRead(@PathVariable Long id) {

        notificationService.markAsRead(id);

        return ResponseEntity.ok().build();
    }
}