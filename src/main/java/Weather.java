public class Weather {
    private String city;
    private String cityId;
    private Double lon;
    private Double lat;
    private String sunrise;
    private String sunset;
    private String country;
    private Float temperature;
    private Byte humidity;
    private Float pressure;
    private Float windSpeed;
    private String windDirection;
    private String clouds;
    private String lastupdate;

    public Weather(String city, String cityId, Double lon, Double lat, String sunrise, String sunset, String country, Float temperature, Byte humidity, Float pressure, Float windSpeed, String windDirection, String clouds, String lastupdate) {
        this.city = city;
        this.cityId = cityId;
        this.lon = lon;
        this.lat = lat;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.country = country;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.clouds = clouds;
        this.lastupdate = lastupdate;
    }

    public String getCity() {
        return city;
    }

    public String getCityId() {
        return cityId;
    }

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public String getCountry() {
        return country;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Byte getHumidity() {
        return humidity;
    }

    public Float getPressure() {
        return pressure;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getClouds() {
        return clouds;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", cityId='" + cityId + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", country='" + country + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", windDirection='" + windDirection + '\'' +
                ", clouds='" + clouds + '\'' +
                ", lastupdate='" + lastupdate + '\'' +
                '}';
    }
}
