package com.example.androidapp1d.Prof;

import java.util.ArrayList;

/**
 * Created by Cheryl Goh on 11/12/2017.
 */

public class ProfItem {
    private String year, description, email, staffID, office,venue,timeslotsize;
    private ArrayList<String> mods = new ArrayList<>();
    private ArrayList<String> availPreference = new ArrayList<>();

    public ProfItem(String year, String description, String email,
                    String staffID, String office,String venue,String timeslotsize, ArrayList<String> mods, ArrayList<String> availPreference) {
        this.year = year;
        this.description = description;
        this.email = email;
        this.staffID = staffID;
        this.mods = mods;
        this.availPreference = availPreference;
        this.office = office;
        this.venue = venue;
        this.timeslotsize = timeslotsize;
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

    public ArrayList<String> getAvailPreference() {
        return availPreference;
    }

    public void setAvailPreference(ArrayList<String> availPreference) {
        this.availPreference = availPreference;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getTimeslotsize() {
        return timeslotsize;
    }

    public void setTimeslotsize(String timeslotsize) {
        this.timeslotsize = timeslotsize;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
