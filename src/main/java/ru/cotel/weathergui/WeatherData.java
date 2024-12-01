package ru.cotel.weathergui;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class WeatherData {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "a7b76e3c606d48effb4e257c3ff96b01";
    private static JSONObject jsObject;
    private static JSONObject main;
    private static JSONObject weather;
    private static String cityName;
    private static double temperature;
    private static double fellsLike;
    private static double maximum;
    private static String description;
    private static String weatherData;
    private static double minimum;

    public static double getTemperature() {
        return temperature;
    }

    public static double getFellsLike() {
        return fellsLike;
    }

    public static double getMinimum() {
        return minimum;
    }

    public static String getDescription() {
        return description;
    }

    public static double getMaximum() {
        return maximum;
    }

    public WeatherData(String city) throws Exception {
        weatherData = getWeatherData(city);
        parsAndDisplayWeather(weatherData);
    }

    private static void parsAndDisplayWeather(String weatherData) throws Exception {
        try {
            jsObject = new JSONObject(weatherData);
            cityName = jsObject.getString("name");
            main = jsObject.getJSONObject("main");
            temperature = main.getDouble("temp");
            fellsLike = main.getDouble("feels_like");
            maximum = main.getDouble("temp_max");
            minimum = main.getDouble("temp_min");
            weather = jsObject.getJSONArray("weather").getJSONObject(0);
            description = weather.getString("description");
        } catch (Exception e) {
            System.out.println("Error parsing weather data");
        }
    }

    public static String getWeatherData(String city) throws Exception {
        OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                System.out.println("Error" + response.code() + " " + response.message());
                return null;
            }
        }
    }
}
