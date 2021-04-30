package main.model.business;

import main.model.users.ActorUser;

public class BusinessReview {
    private int rating;
    private String comment;
    private Business businessToReview;
    private String reviewer;


    public BusinessReview() {
    }

    public BusinessReview(int rating, String comment, Business businessToReview, String reviewer) {
        this.rating = rating;
        this.comment = comment;
        this.businessToReview = businessToReview;
        this.reviewer = reviewer;
    }


    //Setters
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setBusinessToReview(Business businessToReview) {
        this.businessToReview = businessToReview;
    }
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    //Getters
    public int getRating() {
        return rating;
    }
    public String getComment() {
        return comment;
    }
    public Business getBusinessToReview() {
        return businessToReview;
    }
    public String getReviewer() {
        return reviewer;
    }
}