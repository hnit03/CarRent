/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.category;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class CategoryDTO implements Serializable{
    private String categoryID;
    private String category;

    public CategoryDTO() {
    }

    public CategoryDTO(String categoryID, String category) {
        this.categoryID = categoryID;
        this.category = category;
    }

    /**
     * @return the categoryID
     */
    public String getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID the categoryID to set
     */
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
