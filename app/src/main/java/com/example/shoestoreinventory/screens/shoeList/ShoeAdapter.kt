package com.example.shoestoreinventory.screens.shoeList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.shoestoreinventory.R
import kotlinx.android.synthetic.main.shoe_item.view.*

class ShoeAdapter(private val mContext: Context, private val shoeList: List<Shoe>):
    ArrayAdapter<Shoe>(mContext, 0, shoeList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout  = LayoutInflater.from(mContext).inflate(R.layout.shoe_item, parent, false)

        val shoe = shoeList[position]

        layout.image_item_view.setImageResource(shoe.imageView)
        layout.shoe_name.text = shoe.name
        layout.shoe_brand.text = shoe.brand
        layout.shoe_gender.text = shoe.gender

        return layout
    }
}

