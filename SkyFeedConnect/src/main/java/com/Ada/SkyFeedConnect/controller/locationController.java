package com.Ada.SkyFeedConnect.controller;

import com.Ada.SkyFeedConnect.dto.locationDTO;
import com.Ada.SkyFeedConnect.service.locationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notices/location")
@RequiredArgsConstructor
public class locationController {

    private final locationService locationService;

    @PostMapping("notices/location")
    public ResponseEntity<?> getLocation(@RequestBody locationDTO locationDTO) {
        locationService.processLocation(locationDTO);
        return ResponseEntity.ok().build();
    }
}
