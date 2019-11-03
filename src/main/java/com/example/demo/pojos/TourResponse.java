package com.example.demo.pojos;

public class TourResponse {

    private long id;
    private int price;
    private int discount;
    private int finalPrice;
    private String title;
    private String shortDescription;
    private String longDescription;
    private String tourPackageTitle;

    public TourResponse(long id, int price, int discount, int finalPrice, String title, String shortDescription, String longDescription, String tourPackageTitle) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.tourPackageTitle = tourPackageTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getTourPackageTitle() {
        return tourPackageTitle;
    }

    public void setTourPackageTitle(String tourPackageTitle) {
        this.tourPackageTitle = tourPackageTitle;
    }
}
