/**
 * 30 Eyl 2021
 */
package com.bilgeadam.example.weatherforecast;

/**
 * @author $Görkem Sönmez
 *
 */
public class WeatherForecast {
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
		int coIndex = Info.indexOf("\"co\":");
		int colonCoIndex = Info.indexOf(":", coIndex);
		int commaCoIndex = Info.indexOf(",", colonCoIndex);
		String coString = Info.substring(colonCoIndex + 1, commaCoIndex);
		System.out.println("Karbonmonoksit:" + coString);
		
		int noIndex = Info.indexOf("\"no\":");
		int colonNoIndex = Info.indexOf(":", noIndex);
		int commaNoIndex = Info.indexOf(",", colonNoIndex);
		String noString = Info.substring(colonNoIndex + 1, commaNoIndex);
		System.out.println("Azot Oksit:" + noString);
		
		int no2Index = Info.indexOf("\"no2\":");
		int colonNo2Index = Info.indexOf(":", no2Index);
		int commaNo2Index = Info.indexOf(",", colonNo2Index);
		String no2String = Info.substring(colonNo2Index + 1, commaNo2Index);
		System.out.println("Azot dioksit:" + no2String);
		
		int o3Index = Info.indexOf("\"o3\":");
		int colono3Index = Info.indexOf(":", o3Index);
		int commao3Index = Info.indexOf(",", colono3Index);
		String o3String = Info.substring(colono3Index + 1, commao3Index);
		System.out.println("Ozon:" + o3String);
		
		int so2Index = Info.indexOf("\"so2\":");
		int colonSo2Index = Info.indexOf(":", so2Index);
		int commaSo2Index = Info.indexOf(",", colonSo2Index);
		String so2String = Info.substring(colonSo2Index + 1, commaSo2Index);
		System.out.println("Kükürt dioksi:" + so2String);
		
		int pm25Index = Info.indexOf("\"pm2_5\":");
		int colonPm25Index = Info.indexOf(":", pm25Index);
		int commaPm25Index = Info.indexOf(",", colonPm25Index);
		String pm25String = Info.substring(colonPm25Index + 1, commaPm25Index);
		System.out.println("PM2.5:" + pm25String);
		
		int pm10Index = Info.indexOf("\"pm10\":");
		int colonPm10Index = Info.indexOf(":", pm10Index);
		int commaPm10Index = Info.indexOf(",", colonPm10Index);
		String pm10String = Info.substring(colonPm10Index + 1, commaPm10Index);
		System.out.println("PM10:" + pm10String);
		
		int nh3Index = Info.indexOf("\"nh3\":");
		int colonNh3Index = Info.indexOf(":", nh3Index);
		int commaNh3Index = Info.indexOf("}", colonNh3Index);
		String nh3String = Info.substring(colonNh3Index + 1, commaNh3Index);
		System.out.println("Amonyak:" + nh3String);
		
	}
	
	private static void hour(String hour) {
		int hourIndex = hour.indexOf("dt_txt");
		int colonHourIndex = hour.indexOf(":", hourIndex);
		int bracesHourIndex = hour.indexOf("}", colonHourIndex);
		String hourString = hour.substring(colonHourIndex + 12, bracesHourIndex - 1);
		
		System.out.println("Saat : " + hourString);
		
	}
	
	private static void sunrise(String dailyWeatherReport) {
		
		int sunriseIndex = dailyWeatherReport.indexOf("sunrise");
		int colonSunriseIndex = dailyWeatherReport.indexOf(":", sunriseIndex);
		int commaSunriseIndex = dailyWeatherReport.indexOf(",", colonSunriseIndex);
		String sunriseString = dailyWeatherReport.substring(colonSunriseIndex + 1, commaSunriseIndex);
		String date = BAUtils.dateAsString(Long.parseLong(sunriseString));
		String time = BAUtils.timeAsString(Long.parseLong(sunriseString));
		System.out.println("Gün Doğumu : " + date + " Saat :" + time);
		
	}
	
	private static void sunset(String dailyWeatherReport) {
		
		int sunsetIndex = dailyWeatherReport.indexOf("sunset");
		int colonSunsetIndex = dailyWeatherReport.indexOf(":", sunsetIndex);
		int commaSunsetIndex = dailyWeatherReport.indexOf(",", colonSunsetIndex);
		String sunsetString = dailyWeatherReport.substring(colonSunsetIndex + 1, commaSunsetIndex - 1);
		String date = BAUtils.dateAsString(Long.parseLong(sunsetString));
		String time = BAUtils.timeAsString(Long.parseLong(sunsetString));
		System.out.println("Gün Batımı : " + date + " Saat :" + time);
		
	}
	
	public static void description(String dailyWeatherReport) {
		int desIndex = dailyWeatherReport.indexOf("description");
		int colonDesIndex = dailyWeatherReport.indexOf(":", desIndex);
		int commaDesIndex = dailyWeatherReport.indexOf(",", colonDesIndex);
		String desString = dailyWeatherReport.substring(colonDesIndex + 2, commaDesIndex - 1);
		desString = desString.substring(0, 1).toUpperCase() + desString.substring(1).toLowerCase();
		System.out.println("Genel Hava Durumu : " + desString);
	}
	
	private static void feels(String dailyWeatherReport) {
		int feelsIndex = dailyWeatherReport.indexOf("feels_like");
		int colonFeelsIndex = dailyWeatherReport.indexOf(":", feelsIndex);
		int commaFeelsIndex = dailyWeatherReport.indexOf(",", colonFeelsIndex);
		String feelsString = dailyWeatherReport.substring(colonFeelsIndex + 1, commaFeelsIndex);
		
		System.out.println("Hissedilen Sıcaklık : " + feelsString + "°C");
		
	}
	
	private static void temp(String dailyWeatherReport) {
		int tempIndex = dailyWeatherReport.indexOf("temp");
		int colonTempIndex = dailyWeatherReport.indexOf(":", tempIndex);
		int commaTempIndex = dailyWeatherReport.indexOf(",", colonTempIndex);
		String tempString = dailyWeatherReport.substring(colonTempIndex + 1, commaTempIndex);
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
		int latIndex = latLonInfo.indexOf("\"lat\":");
		int colonLatIndex = latLonInfo.indexOf(":", latIndex);
		int commaLatIndex = latLonInfo.indexOf(",", colonLatIndex);
		String latString = latLonInfo.substring(colonLatIndex + 1, commaLatIndex);
		double latitude = Double.parseDouble(latString);
		
		int lonIndex = latLonInfo.indexOf("\"lon\":");
		int colonLonIndex = latLonInfo.indexOf(":", lonIndex);
		int commaLonIndex = latLonInfo.indexOf(",", colonLonIndex);
		String lonString = latLonInfo.substring(colonLonIndex + 1, commaLonIndex);
		double longitude = Double.parseDouble(lonString);
		
		double[] latAndLon = new double[2];
		latAndLon[0] = latitude;
		latAndLon[1] = longitude;
		return latAndLon;
		
	}
	
}
