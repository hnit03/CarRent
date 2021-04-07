/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.status;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class StatusDTO implements Serializable{
    private String statusID;
    private String statusName;

    public StatusDTO() {
    }

    public StatusDTO(String statusID, String statusName) {
        this.statusID = statusID;
        this.statusName = statusName;
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

    /**
     * @return the statusName
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * @param statusName the statusName to set
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
