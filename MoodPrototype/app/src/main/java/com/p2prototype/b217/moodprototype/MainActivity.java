package com.p2prototype.b217.moodprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void moodButtonPressed(View view)
    {
        Intent openMoodScreen = new Intent(this,moodLogging.class);
        startActivity(openMoodScreen);
    }
}
