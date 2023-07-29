package com.bingoogol.frogcare.receiver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import com.bingoogol.frogcare.service.ApplockService;
import com.bingoogol.frogcare.util.Constants;
import com.bingoogol.frogcare.util.DateUtil;
import com.bingoogol.frogcare.util.Logger;
import com.bingoogol.frogcare.util.SpUtil;
import com.bingoogol.frogcare.util.StorageUtil;
import com.bingoogol.frogcare.util.StreamUtil;

public class BootCompleteReceiver extends BroadcastReceiver {
	private static final String TAG = "BootCompleteReceiver";
	private WindowManager wm;
	private Camera camera;
	private SurfaceView surfaceView;
	private Callback cameraPreviewHolderCallback = new Callback() {

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			camera.stopPreview();
			camera.release();
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			camera = Camera.open(1);
			try {
				Parameters parameters = camera.getParameters();
				camera.setParameters(parameters);
				camera.setDisplayOrientation(90);
				camera.setPreviewDisplay(holder);
				camera.startPreview();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		}
	};

	@Override
	public void onReceive(Context context, Intent intent) {
		Logger.i(TAG, "手机启动完毕");
		
		checkSim(context);
		
		// 如果程序锁服务有打开，则启动看门狗
		if (SpUtil.getBoolean(Constants.spkey.APPLOCK, false)) {
			context.startService(new Intent(context, ApplockService.class));
		}
		// TODO
		addTakePictureView(context);
		takePicture();
	}
	
	private void checkSim(Context context) {
		boolean isprotecting = SpUtil.getBoolean("isprotecting", false);
		if (isprotecting) {
			TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			String currentsim = manager.getSimSerialNumber();
			String realsim = SpUtil.getString("sim", "");
			if (!currentsim.equals(realsim)) {
				Log.i(TAG, "发送报警短信");
				System.out.println("发送报警短信");
				SmsManager smsmanager = SmsManager.getDefault();
				String destinationAddress = SpUtil.getString("safenumber", "");
				smsmanager.sendTextMessage(destinationAddress, null, "sim卡发生了改变，手机可能被盗", null, null);
			}
		}
	}

	private void addTakePictureView(Context context) {
		surfaceView = new SurfaceView(context);
		surfaceView.getHolder().addCallback(cameraPreviewHolderCallback);
		LayoutParams params = new LayoutParams();
		params.gravity = Gravity.LEFT + Gravity.TOP;
		params.x = 100;
		params.y = 100;
		params.height = LayoutParams.WRAP_CONTENT;
		params.width = LayoutParams.WRAP_CONTENT;
		params.flags = LayoutParams.FLAG_NOT_FOCUSABLE | LayoutParams.FLAG_KEEP_SCREEN_ON;
		params.format = PixelFormat.TRANSLUCENT;
		params.type = LayoutParams.TYPE_PRIORITY_PHONE;
		wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		wm.addView(surfaceView, params);
	}

	private void takePicture() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				camera.takePicture(null, null, new Camera.PictureCallback() {
					@Override
					public void onPictureTaken(byte[] data, Camera camera) {
						File imgFile = new File(StorageUtil.getTheftDir(), DateUtil.dateToSecondsString(new Date()) + ".jpg");
						FileOutputStream fos = null;
						try {
							fos = new FileOutputStream(imgFile);
							fos.write(data);
							fos.flush();
							Logger.i(TAG, "拍照成功 文件路径：" + imgFile.getAbsolutePath());
						} catch (Exception e) {
							Logger.e(TAG, "拍照失败" + e.getMessage());
							imgFile.deleteOnExit();
							e.printStackTrace();
						} finally {
							StreamUtil.close(fos, "关闭手机重启完毕时拍照文件输出流出错");
							wm.removeView(surfaceView);
						}
					}

				});
			}
		}, 2000);
	}
}