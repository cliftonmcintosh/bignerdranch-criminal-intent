package com.cliftonmcintosh.criminalintent;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.UUID;

/**
 * Created by cmcintosh on 1/26/15.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private LocalDateTime mDateTime;
    private boolean mSolved;

    public Crime() {
        mId = UUID.randomUUID();
        mDateTime = new LocalDateTime();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public LocalDateTime getDateTime() {
        return mDateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        mDateTime = dateTime;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}