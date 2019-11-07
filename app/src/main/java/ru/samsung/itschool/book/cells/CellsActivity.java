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

    private int WIDTH = 10;
    private int HEIGHT = 10;

    private Button[][] cells;

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
                cells[i][j].setText(num + "");
                if(Math.random()>0.5) cells[j][i].setBackgroundColor(BLACK);
            }
            num++;
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

        for (int x = 0; x < WIDTH; x++)
        {
            int color = ((ColorDrawable)cells[tappedY][x].getBackground()).getColor();
            if(color==BLACK){
                cells[tappedY][x].setBackgroundColor(WHITE);
            }
            else{
                cells[tappedY][x].setBackgroundColor(BLACK);
            }


        }
        for (int y = 0; y < WIDTH; y++) {
            if(y!=tappedY){
                int color = ((ColorDrawable)cells[y][tappedX].getBackground()).getColor();
                if (color == BLACK) {
                    cells[y][tappedX].setBackgroundColor(WHITE);
                }
                else{
                    cells[y][tappedX].setBackgroundColor(BLACK);
                }
            }

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