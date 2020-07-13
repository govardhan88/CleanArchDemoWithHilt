package com.govi.pokemon.presentation.base.widgets

import android.view.View
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.govi.pokemon.presentation.extensions.viewBinding

abstract class BaseBottomSheetDialog<VD : ViewBinding>(
    private val layoutId: Int,
    bind: (View) -> VD
) : BottomSheetDialogFragment() {

    protected val dataBinding: VD by viewBinding(bind)

}