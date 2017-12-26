package com.tts.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tts.data.database.tables.SessionTable;

import java.util.List;

/**
 *
 */

@Dao
public interface SessionDao {

    @Query("SELECT * FROM session")
    List<SessionTable> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SessionTable session);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(SessionTable... sessions);

    @Update
    void updateAll(SessionTable... sessions);

    @Delete
    void delete(SessionTable session);

    @Delete
    void deleteAll(SessionTable... sessions);
}
