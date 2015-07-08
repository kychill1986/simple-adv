package com.yang.framework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

	public static String YYYY_MM_DD = "yyyy-MM-dd";

	public static String YYYY_MM_DD_SHORT = "yyyyMMdd";

	public static String YYYY_MM_DD_CN = "yyyy年MM月dd日";

	public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

	public static String YYYYMMDD = "yyyyMMdd";

	public static String YYYYMM = "yyyyMM";

	/**
	 * AM/PM
	 */
	public static final String AM_PM = "a";

	/**
	 * 一个月里第几天
	 */
	public static final String DAY_IN_MONTH = "dd";

	/**
	 * 一年里第几天
	 */
	public static final String DAY_IN_YEAR = "DD";

	/**
	 * 一周里第几天(Sunday,...)
	 */
	public static final String DAY_OF_WEEK = "EEEE";

	/**
	 * 以天为单位
	 */
	public static final int DIFF_DAY = Calendar.DAY_OF_MONTH;

	/**
	 * 以小时为单位
	 */
	public static final int DIFF_HOUR = Calendar.HOUR_OF_DAY;

	/**
	 * 以毫秒为单位
	 */
	public static final int DIFF_MILLSECOND = Calendar.MILLISECOND;

	/**
	 * 以分钟为单位
	 */
	public static final int DIFF_MINUTE = Calendar.MINUTE;

	/**
	 * 以月份为单位，按照每月30天计算
	 */
	public static final int DIFF_MONTH = Calendar.MONTH;

	/**
	 * 以秒为单位
	 */
	public static final int DIFF_SECOND = Calendar.SECOND;

	/**
	 * 以星期为单位，按照每星期7天计算
	 */
	public static final int DIFF_WEEK = Calendar.WEEK_OF_MONTH;

	/**
	 * 以年为单位，按照每年365天计算
	 */
	public static final int DIFF_YEAR = Calendar.YEAR;

	/**
	 * 半天内小时(0-11)
	 */
	public static final String HOUR_IN_APM = "KK";

	/**
	 * 一天内小时(0-23)
	 */
	public static final String HOUR_IN_DAY = "HH";

	/**
	 * 半天内小时(1-12)
	 */
	public static final String HOUR_OF_APM = "hh";

	/**
	 * 一天内小时(1-24)
	 */
	public static final String HOUR_OF_DAY = "kk";

	/**
	 * 年(四位)
	 */
	public static final String LONG_YEAR = "yyyy";

	/**
	 * 毫秒
	 */
	public static final String MILL_SECOND = "SSS";

	/**
	 * 分钟
	 */
	public static final String MINUTE = "mm";

	/**
	 * 月
	 */
	public static final String MONTH = "MM";

	/**
	 * 秒
	 */
	public static final String SECOND = "ss";

	/**
	 * 年(二位)
	 */
	public static final String SHORT_YEAR = "yy";

	/**
	 * 一个月里第几周
	 */
	public static final String WEEK_IN_MONTH = "W";

	/**
	 * 一年里第几周
	 */
	public static final String WEEK_IN_YEAR = "ww";

	public static final int DATE_OF_YYYY_MM_DD = 0;

	public static final int DATE_OF_YYYY_MM = 1;

	// 设置时间时区
	static {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
	}

	public static String getDateByYYYYMMDD(Date date) {
		String dateString = "";
		if (date != null) {
			DateFormat format = new SimpleDateFormat(YYYYMMDD);
			dateString = format.format(date);
		}
		return dateString;
	}

	public static String getDateByYYYY_MM_DD(Date date) {
		String dateString = "";
		if (date != null) {
			DateFormat format = new SimpleDateFormat(YYYY_MM_DD);
			dateString = format.format(date);
		}
		return dateString;
	}

	public static String getDateByYYYY_MM_DD_SHORT(Date date) {
		String dateString = "";
		if (date != null) {
			DateFormat format = new SimpleDateFormat(YYYY_MM_DD_SHORT);
			dateString = format.format(date);
		}
		return dateString;
	}

	public static String getDateByYYYY_MM_DD_HH_MM(Date date) {
		String dateString = "";
		if (date != null) {
			DateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM);
			dateString = format.format(date);
		}
		return dateString;
	}

	public static String getDateByYYYY_MM_DD_HH_MM_SS(Date date) {
		String dateString = "";
		if (date != null) {
			DateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
			dateString = format.format(date);
		}
		return dateString;
	}

	public static Date YYYY_MM_DD2Date(String string) throws ParseException {
		Date date = null;
		if (string != null && !"".equals(string)) {
			DateFormat format = new SimpleDateFormat(YYYY_MM_DD);
			date = format.parse(string);
		}
		return date;
	}

	public static Date YYYYMMDD2Date(String string) {
		Date date = null;
		if (string != null && !"".equals(string)) {
			DateFormat format = new SimpleDateFormat(YYYYMMDD);
			try {
				date = format.parse(string);
			}
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return date;
	}

	public static Date YYYY_MM_DD_CN2Date(String string) throws ParseException {
		Date date = null;
		if (string != null && !"".equals(string)) {
			DateFormat format = new SimpleDateFormat(YYYY_MM_DD_CN);
			date = format.parse(string);
		}
		return date;
	}

	public static Date YYYY_MM_DD_HH_MM_SS2Date(String string) throws ParseException {
		Date date = null;
		if (string != null && !"".equals(string)) {
			DateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
			date = format.parse(string);
		}
		return date;
	}

	public static Date YYYY_MM_DD_HH_MM2Date(String string) throws ParseException {
		Date date = null;
		if (string != null && !"".equals(string)) {
			DateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM);
			date = format.parse(string);
		}
		return date;
	}

	/**
	 * 检查目的时间是否已超过源时间值加上时间段长度
	 * <p>
	 * 用于判别当前是否已经超时
	 * 
	 * @param destDate
	 *            目的时间，一般为当前时间
	 * @param sourceDate
	 *            源时间，一般为事件产生时间
	 * @param type
	 *            时间计算单位，为分钟、小时等
	 * @param elapse
	 *            持续时间长度
	 * @return 是否超时
	 * @throws CodedException
	 */
	public static boolean compareElapsedTime(Date destDate, Date sourceDate, int type, int elapse) throws RuntimeException {
		if (destDate == null || sourceDate == null)
			throw new RuntimeException("compared date invalid");

		return destDate.getTime() > getRelativeDate(sourceDate, type, elapse).getTime();
	}

	/**
	 * 取当前时间字符串
	 * <p>
	 * 时间字符串格式为：年(4位)-月份(2位)-日期(2位) 小时(2位):分钟(2位):秒(2位)
	 * 
	 * @return 时间字符串
	 */
	public static String getCurrentDateString() {
		return getCurrentDateString("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 按格式取当前时间字符串
	 * 
	 * @param formatString
	 *            格式字符串
	 * @return
	 */
	public static String getCurrentDateString(String formatString) {

		Date currentDate = new Date();
		return getDateString(currentDate, formatString);
	}

	/**
	 * 取当天在一周的第几天
	 * 
	 * @return
	 */
	public static int getCurrentDayOfWeek() {
		return getDayOfWeek(new Date());
	}

	/**
	 * 获取当前时间
	 * 
	 * @Deprecated: use getCurrentDate(String) to instead of.
	 * @return Date
	 */
	@Deprecated
	public static Date getCurrentDate() {
		return getDateFromString(getDateString(new Date(), "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取当前时间
	 * 
	 * @return Date
	 */
	public static Date getCurrentDate(String format) {
		if (null == format) {
			format = "yyyy-MM-dd HH:mm:ss";
		}

		return getDateFromString(getDateString(new Date(), format), format);
	}

	/**
	 * 日期格式化
	 * 
	 * @return Date
	 */
	public static Date getDate(Date date) {
		return getDateFromString(getDateString(date, "yyyy-MM-dd"), "yyyy-MM-dd");
	}

	/**
	 * 根据时间字符串生成时间
	 * 
	 * @param dateString
	 * @return
	 * @throws RuntimeException
	 */
	public static Date getDateFromString(String dateString) throws RuntimeException {
		return getDateFromString(dateString, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 根据字符串生成时间，带格式
	 * 
	 * @param dateString
	 * @param pattern
	 * @return
	 * @throws RuntimeException
	 */
	public static Date getDateFromString(String dateString, String pattern) throws RuntimeException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		}
		catch (java.text.ParseException e) {
			throw new RuntimeException("parse date string '" + dateString + "' with pattern '" + pattern + "' failed: " + e.getMessage());
		}
		return date;
	}

	/**
	 * 取时间字符串
	 * 
	 * @param date
	 *            时间
	 * @return 时间字符串
	 */
	public static String getDateString(Date date) {
		return getDateString(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDateStringWithYYYYDD(Date date) {
		return getDateString(date, YYYYMM);
	}

	/**
	 * 取时间字符串
	 * 
	 * @param date
	 *            时间
	 * @param formatString
	 *            转换格式
	 * @return 时间字符串
	 */
	public static String getDateString(Date date, String formatString) {
		return getDateString(date, formatString, Locale.PRC);
	}

	/**
	 * 取时间字符串
	 * 
	 * @param date
	 *            时间
	 * @param formatString
	 *            转换格式
	 * @param locale
	 *            地区
	 * @return 时间字符串
	 */
	public static String getDateString(Date date, String formatString, Locale locale) {
		if (date == null)
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatString);
		;
		return dateFormat.format(date);
	}

	/**
	 * 取日期在一周的第几天
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * @Description: 返回指定日期当周的开始日期(默认第一天是周日)，默认指定日期为当前日期
	 * @param date
	 * @return Date
	 * @throws
	 */
	public static Date getDayOfWeekStart(Date date) {
		int temp_ = 0;
		Calendar calendar = Calendar.getInstance();

		if (null == date) {
			temp_ = getCurrentDayOfWeek();
		} else {
			calendar.setTime(date);
			temp_ = getDayOfWeek(date);
		}

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - temp_ + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * @Description: 返回指定日期当周的结束日期(默认第一天是周日)，默认指定日期为当前日期
	 * @param
	 * @return Date
	 * @throws
	 */
	public static Date getDayOfWeekEnd(Date date) {
		int temp_ = 0;
		Calendar calendar = Calendar.getInstance();

		if (null == date) {
			temp_ = getCurrentDayOfWeek();
		} else {
			calendar.setTime(date);
			temp_ = getDayOfWeek(date);
		}

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + (7 - temp_));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	/**
	 * @Description: 返回指定日期当周的开始日期(默认第一天是周一)，默认指定日期为当前日期
	 * @param date
	 * @return Date
	 * @throws
	 */
	public static Date getDayOfWeekStart4CN(Date date) {
		int temp_ = 0;
		Calendar calendar = Calendar.getInstance();

		if (null == date) {
			temp_ = getCurrentDayOfWeek();
		} else {
			calendar.setTime(date);
			temp_ = getDayOfWeek(date);
		}

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - temp_ + 2);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * @Description: 返回指定日期当周的结束日期(默认第一天是周一)，默认指定日期为当前日期
	 * @param
	 * @return Date
	 * @throws
	 */
	public static Date getDayOfWeekEnd4CN(Date date) {
		int temp_ = 0;
		Calendar calendar = Calendar.getInstance();

		if (null == date) {
			temp_ = getCurrentDayOfWeek();
		} else {
			calendar.setTime(date);
			temp_ = getDayOfWeek(date);
		}

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + (7 - temp_) + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	/**
	 * 取日期在一月的第几天
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static Date getDayOfMonthStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	public static Date getDayOfMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, getMaximumDay(date));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	/**
	 * 取一个月的最大天数
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取日期所在月份的最大天数
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static int getMaximumDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 根据源时间和时长计算目的时间
	 * 
	 * @param date
	 *            源时间
	 * @param type
	 *            时间单位
	 * @param relate
	 *            时长
	 * @return 目的时间
	 */
	public static Date getRelativeDate(Date date, int type, int relate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, relate);
		return calendar.getTime();
	}

	/**
	 * 根据当前时间和时长计算目的时间
	 * 
	 * @param type
	 *            时间单位
	 * @param relate
	 *            时长
	 * @return 目的时间
	 */
	public static Date getRelativeDate(int type, int relate) {
		Date current = new Date();
		return getRelativeDate(current, type, relate);
	}

	/**
	 * 根据当前时间和时长生成目的时间字符串
	 * 
	 * @param type
	 *            时间单位
	 * @param relate
	 *            时长
	 * @param formatString
	 *            时间格式
	 * @return 时间字符串
	 */
	public static String getRelativeDateString(int type, int relate, String formatString) {
		return getDateString(getRelativeDate(type, relate), formatString);
	}

	public static Date getStartDate(Date date) {
		return getDateFromString(getDateString(date, "yyyyMMdd") + "00:00:00", "yyyyMMddHH:mm:ss");
	}

	public static Date getEndDate(Date date) {
		return getDateFromString(getDateString(date, "yyyyMMdd") + "23:59:59", "yyyyMMddHH:mm:ss");
	}

	/**
	 * 取时间戳字符串
	 * 
	 * @param date
	 *            时间
	 * @return 时间戳字符串
	 */
	public static String getTimestampString(Date date) {
		return getDateString(date, "yyyyMMddHHmmssSSS");
	}

	/**
	 * 取当天日期值
	 * 
	 * @return 日期的整数值
	 */
	public static int getToday() {
		return Integer.parseInt(getCurrentDateString("dd"));
	}

	public static long getTimeDiff(Date fromDate, Date toDate, int type) {
		fromDate = (fromDate == null) ? new Date() : fromDate;
		toDate = (toDate == null) ? new Date() : toDate;
		long diff = toDate.getTime() - fromDate.getTime();

		switch (type) {
			case DIFF_MILLSECOND:
				break;

			case DIFF_SECOND:
				diff /= 1000;
				break;

			case DIFF_MINUTE:
				diff /= 1000 * 60;
				break;

			case DIFF_HOUR:
				diff /= 1000 * 60 * 60;
				break;

			case DIFF_DAY:
				diff /= 1000 * 60 * 60 * 24;
				break;

			case DIFF_MONTH:
				diff /= 1000 * 60 * 60 * 24 * 30;
				break;
			case DIFF_YEAR:
				diff /= 1000 * 60 * 60 * 24 * 365;
				break;

			default:
				diff = 0;
				break;
		}

		return diff;
	}

	/**
	 * 比较时间戳是否相同
	 * 
	 * @param arg0
	 *            时间
	 * @param arg1
	 *            时间
	 * @return 是否相同
	 */
	public static boolean isTimestampEqual(Date arg0, Date arg1) {
		return getTimestampString(arg0).compareTo(getTimestampString(arg1)) == 0;
	}

	/**
	 * 当前日期加减n天后的日期
	 * 
	 * @param n
	 * @return
	 */
	public static Date nDaysAfterNowDate(int n) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_MONTH, +n);
		return rightNow.getTime();
	}

	/**
	 * @param dateStr
	 *            : yyyy-MM-dd
	 * @return
	 */
	public static String getWeek(String dateStr) {
		String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		try {
			date = sdfInput.parse(dateStr);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0) {
			dayOfWeek = 0;
		}
		return dayNames[dayOfWeek];
	}

	/**
	 * 当前日期加减n小时后的日期
	 * 
	 * @param n
	 * @return
	 */
	public static Date nHoursAfterNowDate(int n) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.HOUR_OF_DAY, +n);
		return rightNow.getTime();
	}

	/**
	 * 给定一个日期型字符串，返回加减n天后的日期型字符串
	 * 
	 * @param basicDate
	 * @param n
	 * @return
	 */
	public static String nDaysAfterOneDateString(String basicDate, int n) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date tmpDate = null;
		try {
			tmpDate = df.parse(basicDate);
		}
		catch (Exception e) {
			System.out.println("dateformat:" + e.getMessage());
		}
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(tmpDate);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + n);

		return df.format(calendar.getTime());
	}

	/**
	 * 给定一个日期，返回加减n天后的日期
	 * 
	 * @param basicDate
	 * @param n
	 * @return
	 */
	public static Date nDaysAfterOneDate(Date basicDate, int n) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTimeInMillis(basicDate.getTime());
		// Date date = new Date(calendar.getTimeInMillis());
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + n);

		// Date date2 = new Date(calendar.getTimeInMillis());

		return calendar.getTime();
	}

	/**
	 * 计算两个日期相隔的天数
	 * 
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static int nDaysBetweenTwoDate(Date firstDate, Date secondDate) {
		int nDay = (int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay + 1;
	}

	/**
	 * 计算两个日期相隔的年数
	 * 
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static int nYearsBetweenTwoDate(Date firstDate, Date secondDate) {
		int nYear = nDaysBetweenTwoDate(firstDate, secondDate) / 365 + 1;
		return nYear;
	}

	/**
	 * 计算两个日期相隔的天数
	 * 
	 * @param firstString
	 * @param secondString
	 * @return
	 */
	public static int nDaysBetweenTwoDate(String firstString, String secondString) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = null;
		Date secondDate = null;
		try {
			firstDate = df.parse(firstString);
			secondDate = df.parse(secondString);
		}
		catch (Exception e) {
			System.out.println("dateformat:" + e.getMessage());
		}
		int nDay = (int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}

	/**
	 * 获取给定日期所在的周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstOfWeekOneDate(Date date) {
		int day = DateUtil.getDayOfWeek(date);
		Date sunDay = DateUtil.getRelativeDate(date, DateUtil.DIFF_DAY, -(day - 1));
		return getDate(sunDay);
	}

	/**
	 * 返回给定日期在有一年中的第几周
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeeksOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	public static String getTimeZoneDateStr(Date date) {
		DateFormat formatter = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		TimeZone destTimeZone = TimeZone.getTimeZone("GMT+0");
		formatter.setTimeZone(destTimeZone);
		if (date == null) {
			date = new Date();
		}
		return formatter.format(date);
	}

	public static Date getTimeZoneDate(Date date) {
		try {
			return YYYY_MM_DD_HH_MM_SS2Date(getTimeZoneDateStr(date));
		}
		catch (ParseException e) {
			return new Date();
		}
	}

	public static Date longToDate(long currentTime, String formatType) {
		Date dateOld = new Date(currentTime);
		String sDateTime = dateToString(dateOld, formatType);
		Date date = null;
		try {
			date = stringToDate(sDateTime, formatType);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String dateToString(Date data, String formatType) {
		return new SimpleDateFormat(formatType).format(data);
	}

	public static Date stringToDate(String strTime, String formatType) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		Date date = null;
		date = formatter.parse(strTime);
		return date;
	}

	/**
	 * 时间格式是否满足要求<br>
	 * <p>
	 * 
	 * @param date
	 * @param dateFormatFlag
	 * @return
	 */
	public static boolean dateIsRule(String date, int dateFormatFlag) {
		String regex = "";
		switch (dateFormatFlag) {
			case DateUtil.DATE_OF_YYYY_MM_DD:
				regex = "[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))";
				break;
			case DateUtil.DATE_OF_YYYY_MM:
				regex = "[0-9]{4}-((0[13578]|(10|12))|(02)|(0[469]|11))";
				break;
			default:
				break;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

	@SuppressWarnings("unused")
	private static String checkDateString(String dateString) {
		String tmpStr[] = dateString.split("-");

		StringBuffer sb = new StringBuffer(2);

		if (tmpStr.length == 3) {
			sb.append(tmpStr[0]).append("-");

			if (Integer.valueOf(tmpStr[1]) < 10) {
				tmpStr[1] = "0" + tmpStr[1];
			}
			if (Integer.valueOf(tmpStr[2]) < 10) {
				tmpStr[2] = "0" + tmpStr[2];
			}

			sb.append(tmpStr[1] + "-" + tmpStr[2]);
		}

		return sb.toString();
	}

}
