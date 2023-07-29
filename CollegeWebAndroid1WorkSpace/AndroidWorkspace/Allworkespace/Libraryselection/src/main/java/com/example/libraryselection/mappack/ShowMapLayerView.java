package com.example.libraryselection.mappack;


import com.example.libraryselection.resource.MapConstant;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

// 展示地图的view
public class ShowMapLayerView extends View{
	// 上级
	Context supercon;
	private Paint seatpaint;// 座位paint,不实心
	private Paint redpaint;// 测试paint
	private Paint barpaint;	// 障碍物的paint，填充并且黑色
	private Paint yuxuanpaint;// 预选位置的paint,不填充并且绿色
	private Paint bitmappaint;// 位图的绘图paint
	// 此view的地图
	private int showmapview[][];
	
	public ShowMapLayerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		supercon = context;
		initData();
		initPaint();
	}
	// 初始化静态数据,mapdata这些
	protected void initData(){
		showmapview = new int[MapConstant.i][MapConstant.j];
//		EditMapDataUtil.setMapDataSpace();
	}
	// 设置地图数组
	public void setMapData(int mapdata[][]){
		showmapview = mapdata;
	}
	protected void initPaint(){
		seatpaint = new Paint();
		seatpaint.setColor(Color.BLACK);
		seatpaint.setStyle(Paint.Style.STROKE);
		seatpaint.setStrokeWidth(2);
		
		redpaint = new Paint();
		redpaint.setColor(Color.RED);
		redpaint.setStyle(Paint.Style.STROKE);
		redpaint.setStrokeWidth(2);
		
		barpaint = new Paint();
		barpaint.setColor(Color.BLACK);
		barpaint.setStyle(Paint.Style.FILL_AND_STROKE);
		barpaint.setStrokeWidth(2);
		
		yuxuanpaint = new Paint();
		yuxuanpaint.setColor(Color.GREEN);
		yuxuanpaint.setStyle(Paint.Style.STROKE);
		yuxuanpaint.setStrokeWidth(2);
		
		bitmappaint = new Paint();
		bitmappaint.setColor(Color.BLACK);
		bitmappaint.setStyle(Paint.Style.STROKE);
		bitmappaint.setStrokeWidth(1);
	}
	
	@Override
	public void invalidate() {
		// TODO Auto-generated method stub
		// 重新更新画布
		super.invalidate();
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);
		setMeasuredDimension(width,height);
	}
	// 绘画函数
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// i是行，j是列
		for(int i = 0; i < MapConstant.i; i++){
			for(int j = 0; j < MapConstant.j; j++){
				int leftj = j * MapConstant.ShowMapPiexl;
				int lefti = i * MapConstant.ShowMapPiexl;
				int righti = j * MapConstant.ShowMapPiexl + MapConstant.ShowMapPiexl;
				int rightj = i * MapConstant.ShowMapPiexl + MapConstant.ShowMapPiexl;
				Rect rc = new Rect(leftj, lefti, righti, rightj);
				// 如果是墙
				if(showmapview[i][j] == MapConstant.BAR){
//					canvas.drawRect(rc, barpaint);
					canvas.drawBitmap(MapConstant.smallwallbitmap, leftj, lefti, null);
				}
				// 如果是预选地图
				else if(showmapview[i][j] == MapConstant.YU){
					canvas.drawRect(rc, yuxuanpaint);
				}
				// 如果是座位
				else if(showmapview[i][j] == MapConstant.SEAT){
					// 确定圆心位置要加上半径
//					int r = MapConstant.ShowMapPiexl / 2;
//					canvas.drawCircle(leftj + r, lefti + r, r, seatpaint);
					canvas.drawBitmap(MapConstant.smallseatbitmap, leftj, lefti, null);
				}
				// 如果是地板
				else if(showmapview[i][j] == MapConstant.FIELD){
					canvas.drawBitmap(MapConstant.smallfloorbitmap, leftj, lefti, null);
				}
				// 如果是书架
				else if(showmapview[i][j] == MapConstant.SHUJIA){
					canvas.drawBitmap(MapConstant.smallshujiabitmap, leftj, lefti, null);
				}
				// 如果是不可用座位
				else if(showmapview[i][j] == MapConstant.SEATNO){
					canvas.drawBitmap(MapConstant.smallseatnobitmap, leftj, lefti, null);
				}
				
			}
		}
		
//		canvas.drawText("屏幕大小：宽：，"+Constant.ScreenWidth+"高："+Constant.ScreenHeight, 50, 50, seatpaint);
//		this.invalidate();
	}
}
