package com.example.demo.entity;

/**
 * Created by dsm2061 on 12/3/18.
 */
public class Filter {

    private boolean hasPhoto;
    private boolean inContact;
    private boolean favourite;
    private Integer compatibilityScore;
    private Integer age;
    private Integer height;
    private Integer distanceInKm;

    public boolean isHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(boolean hasPhoto) {
        this.hasPhoto = hasPhoto;
    }

    public boolean isInContact() {
        return inContact;
    }

    public void setInContact(boolean inContact) {
        this.inContact = inContact;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public Integer getCompatibilityScore() {
        return compatibilityScore;
    }

    public void setCompatibilityScore(Integer compatibilityScore) {
        this.compatibilityScore = compatibilityScore;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(Integer distanceInKm) {
        this.distanceInKm = distanceInKm;
    }
}
