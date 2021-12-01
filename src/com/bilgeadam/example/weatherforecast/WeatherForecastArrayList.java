/**
 * 30 Eyl 2021
 */
package com.bilgeadam.example.weatherforecast;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author $Görkem Sönmez
 *
 */
public class WeatherForecastArrayList {
	public static void main(String[] args) {
		WMassage2.massageWelcome("Hava Durumu Programına Hoşgeldiniz", 4, 0, "=");
		String province = BAUtils.readString("Şehir Girin");
		String district = BAUtils.readString("İlçe Girin");
		String country = BAUtils.readString("Ülke Kodu Girin(ex.TR)");
		boolean isCont = true;
		
		while (isCont) {
			int pref = BAUtils.readInt("Enlem ve boylam için 1\n\tGünlük Hava Raporu için 2\n\t15 Saatlik Hava Raporu için 3\n\tKirlilik Raporu için 4\n\tÇıkmak için 5\n\tYeni Konum Girmek için 6 Girin");
			
			switch (pref) {
				case 1:
					System.out.println("Enlem: " + latitudeAndLongitudeInfo(district, province, country)[0] + " Boylam: " + latitudeAndLongitudeInfo(district, province, country)[1]);
					
					break;
				
				case 2:
					dailyWeatherReport(latitudeAndLongitudeInfo(district, province, country)[0], latitudeAndLongitudeInfo(district, province, country)[1]);
					
					break;
				
				case 3:
					fifteenHoursWeatherReport(district, province, country);
					
					break;
				
				case 4:
					airPollutionReport(latitudeAndLongitudeInfo(district, province, country)[0], latitudeAndLongitudeInfo(district, province, country)[1]);
					
					break;
				
				case 5:
					isCont = false;
					break;
				case 6:
					main(args);
					break;
				
				default:
					System.out.println("Lütfen belirtilen tercihleri yap!!!");
					break;
			}
		}
		
	}
	
	private static void airPollutionReport(double latitude, double longitude) {
		// "components":{"co":287.06,"no":0.04,"no2":0.44,"o3":66.52,"so2":0.89,"pm2_5":1.64,"pm10":1.8,"nh3":0.16},"dt":1633093200}]}
		
		System.out.println("Hava Kirlilik Raporu");
		String Info = BAUtils.getPolutionData(latitude, longitude);
		
		StringTokenizer token = new StringTokenizer(Info, "  [{\":,}");
		ArrayList<String> list = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
			
		}
		
		int coIndex = list.indexOf("co");
		String coString = list.get(coIndex + 1);
		System.out.println("Karbonmonoksit:" + coString);
		
		int noIndex = list.indexOf("no");
		String noString = list.get(noIndex + 1);
		System.out.println("Azot Oksit:" + noString);
		
		int no2Index = list.indexOf("no2");
		String no2String = list.get(no2Index + 1);
		System.out.println("Azot dioksit:" + no2String);
		
		int o3Index = list.indexOf("o3");
		String o3String = list.get(o3Index + 1);
		System.out.println("Ozon:" + o3String);
		
		int so2Index = list.indexOf("so2");
		String so2String = list.get(so2Index + 1);
		System.out.println("Kükürt dioksi:" + so2String);
		
		int pm25Index = list.indexOf("pm2_5");
		String pm25String = list.get(pm25Index + 1);
		System.out.println("PM2.5:" + pm25String);
		
		int pm10Index = list.indexOf("pm10");
		String pm10String = list.get(pm10Index + 1);
		System.out.println("PM10:" + pm10String);
		
