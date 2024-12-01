module ru.cotel.weathergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires okhttp3;
    requires jdk.httpserver;
    requires org.json;

    opens ru.cotel.weathergui to javafx.fxml;
    exports ru.cotel.weathergui;
}