package com.example.testexamen_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int[] Count = new int[] {0,0,0};
    int[] Code = new int[] {8,3,8};
    int foutAttempts = 0;
    String KEY = "fout";
    TextView[] ShowCount = new TextView[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowCount[0]  = (TextView) findViewById(R.id.txtZero);
        ShowCount[1]  = (TextView) findViewById(R.id.txtOne);
        ShowCount[2] = (TextView) findViewById(R.id.txtTwo);


    }




    public void Access(View view){
        SharedPreferences Attempts = getSharedPreferences("Attempt", Context.MODE_PRIVATE);
        Intent intent = new Intent(this, vault.class);
        if (Count[0] == Code[0] && Count[1] == Code[1] && Count[2] == Code[2]){
            Toast toast = Toast.makeText(this, "POG", Toast.LENGTH_SHORT);
            toast.show();

            startActivity(intent);
            foutAttempts = 0;
        }
        else{
            SharedPreferences.Editor editor = Attempts.edit();
            editor.putInt(KEY, ++foutAttempts);
            editor.apply();
            Toast toast = Toast.makeText(this, R.string.access_denied, Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void CountUp(View view) {
        switch (view.getId()){
            case R.id.btnPlusZero:
                if (Count[0] == 9)
                    Count[0] = 0;
                else ++Count[0];

                if (ShowCount[0] != null){
                    ShowCount[0].setText(Integer.toString(Count[0]));

                }


                break;
            case R.id.btnPlusOne:
                if (Count[1] == 9)
                    Count[1] = 0;
                else ++Count[1];

                if (ShowCount[1] != null)
                    ShowCount[1].setText(Integer.toString(Count[1]));
                break;
            case R.id.btnPlusTwo:
                if (Count[2] == 9)
                    Count[2] = 0;
                else ++Count[2];
                if (ShowCount[2] != null)
                    ShowCount[2].setText(Integer.toString(Count[2]));
                break;
        }

    }

    public void CountDown(View view) {

        switch (view.getId()){
            case R.id.btnMinZero:
                if (Count[0] == 0)
                    Count[0] = 9;
                else --Count[0];

                if (ShowCount[0] != null)
                    ShowCount[0].setText(Integer.toString(Count[0]));
                break;
            case R.id.btnMinOne:
                if (Count[1] == 0)
                    Count[1] = 9;
                else --Count[1];

                if (ShowCount[1] != null)
                    ShowCount[1].setText(Integer.toString(Count[1]));
                break;
            case R.id.btnMinTwo:
                if (Count[2] == 0)
                    Count[2] = 9;
                else --Count[2];
                if (ShowCount[2] != null)
                    ShowCount[2].setText(Integer.toString(Count[2]));
                break;
        }
    }
}
