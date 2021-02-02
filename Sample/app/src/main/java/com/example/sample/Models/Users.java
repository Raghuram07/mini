package com.example.sample.Models;

public class Users {

    String ProfilePic, mail, password , userid ,lastmessage;

    public Users(String profilePic, String mail, String password, String userid, String lastmessage) {
        ProfilePic = profilePic;
        this.mail = mail;
        this.password = password;
        this.userid = userid;
        this.lastmessage = lastmessage;
    }
    public Users(){}

    //signup Costructors
    public Users(String mail, String password, String userid) {
        this.mail = mail;
        this.password = password;
        this.userid = userid;
        this.lastmessage = lastmessage;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setProfilePic(String profilePic) {
        ProfilePic = profilePic;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setLastmessage(String lastmessage) {
        this.lastmessage = lastmessage;
    }

    public String getUserid() {
        return userid;
    }

    public String getLastmessage() {
        return lastmessage;
    }
}
