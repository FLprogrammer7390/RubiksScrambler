package com.example.rubiksscrambler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ScrambleWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scramble_window);

        int numMoves = Integer.parseInt(Objects.requireNonNull(getIntent().getStringExtra("numMoves")));

        String[] moves = generateMoves(numMoves);

        TableLayout table = (TableLayout) findViewById(R.id.scramble_table);
        int item = 0;
        for(int r = 0; r < 1+(moves.length-1)/4; ++r){

            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            ));

            for(int c = 0; c < 4; ++c){
                if(item != moves.length || item == 1) {
                    TextView text = new TextView(this);

                    if(item == 1 && item == moves.length) text.setText(" ");
                    else text.setText(moves[item]);

                    text.setLayoutParams(new TableRow.LayoutParams(c + 1));
                    text.setGravity(Gravity.CENTER);
                    text.setPadding(3, 3, 3, 3);
                    row.addView(text);

                    if(item == 1 && item == moves.length) break;

                    ++item;
                }
                else break;
            }

            table.addView(row);

        }
    }

    private String[] generateMoves(int numMoves) {
        Random rand = new Random();
        int[] i_moves = new int[numMoves];
        String[] c_moves = new String[numMoves];

        for(int i = 0; i < numMoves; ++i){
            i_moves[i] = rand.nextInt(6);
            switch(i_moves[i]){
                case 0: c_moves[i]="F"; break;
                case 1: c_moves[i]="B"; break;
                case 2: c_moves[i]="U"; break;
                case 3: c_moves[i]="D"; break;
                case 4: c_moves[i]="L"; break;
                case 5: c_moves[i]="R"; break;
            }
            if(rand.nextInt(2) == 1) c_moves[i] = c_moves[i] + "'";
        }
        return c_moves;
    }
}