		int nh3Index = list.indexOf("nh3");
		String nh3String = list.get(nh3Index + 1);
		System.out.println("Amonyak:" + nh3String);
		
	}
	
	private static void hour(String hour) {
		StringTokenizer token = new StringTokenizer(hour, "  [{\":,}");
		ArrayList<String> list = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
			
		}
		int indexhour = list.indexOf("dt_txt");
		
		String hourString = list.get(indexhour + 2);
		
		System.out.println("Saat : " + hourString + ":00");
		
	}
	
	private static void sunrise(String dailyWeatherReport) {
		
		StringTokenizer token = new StringTokenizer(dailyWeatherReport, "  [{\":,}");
		ArrayList<String> list = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
			
		}
		int sunrise = list.indexOf("sunrise");
		
		String sunriseString = list.get(sunrise + 1);
		String date = BAUtils.dateAsString(Long.parseLong(sunriseString));
		String time = BAUtils.timeAsString(Long.parseLong(sunriseString));
		System.out.println("Gün Doğumu : " + date + " Saat :" + time);
		
	}
	
	private static void sunset(String dailyWeatherReport) {
		StringTokenizer token = new StringTokenizer(dailyWeatherReport, "  [{\":,}");
		ArrayList<String> list = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
			
		}
		int sunset = list.indexOf("sunset");
		
		String sunsetString = list.get(sunset + 1);
		
		String date = BAUtils.dateAsString(Long.parseLong(sunsetString));
		String time = BAUtils.timeAsString(Long.parseLong(sunsetString));
		System.out.println("Gün Batımı : " + date + " Saat :" + time);
		
	}
	
	public static void description(String dailyWeatherReport) {
		StringTokenizer token = new StringTokenizer(dailyWeatherReport, "[{\":,");
		ArrayList<String> list = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
			
		}
		int des = list.indexOf("description");
		
		String desString = list.get(des + 1);
		desString = desString.substring(0, 1).toUpperCase() + desString.substring(1).toLowerCase();
		System.out.println("Genel Hava Durumu : " + desString);
	}
	
	private static void feels(String dailyWeatherReport) {
		StringTokenizer token = new StringTokenizer(dailyWeatherReport, "  [{\":,");
		ArrayList<String> list = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
			
		}
		int feels = list.indexOf("feels_like");
		
		String feelsString = list.get(feels + 1);
		
		System.out.println("Hissedilen Sıcaklık : " + feelsString + "°C");
		
	}
	
	private static void temp(String dailyWeatherReport) {
		StringTokenizer token = new StringTokenizer(dailyWeatherReport, "  [{\":,");
		ArrayList<String> list = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
			
		}
		int temp = list.indexOf("temp");
		
		String tempString = list.get(temp + 1);
		
		System.out.println("Sıcaklık : " + tempString + "°C");
		
	}
	
	private static void dailyWeatherReport(double latitude, double longitude) {
		System.out.println("Günlük Hava Raporu");
		String dailyWeatherReport = BAUtils.getWeatherData(latitude, longitude);
		description(dailyWeatherReport);
		temp(dailyWeatherReport);
		feels(dailyWeatherReport);
		sunrise(dailyWeatherReport);
		sunset(dailyWeatherReport);
		
	}
	
	private static void fifteenHoursWeatherReport(String district, String province, String country) {
		System.out.println("15 Saatlik Hava Raporu");
		String fiveHoursWeatherReport = BAUtils.getForecastData(district, province, country);
		String[] brokenFiveHoursReport = new String[6];
		brokenFiveHoursReport = fiveHoursWeatherReport.split("\"dt\":");
		
		String firsthour = brokenFiveHoursReport[1];
		hour(firsthour);
		description(firsthour);
		temp(firsthour);
		feels(firsthour);
		
		String secondhour = brokenFiveHoursReport[2];
		hour(secondhour);
		description(secondhour);
		temp(secondhour);
		feels(secondhour);
		String thirdhour = brokenFiveHoursReport[3];
		hour(thirdhour);
		description(thirdhour);
		temp(thirdhour);
		feels(thirdhour);
		String fourthhour = brokenFiveHoursReport[4];
		hour(fourthhour);
		description(fourthhour);
		temp(fourthhour);
		feels(fourthhour);
		String fifthhour = brokenFiveHoursReport[5];
		hour(fifthhour);
		description(fifthhour);
		temp(fifthhour);
		feels(fifthhour);
		
	}
	
	private static double[] latitudeAndLongitudeInfo(String district, String province, String country) {
		String latLonInfo = BAUtils.getDirectData(district, province, country);
		StringTokenizer token = new StringTokenizer(latLonInfo, "  [{\":,");
		ArrayList<String> list = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
			
		}
		
		int lat = list.indexOf("lat");
		
		double latitude = Double.parseDouble(list.get(lat + 1));
		
		int lon = list.indexOf("lon");
		
		double longitude = Double.parseDouble(list.get(lon + 1));
		
		double[] latAndLon = new double[2];
		latAndLon[0] = latitude;
		latAndLon[1] = longitude;
		return latAndLon;
		
	}
	
}
