package com.roth.cs.bottomnavigation.postModel;

public class PostModel {
    String time, profile, imageURL, text_comment, profile_comment, user_name, imageName, more, btn_submit_comment, comment;

    public PostModel() {
    }

    public PostModel(String imageURL, String imageName) {
        this.imageURL = imageURL;
        this.imageName = imageName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getText_comment() {
        return text_comment;
    }

    public void setText_comment(String text_comment) {
        this.text_comment = text_comment;
    }

    public String getProfile_comment() {
        return profile_comment;
    }

    public void setProfile_comment(String profile_comment) {
        this.profile_comment = profile_comment;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getBtn_submit_comment() {
        return btn_submit_comment;
    }

    public void setBtn_submit_comment(String btn_submit_comment) {
        this.btn_submit_comment = btn_submit_comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
