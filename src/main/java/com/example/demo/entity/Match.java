package com.example.demo.entity;

/**
 * Created by dsm2061 on 12/3/18.
 */
public class Match {

    private String displayName;
    private Integer age;
    private String jobTitle;
    private int heightInCm;
    private City city;
    private String mainPhoto;
    private Double compatibilityScore;
    private int contactsExchanged;
    private Boolean favourite;
    private String religion;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(int heightInCm) {
        this.heightInCm = heightInCm;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public Double getCompatibilityScore() {
        return compatibilityScore;
    }

    public void setCompatibilityScore(Double compatibilityScore) {
        this.compatibilityScore = compatibilityScore;
    }

    public int getContactsExchanged() {
        return contactsExchanged;
    }

    public void setContactsExchanged(int contactsExchanged) {
        this.contactsExchanged = contactsExchanged;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }
}
