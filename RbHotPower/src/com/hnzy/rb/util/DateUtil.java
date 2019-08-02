package com.hnzy.rb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

	public static final String YYYY_MM = "yyyy-MM";

	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	public static final String YYYYMMDD = "yyyyMMdd";

	public static final String HHMMSS = "HH:mm:ss";

	public static final String HHMM = "HH:mm";

	public static final char Y = 'Y';
	public static final char M = 'M';
	public static final char D = 'D';
	public static final char H = 'H';
	public static final char F = 'F';
	public static final char S = 'S';

	public static int getDaysOfMonth(int year, int month) {
		int days[] = { 31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (2 == month && 0 == (year % 4)
				&& (0 != (year % 100) || 0 == (year % 400))) {
			days[2] = 29;
		}
		return days[month];
	}

	public static int getDaysInMonth(int year, int mon) {
		java.util.GregorianCalendar d1 = new java.util.GregorianCalendar(year,
				mon - 1, 1);
		java.util.GregorianCalendar d2 = (java.util.GregorianCalendar) d1
				.clone();
		d2.add(Calendar.MONTH, 1);
		return (int) ((d2.getTimeInMillis() - d1.getTimeInMillis()) / 3600 / 1000 / 24);
	}

	public static String getCurrentDateStr(String strFormat) {
		Calendar cal = Calendar.getInstance();
		Date currDate = cal.getTime();
		return format(currDate, strFormat);
	}

	public static Date parse(String str, String strFormat) { 
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Integer getDateStr(char str) {
		Calendar cal = Calendar.getInstance();
		Integer YMD = null;
		switch (str) {
		case Y:
			YMD = cal.get(Calendar.YEAR);
			break;
		case M:
			YMD = cal.get(Calendar.MONTH) + 1;
			break;
		case D:
			YMD = cal.get(Calendar.DAY_OF_MONTH);
			break;
		case H:
			YMD = cal.get(Calendar.HOUR_OF_DAY);
			break;
		case F:
			YMD = cal.get(Calendar.MINUTE);
			break;
		case S:
			YMD = cal.get(Calendar.SECOND);
			break;
		}
		return YMD;
	}

	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);
		Date currDate = cal.getTime();

		return format(currDate, DateUtil.YYYY_MM_DD);
	}
	
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		Date currDate = cal.getTime();
		return format(currDate, DateUtil.YYYY_MM_DD);
	}

	public static String getYesteDateStr(String strFormat) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1); 
		Date currDate = cal.getTime();
		return format(currDate, strFormat);
	}

	public static String getLastMonthDateStr(String strFormat) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1); 
		Date currDate = cal.getTime();
		return format(currDate, strFormat);
	}

	public static String get2WeekAgoDateStr(String strFormat) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -14);
		Date currDate = cal.getTime();
		return format(currDate, strFormat);
	}

	public static String format(Date currDate, String strFormat) {
		SimpleDateFormat format = new SimpleDateFormat(strFormat);
		String time = format.format(currDate.getTime());
		return time;
	}
}
