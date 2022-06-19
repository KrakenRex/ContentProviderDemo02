package com.example.contentproviderdemo02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.contentproviderdemo02.R;
import com.example.contentproviderdemo02.entity.Person;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Person> {

    private Context context;
    private Integer resourceId;

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resourceId, parent, false);
        TextView nameT = view.findViewById(R.id.nameT);
        TextView phoneT = view.findViewById(R.id.phoneT);
        Person person = getItem(position);
        nameT.setText(person.getName());
        phoneT.setText(person.getPhone());
        return view;
    }
}
