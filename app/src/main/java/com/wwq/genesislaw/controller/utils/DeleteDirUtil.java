package com.wwq.genesislaw.controller.utils;

import java.io.File;

/**
 * 删除文件夹及以下所有内容的工具类
 */
public class DeleteDirUtil {
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}
}
