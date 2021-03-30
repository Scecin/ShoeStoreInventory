package com.example.shoestoreinventory.screens.shoe.shoeList

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.shoestoreinventory.R

class ShoeItem(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    init {
        val shoeImage: ImageView = findViewById(R.id.shoe_image)
        val shoeName: TextView = findViewById(R.id.shoe_name)
        val shoeBrand: TextView = findViewById(R.id.shoe_brand)
        val shoeGender: TextView= findViewById(R.id.shoe_gender)
        val shoeSize: TextView = findViewById(R.id.shoe_size)
        val shoeDescription: TextView = findViewById(R.id.shoe_description)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ShoeItem)
        shoeImage.setImageDrawable(attributes.getDrawable(R.styleable.ShoeItem_image))
        shoeName.text = attributes.getString(R.styleable.ShoeItem_text)
        shoeBrand.text = attributes.getString(R.styleable.ShoeItem_text)
        shoeGender.text = attributes.getString(R.styleable.ShoeItem_text)
        shoeSize.text = attributes.getString(R.styleable.ShoeItem_text)
        shoeDescription.text = attributes.getString(R.styleable.ShoeItem_text)

        attributes.recycle()
    }
}