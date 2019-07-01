package ru.ogorodnik.homework711;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button buttonLink;
    public int hourofday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        buttonLink = (Button) findViewById(R.id.buttonLink);

        text.setText("Сейчас " + String.valueOf(takeHour()) + " часов");

        buttonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SYNC);

                if (takeHour() >= 6 && takeHour() < 14) {
                    intent.setData(Uri.parse("http://morning"));
                    startActivity(intent);
                }

                if (takeHour() >= 14 && takeHour() < 15){
                    intent.setData(Uri.parse("http://afternoon"));
                    startActivity(intent);
                }
                else
                    intent.setData(Uri.parse("http://evening"));
                    startActivity(intent);
            }

        });
    }
    public int takeHour (){
        Calendar cal = Calendar.getInstance();
        int hourofday = cal.get(Calendar.HOUR_OF_DAY);
        return hourofday;
    }
}
