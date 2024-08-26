package com.javalab.calendar.vo;

public class UserVo {
    private String username;
    private String gender; // "male" or "female"

    public UserVo(String username, String gender) {
        this.username = username;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

