package com.android.fajar.baserecyclerviewadapter

import android.util.Log


class BaseRecyclerViewCheckBoolean() {

    companion object {
        fun <M> setSingleCanNotEmpty(
            baseRecyclerViewAdapter: BaseRecyclerView<M>,
            pos: Int,
            model: M,
        ) {
            try {
                if (!baseRecyclerViewAdapter.selectedItemPositions.contains(pos)) {
                    val var3: Iterator<*> = baseRecyclerViewAdapter.selectedItemPositions.iterator()
                    while (var3.hasNext()) {
                        val var4 = var3.next() as Int
                        if (baseRecyclerViewAdapter.onItemSelectedListener != null) {
                            if (baseRecyclerViewAdapter.onItemSelectedListener!!.onBeforeItemDeselect(
                                    model,
                                    var4,
                                    true
                                )
                            ) {
                                checkBoolean(baseRecyclerViewAdapter, var4, false)
                                baseRecyclerViewAdapter.onItemSelectedListener!!.onAfterItemDeselect(
                                    model,
                                    var4,
                                    true
                                )
                            }
                        } else {
                            checkBoolean(baseRecyclerViewAdapter, var4, false)
                        }
                        try {
                            baseRecyclerViewAdapter.notifyItemChanged(var4)
                        } catch (var7: Exception) {
                            var7.printStackTrace()
                        }
                    }
                    if (baseRecyclerViewAdapter.onItemSelectedListener != null) {
                        if (baseRecyclerViewAdapter.onItemSelectedListener!!.onBeforeItemSelect(
                                model,
                                pos,
                                true
                            )
                        ) {
                            checkBoolean(baseRecyclerViewAdapter, pos, true)
                            baseRecyclerViewAdapter.onItemSelectedListener!!.onAfterItemSelect(
                                model,
                                pos,
                                true
                            )
                        }
                    } else {
                        checkBoolean(baseRecyclerViewAdapter, pos, true)
                    }
                    try {
                        baseRecyclerViewAdapter.notifyItemChanged(pos)
                    } catch (var6: Exception) {
                        var6.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun checkBoolean(
            baseRecyclerViewAdapter: BaseRecyclerView<*>,
            var1: Int,
            var2: Boolean,
        ): Boolean {
            return if (var2) {
                var var12 = false
                try {
                    val var4: Iterator<*> = baseRecyclerViewAdapter.selectedItemPositions.iterator()
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
                    baseRecyclerViewAdapter.selectedItemPositions.add(var1)
                    true
                } else {
                    try {
                        Log.v(baseRecyclerViewAdapter::class.java.simpleName, "This item is already selected!")
                    } catch (var7: Exception) {
                        var7.printStackTrace()
                    }
                    false
                }
            } else {
                try {
                    for (var3 in baseRecyclerViewAdapter.selectedItemPositions.indices) {
                        try {
                            if (baseRecyclerViewAdapter.selectedItemPositions[var3] as Int == var1) {
                                baseRecyclerViewAdapter.selectedItemPositions.removeAt(var3)
                                return true
                            }
                        } catch (var8: Exception) {
                            var8.printStackTrace()
                        }
                    }
                } catch (var11: Exception) {
                    var11.printStackTrace()
                }
                false
            }
        }
    }
}
