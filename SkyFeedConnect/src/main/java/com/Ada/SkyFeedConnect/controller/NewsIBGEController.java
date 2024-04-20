package com.Ada.SkyFeedConnect.controller;

import com.Ada.SkyFeedConnect.dto.NewsResponseIBGE_DTO;
import com.Ada.SkyFeedConnect.model.NewsResponseIBGE;
import com.Ada.SkyFeedConnect.service.NewsResponseIBGE_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/newsIBGE")
public class NewsIBGEController {

    private final NewsResponseIBGE_Service newsIBGEService;

    @Autowired
    public NewsIBGEController(NewsResponseIBGE_Service newsIBGEService) {
        this.newsIBGEService = newsIBGEService;
    }

    @GetMapping
    public NewsResponseIBGE_DTO getNewsIBGE() {
        return newsIBGEService.getNewsIBGE();
    }
}
