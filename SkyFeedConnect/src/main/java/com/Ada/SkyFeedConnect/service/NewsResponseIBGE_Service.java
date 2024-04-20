package com.Ada.SkyFeedConnect.service;

import com.Ada.SkyFeedConnect.dto.NewsResponseIBGE_DTO;
import com.Ada.SkyFeedConnect.model.NewsResponseIBGE;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsResponseIBGE_Service {

    public NewsResponseIBGE_DTO getNewsIBGE() {
        String url = "https://servicodados.ibge.gov.br/api/v3/noticias/?qtd=3";
        RestTemplate restTemplate = new RestTemplate();
        NewsResponseIBGE response = restTemplate.getForObject(url, NewsResponseIBGE.class);

        List<NewsResponseIBGE_DTO.NewsItemDTO> newsItemList = new ArrayList<>();

        for (NewsResponseIBGE.NewsItem item : response.getItems()) {
            NewsResponseIBGE_DTO.NewsItemDTO newsItemDTO = new NewsResponseIBGE_DTO.NewsItemDTO(item.getData_publicacao(),
                    item.getTitulo(), item.getIntroducao(), item.getLink());
            newsItemList.add(newsItemDTO);
        }

        NewsResponseIBGE_DTO newsResponseIBGE_dto = new NewsResponseIBGE_DTO(newsItemList);

        return newsResponseIBGE_dto;
    }
}

