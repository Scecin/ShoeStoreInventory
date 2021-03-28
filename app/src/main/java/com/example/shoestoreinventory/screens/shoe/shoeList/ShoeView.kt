package com.example.shoestoreinventory.screens.shoe.shoeList

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.shoestoreinventory.R
import kotlinx.android.synthetic.main.shoe_item.view.*

class ShoeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val inflater: LayoutInflater by lazy { LayoutInflater.from(context) }

    init {
        inflater.inflate(R.layout.shoe_item, this, false)
        constraint_layout.layoutParams.height = 150
        constraint_layout.layoutParams.width = MATCH_PARENT
    }

    fun setShoeItemView(shoe: Shoe) {
        shoe_name.text = shoe.name
        shoe_brand.text = shoe.brand
        shoe_gender.text = shoe.gender
        shoe_size.text = shoe.size
        shoe_description.text = shoe.description

    }
}
