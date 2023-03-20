package com.example.timetolearn;

public class MovieData {
    //Atribut
    private String name;
    private String image_url;
    private String year;
    private String web_url;
    //Konstruktor
    public MovieData(String name, String image_url, String year, String
            web_url) {
        this.name = name;
        this.image_url = image_url;
        this.year = year;
        this.web_url = web_url;
    }
    //Getter/Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getWeb_url() {
        return web_url;
    }
    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}
