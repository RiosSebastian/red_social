package com.example.ApisRest.servis;

import com.example.ApisRest.dto.FollowStatsDto;

public interface FollowService {

    void followUser(Long targetUserId);

    void unfollowUser(Long targetUserId);

    FollowStatsDto getStats(Long userId);
}