package com.govi.pokemon.presentation.base.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View.MeasureSpec.getSize
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.ceil

class DynamicImageView(
    context: Context?,
    attrs: AttributeSet?
) : AppCompatImageView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) =
        when(val d = this.drawable)
        {
            d->{
                val width = getSize(widthMeasureSpec)
                val height = ceil(
                    width * d.intrinsicHeight.toFloat() / d.intrinsicWidth.toDouble()
                ).toInt()
                setMeasuredDimension(width, height)
            }
            else ->{
                super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            }
        }
}