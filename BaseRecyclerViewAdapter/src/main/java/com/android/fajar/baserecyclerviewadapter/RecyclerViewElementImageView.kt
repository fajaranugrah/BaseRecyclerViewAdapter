package com.android.fajar.baserecyclerviewadapter

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.bumptech.glide.Glide
import java.lang.Exception

abstract class RecyclerViewElementImageView<M> :
    BaseRecyclerViewElement<ImageView?, M?> {
    @DrawableRes
    var a = 0

    constructor(@IdRes var1: Int) : super(var1) {}
    constructor(@IdRes var1: Int, var2: OnItemClickListener<M?>) : super(var1, var2) {}
    constructor(@IdRes var1: Int, @DrawableRes var2: Int) : super(var1) {
        a = var2
    }

    constructor(@IdRes var1: Int, var2: OnItemClickListener<M?>, @DrawableRes var3: Int) : super(
        var1,
        var2
    ) {
        a = var3
    }

    override fun fillView(p0: ImageView?, p1: M?, p2: Int) {
        try {
            Glide.with(p0!!.context).load(getUrl(p1!!)).error(a).into(p0!!)
        } catch (var4: Exception) {
            var4.printStackTrace()
        }
    }

    override fun fillView(p0: ImageView?, p1: M?) {
        try {
            Glide.with(p0!!.context).load(getUrl(p1!!)).error(a).into(p0!!)
        } catch (var4: Exception) {
            var4.printStackTrace()
        }
    }

    abstract fun getUrl(var1: M): String?
}