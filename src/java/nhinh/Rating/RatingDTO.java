/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.Rating;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class RatingDTO implements Serializable{
    private String ratingID;
    private String carID;
    private int point;
    private String comment;

    public RatingDTO() {
    }

    public RatingDTO(String ratingID, String carID, int point, String comment) {
        this.ratingID = ratingID;
        this.carID = carID;
        this.point = point;
        this.comment = comment;
    }

    /**
     * @return the ratingID
     */
    public String getRatingID() {
        return ratingID;
    }

    /**
     * @param ratingID the ratingID to set
     */
    public void setRatingID(String ratingID) {
        this.ratingID = ratingID;
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
     * @return the point
     */
    public int getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
