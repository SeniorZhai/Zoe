package com.zoe.cache;

import com.zoe.util.FileManager;

import android.content.Context;

public class FileCahce extends AbstractFileCache {

	public FileCahce(Context context) {
		super(context);
	}

	@Override
	public String getSavePath(String url) {
		String filename = String.valueOf(url.hashCode());
		return getCacheDir() + filename;
	}
	@Override
	public String getCacheDir() {
		
		return FileManager.getSaveFilePath();
	}
}
