package com.zq.books.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 *
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long doubanId;

    private String phoneNo;

    private String isbn;

    private String title;

    private String summary;

    private String authorJson;

    private String image;

    private String rating;

    private String publisher;

    private String translatorJson;

    private String price;

    private String authorIntro;

    private String state;

    private Double deposite;

    private Double jhiCost;

    private Instant returnPeriod;

    private String cityName;

    public Long getDoubanId() {
        return doubanId;
    }

    public void setDoubanId(Long doubanId) {
        this.doubanId = doubanId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorJson() {
        return authorJson;
    }

    public void setAuthorJson(String authorJson) {
        this.authorJson = authorJson;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTranslatorJson() {
        return translatorJson;
    }

    public void setTranslatorJson(String translatorJson) {
        this.translatorJson = translatorJson;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getDeposite() {
        return deposite;
    }

    public void setDeposite(Double deposite) {
        this.deposite = deposite;
    }

    public Double getJhiCost() {
        return jhiCost;
    }

    public void setJhiCost(Double jhiCost) {
        this.jhiCost = jhiCost;
    }

    public Instant getReturnPeriod() {
        return returnPeriod;
    }

    public void setReturnPeriod(Instant returnPeriod) {
        this.returnPeriod = returnPeriod;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        if (book.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", phoneNo='" + getPhoneNo() + "'" +
                ", isbn='" + getIsbn() + "'" +
                ", title='" + getTitle() + "'" +
                ", authorJson='" + getAuthorJson() + "'" +
                ", image='" + getImage() + "'" +
                ", rating='" + getRating() + "'" +
                ", publisher='" + getPublisher() + "'" +
                ", translatorJson='" + getTranslatorJson() + "'" +
                ", price=" + getPrice() +
                ", authorIntro='" + getAuthorIntro() + "'" +
                ", state='" + getState() + "'" +
                ", deposite=" + getDeposite() +
                ", jhiCost=" + getJhiCost() +
                ", returnPeriod='" + getReturnPeriod() + "'" +
                ", cityName='" + getCityName() + "'" +
                "}";
    }
}
