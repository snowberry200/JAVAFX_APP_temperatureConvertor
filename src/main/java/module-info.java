module com.example.temperatureconvertor_01234610b {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.temperatureconvertor_01234610b to javafx.fxml;
    exports com.example.temperatureconvertor_01234610b;
}