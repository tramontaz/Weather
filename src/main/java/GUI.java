import javax.swing.*;
import java.awt.*;

/**
 * Created by Vadim on 7/30/2017.
 */
public class GUI extends JFrame implements Thread.UncaughtExceptionHandler {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    private static final String WINDOW_TITLE = "Weather";
    private final JPanel jPanel = new JPanel(new GridLayout(7, 2));

    private final JTextField cityField = new JTextField();
    private final JTextField cityIdField = new JTextField();
    private final JTextField lonField = new JTextField();
    private final JTextField latField = new JTextField();
    private final JTextField sunriseField = new JTextField();
    private final JTextField sunsetField = new JTextField();
    private final JTextField countryField = new JTextField();
    private final JTextField temperatureField = new JTextField();
    private final JTextField humidityField = new JTextField();
    private final JTextField pressureField = new JTextField();
    private final JTextField windDirection = new JTextField();
    private final JTextField windSpeedField = new JTextField();
    private final JTextField cloudsField = new JTextField();
    private final JTextField lastUpdateField = new JTextField();

    protected GUI(Weather city) {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(WINDOW_TITLE);
        setVisible(true);
        cityField.setText("City: " + city.getCity());
        cityField.setEditable(false);
        jPanel.add(cityField);
        cityIdField.setText("City id: " + city.getCityId());
        cityIdField.setEditable(false);
        jPanel.add(cityIdField);
        latField.setText("Latitude: " + city.getLat());
        latField.setEditable(false);
        jPanel.add(latField);
        lonField.setText("Longitude: " + city.getLon());
        lonField.setEditable(false);
        jPanel.add(lonField);
        sunriseField.setText("Sunrise: " + city.getSunrise());
        sunriseField.setEditable(false);
        jPanel.add(sunriseField);
        sunsetField.setText("Sunset: " + city.getSunset());
        sunsetField.setEditable(false);
        jPanel.add(sunsetField);
        countryField.setText("Country zone: " + city.getCountry());
        countryField.setEditable(false);
        jPanel.add(countryField);
        temperatureField.setText("temperature: " + city.getTemperature());
        temperatureField.setEditable(false);
        jPanel.add(temperatureField);
        humidityField.setText("humidity: " + city.getHumidity());
        humidityField.setEditable(false);
        jPanel.add(humidityField);
        pressureField.setText("pressure: " + city.getPressure());
        pressureField.setEditable(false);
        jPanel.add(pressureField);
        windDirection.setText("Wind Direction: " + city.getWindDirection());
        windDirection.setEditable(false);
        jPanel.add(windDirection);
        windSpeedField.setText("Wind Speed: " + city.getWindSpeed());
        windSpeedField.setEditable(false);
        jPanel.add(windSpeedField);
        cloudsField.setText("clouds: " + city.getClouds());
        cloudsField.setEditable(false);
        jPanel.add(cloudsField);
        lastUpdateField.setText("Last Update: " + city.getLastupdate());
        lastUpdateField.setEditable(false);
        jPanel.add(lastUpdateField);
        add(jPanel);
    }


    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        e.getStackTrace();
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        String msg;
        if (stackTraceElements.length == 0) msg = "Пустой stackTraceElements";
        else msg = e.getClass().getCanonicalName() + ": " + e.getMessage() + " \n" +
                stackTraceElements[0].toString();
        JOptionPane.showMessageDialog(null, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);

    }
}
