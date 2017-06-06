package com.zterry.materialbottomsheet;

import android.support.annotation.NonNull;

import com.zterry.library.BottomSheetMenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Creator:Terry
 * Date:2017/6/6 下午6:22
 */

public class SampleData {
    @NonNull
    public static List<BottomSheetMenuItem> getData() {
        final ArrayList<BottomSheetMenuItem> bottomSheetMenuItems = new ArrayList<>(4);
        bottomSheetMenuItems.add(new BottomSheetMenuItem(R.drawable.ic_backup_black_24dp,R.string.bottom_sheet_item_title_backup));
        bottomSheetMenuItems.add(new BottomSheetMenuItem(R.drawable.ic_build_black_24dp,R.string.bottom_sheet_item_title_build));
        bottomSheetMenuItems.add(new BottomSheetMenuItem(R.drawable.ic_history_black_24dp,R.string.bottom_sheet_item_title_history));
        bottomSheetMenuItems.add(new BottomSheetMenuItem(R.drawable.ic_loyalty_black_24dp,R.string.bottom_sheet_item_title_loyalty));
        return bottomSheetMenuItems;
    }
}
