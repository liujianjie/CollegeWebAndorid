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

// չʾ��ͼ��view
public class ShowMapLayerView extends View{
	// �ϼ�
	Context supercon;
	private Paint seatpaint;// ��λpaint,��ʵ��
	private Paint redpaint;// ����paint
	private Paint barpaint;	// �ϰ����paint����䲢�Һ�ɫ
	private Paint yuxuanpaint;// Ԥѡλ�õ�paint,����䲢����ɫ
	private Paint bitmappaint;// λͼ�Ļ�ͼpaint
	// ��view�ĵ�ͼ
	private int showmapview[][];
	
	public ShowMapLayerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		supercon = context;
		initData();
		initPaint();
	}
	// ��ʼ����̬����,mapdata��Щ
	protected void initData(){
		showmapview = new int[MapConstant.i][MapConstant.j];
//		EditMapDataUtil.setMapDataSpace();
	}
	// ���õ�ͼ����
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
		// ���¸��»���
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
	// �滭����
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// i���У�j����
		for(int i = 0; i < MapConstant.i; i++){
			for(int j = 0; j < MapConstant.j; j++){
				int leftj = j * MapConstant.ShowMapPiexl;
				int lefti = i * MapConstant.ShowMapPiexl;
				int righti = j * MapConstant.ShowMapPiexl + MapConstant.ShowMapPiexl;
				int rightj = i * MapConstant.ShowMapPiexl + MapConstant.ShowMapPiexl;
				Rect rc = new Rect(leftj, lefti, righti, rightj);
				// �����ǽ
				if(showmapview[i][j] == MapConstant.BAR){
//					canvas.drawRect(rc, barpaint);
					canvas.drawBitmap(MapConstant.smallwallbitmap, leftj, lefti, null);
				}
				// �����Ԥѡ��ͼ
				else if(showmapview[i][j] == MapConstant.YU){
					canvas.drawRect(rc, yuxuanpaint);
				}
				// �������λ
				else if(showmapview[i][j] == MapConstant.SEAT){
					// ȷ��Բ��λ��Ҫ���ϰ뾶
//					int r = MapConstant.ShowMapPiexl / 2;
//					canvas.drawCircle(leftj + r, lefti + r, r, seatpaint);
					canvas.drawBitmap(MapConstant.smallseatbitmap, leftj, lefti, null);
				}
				// ����ǵذ�
				else if(showmapview[i][j] == MapConstant.FIELD){
					canvas.drawBitmap(MapConstant.smallfloorbitmap, leftj, lefti, null);
				}
				// ��������
				else if(showmapview[i][j] == MapConstant.SHUJIA){
					canvas.drawBitmap(MapConstant.smallshujiabitmap, leftj, lefti, null);
				}
				// ����ǲ�������λ
				else if(showmapview[i][j] == MapConstant.SEATNO){
					canvas.drawBitmap(MapConstant.smallseatnobitmap, leftj, lefti, null);
				}
				
			}
		}
		
//		canvas.drawText("��Ļ��С������"+Constant.ScreenWidth+"�ߣ�"+Constant.ScreenHeight, 50, 50, seatpaint);
//		this.invalidate();
	}
}
