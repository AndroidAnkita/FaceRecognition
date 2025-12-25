package org.tensorflow.lite.examples.detection.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.detection.Attendancedatabase.AttendanceDetails;
import org.tensorflow.lite.examples.detection.R;

import java.util.List;

public class AttendanceAdapter
        extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {

    List<AttendanceDetails> list;

    public AttendanceAdapter(List<AttendanceDetails> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attendance, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder, int position) {

        AttendanceDetails item = list.get(position);
        holder.tvName.setText("Name : " + item.name);
        holder.tvDate.setText("Date : " + item.date);
        holder.tvTime.setText("Time : " + item.time);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDate, tvTime;

        ViewHolder(View v) {
            super(v);
            tvName = v.findViewById(R.id.tvName);
            tvDate = v.findViewById(R.id.tvDate);
            tvTime = v.findViewById(R.id.tvTime);
        }
    }
}




