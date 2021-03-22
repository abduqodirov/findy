package com.abduqodirov.findy;

public class LostItem {

    private String title;
    private long gift;
    private long lostDate;

    public LostItem(String title, long gift, long lostDate) {
        this.title = title;
        this.gift = gift;
        this.lostDate = lostDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getGift() {
        return gift;
    }

    public void setGift(long gift) {
        this.gift = gift;
    }

    public long getLostDate() {
        return lostDate;
    }

    public void setLostDate(long lostDate) {
        this.lostDate = lostDate;
    }
}
