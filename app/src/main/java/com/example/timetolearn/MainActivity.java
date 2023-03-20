package com.example.timetolearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Membuat Item List Bisa Diklik
        AdapterView.OnItemClickListener itemClickListener = new
                AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        if(position == 0){
                            Intent intent = new Intent(MainActivity.this,
                                    LinearLayoutActivity.class);
                            startActivity(intent);
                        }
                        if(position == 1){
                            Intent intent = new Intent(MainActivity.this,
                                    RelativeLayoutActivity.class);
                            startActivity(intent);
                        }
                        if(position == 2){
                            Intent intent = new Intent(MainActivity.this,
                                    RecyclerViewActivity.class);
                            startActivity(intent);
                        }
                    }
                };
        ListView listView = findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

}