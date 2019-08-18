package com.example.swapn.customadapterdemo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterDemoActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_demo);

        listView = (ListView) findViewById(R.id.id_list);
        arrayList = new ArrayList<>();

        arrayList.add("Bob");
        arrayList.add("Bob1");
        arrayList.add("Bob2");
        arrayList.add("Bob3");
        arrayList.add("Bob4");
        arrayList.add("Bob5");

        CustomAdapter adapter = new CustomAdapter(this,R.layout.list_layout,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomAdapterDemoActivity.this, "aslkdjfkajdf;a", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class CustomAdapter extends ArrayAdapter<String>{

        Context context;
        List list;

        public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
            super(context, resource, objects);

            this.context = context;
            list = objects;
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            View adapterView = inflater.inflate(R.layout.list_layout,null);

            TextView textView = adapterView.findViewById(R.id.id_textView);
            Button button = adapterView.findViewById(R.id.id_button);

            textView.setText(list.get(position)+" "+position);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    arrayList.remove(position);
                    notifyDataSetChanged();
                }
            });

            return adapterView;
        }
    }

}
