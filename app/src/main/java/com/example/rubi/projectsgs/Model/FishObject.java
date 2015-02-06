package com.example.rubi.projectsgs.Model;

import java.io.Serializable;

/**
 * Created by Rubi on 02/02/2015.
 */
public class FishObject implements Serializable {

    public String cookingName;
    public String cookingMaterials;
    public String cookingMethod;
    public String kitchen;
    public String type;
    public long fishId;
    public int imageId;

    public void setFishId(long fishId) {
        this.fishId = fishId;
    }

    public long getFishId() {
        return fishId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setCookingName(String cookingName) {
        this.cookingName = cookingName;
    }

    public String getCookingName() {
        return cookingName;
    }

    public void setCookingMaterials(String cookingMaterials) {
        this.cookingMaterials = cookingMaterials;
    }

    public String getCookingMaterials() {
        return cookingMaterials;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    public String getCookingMethod() {
        return cookingMethod;
    }
}

