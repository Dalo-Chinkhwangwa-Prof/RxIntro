
package com.coolcats.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dob {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private int age;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Dob.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("age");
        sb.append('=');
        sb.append(this.age);
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
