package com.janrone.lib.listener;

import com.janrone.lib.ui.ToolbarWebView;

/*
* This class is a ScrollListener for ToolbarWebView that allows to show/hide
* views when list is scrolled. It assumes that you have added a header
* to your webview. @see com.janrone.lib.ToolbarWebView.ScrollInterface
* */
public abstract class ToolbarWebViewScrollListener implements ToolbarWebView.ScrollInterface {

    private static final int HIDE_THRESHOLD = 26;

    private int mScrolledDistance = 0;
    private boolean mControlsVisible = true;

    @Override
    public void onSChanged(ToolbarWebView toolbarWebView,int l, int t, int oldl, int oldt){
            if (toolbarWebView.getScrollY() == 0) {
                if(!mControlsVisible) {
                    onShow();
                    mControlsVisible = true;
                }
            } else {
                if (mScrolledDistance > HIDE_THRESHOLD && mControlsVisible) {
                    onHide();
                    mControlsVisible = false;
                    mScrolledDistance = 0;
                } else if (mScrolledDistance < -HIDE_THRESHOLD && !mControlsVisible) {
                    onShow();
                    mControlsVisible = true;
                    mScrolledDistance = 0;
                }
            }

            if((mControlsVisible && t-oldt>0) || (!mControlsVisible && t-oldt<0)) {
                mScrolledDistance += (t-oldt);
            }
    }

    public abstract void onHide();
    public abstract void onShow();
}
