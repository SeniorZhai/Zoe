package com.zoe.cache;

import java.io.File;

import com.zoe.util.FileHelper;

import android.content.Context;
import android.util.Log;

public abstract class AbstractFileCache {

	private String dirString;

	public AbstractFileCache(Context context) {
		dirString = getCacheDir();
		boolean ret = FileHelper.createDirectory(dirString);
		Log.e("", "FileHelper.createDirectoty:" + dirString + ", ret = " + ret);
	}

	public File getFile(String url) {
		File f = new File(getSavePath(url));
		return f;
	}

	public abstract String getSavePath(String url);

	public abstract String getCacheDir();

	public void clear() {
		FileHelper.deleteDiretory(dirString);
	}
}
