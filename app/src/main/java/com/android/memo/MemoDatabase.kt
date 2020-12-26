package com.android.memo

import android.content.Context
import androidx.room.*

@Database(entities = [Memo::class], version = 2)
abstract class MemoDatabase:RoomDatabase() {
    abstract fun memoDao(): MemoDao

    companion object{
        private var INSTANCE: MemoDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): MemoDatabase{
            synchronized(lock){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MemoDatabase::class.java, "Memodata.db"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}