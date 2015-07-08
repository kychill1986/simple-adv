package com.yang.framework.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.yang.framework.config.ConfigKeys;
import com.yang.framework.config.SystemConfig;
import com.yang.framework.config.SystemConstants;

public class ResourceFolder {

	public static final String TYPE_HOT_SITE = "hotsite";

	public static final String TYPE_HOT_LINK = "hotlink";

	public static final String TYPE_THEME = "theme";

	public static final String TYPE_FONT = "font";

	public static final String TYPE_WALLPAPER = "wallpaper";

	public static final String TYPE_SPLASH = "splash";

	public static final String TYPE_APP_CATEGORY = "appcate";

	public static final String TYPE_APP = "app";

	public static final String TYPE_WALLPAPER_TAG = "wallpapertag";

	public static final String INSTALLER_RES_FOLDER = "/holalauncher/installer";

	public static final String THEME_BASE_FOLDER = "/holalauncher/theme";

	public static final String FONT_BASE_FOLDER = "/holalauncher/font";

	public static final String WALLPAPER_BASE_FOLDER = "/holalauncher/wallpaper";

	public static final String SPLASH_BASE_FOLDER = "/holalauncher/splash";

	public static final String FOCUS_BASE_FOLDER = "/holalauncher/focus";

	public static final String HOT_LINK_BASE_FOLDER = "/holalauncher/hotlink";

	public static final String HOT_SITE_BASE_FOLDER = "/holalauncher/hotsite";

	public static final String APP_CATEGORY_BASE_FOLDER = "/holalauncher/appcate";

	public static final String APP_BASE_FOLDER = "/holalauncher/app";

	public static final String WALLPAPER_TAG_BASE_FOLDER = "/holalauncher/wallpaper/tag";

	public static final String APK_RES_FOLDER = "/apk";

	public static final String ZIP_RES_FOLDER = "/zip";

	public static final String ICON_RES_FOLDER = "/icon";

	public static final String PREVIEW_IMG_FOLDER = "/preview";

	public static final String HTML_FILE_FOLDER = "/html";

	public static final String BANNER_IMG_FOLDER = "/banner";

	public static final String DETAIL_IMG_FOLDER = "/detail";

	public static final String COVER_IMG_FOLDER = "/cover";

	public static final String TEMP_IMG_FOLDER = "/tmp";

	public static final String RES_FOLDER_TYPE_COVER = "cover";

	public static final String RES_FOLDER_TYPE_ICON = "icon";

	public static final String RES_FOLDER_TYPE_ZIP = "zip";

	public static final String RES_FOLDER_TYPE_APK = "apk";

	public static final String IMG_FOLDER_TYPE_PREVIEW = "preview";

	public static final String RES_FOLDER_TYPE_BANNER = "banner";

	public static final String RES_FOLDER_TYPE_HTML = "html";

	public static final String IMG_FOLDER_TYPE_DETAIL = "detail";

	public static File getResRoot() {
		return new File(SystemConfig.getValue(ConfigKeys.RES_DIRECTORY));
	}

	public static File getInstallerResRoot() {
		return new File(getResRoot(), INSTALLER_RES_FOLDER);
	}

	public static File getTaskDirectoryRoot() {
		return new File(SystemConstants.SYS_ROOT_DIR, "/task");
	}

	public static File getInstallerFolder(String verName) {
		File tmpFile = new File(getInstallerResRoot(), verName);

		if (!tmpFile.exists()) {
			tmpFile.mkdirs();
		}

		return tmpFile;
	}

	/**
	 * 取得文件的保存相对路径，去掉资源存储的根目录
	 * 
	 * @param savedFile
	 * @return
	 */
	public static String getFileUrl(File savedFile) {

		String filePath = savedFile.getAbsolutePath();

		if (filePath.contains("\\")) {
			filePath = filePath.replace("\\", "/");
		}
		if (filePath.contains("//")) {
			filePath = filePath.replace("//", "/");
		}
		String resDirPath = SystemConfig.getValue(ConfigKeys.RES_DIRECTORY);
		if (resDirPath.contains("\\")) {
			resDirPath = resDirPath.replace("\\", "/");
		}
		if (resDirPath.contains("//")) {
			resDirPath = resDirPath.replace("//", "/");
		}
		return SystemConfig.getValue(ConfigKeys.RES_HOST) + StringUtils.substringAfter(filePath, resDirPath);
	}

	/**
	 * 取得文件的资源存储路径，去掉保存相对目录
	 * 
	 * @param savedFile
	 * @return
	 */
	public static String getFilePath(String filePath) {
		if (filePath.contains("\\")) {
			filePath = filePath.replace("\\", "/");
		}

		String resDirPath = SystemConfig.getValue(ConfigKeys.RES_HOST);
		if (resDirPath.contains("\\")) {
			resDirPath = resDirPath.replace("\\", "/");
		}

		String tmpPath = StringUtils.substringAfter(filePath, resDirPath);

		if (StringUtils.isBlank(tmpPath)) {
			return null;
		} else {
			return SystemConfig.getValue(ConfigKeys.RES_DIRECTORY) + tmpPath;
		}
	}

	public static String getResHost() {
		String resHostPath = SystemConfig.getValue(ConfigKeys.RES_HOST);
		if (resHostPath.contains("\\")) {
			resHostPath = resHostPath.replace("\\", "/");
		}

		return resHostPath;
	}

