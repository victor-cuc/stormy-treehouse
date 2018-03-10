package com.victorcuc.stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.victorcuc.stormy.R;
import com.victorcuc.stormy.weather.Day;


public class DayAdapter extends BaseAdapter {
    private Context context;
    private Day[] days;

    public DayAdapter(Context context, Day[] days) {
        this.context = context;
        this.days = days;
    }

    @Override
    public int getCount() {
        return days.length;
    }

    @Override
    public Object getItem(int position) {
        return days[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; //not used - used to tag items for easy reference
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.circleImageView = convertView.findViewById(R.id.circleImageView);
            holder.iconImageView = convertView.findViewById(R.id.iconImageView);
            holder.dayLabel = convertView.findViewById(R.id.dayNameLabel);
            holder.temperatureLabel = convertView.findViewById(R.id.temperatureLabel);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = days[position];
        holder.circleImageView.setImageResource(R.drawable.bg_temperature);
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(String.valueOf(day.getTemperatureMax()));

        if (position == 0) {
            holder.dayLabel.setText("Today");
        }
        else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView circleImageView;
        ImageView iconImageView;
        TextView temperatureLabel;
        TextView dayLabel;
    }
}
