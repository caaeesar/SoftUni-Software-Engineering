package softuni.exam.models.dto;

import java.time.LocalTime;

public class ForecastExportDto {

    private String cityName;
    private Double minTemperature;
    private Double maxTemperature;
    private LocalTime sunrise = LocalTime.now();
    private LocalTime sunset = LocalTime.now();

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalTime sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        String format = "City: %s:\n-min temperature: %.2f\n--max temperature: %.2f\n---sunrise: %s\n----sunset: %s";
        return String.format(format, getCityName(), getMinTemperature(), getMaxTemperature(), getSunrise(), getSunset());
    }
}
