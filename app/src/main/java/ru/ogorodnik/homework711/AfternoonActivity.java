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

public class AfternoonActivity extends AppCompatActivity {
    TextView text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afternoon);
        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);

        DateFormat df = new SimpleDateFormat("HH:mm");
        text.setText("Сейчас " + df.format(Calendar.getInstance().getTime()));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent;
                myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://afternoon"));
                startActivity(myIntent);
            }
        });
    }
}