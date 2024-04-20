package com.Ada.SkyFeedConnect.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsIBGE {

    private news[] newss;

    public news[] getnewss() {
        return newss;
    }

    public static class news {
        @JsonProperty("titulo")
        private String title;
        private String link;
        @JsonProperty("introducao")
        private String introduction;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }
    }
}
