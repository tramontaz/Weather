import org.w3c.dom.Document;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class GUI extends JFrame implements Thread.UncaughtExceptionHandler, ActionListener {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    private static final String WINDOW_TITLE = "Weather";
    private final JPanel infoJPanel = new JPanel(new GridLayout(7, 2));
    private final JPanel inputJPanel = new JPanel(new GridLayout(1, 2));
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
    private final JTextField textFieldCity = new JTextField("Krasnodar");
    private final JButton btnGet = new JButton("Get");

    private Document document;
    private URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Krasnodar,ru&units=metric&mode=xml&appid=6d0f23a5071298a2af64c8245db45058");

    GUI() throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(WINDOW_TITLE);
        setVisible(true);

        inputJPanel.add(textFieldCity);
        inputJPanel.add(btnGet);
        textFieldCity.addActionListener(this);
        btnGet.addActionListener(this);
        add(inputJPanel, BorderLayout.NORTH);

        fillTheInfoPanel();
        add(infoJPanel, BorderLayout.CENTER);
    }

    private void fillTheInfoPanel() throws Exception {
        Weather city = getWeather(url);
        //cityField
        infoJPanel.add(cityField);
        cityField.setText("City: " + city.getCity());
        cityField.setEditable(false);
        //cityIdField
        infoJPanel.add(cityIdField);
        cityIdField.setText("City ID: " + city.getCityId());
        cityIdField.setEditable(false);
        //latField
        latField.setText("Latitude: " + city.getLat());
        latField.setEditable(false);
        infoJPanel.add(latField);
        //lonField
        lonField.setText("Longitude: " + city.getLon());
        lonField.setEditable(false);
        infoJPanel.add(lonField);
        //sunriseField
        sunriseField.setText("Sunrise: " + city.getSunrise());
        sunriseField.setEditable(false);
        infoJPanel.add(sunriseField);
        //sunsetField
        sunsetField.setText("Sunset: " + city.getSunset());
        sunsetField.setEditable(false);
        infoJPanel.add(sunsetField);
        //countryField
        countryField.setText("Country zone: " + city.getCountry());
        countryField.setEditable(false);
        infoJPanel.add(countryField);
        //temperatureField
        temperatureField.setText("temperature: " + city.getTemperature());
        temperatureField.setEditable(false);
        infoJPanel.add(temperatureField);
        //humidityField
        humidityField.setText("humidity: " + city.getHumidity());
        humidityField.setEditable(false);
        infoJPanel.add(humidityField);
        //pressureField
        pressureField.setText("pressure: " + city.getPressure());
        pressureField.setEditable(false);
        infoJPanel.add(pressureField);
        //windDirection
        windDirection.setText("Wind Direction: " + city.getWindDirection());
        windDirection.setEditable(false);
        infoJPanel.add(windDirection);
        //windSpeedField
        windSpeedField.setText("Wind Speed: " + city.getWindSpeed());
        windSpeedField.setEditable(false);
        infoJPanel.add(windSpeedField);
        //cloudsField
        cloudsField.setText("clouds: " + city.getClouds());
        cloudsField.setEditable(false);
        infoJPanel.add(cloudsField);
        //lastUpdateField
        lastUpdateField.setText("Last Update: " + city.getLastupdate());
        lastUpdateField.setEditable(false);
        infoJPanel.add(lastUpdateField);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnGet || src == textFieldCity) try {
            updateURL(textFieldCity.getText());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        else throw new RuntimeException("Неизвестный src = " + src);
    }

    private void updateURL(String city) throws Exception {
        url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + ",ru&units=metric&mode=xml&appid=6d0f23a5071298a2af64c8245db45058");
        fillTheInfoPanel();
    }

    private Weather getWeather(URL url) throws Exception{
        InputStream inputStream = url.openStream();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(inputStream);
        return Parser.parse(document);
    }
}
