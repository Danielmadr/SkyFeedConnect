package com.Ada.SkyFeedConnect.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsResponseIBGE {
    private NewsItem[] items;

    public NewsItem[] getItems() {
        return items;
    }

    public void setItems(NewsItem[] items) {
        this.items = items;
    }

    public static class NewsItem {
        private String data_publicacao;
        private String titulo;
        private String introducao;
        private String link;

        public String getData_publicacao() {
            return data_publicacao;
        }

        public void setData_publicacao(String data_publicacao) {
            this.data_publicacao = data_publicacao;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getIntroducao() {
            return introducao;
        }

        public void setIntroducao(String introducao) {
            this.introducao = introducao;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
