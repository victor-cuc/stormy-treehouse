package com.victorcuc.stormy.weather;


import com.victorcuc.stormy.R;

public class Forecast {
    private Current current;
    private Hour[] hourlyForecast;
    private Day[] dailyForecast;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Hour[] getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(Hour[] hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

    public Day[] getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(Day[] dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    public static int getIconId(String iconString) {

        // clear-day, clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night
        int iconId = R.drawable.clear_day;

        if (iconString.equals("clear-day")) {
            iconId = R.drawable.clear_day;
        }
        else if (iconString.equals("clear-night")) {
            iconId = R.drawable.clear_night;
        }
        else if (iconString.equals("rain")) {
            iconId = R.drawable.rain;
        }
        else if (iconString.equals("snow")) {
            iconId = R.drawable.snow;
        }
        else if (iconString.equals("sleet")) {
            iconId = R.drawable.sleet;
        }
        else if (iconString.equals("wind")) {
            iconId = R.drawable.wind;
        }
        else if (iconString.equals("fog")) {
            iconId = R.drawable.fog;
        }
        else if (iconString.equals("cloudy")) {
            iconId = R.drawable.cloudy;
        }
        else if (iconString.equals("partly-cloudy-day")) {
            iconId = R.drawable.partly_cloudy;
        }
        else if (iconString.equals("partly-cloudy-night")) {
            iconId = R.drawable.cloudy_night;
        }

        return iconId;
    }
}
