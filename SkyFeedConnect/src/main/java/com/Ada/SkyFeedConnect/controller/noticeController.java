package com.Ada.SkyFeedConnect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notices")

public class noticeController {

    public String getNotices() {
        return "Notices";
    }
}
