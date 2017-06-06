package com.zterry.library;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Description:
 * Creator:Terry
 * Date:2017/6/6 下午5:09
 */
public class BottomSheetMenuItem implements Serializable {

    public int drawableId;
    public int titleId;

    public BottomSheetMenuItem(int drawableId, int titleId) {
        this.drawableId = drawableId;
        this.titleId = titleId;
    }
}
