package com.lianyao.ftf.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lianyao.ftf.R;
import com.lianyao.ftf.fork.NativeRuntime;
import com.lianyao.ftf.utils.FileUtils;

public class MainActivity extends Activity {

	Button btnstart, btnend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initService();
	}

	private void initService() {
		btnstart = (Button) findViewById(R.id.btn_start);
		btnend = (Button) findViewById(R.id.btn_end);

		btnstart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				(new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							NativeRuntime.startService(getPackageName()
									+ "/com.lianyao.ftf.sdk.realize.FtfService",
									FileUtils.createRootPath());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				})).start();
			}
		});

		btnend.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					NativeRuntime.stopService();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}
