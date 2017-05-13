package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by trainer6 on 5/13/17.
 */
public class OmdbMovie {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("title")
    private String title;

    @JsonProperty("imdbId")
    private String imdbID;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("year")
    private String year;


}
