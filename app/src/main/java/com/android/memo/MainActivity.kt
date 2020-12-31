package com.android.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveButton: Button = findViewById(R.id.saveButton)
        val memoText: TextView = findViewById(R.id.memoText)

        val database = MemoDatabase.getInstance(this)
        val memoDao = database.memoDao()
        val memoList = memoDao.getAll()
        val data = arrayListOf("0")

        for (memo in memoList) {
            data.add(memo.text.toString())
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,data)
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = adapter

        saveButton.setOnClickListener{
            val newMemo = Memo(0,memoText.text.toString())
            memoDao.insert(newMemo)
        }
    }
}