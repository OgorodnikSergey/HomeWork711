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

public class EveningActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);

        TextView  textView2 = (TextView) findViewById(R.id.textView2);
        Button button = (Button) findViewById(R.id.button);

        DateFormat df = SimpleDateFormat.getTimeInstance();
        textView2.setText(getString(R.string.current_time, df.format(Calendar.getInstance().getTime())));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent;
                myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.ru")); // оставил Яндекс вместо evening, чтобы поспотреть как открывается ссылка
                startActivity(myIntent);
            }
        });
    }

}