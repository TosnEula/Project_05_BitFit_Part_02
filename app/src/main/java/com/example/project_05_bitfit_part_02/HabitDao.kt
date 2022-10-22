package com.example.project_05_bitfit_part_02

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

val high = "High"
@Dao
interface HabitDao {
    @Query("SELECT * FROM habit_table")
    fun getAll(): Flow<List<HabitEntity>>

    @Insert
    fun insertAll(habits: List<HabitEntity>)

    @Insert
    fun insert(habits: HabitEntity)

    @Query("DELETE FROM habit_table")
    fun deleteAll()

    @Query("SELECT COUNT (habitValue) " +
            "FROM habit_table " +
            "WHERE habitValue='High'")
    fun getHighTotal() : Int
}