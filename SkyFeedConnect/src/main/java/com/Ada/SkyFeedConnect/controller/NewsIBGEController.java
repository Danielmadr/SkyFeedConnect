package com.Ada.SkyFeedConnect.controller;

import com.Ada.SkyFeedConnect.dto.NewsResponseIBGE_DTO;
import com.Ada.SkyFeedConnect.service.NewsResponseIBGE_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/newsIBGE")
@CrossOrigin
public class NewsIBGEController {

  private final NewsResponseIBGE_Service newsIBGEService;

  @Autowired
  public NewsIBGEController(NewsResponseIBGE_Service newsIBGEService) {
    this.newsIBGEService = newsIBGEService;
  }

  @GetMapping("/{qtd}")
  public NewsResponseIBGE_DTO getNewsIBGE(@PathVariable Integer qtd) {
    return newsIBGEService.getNewsIBGE(qtd);
  }
}
