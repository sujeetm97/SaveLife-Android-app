package com.android.iunoob.bloodbank;

public class FirstQuestion {

    private String firstuestion,desc;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public FirstQuestion(String firstuestion, String desc) {
        this.firstuestion = firstuestion;
        this.desc = desc;
        this.expandable = false;

    }

    public String getFirstuestion() {

        return firstuestion;
    }

    public void setFirstuestion(String firstuestion) {

        this.firstuestion = firstuestion;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "FirstQuestion{" +
                "firstuestion='" + firstuestion + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
