package com.example.myapplication;


import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyCompanyAdapter adapter = new MyCompanyAdapter(this, makeCompanies());
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    MyCompany[] makeCompanies(){
        MyCompany[] arr = new MyCompany[13];

        String[] names = {
                "Blizzard",
                "Sony",
                "Samsung",
                "IBM",
                "Microsoft",
                "Сбребанк",
                "Oracle",
                "Apple",
                "Facebook",
                "Valve",
                "Electronic Arts",
                "Яндекс",
                "Google"

        };

        int[] pictures = {
                R.drawable.blizzard,
                R.drawable.sony,
                R.drawable.samsung,
                R.drawable.ibm,
                R.drawable.microsoft,
                R.drawable.sberbank,
                R.drawable.oracle,
                R.drawable.apple,
                R.drawable.facebook,
                R.drawable.valve,
                R.drawable.electronic_arts,
                R.drawable.yandex,
                R.drawable.google

        };

        double[] costs = {
                87.81,
                13.94,
                814.97,
                1488.07,
                197.38,
                127.95,
                148.83,
                214.71,
                97.93,
                49.94,
                876.00,
                123.58,
                238.90
        };

        for (int i = 0; i < arr.length; i++){
            arr[i] = new MyCompany();
            arr[i].name = names[i];
            arr[i].picture = pictures[i];
            arr[i].cost = costs[i];
        }

        return arr;
    }
}
