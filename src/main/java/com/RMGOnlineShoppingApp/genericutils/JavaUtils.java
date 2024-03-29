package com.RMGOnlineShoppingApp.genericutils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	public int getRandomNum(int num) {
		Random ran = new Random();
		int randomNum = ran.nextInt(num);
		return randomNum;
	}

	public String getSystemDate() {
		String localDateTime = LocalDateTime.now().toString().replace(":", "-");
		return localDateTime;
	}

	public String getSystemDateInFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD-M-yyyy hh:mm:ss");

		Date dt = new Date();
		String date = dateFormat.format(dt);
		return date;
	}
}
