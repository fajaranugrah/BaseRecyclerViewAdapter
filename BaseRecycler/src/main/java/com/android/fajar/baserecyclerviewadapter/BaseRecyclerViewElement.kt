package com.android.fajar.baserecyclerviewadapter

import android.view.View
import androidx.annotation.IdRes
import java.lang.Exception

abstract class BaseRecyclerViewElement<T : View?, M>(@IdRes var1: Int) {
    @IdRes
    var idRes: Int
    var onItemClickListener: OnItemClickListener<M>?
    var viewType: Int?

    constructor(@IdRes var1: Int, var2: OnItemClickListener<M>?) : this(var1) {
        onItemClickListener = var2
    }

    fun processView(var1: View, var2: M, var3: Int) {
        try {
            val var4 = var1.findViewById<View>(idRes)
            try {
                this.fillView(var4 as T, var2, var3)
            } catch (var7: Exception) {
                var7.printStackTrace()
            }
            try {
                if (onItemClickListener != null) {
                    var4.setOnClickListener { var1 ->
                        onItemClickListener!!.onItemClick(
                            var1,
                            var2
                        )
                    }
                }
            } catch (var6: Exception) {
                var6.printStackTrace()
            }
        } catch (var8: Exception) {
            var8.printStackTrace()
        }
    }

    open fun fillView(var1: T, var2: M, var3: Int) {
        this.fillView(var1, var2)
    }

    abstract fun fillView(var1: T, var2: M)
    interface OnItemClickListener<M> {
        fun onItemClick(var1: View?, var2: M)
    }

    init {
        onItemClickListener = null
        viewType = null
        idRes = var1
    }
}