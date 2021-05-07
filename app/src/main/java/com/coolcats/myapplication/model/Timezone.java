
package com.coolcats.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timezone {

    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("description")
    @Expose
    private String description;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Timezone.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offset");
        sb.append('=');
        sb.append(((this.offset == null)?"<null>":this.offset));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
