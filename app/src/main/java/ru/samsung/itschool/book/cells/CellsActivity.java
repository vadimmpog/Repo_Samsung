package ru.samsung.itschool.book.cells;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;


public class CellsActivity extends Activity implements OnClickListener,
        OnLongClickListener {

    private int WIDTH = 13;
    private int HEIGHT = 9;

    private Button[][] cells;
    private int[][] bomb= new int[9][13];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();
        generate();

    }

    void generate() {

        int num = 0;
        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++) {
                if (Math.random() > 0.8) bomb[i][j] = 1;
                else bomb[i][j] = 0;
            }
        }

    }

    @Override
    public boolean onLongClick(View v) {

        return false;
    }

    @Override
    public void onClick(View v) {


        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        if(bomb[tappedX][tappedY]==1){

            generate();
        }


    }



    int getX(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    void makeCells() {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(HEIGHT);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }

}