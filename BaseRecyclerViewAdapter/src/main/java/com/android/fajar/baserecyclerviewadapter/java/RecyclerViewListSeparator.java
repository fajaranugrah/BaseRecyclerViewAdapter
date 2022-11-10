package com.android.fajar.baserecyclerviewadapter.java;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewListSeparator extends RecyclerView.ItemDecoration {
    @DimenRes
    private int a;
    private float b;
    private ArrayList<Integer> c;
    private int d;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int ORIENTATION_HORIZONTAL = 2;

    public RecyclerViewListSeparator(@DimenRes int var1) {
        this.a = -1;
        this.b = 0.0F;
        this.d = 1;
        this.a = var1;
        this.c = new ArrayList();
        this.d = 1;
    }

    public RecyclerViewListSeparator(@DimenRes int var1, ArrayList<Integer> var2) {
        this(var1);
        this.c = var2;
    }

    public RecyclerViewListSeparator(@DimenRes int var1, ArrayList<Integer> var2, int var3) {
        this(var1, var2);
    }

    public RecyclerViewListSeparator(@DimenRes int var1, int var2) {
        this(var1);
        this.d = var2;
    }

    public RecyclerViewListSeparator(float var1) {
        this.a = -1;
        this.b = 0.0F;
        this.d = 1;
        this.b = var1;
        this.c = new ArrayList();
        this.d = 1;
    }

    public RecyclerViewListSeparator(float var1, ArrayList<Integer> var2) {
        this(var1);
        this.c = var2;
    }

    public RecyclerViewListSeparator(float var1, ArrayList<Integer> var2, int var3) {
        this(var1, var2);
    }

    public RecyclerViewListSeparator(float var1, int var2) {
        this(var1);
        this.d = var2;
    }

    public void getItemOffsets(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
        try {
            float var5;
            if (this.a != -1) {
                var5 = var3.getContext().getResources().getDimension(this.a);
            } else {
                var5 = this.b;
            }

            int var6 = var3.getChildLayoutPosition(var2);
            if (!this.c.contains(var6)) {
                if (var6 == 0) {
                    if (this.d == 2) {
                        var1.left = (int)var5;
                    } else if (this.d == 1) {
                        var1.top = (int)var5;
                    }
                }

                if (this.d == 2) {
                    var1.right = (int)var5;
                } else if (this.d == 1) {
                    var1.bottom = (int)var5;
                }
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }
}