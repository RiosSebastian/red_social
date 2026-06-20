package com.example.ApisRest.servis;

import com.example.ApisRest.dto.LikeResponseDto;

public interface LikeService {



    LikeResponseDto likePublication(
            Long publicationId
    );

    LikeResponseDto unlikePublication(
            Long publicationId
    );

    LikeResponseDto getLikes(
            Long publicationId
    );


}