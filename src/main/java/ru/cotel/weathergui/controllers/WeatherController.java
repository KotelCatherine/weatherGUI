package ru.cotel.weathergui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.cotel.weathergui.weatherData.WeatherData;

public class WeatherController {
    String city;

    @FXML
    private Button buttonSearch;

    @FXML
    private Label cityNameLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextArea feelsLikeText;

    @FXML
    private TextField fieldEnterCityName;

    @FXML
    private TextArea maximumText;

    @FXML
    private TextArea minimumText;

    @FXML
    private TextArea temperatureText;

    @FXML
    void initialize() {
        onButtonSearchClick();
    }

    @FXML
    private void onButtonSearchClick() {
        buttonSearch.setOnAction(event -> {
            city = fieldEnterCityName.getText();
            try {
                new WeatherData(city);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (city.isEmpty()){
                cityNameLabel.setText("Please enter a city");
            }else {
                cityNameLabel.setText(fieldEnterCityName.getText());
                descriptionLabel.setText(WeatherData.getDescription());
                temperatureText.setText(String.valueOf(WeatherData.getTemperature()));
                feelsLikeText.setText(String.valueOf(WeatherData.getFellsLike()));
                maximumText.setText(String.valueOf(WeatherData.getMaximum()));
                minimumText.setText(String.valueOf(WeatherData.getMinimum()));
            }
        });
    }


}

