package com.Ada.SkyFeedConnect.service;

import com.Ada.SkyFeedConnect.dto.NewsResponseIBGE_DTO;
import com.Ada.SkyFeedConnect.model.NewsResponseIBGE;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsResponseIBGE_Service {

  public NewsResponseIBGE_DTO getNewsIBGE(Integer qtd) {
    if (qtd == null || qtd == 0) {
      qtd = 1;
    }
    String url = "https://servicodados.ibge.gov.br/api/v3/noticias/?qtd=" + qtd;
    RestTemplate restTemplate = new RestTemplate();
    NewsResponseIBGE response = restTemplate.getForObject(url, NewsResponseIBGE.class);

    List<NewsResponseIBGE_DTO.NewsItemDTO> newsItemList = new ArrayList<>();

    for (NewsResponseIBGE.NewsItem item : response.getItems()) {
      String imageIntroduction = "https://agenciadenoticias.ibge.gov.br/" + getImageIntroduction(item);
      NewsResponseIBGE_DTO.NewsItemDTO newsItemDTO = new NewsResponseIBGE_DTO.NewsItemDTO(item.getData_publicacao(),
              item.getTitulo(), item.getIntroducao(), item.getLink(), imageIntroduction);
      newsItemList.add(newsItemDTO);
    }

    return new NewsResponseIBGE_DTO(newsItemList);
  }

  private String getImageIntroduction(NewsResponseIBGE.NewsItem response) {
    String imageIntroduction = "";
    String images = response.getImagens();
    String[] imageArray = images.split(",");
    imageIntroduction = imageArray[0].split("\"")[3];
    imageIntroduction = imageIntroduction.replaceAll("\\\\", "");
    return imageIntroduction;
  }
}

