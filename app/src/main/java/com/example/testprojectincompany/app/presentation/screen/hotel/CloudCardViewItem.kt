package com.example.testprojectincompany.app.presentation.screen.hotel

import android.content.Context
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.example.testprojectincompany.R
import com.google.android.material.textview.MaterialTextView

class CloudCardViewItem(context: Context) : CardView(context) {

    constructor(context: Context, text: String) : this(context) {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val inflat =
            inflater.inflate(R.layout.hotel_cloud_tag_layout, this)

        val textView = inflat.findViewById<MaterialTextView>(R.id.tvCloudString)
        textView.text = text
    }

    private fun initializeViews(context: Context) {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.hotel_cloud_tag_layout, this)
    }
}
