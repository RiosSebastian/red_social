package com.example.ApisRest.servis.impl;

import com.example.ApisRest.dto.FollowStatsDto;
import com.example.ApisRest.entity.Follow;
import com.example.ApisRest.entity.User;
import com.example.ApisRest.repository.FollowRepository;
import com.example.ApisRest.repository.UserRepository;
import com.example.ApisRest.servis.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private FollowRepository followRepository;


    @Override
    public void followUser(Long targetUserId) {

        String username =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        User follower =
                userRepository
                        .findByUsername(username)
                        .orElseThrow();

        User following =
                userRepository
                        .findById(targetUserId)
                        .orElseThrow();

        if(follower.getId().equals(following.getId())){
            throw new RuntimeException(
                    "No puedes seguirte a ti mismo"
            );
        }

        if(followRepository.existsByFollowerAndFollowing(
                follower,
                following
        )){
            throw new RuntimeException(
                    "Ya sigues a este usuario"
            );
        }

        Follow follow = new Follow();

        follow.setFollower(follower);
        follow.setFollowing(following);
        follow.setCreatedAt(LocalDateTime.now());

        followRepository.save(follow);
    }

    @Override
    public void unfollowUser(Long targetUserId) {

        String username =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName();

        User follower =
                userRepository
                        .findByUsername(username)
                        .orElseThrow();

        User following =
                userRepository
                        .findById(targetUserId)
                        .orElseThrow();

        Follow follow =
                followRepository
                        .findByFollowerAndFollowing(
                                follower,
                                following
                        )
                        .orElseThrow();

        followRepository.delete(follow);
    }

    @Override
    public FollowStatsDto getStats(Long userId) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow();

        return FollowStatsDto.builder()
                .userId(userId)
                .followers(
                        followRepository
                                .countByFollowing(user)
                )
                .following(
                        followRepository
                                .countByFollower(user)
                )
                .build();
    }
}
