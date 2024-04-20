package com.Ada.SkyFeedConnect.dto;

import com.Ada.SkyFeedConnect.model.NewsIBGE;

public record NewsIBGE_DTO(String title, String link, String introduction) {
    public NewsIBGE_DTO(NewsIBGE.news news) {
        this(news.getTitle(), news.getLink(), news.getIntroduction());
    }
}
