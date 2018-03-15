package com.a4direct.sample.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.a4direct.blanket.adapter.BaseObject;

import java.util.UUID;

/**
 * Created by Jyothi Asapu on 25-01-2018.
 */

@Entity(tableName = "feedback")
public final class Feedback extends BaseObject {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String id;

    @Nullable
    @ColumnInfo(name = "description")
    public String description;

    @Nullable
    @ColumnInfo(name = "title")
    public String title;

    @Nullable
    @ColumnInfo(name = "feedback_by")
    public String feedback_by;

    @Ignore
    public Feedback(@Nullable String title, @Nullable String description,
                    @Nullable String feedback_by) {
        this(UUID.randomUUID().toString(), title, description, feedback_by);
    }

    public Feedback(@NonNull String id, @Nullable String title, @Nullable String description,
                    @Nullable String feedback_by) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.feedback_by = feedback_by;
    }

    @NonNull
    @Override
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public String getFeedback_by() {
        return feedback_by;
    }

    public void setFeedback_by(@Nullable String feedback_by) {
        this.feedback_by = feedback_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Feedback feedback = (Feedback) o;
        if (!id.equals(feedback.id)) {
            return false;
        }

        if (description != null ? !description.equals(feedback.description) : feedback.description != null) {
            return false;
        }

        if (title != null ? !title.equals(feedback.title) : feedback.title != null) {
            return false;
        }

        return feedback_by != null ? feedback_by.equals(feedback.feedback_by) : feedback.feedback_by == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (feedback_by != null ? feedback_by.hashCode() : 0);
        return result;
    }
}
