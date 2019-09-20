package com.cysion.forTest.ui

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NestAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("--d","--")
        return InnerHolder(TextView(parent.context).apply {
            text="haha"
            textSize=20f
        })
    }

    override fun getItemCount(): Int =100

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("--d","$position")
    }

}

class InnerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}