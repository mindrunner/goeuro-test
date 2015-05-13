package de.mindrunner.goeuro.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Lukas Elsner <open@mindrunner.de>
 * @version 1.0
 * @since 13-05-2015
 * <p>
 * POJO representing Position
 */
public class Position {
    @JsonProperty("_id")
    private Integer id;
    @JsonProperty("key")
    private String key;
    @JsonProperty("name")
    private String name;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("iata_airport_code")
    private String iataAirportCode;
    @JsonProperty("type")
    private String type;
    @JsonProperty("country")
    private String country;
    @JsonProperty("geo_position")
    private GeoPosition geoPosition;
    @JsonProperty("locationId")
    private Integer locationId;
    @JsonProperty("inEurope")
    private Boolean inEurope;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("coreCountry")
    private Boolean coreCountry;
    @JsonProperty("distance")
    private Integer distance;

    public Integer getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIataAirportCode() {
        return iataAirportCode;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public Boolean getInEurope() {
        return inEurope;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Boolean getCoreCountry() {
        return coreCountry;
    }

    public Integer getDistance() {
        return distance;
    }

    /**
     * String representation of this object
     *
     * @return The CSV formatted data ob this object for using it with the CsvWriter
     */
    public String toString() {
        return String.format("%s,%d,%s,%s,%f,%f",
                this.getClass().getSimpleName(),
                getId(),
                getName(),
                getType(),
                getGeoPosition().getLatitude(),
                getGeoPosition().getLongitude());
    }
}
