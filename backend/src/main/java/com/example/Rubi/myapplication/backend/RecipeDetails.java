package com.example.Rubi.myapplication.backend;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Link;
import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by Rubi on 30/03/2015.
 */
public class RecipeDetails {
    @Id
    Long id;
    String name;
    String description;
    Text ingredients;
    Text directions;
    Text nutritionFacts;
    Link youtube_url;
    String image_url;

    Key<SeafoodSpecies> seafoodSpecs;
    BlobKey image;

    public String getCookingName() {
        return name;
    }

    public void setCookingName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Text getDirections() {
        return directions;
    }

    public void setDirections(Text directions) {
        this.directions = directions;
    }

    public Link getYoutube_url() {
        return youtube_url;
    }

    public void setYoutube_url(Link youtube_url) {
        this.youtube_url = youtube_url;
    }

    public BlobKey getImage() {
        return image;
    }

    public void setImage(BlobKey image) {
        this.image = image;
    }

    @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    public Key<SeafoodSpecies> getSeafoodSpecies() {
        return seafoodSpecs;
    }

    @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    public void setSeafoodSpecies(Key<SeafoodSpecies> seafoodSpecs) {
        this.seafoodSpecs = seafoodSpecs;
    }

    public Long getSeafoodSpeciesId(){
        return seafoodSpecs == null ? null : seafoodSpecs.getId();
    }

    public void setSeafoodSpeciesId(Long seafoodId){
        seafoodSpecs = Key.create(SeafoodSpecies.class, getSeafoodSpeciesId());
    }

    public Text getIngredients() {
        return ingredients;
    }

    public void setIngredients(Text ingredients) {
        this.ingredients = ingredients;
    }

    public Text getNutritionFacts() {
        return nutritionFacts;
    }

    public void setNutritionFacts(Text nutritionFacts) {
        this.nutritionFacts = nutritionFacts;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
