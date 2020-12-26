package com.android.memo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Memo (
    @PrimaryKey(autoGenerate = true) val id: Int,
    var text: String?
)