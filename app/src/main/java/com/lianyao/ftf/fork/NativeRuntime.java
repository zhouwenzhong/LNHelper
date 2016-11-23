package com.lianyao.ftf.fork;

public class NativeRuntime {

	public native static void startActivity(String compname);

	public native static String stringFromJNI();

	public native static void startService(String srvname, String sdpath);

	public native static int findProcess(String packname);

	public native static int stopService();

	static {
		try {
			System.loadLibrary("helper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
