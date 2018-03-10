package com.victorcuc.stormy.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.victorcuc.stormy.R;
import com.victorcuc.stormy.weather.Hour;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {

    private Context context;
    private Hour[] hours;

    public HourAdapter(Context context, Hour[] hours) {
        this.context = context;
        this.hours = hours;
    }

    @NonNull
    @Override
    public HourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_list_item, parent, false);

        HourViewHolder hourViewHolder = new HourViewHolder(view);
        return hourViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HourViewHolder holder, int position) {
        holder.bindHour(hours[position]);
    }

    @Override
    public int getItemCount() {
        return hours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.timeLabel) TextView timeLabel;
        @BindView(R.id.summaryLabel) TextView summaryLabel;
        @BindView(R.id.temperatureLabel) TextView temperatureLabel;
        @BindView(R.id.iconImageView) ImageView iconImageView;
        // @BindView(R.id.circleImage) ImageView circleImage;

        public HourViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour) {
            timeLabel.setText(hour.getHour());
            temperatureLabel.setText(String.valueOf(hour.getTemperature()));
            summaryLabel.setText(hour.getSummary());
            iconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View v) {
            String time = timeLabel.getText().toString();
            String temperature = temperatureLabel.getText().toString();
            String summary = summaryLabel.getText().toString();

            String message = String.format("At %s it will be %s°C and %s",
                    time,
                    temperature,
                    summary);

            Toast.makeText(context, message, Toast.LENGTH_LONG).show();

        }
    }
}