	public static String getDateDirName() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMM");
		return dateformat.format(new Date());
	}

	public static String getResDirectory() {
		String resDirPath = SystemConfig.getValue(ConfigKeys.RES_DIRECTORY);
		if (resDirPath.contains("\\")) {
			resDirPath = resDirPath.replace("\\", "/");
		}
		if (resDirPath.contains("//")) {
			resDirPath = resDirPath.replace("//", "/");
		}

		return resDirPath;
	}

	public static File getResFolder(String UiType, String resType) {
		if (RES_FOLDER_TYPE_APK.equals(resType)) {
			return getApkRoot(UiType);
		} else if (RES_FOLDER_TYPE_ZIP.equals(resType)) {
			return getZipRoot(UiType);
		} else if (RES_FOLDER_TYPE_ICON.equals(resType)) {
			return getIconRoot(UiType);
		} else if (RES_FOLDER_TYPE_COVER.equals(resType)) {
			return getCoverRoot(UiType);
		} else if (IMG_FOLDER_TYPE_PREVIEW.equals(resType)) {
			return getPreviewRoot(UiType);
		} else if (IMG_FOLDER_TYPE_DETAIL.equals(resType)) {
			return getDetailRoot(UiType);
		} else if (RES_FOLDER_TYPE_BANNER.equals(resType)) {
			return getBannerRoot(UiType);
		} else if (RES_FOLDER_TYPE_HTML.equals(resType)) {
			return getHtmlRoot(UiType);
		}
		return null;
	}

	// 取得APK的根目录
	public static File getApkRoot(String UiType) {
		if (TYPE_FONT.equals(UiType)) {
			return new File(getResRoot(), FONT_BASE_FOLDER + APK_RES_FOLDER);
		} else if (TYPE_APP.equals(UiType)) {
			return new File(getResRoot(), APP_BASE_FOLDER + APK_RES_FOLDER);
		} else {
			return new File(getResRoot(), THEME_BASE_FOLDER + APK_RES_FOLDER);
		}
	}

	// 取得ZIP的根目录
	public static File getZipRoot(String UiType) {
		if (TYPE_FONT.equals(UiType)) {
			return new File(getResRoot(), FONT_BASE_FOLDER + ZIP_RES_FOLDER);
		} else {
			return new File(getResRoot(), THEME_BASE_FOLDER + ZIP_RES_FOLDER);
		}
	}

	// 取得icon的根目录
	public static File getIconRoot(String UiType) {
		if (TYPE_HOT_LINK.equals(UiType)) {
			return new File(getResRoot(), HOT_LINK_BASE_FOLDER + ICON_RES_FOLDER);
		} else if (TYPE_HOT_SITE.equals(UiType)) {
			return new File(getResRoot(), HOT_SITE_BASE_FOLDER + ICON_RES_FOLDER);
		} else if (TYPE_APP_CATEGORY.equals(UiType)) {
			return new File(getResRoot(), APP_CATEGORY_BASE_FOLDER + ICON_RES_FOLDER);
		} else if (TYPE_APP.equals(UiType)) {
			return new File(getResRoot(), APP_BASE_FOLDER + ICON_RES_FOLDER);
		} else {
			return new File(getResRoot(), THEME_BASE_FOLDER + ICON_RES_FOLDER);
		}
	}

	// 取得Cover的根目录
	public static File getCoverRoot(String UiType) {
		return new File(getResRoot(), WALLPAPER_TAG_BASE_FOLDER + COVER_IMG_FOLDER);
	}

	// 取得Preview的根目录
	public static File getPreviewRoot(String UiType) {
		if (TYPE_FONT.equals(UiType)) {
			return new File(getResRoot(), FONT_BASE_FOLDER + PREVIEW_IMG_FOLDER);
		} else if (TYPE_THEME.equals(UiType)) {
			return new File(getResRoot(), THEME_BASE_FOLDER + PREVIEW_IMG_FOLDER);
		} else if (TYPE_APP.equals(UiType)) {
			return new File(getResRoot(), APP_BASE_FOLDER + PREVIEW_IMG_FOLDER);
		} else {
			return new File(getResRoot(), WALLPAPER_BASE_FOLDER + PREVIEW_IMG_FOLDER);
		}
	}

	// 取得banner的根目录
	public static File getBannerRoot(String UiType) {
		if (TYPE_APP.equals(UiType)) {
			return new File(getResRoot(), APP_BASE_FOLDER + BANNER_IMG_FOLDER);
		} else {
			return null;
		}
	}

	// 取得html的根目录
	public static File getHtmlRoot(String UiType) {
		if (TYPE_APP.equals(UiType)) {
			return new File(getResRoot(), APP_BASE_FOLDER + HTML_FILE_FOLDER);
		} else {
			return null;
		}
	}

	// 取得Detail的根目录
	public static File getDetailRoot(String UiType) {
		if (TYPE_FONT.equals(UiType)) {
			return new File(getResRoot(), FONT_BASE_FOLDER + DETAIL_IMG_FOLDER);
		} else if (TYPE_THEME.equals(UiType)) {
			return new File(getResRoot(), THEME_BASE_FOLDER + DETAIL_IMG_FOLDER);
		} else {
			return new File(getResRoot(), WALLPAPER_BASE_FOLDER + DETAIL_IMG_FOLDER);
		}
	}

	// 取得闪屏的根目录
	public static File getSplashRoot() {
		return new File(getResRoot(), SPLASH_BASE_FOLDER);
	}

	// 取得焦点的根目录
	public static File getFocusRoot() {
		return new File(getResRoot(), FOCUS_BASE_FOLDER);
	}

	// 取得临时Zip的目录
	public static File getTempRoot() {
		return new File(getResRoot(), WALLPAPER_BASE_FOLDER + TEMP_IMG_FOLDER);
	}

}
