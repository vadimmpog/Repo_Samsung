package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBBets db;
    BetAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBBets(this);

        adapter = new BetAdapter(this, db.selectAll());
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        findViewById(R.id.butSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = db.getLastId() + 1;
                String teamHome = ((TextView)findViewById(R.id.TeamHome)).getText().toString();
                String teamGuest = ((TextView)findViewById(R.id.TeamGuest)).getText().toString();
                float betHome = Float.parseFloat(((TextView)findViewById(R.id.BetHome))
                        .getText().toString());
                float betGuest = Float.parseFloat(((TextView)findViewById(R.id.BetGuest))
                        .getText().toString());
                float betDraw = Float.parseFloat(((TextView)findViewById(R.id.BetDraw))
                        .getText().toString());

                Bet bet = new Bet(id, teamHome, teamGuest, betHome, betDraw, betGuest);

                db.insert(bet);

                adapter.setBets(db.selectAll());
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.butCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.TeamHome)).setText("");
                ((TextView)findViewById(R.id.TeamGuest)).setText("");
                ((TextView)findViewById(R.id.BetHome)).setText("");
                ((TextView)findViewById(R.id.BetGuest)).setText("");
                ((TextView)findViewById(R.id.BetDraw)).setText("");
            }
        });
    }
}
