package com.wwq.genesislaw.controller.utils;

import android.os.Build;
import android.os.StatFs;

import java.io.File;

/**
 * 传入路径，计算总空间和剩余空间的工具类
 */
public class AvailableSizeUtil {
	// 得到文件系统的信息：存储块大小，总的存储块数量，可用存储块数量
	// 获取sd卡空间
	// 存储设备会被分为若干个区块
	// 每个区块的大小 * 区块总数 = 存储设备的总大小
	// 每个区块的大小 * 可用区块的数量 = 存储设备可用大小
	/**
	 * 获取剩余存储空间大小
	 */
	public static long available(File path) {
		StatFs stat = new StatFs(path.getPath());
		long blockSize;
		long availableBlocks;
		// 由于API18（Android4.3）以后getBlockSize过时并且改为了getBlockSizeLong
		// 因此这里需要根据版本号来使用那一套API
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
			blockSize = stat.getBlockSizeLong();
			availableBlocks = stat.getAvailableBlocksLong();
		} else {
			blockSize = stat.getBlockSize();
			availableBlocks = stat.getAvailableBlocks();
		}
		long availableSize = blockSize * availableBlocks;
		return availableSize;
	}

	/**
	 * 获取物理存储总大小
	 */
	public static long total(File path) {
		StatFs stat = new StatFs(path.getPath());
		long blockSize;
		long totalBlocks;
		// 由于API18（Android4.3）以后getBlockSize过时并且改为了getBlockSizeLong
		// 因此这里需要根据版本号来使用那一套API
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
			blockSize = stat.getBlockSizeLong();
			totalBlocks = stat.getBlockCountLong();
		} else {
			blockSize = stat.getBlockSize();
			totalBlocks = stat.getBlockCount();
		}
		long totalSize = blockSize * totalBlocks;
		return totalSize;
	}
}
