package com.Ada.SkyFeedConnect.service;

import com.Ada.SkyFeedConnect.dto.NewsResponseIBGE_DTO;
import com.Ada.SkyFeedConnect.model.NewsResponseIBGE;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class NewsResponseIBGE_Service {

  public NewsResponseIBGE_DTO getNewsIBGE(Integer qtd) {
    if (qtd == null || qtd == 0) {
      qtd = 1;
    }
    String url = "https://servicodados.ibge.gov.br/api/v3/noticias/?qtd=" + qtd;
    RestTemplate restTemplate = new RestTemplate();
    NewsResponseIBGE response = restTemplate.getForObject(url, NewsResponseIBGE.class);

    NewsResponseIBGE_DTO newsItemList = new NewsResponseIBGE_DTO(new ArrayList<>());

    if (response != null) {
      for (NewsResponseIBGE.NewsItem item : response.getItems()) {
        String imageIntroduction = getImageIntroduction(item.getImagens());
        item.setImagens(imageIntroduction);
        newsItemList.newsList().add(item);
      }
    }
    return newsItemList;
  }

  private String getImageIntroduction(String images) {
    String imageIntroduction;
    String[] imageArray = images.split(",");
    imageIntroduction = imageArray[0].split("\"")[3];
    imageIntroduction = imageIntroduction.replaceAll("\\\\", "");
    return "https://agenciadenoticias.ibge.gov.br/" + imageIntroduction;
  }
}

