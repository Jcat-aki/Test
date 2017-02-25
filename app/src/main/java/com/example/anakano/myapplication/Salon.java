package com.example.anakano.myapplication;

/**
 * Created by anakano on 16/07/24.
 */
public class Salon {
    private String shopName;
    private String shopAddress;
    private String shopAccess;
    private String shopImage;
    private String shopDescription;
    private String shopId;

    /**
     * 空のコンストラクタ
     */
    public Salon(){
    }

    public Salon(String shopName, String shopAddress, String shopAccess, String shopImage, String shopDescription, String shopId) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopAccess = shopAccess;
        this.shopImage = shopImage;
        this.shopDescription = shopDescription;
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopAccess() {
        return shopAccess;
    }

    public void setShopAccess(String shopAccess) {
        this.shopAccess = shopAccess;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public void setShopId(String shopId){
        this.shopId = shopId;
    }
    public String getShopId(){
        return this.shopId;
    }

}
