package com.a4direct.sample.data;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.a4direct.sample.model.Feedback;


/**
 * Created by Jyothi Asapu on 28-01-2018.
 */

@Dao
public interface FeedbackDao {

    @Query("SELECT * FROM feedback")
    public abstract DataSource.Factory<Integer, Feedback> getFeedbackList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFeedback(Feedback task);
}
