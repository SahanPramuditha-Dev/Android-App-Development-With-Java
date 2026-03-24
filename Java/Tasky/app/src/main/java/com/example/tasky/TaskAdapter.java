package com.example.tasky;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;
    private OnTaskActionListener listener;

    public interface OnTaskActionListener {
        void onTaskDelete(int position);
        void onTaskStatusChanged(int position, boolean isCompleted);
        void onTaskEdit(int position);
    }

    public TaskAdapter(List<Task> tasks, OnTaskActionListener listener) {
        this.tasks = tasks;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.title.setText(task.getTitle());
        holder.checkbox.setChecked(task.isCompleted());
        holder.priorityChip.setText(task.getPriority().toUpperCase());

        if (task.isCompleted()) {
            holder.title.setPaintFlags(holder.title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.title.setTextColor(0xFF707971);
        } else {
            holder.title.setPaintFlags(holder.title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.title.setTextColor(0xFF000000);
        }

        if (task.getPriority().equalsIgnoreCase("high")) {
            holder.priorityChip.setChipBackgroundColorResource(android.R.color.holo_red_light);
            holder.priorityChip.setTextColor(0xFFFFFFFF);
        } else {
            holder.priorityChip.setChipBackgroundColorResource(R.color.tasky_light_green);
            holder.priorityChip.setTextColor(0xFF0B301B);
        }

        holder.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            listener.onTaskStatusChanged(position, isChecked);
        });

        holder.btnDelete.setOnClickListener(v -> listener.onTaskDelete(position));
        holder.btnEdit.setOnClickListener(v -> listener.onTaskEdit(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkbox;
        TextView title;
        Chip priorityChip;
        ImageButton btnEdit, btnDelete;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            checkbox = itemView.findViewById(R.id.task_checkbox);
            title = itemView.findViewById(R.id.task_title);
            priorityChip = itemView.findViewById(R.id.priority_chip);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}