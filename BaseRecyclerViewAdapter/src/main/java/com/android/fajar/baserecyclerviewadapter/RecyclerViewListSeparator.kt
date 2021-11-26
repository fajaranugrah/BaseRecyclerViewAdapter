package com.android.fajar.baserecyclerviewadapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.util.ArrayList

class RecyclerViewListSeparator : ItemDecoration {
    @DimenRes
    private var a: Int
    private var b: Float
    private var c: ArrayList<Int?>
    private var d: Int

    constructor(@DimenRes var1: Int) {
        a = -1
        b = 0.0f
        d = 1
        a = var1
        c = ArrayList<Int?>()
        d = 1
    }

    constructor(@DimenRes var1: Int, var2: ArrayList<Int?>) : this(var1) {
        c = var2
    }

    constructor(@DimenRes var1: Int, var2: ArrayList<Int?>, var3: Int) : this(var1, var2) {}
    constructor(@DimenRes var1: Int, var2: Int) : this(var1) {
        d = var2
    }

    constructor(var1: Float) {
        a = -1
        b = 0.0f
        d = 1
        b = var1
        c = ArrayList<Int?>()
        d = 1
    }

    constructor(var1: Float, var2: ArrayList<Int?>) : this(var1) {
        c = var2
    }

    constructor(var1: Float, var2: ArrayList<Int?>, var3: Int) : this(var1, var2) {}
    constructor(var1: Float, var2: Int) : this(var1) {
        d = var2
    }

    override fun getItemOffsets(
        var1: Rect,
        var2: View,
        var3: RecyclerView,
        var4: RecyclerView.State
    ) {
        try {
            val var5: Float
            var5 = if (a != -1) {
                var3.context.resources.getDimension(a)
            } else {
                b
            }
            val var6 = var3.getChildLayoutPosition(var2)
            if (!c.contains(var6)) {
                if (var6 == 0) {
                    if (d == 2) {
                        var1.left = var5.toInt()
                    } else if (d == 1) {
                        var1.top = var5.toInt()
                    }
                }
                if (d == 2) {
                    var1.right = var5.toInt()
                } else if (d == 1) {
                    var1.bottom = var5.toInt()
                }
            }
        } catch (var7: Exception) {
            var7.printStackTrace()
        }
    }

    companion object {
        const val ORIENTATION_VERTICAL = 1
        const val ORIENTATION_HORIZONTAL = 2
    }
}