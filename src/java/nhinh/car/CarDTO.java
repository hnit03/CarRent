/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.car;

import java.io.Serializable;
import nhinh.category.CategoryDTO;
import nhinh.color.ColorDTO;

/**
 *
 * @author PC
 */
public class CarDTO implements Serializable{
    private String carID;
    private String carName;
    private String image;
    private ColorDTO cdto;
    private int year;
    private CategoryDTO cateDTO;
    private String price;
    private int quantity;
    private String statusID;

    public CarDTO() {
    }

    public CarDTO(String carID, String carName, String image, ColorDTO cdto, int year, CategoryDTO cateDTO, String price, int quantity, String statusID) {
        this.carID = carID;
        this.carName = carName;
        this.image = image;
        this.cdto = cdto;
        this.year = year;
        this.cateDTO = cateDTO;
        this.price = price;
        this.quantity = quantity;
        this.statusID = statusID;
    }

    /**
     * @return the carID
     */
    public String getCarID() {
        return carID;
    }

    /**
     * @param carID the carID to set
     */
    public void setCarID(String carID) {
        this.carID = carID;
    }

    /**
     * @return the carName
     */
    public String getCarName() {
        return carName;
    }

    /**
     * @param carName the carName to set
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the cdto
     */
    public ColorDTO getCdto() {
        return cdto;
    }

    /**
     * @param cdto the cdto to set
     */
    public void setCdto(ColorDTO cdto) {
        this.cdto = cdto;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the cateDTO
     */
    public CategoryDTO getCateDTO() {
        return cateDTO;
    }

    /**
     * @param cateDTO the cateDTO to set
     */
    public void setCateDTO(CategoryDTO cateDTO) {
        this.cateDTO = cateDTO;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the statusID
     */
    public String getStatusID() {
        return statusID;
    }

    /**
     * @param statusID the statusID to set
     */
    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }
    
    
    
}
