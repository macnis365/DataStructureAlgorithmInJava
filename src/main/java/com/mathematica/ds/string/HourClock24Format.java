package com.mathematica.ds.string;

public class HourClock24Format {
	
	public static String timeConversion(String timeIn12Format){
		String anteMeridieamOrPostMeridieam = timeIn12Format.substring(timeIn12Format.length()-2);
		String hour = timeIn12Format.substring(0, 2);
		System.out.println("AM or PM "+anteMeridieamOrPostMeridieam);
		System.out.println("Hour is "+Integer.getInteger("12"));
		StringBuilder hour24Format = new StringBuilder();
		
		if("AM".equals(anteMeridieamOrPostMeridieam) && Integer.getInteger("12").equals(12)){
			hour24Format.append("00");
		} else {
			int hourIn12HourFormat = 12;
			int hourIn24HourFormat = Integer.getInteger("12");
			if(hourIn12HourFormat < 12 && hourIn12HourFormat > 1){
				hourIn24HourFormat += 12;
			}
			hour24Format.append(hourIn24HourFormat);
		}
		hour24Format.append(timeIn12Format.substring(2));
		return hour24Format.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("converted string "+timeConversion("12:05:45PM"));
		System.out.println("converted string "+timeConversion("12:05:45AM"));
	}

}
