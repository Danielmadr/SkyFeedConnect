package com.Ada.SkyFeedConnect.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class NewsResponseIBGE {
  private NewsItem[] items;

  @Setter
  @Getter
  public static class NewsItem {
    private final String data_publicacao;
    private final String titulo;
    private final String introducao;
    private final String link;
    private String imagens;

    public NewsItem(String data_publicacao, String titulo, String introducao, String link, String imagens) {
      this.data_publicacao = data_publicacao;
      this.titulo = titulo;
      this.introducao = introducao;
      this.link = link;
      this.imagens = imagens;
    }
  }
}
