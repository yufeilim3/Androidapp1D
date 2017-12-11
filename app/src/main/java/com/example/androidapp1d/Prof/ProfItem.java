package com.example.androidapp1d.Prof;

import java.util.ArrayList;

/**
 * Created by Cheryl Goh on 11/12/2017.
 */

public class ProfItem {
    private String year, description, email, staffID;
    private ArrayList<String> mods = new ArrayList<>();

    public ProfItem(String year, String description, String email,
                    String staffID, ArrayList<String> mods) {
        this.year = year;
        this.description = description;
        this.email = email;
        this.staffID = staffID;
        this.mods = mods;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

   public ArrayList<String> getMods() {
        return mods;
    }

    public void setMods(ArrayList<String> mods) {
        this.mods = mods;
    }
}