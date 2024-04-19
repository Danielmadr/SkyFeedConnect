package com.Ada.SkyFeedConnect.dto;

import com.Ada.SkyFeedConnect.model.Location;

public record locationDTO(double latitude, double longitude) {
    public Location toLocation() {
        return new Location(latitude, longitude);
    }
}
