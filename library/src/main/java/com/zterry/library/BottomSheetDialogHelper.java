package com.zterry.library;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Description:
 * Creator:Terry
 * Date:2017/6/6 下午5:35
 */

public class BottomSheetDialogHelper {

    BottomSheetDialog bottomSheetDialog;
    private Context context;
    View content;
    LinearLayout contentListContainer;

    public BottomSheetDialogHelper(Context context) {
        this.context = context;
        bottomSheetDialog = new BottomSheetDialog(context);
        content = View.inflate(context, R.layout.bottom_sheet_layout, null);
        contentListContainer = (LinearLayout) content.findViewById(R.id.ll_content);
    }

    public void setData(List<BottomSheetMenuItem> menuItems) {
        if (menuItems == null) {
            throw new IllegalArgumentException("The list of bottom sheet item must not be null");
        }

        for (final BottomSheetMenuItem menuItem : menuItems) {
//            View menuItemView=  LayoutInflater.from(context).inflate(R.layout.bottom_sheet_menu_item,contentListContainer,true);
            View menuItemView = View.inflate(context, R.layout.bottom_sheet_menu_item, null);

            TextView title = (TextView) menuItemView.findViewById(R.id.title);
            title.setText(menuItem.titleId);

            ImageView icon = (ImageView) menuItemView.findViewById(R.id.icon);
            icon.setImageResource(menuItem.drawableId);
            menuItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMenuItemClickListener != null) {
                        onMenuItemClickListener.onMenuItemClick(v, menuItem);
                    }
                }
            });
            contentListContainer.addView(menuItemView, ViewGroup.LayoutParams.MATCH_PARENT,dip2px(context,48));
        }
        bottomSheetDialog.setContentView(content);

    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void setOnMenuItemClickListener(BottomSheetDialogHelper.OnMenuItemClickListener onMenuItemClickListener) {
        this.onMenuItemClickListener = onMenuItemClickListener;
    }

    BottomSheetDialogHelper.OnMenuItemClickListener onMenuItemClickListener;

    public interface OnMenuItemClickListener {
        void onMenuItemClick(View view, BottomSheetMenuItem item);
    }

    public void show() {
        bottomSheetDialog.show();
    }

}
