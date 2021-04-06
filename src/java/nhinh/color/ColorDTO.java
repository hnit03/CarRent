/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.color;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class ColorDTO implements Serializable{
    private String colorID;
    private String colorName;

    public ColorDTO() {
    }

    public ColorDTO(String colorID, String colorName) {
        this.colorID = colorID;
        this.colorName = colorName;
    }

    /**
     * @return the colorID
     */
    public String getColorID() {
        return colorID;
    }

    /**
     * @param colorID the colorID to set
     */
    public void setColorID(String colorID) {
        this.colorID = colorID;
    }

    /**
     * @return the colorName
     */
    public String getColorName() {
        return colorName;
    }

    /**
     * @param colorName the colorName to set
     */
    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
    
    
}
