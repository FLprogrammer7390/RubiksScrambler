package com.example.rubiksscrambler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.scramble_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                EditText inputView = (EditText) findViewById(R.id.editTextMoves);
                String input = inputView.getText().toString();
                if(input.length()==0 || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 100){
                    inputView.requestFocus();
                    inputView.setError("You must enter a number between 1 and 100!");
                }
                else {
                    Intent intent = new Intent(v.getContext(), ScrambleWindow.class);
                    intent.putExtra("numMoves", input);
                    v.getContext().startActivity(intent);
                }
            }
        });
    }
}
