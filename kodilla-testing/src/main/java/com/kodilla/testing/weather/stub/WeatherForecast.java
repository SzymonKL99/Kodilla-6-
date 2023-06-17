package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

        private Temperatures temperatures;

        public WeatherForecast(Temperatures temperatures) {
            this.temperatures = temperatures;
        }

        public Map<String, Double> calculateForecast() {
            Map<String, Double> resultMap = new HashMap<>();

            for (Map.Entry<String, Double> temperature :
                    temperatures.getTemperatures().entrySet()) {

                // adding 1 celsius degree to current value
                // as a temporary weather forecast
                resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
            }
            return resultMap;
        }
    public double calculateAverageTemperature() {
        double sum = 0.0;
        int count = 0;

        for (double temperature : temperatures.getTemperatures().values()) {
            sum += temperature;
            count++;
        }

        return sum / count;
    }
    public double calculateMedianTemperature() {
        List<Double> temperatureValues = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temperatureValues);
        int size = temperatureValues.size();
        if (size % 2 == 0) {
            int mid = size / 2;
            return (temperatureValues.get(mid - 1) + temperatureValues.get(mid)) / 2.0;
        } else {
            return temperatureValues.get(size / 2);
        }
    }

}

