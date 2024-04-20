package com.Ada.SkyFeedConnect.dto;

import java.util.List;

public record NewsResponseIBGE_DTO(List<NewsItemDTO> items) {
    public static record NewsItemDTO(String data_publicacao, String title, String introduction, String link) {}
}
