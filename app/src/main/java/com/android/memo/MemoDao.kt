package com.android.memo

import androidx.room.*

@Dao
interface MemoDao {
    @Query("Select * From memo")
    fun getAll() : List<Memo>

    @Insert
    fun insert(memo: Memo)

    @Update
    fun update(memo: Memo)

    @Delete
    fun delete(memo: Memo)
}