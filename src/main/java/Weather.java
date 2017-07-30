public class Weather {
    private String city;
    private String cityId;
    private Double lon;
    private Double lat;
    private String sunrise;
    private String sunset;
    private String country;
    private Byte temperature;
    private Byte humidity;
    private Short pressure;
    private Byte windSpeed;
    private String windDirection;
    private String clouds;
    private String lastupdate;

    public Weather(String city, String cityId, Double lon, Double lat, String sunrise, String sunset, String country, Byte temperature, Byte humidity, Short pressure, Byte windSpeed, String windDirection, String clouds, String lastupdate) {
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

    public Byte getTemperature() {
        return temperature;
    }

    public Byte getHumidity() {
        return humidity;
    }

    public Short getPressure() {
        return pressure;
    }

    public Byte getWindSpeed() {
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
