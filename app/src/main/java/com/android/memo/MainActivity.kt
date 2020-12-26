package com.android.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveButton: Button = findViewById(R.id.saveButton)
        val memoText: TextView = findViewById(R.id.memoText)
        val memoView: TextView = findViewById(R.id.memoView)
        val database = MemoDatabase.getInstance(this)
        val memoDao = database.memoDao()


        saveButton.setOnClickListener{

            val newMemo = Memo(0,memoText.text.toString())
            memoDao.insert(newMemo)
            memoView.text = memoText.text

        }
    }
}