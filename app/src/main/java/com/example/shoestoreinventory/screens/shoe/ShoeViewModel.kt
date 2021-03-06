package com.example.shoestoreinventory.screens.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.screens.shoe.shoeList.Shoe

class ShoeViewModel : ViewModel() {

    // Shoe list
    private val _shoeList = MutableLiveData (mutableListOf<Shoe>())
    val shoeList: LiveData<MutableList<Shoe>>
    get() = _shoeList

    // Shoe
    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
    get() = _shoe

    private val _addNewItem = MutableLiveData<Boolean>()
    val addNewItem: LiveData<Boolean>
        get() = _addNewItem

    // Toast
    private val _eventNewShoeCreated = MutableLiveData<Boolean>()
    val eventNewShoeCreated: LiveData<Boolean>
        get() = _eventNewShoeCreated

    init {
        _eventNewShoeCreated.value = false
        _shoe.value = Shoe(0,"","","","","")
        _shoeList.value = shoeList()
        _addNewItem.value = false
    }

    private fun shoeList(): MutableList<Shoe> {
        return mutableListOf(
        Shoe(R.drawable.boots_shoe, "Black boots", "Dr. Martens",
            "Women", "6.5", "Black ankle boots with laces."),
        Shoe(R.drawable.heeled_shoe, "Classic white shoes", "Mustang",
            "Women", "7.0", "Heeled shoes in matte white. Classic model."),
        Shoe(R.drawable.heeled_shoe1, "Classic black shoes", "Mustang",
            "Women", "5.5", "Heeled shoes in matte black. Classic model."),
        Shoe(R.drawable.kid__shoe, "Multicolor kid trainers", "Adidas",
            "Women", "3.0", "Multicolor sneakers, with dotted laces and non-slip sole."),
        Shoe(R.drawable.man_shoe, "Classic men shoes", "Clarks",
            "Men", "10.0", "Classic men's shoe, without laces and with a shield on the upper part."),
        Shoe(R.drawable.mountain_boot_shoe, "Hiking shoes", "Columbia",
            "Men", "11.5", "Waterproof boots with non-slip soles and safety laces."),
        Shoe(R.drawable.trainer_shoe, "Running trainers", "Nike",
            "Men", "9.0", "Running shoes, in gold and antiperspirant.")
        )
    }

    fun addNewShoe() {
        _shoeList.value?.add(_shoe.value!!)
        _addNewItem.value = true
        _shoe.value = Shoe(0,"","","","","")
        _eventNewShoeCreated.value = true
    }

    fun updateList() {
        _addNewItem.value = false
    }

    fun addNewShoeComplete() {
        _eventNewShoeCreated.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}






