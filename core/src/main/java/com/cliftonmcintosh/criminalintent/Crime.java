package com.cliftonmcintosh.criminalintent;

import org.joda.time.LocalDateTime;

import java.util.UUID;

/**
 * Created by cmcintosh on 1/26/15.
 */
public class Crime {

    private long mId;
    private String mExternalId;
    private String mTitle;
    private String mDescription;
    private LocalDateTime mDateTime;
    private boolean mSolved;

    public Crime() {
        mId = -1;
        mExternalId = UUID.randomUUID().toString();
        mDateTime = new LocalDateTime();
        mSolved = false;
    }

    public Crime(long id, String externalId, String title, String description, LocalDateTime dateTime, boolean solved) {
        mId = id;
        mExternalId = externalId;
        mTitle = title;
        mDescription = description;
        mDateTime = dateTime;
        mSolved = solved;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getExternalId() {
        return mExternalId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
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