package com.example.databases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ToDoAdapter extends ArrayAdapter<ToDo> {

    private Context context;
    private int resource;
    private List<ToDo> toDoList;

    public ToDoAdapter(@NonNull Context context, int resource, @NonNull List<ToDo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.toDoList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);

        TextView title = row.findViewById(R.id.title);
        TextView description = row.findViewById(R.id.description);
        ImageView onGoing = row.findViewById(R.id.onGoing);

        ToDo toDo = toDoList.get(position);
        title.setText(toDo.getTitle());
        description.setText(toDo.getDescription());
        onGoing.setVisibility(View.INVISIBLE);

        if (toDo.getFinished() > 0) {
            onGoing.setVisibility(View.VISIBLE);
        }

        return row;
    }
}
