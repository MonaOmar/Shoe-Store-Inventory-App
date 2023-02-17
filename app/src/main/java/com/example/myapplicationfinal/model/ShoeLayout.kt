package com.example.myapplicationfinal.model

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.example.myapplicationfinal.R
import com.example.myapplicationfinal.databinding.ShoeItemListBinding
import com.example.myapplicationfinal.Shoe

class ShoeLayout:LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
   private val binding:ShoeItemListBinding=
       DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_item_list, this, false)
    fun loadShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            name.text = shoe.name
            name1.text = shoe.company
            size.text = shoe.size.toString()
            description.text = shoe.description
        }
    }
}