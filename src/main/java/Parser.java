import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Parser {

    public static Weather parse(Document document){
        Weather krasnodar;
        //city
        Element cityElement = (Element) document.getElementsByTagName("city").item(0);
        String city = cityElement.getAttribute("name");
        //coordinate
        Element coordElement = (Element) document.getElementsByTagName("coord").item(0);
        Double lon = Double.valueOf(coordElement.getAttribute("lon"));
        Double lat = Double.valueOf(coordElement.getAttribute("lat"));
        //sun
        Element sunElement = (Element) document.getElementsByTagName("sun").item(0);
        String sunrise = sunElement.getAttribute("rise");
        String sunset = sunElement.getAttribute("set");
        //country
        Element countryElement = (Element) document.getElementsByTagName("country").item(0);
        String country = countryElement.getTextContent();
        //temperature
        Element temperatureElement = (Element) document.getElementsByTagName("temperature").item(0);
        Float temperature = Float.valueOf(temperatureElement.getAttribute("value"));
        Float minTempererure = Float.valueOf(temperatureElement.getAttribute("min"));
        Float maxTempererure = Float.valueOf(temperatureElement.getAttribute("max"));
        //humidity
        Element humidityElement = (Element) document.getElementsByTagName("humidity").item(0);
        Byte humidity = Byte.valueOf(humidityElement.getAttribute("value"));
        //pressure
        Element pressureElement = (Element) document.getElementsByTagName("pressure").item(0);
        Float pressure = Float.valueOf(pressureElement.getAttribute("value"));
        //wind
        Element windSpeedElement = (Element) document.getElementsByTagName("speed").item(0);
        Float windSpeed = Float.valueOf(windSpeedElement.getAttribute("value"));
        Element windDirectionElement = (Element) document.getElementsByTagName("direction").item(0);
        String windDirection = windDirectionElement.getAttribute("name");
        //clouds
        Element cloudsElement = (Element) document.getElementsByTagName("clouds").item(0);
        String clouds = cloudsElement.getAttribute("name");
        //lasupdate
        Element lastUpdateElement = (Element) document.getElementsByTagName("lastupdate").item(0);
        String lastupdate = lastUpdateElement.getAttribute("value");

        return krasnodar = new Weather(city, cityElement.getAttribute("id"), lon, lat, sunrise, sunset, country, temperature, humidity, pressure, windSpeed, windDirection, clouds, lastupdate);
    }
}


//  http://api.openweathermap.org/data/2.5/weather?q=Krasnodar&appid=6d0f23a5071298a2af64c8245db45058   json
//  http://api.openweathermap.org/data/2.5/weather?q=Krasnodar,ru&units=metric&mode=xml&appid=6d0f23a5071298a2af64c8245db45058  xml
