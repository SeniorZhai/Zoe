package com.zoe.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;


public class CommonUtil {
	private static final CommonLog log = LogFactory.createLog();

	public static boolean hasSDCard(){
		String status = Environment.getExternalStorageState();
		if (!status.equals(Environment.MEDIA_MOUNTED)) {
			return false;
		}
		return true;
	}

	public static String getRootFilePath() {
		if (hasSDCard()){
			return Environment.getExternalStorageDirectory().getAbsolutePath() + "/"; //filePath:/sdcard/
		}
		 else {
			 return Environment.getDataDirectory().getAbsolutePath() + "/data/"; //filePath: /data/data/
		 }
	}

	public static boolean checkNetState(Context context){
		boolean netstate = false;
		ConnectivityManager connecivity = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE));
		if (connecivity != null) {
			NetworkInfo[] info = connecivity.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length ; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						netstate = true;
						break;
					}
				}
			}
		}
		/*
 		 * 跳转到无线网络设置界面  
 		 * startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));  
		 * 跳转到无限wifi网络设置界面  
 		 * startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS)); 
		 */
		return netstate;
	}

	public static void showToask(Context context,String tip) {
		Toast.makeText(context,tip,Toast.LENGTH_SHORT).show();
	}

	public static int getScreenWidth(Context context) {
		WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		return display.getWidth();
	}
	public static int getScreenHeight(Context context) {
		WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		return display.getHeight();
	}
}
