package com.example.qq_lxr9y18r.chongxie;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class ChongXieGridView extends GridView{
	 public ChongXieGridView(Context context, AttributeSet attrs) {   
        super(context, attrs);   
     }   
	  
    public ChongXieGridView(Context context) {   
        super(context);   
    }   
	  
    public ChongXieGridView(Context context, AttributeSet attrs, int defStyle) {   
        super(context, attrs, defStyle);   
    }   
	  
    @Override   
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {   
  
        int expandSpec = MeasureSpec.makeMeasureSpec(   
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);   
        super.onMeasure(widthMeasureSpec, expandSpec);   
    }   
}
