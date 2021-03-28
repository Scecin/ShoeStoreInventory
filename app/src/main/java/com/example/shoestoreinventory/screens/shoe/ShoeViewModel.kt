package com.example.shoestoreinventory.screens.shoe

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.screens.shoe.shoeList.Shoe

class ShoeViewModel : ViewModel() {
    // Name
    private val _name = MutableLiveData<Editable>()
    val name: LiveData<Editable>
        get() = _name

    // Brand
    private val _brand = MutableLiveData<Editable>()
    val brand: LiveData<Editable>
        get() = _brand

    // Gender
    private val _gender = MutableLiveData<Editable>()
    val gender: LiveData<Editable>
        get() = _gender

    // Size
    private val _size = MutableLiveData<Editable>()
    val size: LiveData<Editable>
        get() = _size

    // Description
    private val _description = MutableLiveData<Editable>()
    val description: MutableLiveData<Editable>
        get() = _description

    private var _shoeList: MutableList<Shoe> = mutableListOf()
    val shoeList: MutableList<Shoe>
    get() = _shoeList

//    private val _addNewItem = MutableLiveData<Boolean>()
//    val addNewItem: LiveData<Boolean>
//    get() = _addNewItem


    //TODO create shoeList variable (val shoeList: MutableList<Shoe> = mutableListOf())

    init {
        //_addNewItem.value =false
        createList()
    }

    override fun onCleared() {
        super.onCleared()
    }

    private fun createList() {
        _shoeList = mutableListOf()
        val shoe = Shoe(
            R.drawable.boots_shoe, "Black boots", "Dr. Martens",
            "Women", "6.5", "Black ankle boots with laces."
        )
        val shoe2 = Shoe(
            R.drawable.heeled_shoe, "Classic white shoes", "Mustang",
            "Women", "7.0", "Heeled shoes in matte white. Classic model."
        )
        val shoe3 = Shoe(
            R.drawable.heeled_shoe1, "Classic black shoes", "Mustang",
            "Women", "5.5", "Heeled shoes in matte black. Classic model."
        )
        val shoe4 = Shoe(
            R.drawable.kid__shoe, "Multicolor kid trainers", "Adidas",
            "Women", "3.0", "Multicolor sneakers, with dotted laces and non-slip sole."
        )
        val shoe5 = Shoe(
            R.drawable.man_shoe, "Classic men shoes", "Clarks",
            "Men", "10.0", "Classic men's shoe, without laces and with a shield on the upper part."
        )
        val shoe6 = Shoe(
            R.drawable.mountain_boot_shoe, "Hiking shoes", "Columbia",
            "Men", "11.5", "Waterproof boots with non-slip soles and safety laces."
        )
        val shoe7 = Shoe(
            R.drawable.trainer_shoe, "Running trainers", "Nike",
            "Men", "9.0", "Running shoes, in gold and antiperspirant."
        )

    }

    fun addShoe(newShoe: Shoe) {
        shoeList.add(newShoe)
    }


}





