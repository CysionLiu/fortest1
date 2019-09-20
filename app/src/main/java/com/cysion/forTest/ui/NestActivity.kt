package com.cysion.forTest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cysion.forTest.R
import kotlinx.android.synthetic.main.activity_nest.*

class NestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nest)
        rvlist.layoutManager = LinearLayoutManager(this)
        rvlist.adapter = NestAdapter()
    }
}
