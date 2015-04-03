package me.kaede.brighter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class SquareLayout extends RelativeLayout {

	
	public SquareLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	public SquareLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public SquareLayout(Context context) {
		super(context);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		//决定了当前View的大小
		 setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),getDefaultSize(0, heightMeasureSpec));
		 int childWidthSize = getMeasuredWidth();
		 int childHeightSize = getMeasuredHeight();
		 //高度和宽度一样
		 heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize,MeasureSpec.EXACTLY);
		 super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	public void onLayout(boolean changed, int l, int t, int r, int b) {
		int width = r - l;
		ViewGroup.LayoutParams params = this.getLayoutParams();
		params.height = width;
		this.setLayoutParams(params);
		this.setMeasuredDimension(width, width);
		super.onLayout(changed, l, t, r, t + width);
	}


}
