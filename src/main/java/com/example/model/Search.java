package com.example.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by trainer6 on 5/13/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Title",
        "Year",
        "imdbID",
        "Type",
        "Poster"
})
public class Search {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Poster")
    private String poster;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("Year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("imdbId")
    public String getImdbID() {
        return imdbID;
    }

    @JsonProperty("imdbID")
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @JsonIgnore
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("poster")
    public String getPoster() {
        return poster;
    }

    @JsonProperty("Poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}



