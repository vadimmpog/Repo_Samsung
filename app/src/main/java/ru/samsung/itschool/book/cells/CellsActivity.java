package ru.samsung.itschool.book.cells;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import static android.graphics.Color.BLACK;



public class CellsActivity extends Activity implements OnClickListener,
        OnLongClickListener {

    private int WIDTH = 9;
    private int HEIGHT = 13;

    private Button[][] cells;
    private int[][] bomb= new int[13][9],flag=new int[13][9];

    public void req(int y, int x){
        if((y>=0&&y<HEIGHT)&&(x>=0&&x<WIDTH)){
            if(flag[y][x]==0&&bomb[y][x]==0){
                flag[y][x]=1;
                int k=0;
                if(x-1>=0){
                    if(bomb[y][x-1]==1) k++;
                }
                if(x-1>=0&&y+1<HEIGHT){
                    if(bomb[y+1][x-1]==1) k++;
                }
                if(y+1<HEIGHT){
                    if(bomb[y+1][x]==1) k++;
                }
                if(x+1<WIDTH&&y+1<HEIGHT) {
                    if (bomb[y + 1][x + 1] == 1) k++;
                }
                if(x+1<WIDTH){
                    if(bomb[y][x+1]==1) k++;
                }
                if(y-1>=0&&x+1<WIDTH){
                    if(bomb[y-1][x+1]==1) k++;
                }
                if(x-1>=0&&y-1>=0){
                    if(bomb[y-1][x-1]==1) k++;
                }
                if(y-1>=0){
                    if(bomb[y-1][x]==1) k++;
                }
                cells[y][x].setBackgroundColor(0xFF505050);
                if(k!=0) cells[y][x].setText(k+"");
                else {
                    req(y+1,x);
                    req(y,x+1);
                    req(y-1,x);
                    req(y,x-1);
                    req(y-1,x-1);
                    req(y+1,x+1);
                    req(y-1,x+1);
                    req(y+1,x-1);
                }
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();
        generate();

    }

    void generate() {

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++) {
                if (Math.random() > 0.8) bomb[i][j] = 1;
                else bomb[i][j] = 0;
                flag[i][j]=0;
            }
        }

    }

    @Override
    public boolean onLongClick(View v) {
        int f=0;
        Button tappedCell = (Button) v;
        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        //bomb[tappedY][tappedX]=1;
        cells[tappedY][tappedX].setText("¤");
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++)
                if(bomb[i][j]==1){
                    f=1;
                }
        if(f==0){
            //выигрыш
        }
        return false;
    }

    @Override
    public void onClick(View v) {


        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        if(bomb[tappedY][tappedX]==1){
            cells[tappedY][tappedX].setBackgroundColor(Color.RED);
            cells[tappedY][tappedX].setText("*");
            //generate();
        }
        else{
            if(bomb[tappedY][tappedX]==0){
                req(tappedY,tappedX);
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
        GridLayout cellsLayout = (GridLayout)findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(WIDTH);
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