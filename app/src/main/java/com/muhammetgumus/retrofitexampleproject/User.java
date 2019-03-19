package com.muhammetgumus.retrofitexampleproject;

class User {
    public String name;
    public String surName;

    public User(){}
    public User(String name, String surName){
        this.name=name;
        this.surName=surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
