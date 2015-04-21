# ToolbarWebView

This is an example  show or hide toolbar when scrolling a webview .

####Usage  toolbarwebview 1.0.0
 
       compile 'com.janrone.android.lib:toolbarwebview:1.0.0'
 
       <com.janrone.lib.ui.ToolbarWebView
              android:id="@+id/toolbar_web_view"
              android:layout_width="match_parent"
              android:layout_height="match_parent"/>
        
       toolbarWebView.setOnCustomScroolChangeListener(webView, new ToolbarWebViewScrollListener(){
                 @Override
                 public void onHide() {
                     hideViews();
                 }
     
                 @Override
                 public void onShow() {
                     showViews();
                 }
             });        
       private void hideViews() {
             mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
         }
     
         private void showViews() {
             mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
         }      


####Scrolling like in Chrome
![Scrolling like in Chrome](https://raw.githubusercontent.com/janrone/ToolbarWebView/master/screenshots/toolbarwebview.gif "")
