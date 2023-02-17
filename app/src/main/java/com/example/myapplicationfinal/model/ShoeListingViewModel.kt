package com.example.myapplicationfinal.model

import androidx.lifecycle.ViewModel
import androidx.databinding.Bindable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplicationfinal.BR
import com.example.myapplicationfinal.Shoe

class ShoeListingViewModel: ViewModel(), androidx.databinding.Observable {
    private val propertyChangeRegistry = PropertyChangeRegistry()

    private val shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    @Bindable
    var shoe = Shoe()
        set(value) {
            if(value != field) {
                field = value
                propertyChangeRegistry.notifyChange(this, BR.shoe)
            }
        }
    fun getShoeLiveData(): LiveData<MutableList<Shoe>> = shoes

    fun addShoe(item: Shoe?) {
        item?.let {
            shoes.value?.add(item)
        }
    }

    override fun addOnPropertyChangedCallback(callback: androidx.databinding.Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: androidx.databinding.Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }
}