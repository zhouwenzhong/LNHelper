package com.lianyao.ftf.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FtfService extends Service {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("daemon_java", "FtfService: onCreate! I can not be Killed!");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("daemon_java", "FtfService: onStartCommand! I can not be Killed!");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
}
