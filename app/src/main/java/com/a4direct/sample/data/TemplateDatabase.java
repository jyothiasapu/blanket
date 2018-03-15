package com.a4direct.sample.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.a4direct.sample.model.Feedback;


/**
 * Created by Jyothi Asapu on 28-01-2018.
 */

@Database(entities = {Feedback.class}, version = 1, exportSchema = false)
public abstract class TemplateDatabase extends RoomDatabase {

    public abstract FeedbackDao feedbackDao();

}
