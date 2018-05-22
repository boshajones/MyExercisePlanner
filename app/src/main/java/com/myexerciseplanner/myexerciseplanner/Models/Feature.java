package com.myexerciseplanner.myexerciseplanner.Models;

import android.content.Intent;

import java.util.UUID;

public class Feature {
    private UUID mFeatureId;
    private String mTitle;
    private String mSubTitle;
    private String mDescription;
    private String mActionText;
    private Intent mActionIntent;

    public Feature(UUID featureId, String title, String subTitle, String description, String actionText, Intent actionIntent) {
        mFeatureId = featureId;
        mTitle = title;
        mSubTitle = subTitle;
        mDescription = description;
        mActionText = actionText;
        mActionIntent = actionIntent;
    }

    public UUID getFeatureId() {
        return mFeatureId;
    }

    public void setFeatureId(UUID featureId) {
        mFeatureId = featureId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String subTitle) {
        mSubTitle = subTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getActionText() {
        return mActionText;
    }

    public void setActionText(String actionText) {
        mActionText = actionText;
    }

    public Intent getActionIntent() {
        return mActionIntent;
    }

    public void setActionIntent(Intent actionIntent) {
        mActionIntent = actionIntent;
    }
}
