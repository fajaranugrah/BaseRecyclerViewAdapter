package com.android.fajar.baserecyclerviewadapter

import android.R
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by
 * Fajar Anugrah Ramadhan License
 * ===============================================
 *
 * Copyright (C).
 * All right reserved
 *
 * Name      : Fajar Anugrah Ramadhan
 * E-mail    : fajarconan@gmail.com
 * Github    : https://github.com/fajaranugrah
 * LinkedIn  : linkedin.com/in/fajar-anugrah
 *
 */

class BaseRecyclerView<M>(
    var1: Context?,
    var2: MutableList<M>,
    var3: MutableList<BaseRecyclerViewElement<*, *>>?,
    var4: OnItemRootClickListener<M>?,
    var5: OnItemRootLongClickListener<M>?,
    var6: Boolean,
    var7: Int,
    var8: Int,
    var9: Int,
    var10: Int,
    var11: Int,
    var12: Float,
    var13: Float,
    var14: Int,
    var15: MutableList<BaseRecyclerViewElement<View, M>?>?,
    var16: MutableList<BaseRecyclerViewElement<View, M>?>?,
    var17: OnItemSelectedListener<M>?,
    var18: HashMap<Int?, ItemRootViewGetter?>,
    var19: BaseRecyclerView.OnGetItemViewType<M>?,
) : RecyclerView.Adapter<BaseRecyclerView.BaseViewHolder?>() {
    private val a: Context?
    private var b: MutableList<M> = mutableListOf()
    private var c: MutableList<BaseRecyclerViewElement<*, *>>? = null
    private var d: OnItemRootClickListener<M>? = null
    private var e: OnItemRootLongClickListener<M>? = null
    private var f = false
    private val g: Int
    private var h = 0
    private var i = 0
    private var j = 0
    private var k = 0
    private var l = 0.0f
    private var m = 0.0f
    private var n: Int
    var selectedRecyclerViewElements: List<BaseRecyclerViewElement<View, M>?>?
    var unselectedRecyclerViewElements: List<BaseRecyclerViewElement<View, M>?>?
    @JvmField
    var selectedItemPositions: MutableList<Int?>
    @JvmField
    var onItemSelectedListener: OnItemSelectedListener<M>?
    private var o: HashMap<Int?, ItemRootViewGetter?>
    private var p: BaseRecyclerView.OnGetItemViewType<M>? = null
    override fun getItemViewType(var1: Int): Int {
        return if (p != null) p!!.getViewType(b!![var1], var1) else 2147483647
    }

    fun getItem(var1: Int): M? {
        try {
            return b!![var1]
        } catch (var3: Exception) {
            var3.printStackTrace()
            return null
        }
    }

    override fun onCreateViewHolder(var1: ViewGroup, var2: Int): BaseViewHolder {
        var var3: BaseViewHolder? = null
        try {
            if (f) {
                try {
                    if (o.containsKey(var2)) {
                        val var4 = o[var2]!!.getItemRootView(
                            a, var1
                        )
                        val var5 = CardView((a)!!)
                        var5.layoutParams = ViewGroup.LayoutParams(
                            var4!!.layoutParams.width,
                            var4.layoutParams.height
                        )
                        var5.setCardBackgroundColor(g)
                        var5.setPadding(j, h, k, i)
                        var5.radius = l
                        try {
                            if (Build.VERSION.SDK_INT >= 21) {
                                var5.elevation = m
                            }
                        } catch (var8: Exception) {
                            var8.printStackTrace()
                        }
                        var5.addView(var4)
                        var3 = BaseViewHolder(var5)
                    } else {
                        Log.v(
                            BaseRecyclerView::class.java.simpleName,
                            String.format("No View Found for itemViewType %d", var2))
                        Log.v(
                            BaseRecyclerView::class.java.simpleName,
                            "Have you set the default view type using .setLayoutRes() or .setContentView()?")
                    }
                } catch (var9: Exception) {
                    var9.printStackTrace()
                }
            } else {
                try {
                    if (o.containsKey(var2)) {
                        var3 = BaseViewHolder(
                            o[var2]!!.getItemRootView(
                                a, var1
                            )
                        )
                    } else {

                        Log.v(
                            BaseRecyclerView::class.java.simpleName,
                            String.format("No View Found for itemViewType %d", var2)
                        )
                        Log.v(
                            BaseRecyclerView::class.java.simpleName,
                            "Have you set the default view type using .setLayoutRes() or .setContentView()?"
                        )
                    }
                } catch (var7: Exception) {
                    var7.printStackTrace()
                }
            }
        } catch (var10: Exception) {
            var10.printStackTrace()
        }
        return var3!!
    }

    override fun onBindViewHolder(var1: BaseViewHolder, var2: Int) {
        var var3: OnItemRootClickListener<M>? = d
        try {
            if (n == SELECTION_TYPE_SINGLE_CAN_EMPTY) {
                var3 = object : OnItemRootClickListener<M> {
                    override fun onItemRootClick(var1: M, var2: Int) {
                        if (selectedItemPositions.contains(var2)) {
                            try {
                                if (onItemSelectedListener != null) {
                                    if (onItemSelectedListener!!.onBeforeItemDeselect(
                                            var1,
                                            var2,
                                            true
                                        )
                                    ) {
                                        a(var2, false)
                                        try {
                                            onItemSelectedListener!!.onAfterItemDeselect(
                                                var1,
                                                var2,
                                                true
                                            )
                                        } catch (var9: Exception) {
                                            var9.printStackTrace()
                                        }
                                    }
                                } else {
                                    a(var2, false)
                                }
                            } catch (var10: Exception) {
                                var10.printStackTrace()
                            }
                            try {
                                notifyItemChanged(var2)
                            } catch (var8: Exception) {
                                var8.printStackTrace()
                            }
                        } else {
                            val var31: Iterator<*> = selectedItemPositions.iterator()
                            while (var31.hasNext()) {
                                val var4: Int = var31.next() as Int
                                if (onItemSelectedListener != null) {
                                    if (onItemSelectedListener!!.onBeforeItemDeselect(
                                            var1,
                                            var4,
                                            true
                                        )
                                    ) {
                                        a(var4, false)
                                        onItemSelectedListener!!.onAfterItemDeselect(
                                            var1,
                                            var4,
                                            true
                                        )
                                    }
                                } else {
                                    a(var4, false)
                                }
                                try {
                                    notifyItemChanged(var4)
                                } catch (var7: Exception) {
                                    var7.printStackTrace()
                                }
                            }
                            if (onItemSelectedListener != null) {
                                if (onItemSelectedListener!!.onBeforeItemSelect(
                                        var1,
                                        var2,
                                        true
                                    )
                                ) {
                                    a(var2, true)
                                    onItemSelectedListener!!.onAfterItemSelect(var1, var2, true)
                                }
                            } else {
                                a(var2, true)
                            }
                            try {
                                notifyItemChanged(var2)
                            } catch (var6: Exception) {
                                var6.printStackTrace()
                            }
                        }
                    }
                } as OnItemRootClickListener<M>?
            } else if (n == SELECTION_TYPE_SINGLE_CANNOT_EMPTY) {
                var3 = object : OnItemRootClickListener<M> {
                    override fun onItemRootClick(var1: M, var2: Int) {
                        if (!selectedItemPositions.contains(var2)) {
                            val var312: Iterator<*> = selectedItemPositions.iterator()
                            while (var312.hasNext()) {
                                val var4: Int = var312.next() as Int
                                if (onItemSelectedListener != null) {
                                    if (onItemSelectedListener!!.onBeforeItemDeselect(
                                            var1,
                                            var4,
                                            true
                                        )
                                    ) {
                                        a(var4, false)
                                        onItemSelectedListener!!.onAfterItemDeselect(
                                            var1,
                                            var4,
                                            true
                                        )
                                    }
                                } else {
                                    a(var4, false)
                                }
                                try {
                                    notifyItemChanged(var4)
                                } catch (var7: Exception) {
                                    var7.printStackTrace()
                                }
                            }
                            if (onItemSelectedListener != null) {
                                if (onItemSelectedListener!!.onBeforeItemSelect(
                                        var1,
                                        var2,
                                        true
                                    )
                                ) {
                                    a(var2, true)
                                    onItemSelectedListener!!.onAfterItemSelect(var1, var2, true)
                                }
                            } else {
                                a(var2, true)
                            }
                            try {
                                notifyItemChanged(var2)
                            } catch (var6: Exception) {
                                var6.printStackTrace()
                            }
                        }
                    }
                } as OnItemRootClickListener<M>?
            } else if (n == SELECTION_TYPE_MULTIPLE) {
                var3 = object : OnItemRootClickListener<M> {
                    override fun onItemRootClick(var1: M, var2: Int) {
                        if (selectedItemPositions.contains(var2)) {
                            if (onItemSelectedListener != null) {
                                if (onItemSelectedListener!!.onBeforeItemDeselect(
                                        var1,
                                        var2,
                                        true
                                    )
                                ) {
                                    a(var2, false)
                                    onItemSelectedListener!!.onAfterItemDeselect(
                                        var1,
                                        var2,
                                        true
                                    )
                                }
                            } else {
                                a(var2, false)
                            }
                            try {
                                notifyItemChanged(var2)
                            } catch (var5: Exception) {
                                var5.printStackTrace()
                            }
                        } else {
                            if (onItemSelectedListener != null) {
                                if (onItemSelectedListener!!.onBeforeItemSelect(
                                        var1,
                                        var2,
                                        true
                                    )
                                ) {
                                    a(var2, true)
                                    onItemSelectedListener!!.onAfterItemSelect(var1, var2, true)
                                }
                            } else {
                                a(var2, true)
                            }
                            try {
                                notifyItemChanged(var2)
                            } catch (var4: Exception) {
                                var4.printStackTrace()
                            }
                        }
                    }
                } as OnItemRootClickListener<M>?
            }
        } catch (var12: Exception) {
            var12.printStackTrace()
        }
        var var4: Int
        try {
            var4 = var1!!.adapterPosition
            if (var3 != null) {
                val finalVar: OnItemRootClickListener<M> = var3
                val finalVar1 = var4
                var1.rootView!!.setOnClickListener(View.OnClickListener {
                    finalVar.onItemRootClick(
                        b!![finalVar1], finalVar1
                    )
                })
            }
        } catch (var11: Exception) {
            var11.printStackTrace()
        }
        try {
            var4 = var1!!.adapterPosition
            if (e != null) {
                val finalVar2 = var4
                var1.rootView!!.setOnLongClickListener {
                    e!!.onItemRootLongClick(b!![finalVar2], finalVar2)
                    true
                }
            }
        } catch (var10: Exception) {
            var10.printStackTrace()
        }
        try {
            if (c != null) {
                val var15: Iterator<*> = c!!.iterator()
                while (var15.hasNext()) {
                    val var5 = var15.next() as BaseRecyclerViewElement<*, M>
                    if (var5.viewType == null) {
                        var5.processView((var1!!.rootView)!!, b!![var2], var2)
                    } else if (var5.viewType == getItemViewType(var2)) {
                        var5.processView((var1!!.rootView)!!, b!![var2], var2)
                    }
                }
            }
        } catch (var14: Exception) {
            var14.printStackTrace()
        }
        try {
            if ((n == SELECTION_TYPE_SINGLE_CAN_EMPTY) || (n == SELECTION_TYPE_SINGLE_CANNOT_EMPTY) || (n == SELECTION_TYPE_MULTIPLE)) {
                var4 = 0
                while (var4 < this.itemCount) {
                    var var6: BaseRecyclerViewElement<*, *>
                    var var16: Iterator<*>
                    if (selectedItemPositions.contains(var2)) {
                        if (selectedRecyclerViewElements != null) {
                            var16 = selectedRecyclerViewElements!!.iterator()
                            while (var16.hasNext()) {
                                var6 = var16.next() as BaseRecyclerViewElement<*, M>
                                try {
                                    if (var6.viewType == null) {
                                        var6.processView((var1!!.rootView)!!, b!![var2], var2)
                                    } else if (var6.viewType == getItemViewType(var2)) {
                                        var6.processView((var1!!.rootView)!!, b!![var2], var2)
                                    }
                                } catch (var9: Exception) {
                                    var9.printStackTrace()
                                }
                            }
                        }
                    } else if (unselectedRecyclerViewElements != null) {
                        var16 = unselectedRecyclerViewElements!!.iterator()
                        while (var16.hasNext()) {
                            var6 = var16.next() as BaseRecyclerViewElement<*, M>
                            try {
                                if (var6.viewType == null) {
                                    var6.processView((var1!!.rootView)!!, b!![var2], var2)
                                } else if (var6.viewType == getItemViewType(var2)) {
                                    var6.processView((var1!!.rootView)!!, b!![var2], var2)
                                }
                            } catch (var8: Exception) {
                                var8.printStackTrace()
                            }
                        }
                    }
                    ++var4
                }
            }
        } catch (var13: Exception) {
            var13.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        try {
            return this.b!!.size
        } catch (var2: Exception) {
            var2.printStackTrace()
            return 0
        }
    }

    fun getSelectedItemPositions(): List<Int?> {
        return selectedItemPositions
    }

    val selectedItems: MutableList<M>
        get() {
            val var1: ArrayList<M> = ArrayList<M>()
            val var2: Iterator<*> = selectedItemPositions.iterator()
            while (var2.hasNext()) {
                val var3 = var2.next() as Int
                try {
                    var1.add(b!![var3])
                } catch (var5: Exception) {
                    var5.printStackTrace()
                }
            }
            return var1.toList() as MutableList<M>
        }

    private fun a(var1: Int, var2: Boolean): Boolean {
        if (var2) {
            var var12 = false
            try {
                val var4: Iterator<*> = selectedItemPositions.iterator()
                while (var4.hasNext()) {
                    val var5 = var4.next() as Int
                    try {
                        if (var5 == var1) {
                            var12 = true
                            break
                        }
                    } catch (var9: Exception) {
                        var9.printStackTrace()
                    }
                }
            } catch (var10: Exception) {
                var10.printStackTrace()
            }
            if (!var12) {
                selectedItemPositions.add(var1)
                return true
            } else {
                try {
                    Log.v(BaseRecyclerView::class.java.simpleName, "This item is already selected!")
                } catch (var7: Exception) {
                    var7.printStackTrace()
                }
                return false
            }
        } else {
            try {
                for (var3 in selectedItemPositions.indices) {
                    try {
                        if (selectedItemPositions[var3] == var1) {
                            selectedItemPositions.removeAt(var3)
                            return true
                        }
                    } catch (var8: Exception) {
                        var8.printStackTrace()
                    }
                }
            } catch (var11: Exception) {
                var11.printStackTrace()
            }
            return false
        }
    }

    fun setSelected(var1: Int, var2: Boolean): Boolean {
        var var3 = false
        try {
            if (onItemSelectedListener != null) {
                if (var2) {
                    if (onItemSelectedListener!!.onBeforeItemSelect(getItem(var1)!!, var1, false)) {
                        var3 = a(var1, var2)
                        onItemSelectedListener!!.onAfterItemSelect(getItem(var1)!!, var1, false)
                    }
                } else if (onItemSelectedListener!!.onBeforeItemDeselect(
                        getItem(var1)!!,
                        var1,
                        false
                    )
                ) {
                    var3 = a(var1, var2)
                    onItemSelectedListener!!.onAfterItemDeselect(getItem(var1)!!, var1, false)
                }
            } else {
                var3 = a(var1, var2)
            }
        } catch (var5: Exception) {
            var5.printStackTrace()
        }
        return var3
    }

    fun setSelectionType(var1: Int) {
        n = var1
    }

    class Builder<M>(var1: Context, var2: MutableList<M>) {
        var a: Context? = null
        var b: MutableList<M> = mutableListOf()
        var c: OnItemRootClickListener<M>? = null
        var d: OnItemRootLongClickListener<M>? = null
        var e: MutableList<BaseRecyclerViewElement<*, *>>? = ArrayList()
        var f = false
        var g = 0
        var h = 0
        var i = 0
        var j = 0
        var k = 0.0f
        var l: Int
        var m = 0.0f
        var n: Int
        var selectedRecyclerViewElements: MutableList<BaseRecyclerViewElement<View, M>?>
        var unselectedRecyclerViewElements: MutableList<BaseRecyclerViewElement<View, M>?>
        var onItemSelectedListener: OnItemSelectedListener<M>?
        var itemRootViewGetterMap: HashMap<Int?, ItemRootViewGetter?>
        private var onGetItemViewType: OnGetItemViewType<M>? = null
        fun setLayoutRes(@LayoutRes var1: Int): Builder<M> {
            try {
                itemRootViewGetterMap[2147483647] = ItemRootViewGetter(2147483647, var1)
            } catch (var3: Exception) {
                var3.printStackTrace()
            }
            return this
        }

        fun setContentView(@LayoutRes var1: Int): Builder<M> {
            return setLayoutRes(var1)
        }

        fun addContentViewForViewType(var1: Int, @LayoutRes var2: Int): Builder<M> {
            try {
                if (var1 == 2147483647) {
                    throw RuntimeException(
                        String.format(
                            "Please don't use Integer.MAX_VALUE or %d as your itemViewType",
                            2147483647
                        )
                    )
                }
                itemRootViewGetterMap[var1] = ItemRootViewGetter(var1, var2)
            } catch (var4: Exception) {
                var4.printStackTrace()
            }
            return this
        }

        fun addContentViewForViewType(var1: Int, var2: View?): Builder<M> {
            try {
                if (var1 == 2147483647) {
                    throw RuntimeException(
                        String.format(
                            "Please don't use Integer.MAX_VALUE or %d as your itemViewType",
                            2147483647
                        )
                    )
                }
                itemRootViewGetterMap[var1] = ItemRootViewGetter(var1, var2)
            } catch (var4: Exception) {
                var4.printStackTrace()
            }
            return this
        }

        fun addLayoutResForViewType(var1: Int, @LayoutRes var2: Int): Builder<M> {
            this.addContentViewForViewType(var1, var2)
            return this
        }

        fun addLayoutResForViewType(var1: Int, var2: View?): Builder<M> {
            this.addContentViewForViewType(var1, var2)
            return this
        }

        fun setOnGetItemViewType(var1: OnGetItemViewType<M>?): Builder<M>? {
            onGetItemViewType = var1
            return this
        }

        fun setOnItemRootClickListener(var1: OnItemRootClickListener<M>?): BaseRecyclerView.Builder<M> {
            c = var1
            return this
        }

        fun setOnItemRootLongClickListener(var1: OnItemRootLongClickListener<M>?): Builder<M> {
            d = var1
            return this
        }

        fun addElement(var1: BaseRecyclerViewElement<*, *>): Builder<M> {
            e!!.add(var1)
            return this
        }

        fun addElement(var1: BaseRecyclerViewElement<*, *>, var2: Int): Builder<M> {
            var1?.viewType = var2
            e!!.add(var1)
            return this
        }

        fun build(): BaseRecyclerView<M> {
            return if (itemRootViewGetterMap.size <= 0) {
                throw RuntimeException("You must specify your Layout res Id. Have you call .setLayoutRes(yourLayoutIdRes)?")
            } else {
                BaseRecyclerView<M>(
                    a,
                    b,
                    e,
                    c,
                    d,
                    f,
                    l,
                    g,
                    h,
                    i,
                    j,
                    k,
                    m,
                    n,
                    selectedRecyclerViewElements,
                    unselectedRecyclerViewElements,
                    onItemSelectedListener,
                    itemRootViewGetterMap,
                    onGetItemViewType
                )
            }
        }

        fun wrapInCardView(): Builder<M> {
            f = true
            return this
        }

        fun setCardViewBackgroundColor(var1: Int): Builder<M> {
            l = var1
            return this
        }

        fun setCardViewBackgroundColorRes(@ColorRes var1: Int): Builder<M> {
            l = a!!.resources.getColor(var1)
            return this
        }

        fun setCardViewPadding(var1: Int): Builder<M> {
            g = var1
            h = var1
            i = var1
            j = var1
            return this
        }

        fun setCardViewPadding(var1: Int, var2: Int, var3: Int, var4: Int): Builder<M> {
            g = var2
            h = var4
            i = var1
            j = var3
            return this
        }

        fun setCardRadius(var1: Float): Builder<M> {
            k = var1
            return this
        }

        fun setCardViewElevation(var1: Float): Builder<M> {
            m = var1
            return this
        }

        fun setSelectionType(
            var1: Int,
            var2: List<BaseRecyclerViewElement<View?, M>?>?,
            var3: List<BaseRecyclerViewElement<View, M>?>?,
        ): Builder<M> {
            if ((var1 != SELECTION_TYPE_NO_SELECTION) && (var1 != SELECTION_TYPE_SINGLE_CAN_EMPTY) && (var1 != SELECTION_TYPE_SINGLE_CANNOT_EMPTY) && (var1 != SELECTION_TYPE_MULTIPLE)) {
                n = SELECTION_TYPE_NO_SELECTION
            } else {
                try {
                    try {
                        if (var1 != SELECTION_TYPE_NO_SELECTION) {
                            try {
                                Log.v(
                                    BaseRecyclerView::class.java.simpleName,
                                    "Selection already defined. The old Selection Type will be replaced."
                                )
                            } catch (var8: Exception) {
                                var8.printStackTrace()
                            }
                        }
                    } catch (var9: Exception) {
                        var9.printStackTrace()
                    }
                    try {
                        if (c != null) {
                            try {
                                Log.v(
                                    BaseRecyclerView::class.java.simpleName,
                                    "This Adapter already have onItemRootClickListener, onItemRootClickListener will not working and be replaced with the selection mode."
                                )
                                c = null
                            } catch (var6: Exception) {
                                var6.printStackTrace()
                            }
                        }
                    } catch (var7: Exception) {
                        var7.printStackTrace()
                    }
                    n = var1
                } catch (var10: Exception) {
                    var10.printStackTrace()
                }
            }
            var var4: Iterator<*>
            var var5: BaseRecyclerViewElement<*, *>?
            try {
                if (var2 != null) {
                    var4 = var2.iterator()
                    while (var4.hasNext()) {
                        var5 = var4.next()
                        addSelectedElement(var5)
                    }
                }
            } catch (var12: Exception) {
                var12.printStackTrace()
            }
            try {
                if (var3 != null) {
                    var4 = var3.iterator()
                    while (var4.hasNext()) {
                        var5 = var4.next()
                        addUnselectedElement(var5)
                    }
                    unselectedRecyclerViewElements.addAll(var3)
                }
            } catch (var11: Exception) {
                var11.printStackTrace()
            }
            return this
        }

        fun setSelectionType(var1: Int): Builder<M> {
            if ((var1 != SELECTION_TYPE_NO_SELECTION) && (var1 != SELECTION_TYPE_SINGLE_CAN_EMPTY) && (var1 != SELECTION_TYPE_SINGLE_CANNOT_EMPTY) && (var1 != SELECTION_TYPE_MULTIPLE)) {
                n = SELECTION_TYPE_NO_SELECTION
            } else {
                try {
                    try {
                        if (var1 != SELECTION_TYPE_NO_SELECTION) {
                            try {
                                Log.v(
                                    BaseRecyclerView::class.java.simpleName,
                                    "Selection already defined. The old Selection Type will be replaced."
                                )
                            } catch (var5: Exception) {
                                var5.printStackTrace()
                            }
                        }
                    } catch (var6: Exception) {
                        var6.printStackTrace()
                    }
                    try {
                        if (c != null) {
                            try {
                                Log.v(
                                    BaseRecyclerView::class.java.simpleName,
                                    "This Adapter already have onItemRootClickListener, onItemRootClickListener will not working and be replaced with the selection mode.")
                                c = null
                            } catch (var3: Exception) {
                                var3.printStackTrace()
                            }
                        }
                    } catch (var4: Exception) {
                        var4.printStackTrace()
                    }
                    n = var1
                } catch (var7: Exception) {
                    var7.printStackTrace()
                }
            }
            return this
        }

        fun addSelectedElement(var1: BaseRecyclerViewElement<*, *>?): Builder<M> {
            selectedRecyclerViewElements.add(var1 as BaseRecyclerViewElement<View, M>?)
            return this
        }

        fun addUnselectedElement(var1: BaseRecyclerViewElement<*, *>?): Builder<M> {
            unselectedRecyclerViewElements.add(var1 as BaseRecyclerViewElement<View, M>?)
            return this
        }

        fun setOnItemSelectedElement(var1: OnItemSelectedListener<*>?): Builder<M> {
            onItemSelectedListener = var1 as OnItemSelectedListener<M>?
            return this
        }

        init {
            n = SELECTION_TYPE_NO_SELECTION
            selectedRecyclerViewElements = ArrayList<BaseRecyclerViewElement<View, M>?>()
            unselectedRecyclerViewElements = ArrayList<BaseRecyclerViewElement<View, M>?>()
            onItemSelectedListener = null
            itemRootViewGetterMap = HashMap<Int?, ItemRootViewGetter?>()
            onGetItemViewType = null
            a = var1
            b = var2
            l = var1.resources.getColor(R.color.white)
        }
    }

    interface OnGetItemViewType<M> {
        fun getViewType(var1: M, var2: Int): Int
    }

    class ItemRootViewGetter {
        var a = -1
        var b: View? = null

        @LayoutRes
        var c = -1

        constructor(var1: Int, @LayoutRes var2: Int) {
            a = var1
            c = var2
        }

        constructor(var1: Int, var2: View?) {
            a = var1
            b = var2
        }

        fun getItemRootView(var1: Context?, var2: ViewGroup?): View? {
            if (c != -1 && b == null) {
                return LayoutInflater.from(var1).inflate(c, var2, false)
            } else return if (c == -1 && b != null) {
                b
            } else {
                throw RuntimeException(
                    String.format(
                        "No View found for viewType %d",
                        a
                    )
                )
            }
        }
    }

    abstract class OnItemSelectedListener<M>() {
        fun onBeforeItemSelect(var1: M, var2: Int, var3: Boolean): Boolean {
            return true
        }

        fun onBeforeItemDeselect(var1: M, var2: Int, var3: Boolean): Boolean {
            return true
        }

        open fun onAfterItemSelect(var1: M, var2: Int, var3: Boolean) {}
        open fun onAfterItemDeselect(var1: M, var2: Int, var3: Boolean) {}
    }

    interface OnItemRootLongClickListener<M> {
        fun onItemRootLongClick(var1: M, var2: Int)
    }

    interface OnItemRootClickListener<M> {
        fun onItemRootClick(var1: M, var2: Int)
    }

    class BaseViewHolder(var rootView: View?) : RecyclerView.ViewHolder(
        (rootView)!!
    )

    companion object {
        lateinit var Builder: Any
        val DEFAULT_ITEM_VIEW_TYPE = 2147483647
        var SELECTION_TYPE_NO_SELECTION = 0
        @JvmField
        var SELECTION_TYPE_SINGLE_CAN_EMPTY = 1
        var SELECTION_TYPE_SINGLE_CANNOT_EMPTY = 2
        var SELECTION_TYPE_MULTIPLE = 3
    }

    init {
        n = SELECTION_TYPE_NO_SELECTION
        selectedRecyclerViewElements = null
        unselectedRecyclerViewElements = null
        selectedItemPositions = ArrayList<Int?>()
        onItemSelectedListener = null
        o = HashMap<Int?, ItemRootViewGetter?>()
        p = null
        //checkPermission()
        a = var1
        b = var2
        c = var3
        d = var4
        e = var5
        f = var6
        g = var7
        h = var8
        i = var9
        j = var10
        k = var11
        l = var12
        m = var13
        n = var14
        selectedRecyclerViewElements = var15
        unselectedRecyclerViewElements = var16
        onItemSelectedListener = var17
        o = var18
        p = var19
    }
}