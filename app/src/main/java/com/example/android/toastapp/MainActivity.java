package com.example.android.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int clickCount=0;
    private TextView showClickCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showClickCount= (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast=Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        clickCount++;
        if (showClickCount!=null){
            showClickCount.setText(Integer.toString(clickCount));
        }
    }
}
