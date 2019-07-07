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

    private static final int MORNING_START_HOUR = 6;
    private static final int AFTERNOON_START_HOUR = 14;
    private static final int EVENING_START_HOUR = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView  text = (TextView) findViewById(R.id.text);
        Button buttonLink = (Button) findViewById(R.id.buttonLink);

        text.setText(getString(R.string.current_time, String.valueOf(takeHour())));

        buttonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SYNC);
                if (takeHour() >= MORNING_START_HOUR && takeHour() < AFTERNOON_START_HOUR) {
                    intent.setData(Uri.parse("http://morning"));
                } else if (takeHour() >= AFTERNOON_START_HOUR && takeHour() < EVENING_START_HOUR) {
                    intent.setData(Uri.parse("http://afternoon"));
                } else {
                    intent.setData(Uri.parse("http://evening"));
                }
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
