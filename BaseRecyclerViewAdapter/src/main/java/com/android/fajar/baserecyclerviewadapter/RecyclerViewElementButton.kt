package com.android.fajar.baserecyclerviewadapter

import android.widget.Button
import androidx.annotation.IdRes
import java.lang.Exception

abstract class RecyclerViewElementButton<M> :
    BaseRecyclerViewElement<Button, M> {
    constructor(@IdRes var1: Int) : super(var1) {}
    constructor(@IdRes var1: Int, var2: OnItemClickListener<M>?) : super(var1, var2) {}

    override fun fillView(var1: Button, var2: M) {
        try {
            if (getText(var2) != null) {
                var1.text = getText(var2)
            }
        } catch (var4: Exception) {
            var4.printStackTrace()
        }
    }

    fun getText(var1: M): String? {
        return null
    }
}