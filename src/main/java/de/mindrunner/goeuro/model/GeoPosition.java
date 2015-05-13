package de.mindrunner.goeuro.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Lukas Elsner <open@mindrunner.de>
 * @version 1.0
 * @since 13-05-2015
 * <p>
 * POJO representing GeoPosition
 */
public class GeoPosition {
    @JsonProperty("latitude")
    private double latitude;
    @JsonProperty("longitude")
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
