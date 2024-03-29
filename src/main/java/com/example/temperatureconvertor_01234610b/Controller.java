package com.example.temperatureconvertor_01234610b;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;


public class Controller implements Initializable {
//inject controllers from FXML file into Controller.java
    @FXML
    private Slider sliderController;
    @FXML
    private Label degreeController;
    @FXML
    private Label fahrenheitController;
    @FXML
    private TextField degreeTextFieldController;
    @FXML
    private TextField fahrenheitTextFieldController;

    //number format variable
    private final static NumberFormat temperature = NumberFormat.getInstance();

    //Degree temperature value on slider
    private BigDecimal sliderDegreeValue ;

    //fahrenheit temperature value on slider
    private BigDecimal sliderFahrenheitValue;

    //the conversion ratio between Degree and Fahrenheit
    private final BigDecimal conversionRatio = new BigDecimal ("1.8");



    @Override
    //initialization method for slider and its changing values
    public void initialize(URL url, ResourceBundle resourceBundle) {
    //try , catch and print possible errors.
        try{
            temperature.setRoundingMode(RoundingMode.HALF_EVEN);
            sliderDegreeValue = BigDecimal.valueOf(sliderController.getValue());
            degreeController.setText((sliderDegreeValue) + "°C");
            degreeController.setFont(Font. font("Verdana", FontWeight. BOLD,FontPosture.ITALIC, 20));
            degreeController.setTextFill(Color.RED);
            sliderFahrenheitValue = sliderDegreeValue.multiply(conversionRatio).add(BigDecimal.valueOf(32.0));
            fahrenheitController.setText((temperature.format(sliderFahrenheitValue)) + "°F");
            fahrenheitController.setFont(Font. font("Verdana", FontWeight.BOLD,FontPosture.ITALIC, 30));
            fahrenheitController.setTextFill(Color.RED);

            sliderController.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                sliderDegreeValue = BigDecimal.valueOf(sliderController.getValue());
                degreeController.setText(temperature.format(sliderDegreeValue ) + "°C");
                sliderFahrenheitValue = sliderDegreeValue.multiply(conversionRatio).add(BigDecimal.valueOf(32.0));
                fahrenheitController.setText((temperature.format(sliderFahrenheitValue)) + "°F");

            }
        });
    }
        catch(Exception e){
            degreeTextFieldController.setText("please enter a number");
            fahrenheitTextFieldController.setText("please enter a number");
            degreeTextFieldController.selectAll();
            fahrenheitTextFieldController.selectAll();

        }
    }
//method to convert Degree Celsius to Fahrenheit
    public void onConvert(){

        try{

            temperature.setRoundingMode(RoundingMode.HALF_EVEN);
            BigDecimal celsiusInputValue = new BigDecimal(degreeTextFieldController.getText());
            BigDecimal fahrenheitValue = celsiusInputValue.multiply(conversionRatio).add(BigDecimal.valueOf(32));
            fahrenheitTextFieldController.setText(temperature.format(fahrenheitValue));
            fahrenheitTextFieldController.setFont(Font.font("Verdana", FontWeight.BOLD,FontPosture.ITALIC, 30));
            
        

        }

       catch(NumberFormatException e){
           e.printStackTrace();
           degreeTextFieldController.setText ("please enter and value");
           degreeTextFieldController.selectAll();

        }


    }

    //reset method to reset all changes back to initial State
    public void onReset(){
        degreeTextFieldController.setText((null));
        fahrenheitTextFieldController.setText(null);
        sliderController.setValue(0.0);

    }
}