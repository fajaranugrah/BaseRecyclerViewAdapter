package com.android.fajar.baserecyclerviewadapter

import android.widget.TextView
import androidx.annotation.IdRes
import java.lang.Exception

abstract class RecyclerViewElementTextView<M> :
    BaseRecyclerViewElement<TextView, M> {
    constructor(@IdRes var1: Int) : super(var1) {}
    constructor(@IdRes var1: Int, var2: OnItemClickListener<M>?) : super(var1, var2) {}

    override fun fillView(var1: TextView, var2: M) {
        try {
            var1.text = getText(var2)
        } catch (var4: Exception) {
            var4.printStackTrace()
        }
    }

    abstract fun getText(var1: M): CharSequence?
}