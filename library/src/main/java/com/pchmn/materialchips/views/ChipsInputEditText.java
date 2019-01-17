package com.pchmn.materialchips.views;


import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

public class ChipsInputEditText extends android.support.v7.widget.AppCompatEditText {

    private FilterableListView filterableListView;
    private InputKeyInterceptor inputKeyInterceptor;

    public ChipsInputEditText(Context context) {
        super(context);
    }

    public ChipsInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            if(inputKeyInterceptor != null) {
                inputKeyInterceptor.onEnterKey(getText().toString());
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean isFilterableListVisible() {
        return filterableListView != null && filterableListView.getVisibility() == VISIBLE;
    }

    public FilterableListView getFilterableListView() {
        return filterableListView;
    }

    public void setFilterableListView(FilterableListView filterableListView) {
        this.filterableListView = filterableListView;
    }

    public void setInputKeyInterceptor(InputKeyInterceptor inputKeyInterceptor) {
        this.inputKeyInterceptor = inputKeyInterceptor;
    }

    public interface InputKeyInterceptor {
        void onEnterKey(String text);
    }
}
