package com.bookworm.bookwormauth.api.adapter.in.web.dto.response;

import com.bookworm.bookwormauth.api.application.domain.Worm;
import lombok.Data;

@Data
public class WormResponse {
    private Long id;
    private String userId;
    private String nickname;

    public static WormResponse of(Worm worm) {
        WormResponse response = new WormResponse();
        response.setId(worm.id());
        response.setUserId(worm.userId());
        response.setNickname(worm.nickname());

        return response;
    }
}
