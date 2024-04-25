package com.Ada.SkyFeedConnect.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class NewsResponseIBGE {
  private NewsItem[] items;

  @Setter
  @Getter
  public static class NewsItem {
    private String data_publicacao;
    private String titulo;
    private String introducao;
    private String link;
    private String imagens;
  }
}
