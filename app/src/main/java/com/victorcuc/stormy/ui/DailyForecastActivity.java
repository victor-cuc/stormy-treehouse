package com.victorcuc.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.victorcuc.stormy.R;
import com.victorcuc.stormy.adapters.DayAdapter;
import com.victorcuc.stormy.weather.Day;

import java.util.Arrays;

public class DailyForecastActivity extends ListActivity {

    Day[] days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        days = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayAdapter adapter = new DayAdapter(this, days);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayOfTheWeek = days[position].getDayOfTheWeek();
        String conditions = days[position].getSummary().toLowerCase();
        String highTemp = String.valueOf(days[position].getTemperatureMax());
        String message = String.format("On %s the high will be %s°C and it will be %s",
                dayOfTheWeek,
                highTemp,
                conditions);

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
