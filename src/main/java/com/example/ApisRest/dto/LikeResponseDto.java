package com.example.ApisRest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeResponseDto {

    private Long publicationId;

    private long likesCount;

    private boolean likedByCurrentUser;
}