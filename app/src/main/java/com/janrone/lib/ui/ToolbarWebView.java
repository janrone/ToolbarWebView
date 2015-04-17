package com.janrone.lib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class ToolbarWebView extends WebView {
    public ScrollInterface mScrollInterface;
    public ToolbarWebView mToolbarWebView;

    public ToolbarWebView(Context context) {
        super(context);
    }

    public ToolbarWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ToolbarWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredHeight() - 200); // the padding you need.
    }



    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
 
        super.onScrollChanged(l, t, oldl, oldt);
 
        mScrollInterface.onSChanged(mToolbarWebView, l, t, oldl, oldt);
 
    }
 
    public void setOnCustomScroolChangeListener(ToolbarWebView toolbarWebView, ScrollInterface scrollInterface) {
 
        this.mScrollInterface = scrollInterface;
        this.mToolbarWebView = toolbarWebView;
    }
 
    public interface ScrollInterface {
 
        public void onSChanged(ToolbarWebView testWebView, int l, int t, int oldl, int oldt);
 
    }
 
}