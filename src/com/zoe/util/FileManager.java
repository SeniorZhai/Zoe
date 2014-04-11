package com.zoe.util;


public class FileManager {

	public static String getSaveFilePath() {
		if (CommonUtil.hasSDCard()) {
			return CommonUtil.getRootFilePath() + "com.zoe/files/";
		} else {
			return CommonUtil.getRootFilePath() + "com.zoe/files";
		}
	}
}
