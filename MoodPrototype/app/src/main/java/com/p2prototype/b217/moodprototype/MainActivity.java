package com.p2prototype.b217.moodprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
    public void InfoButtonPressed(View view){


        Intent openInfoScreen = new Intent(this,InfoActivity.class);
        startActivity(openInfoScreen);
    }

    public void SettingsButtonPressed(View view) {

        Intent openSettingScreen = new Intent(this,SettingsActivity.class);
        startActivity(openSettingScreen);
    }
    public void HistorikButtonPressed (View view){
        Intent openHistorikScreen = new Intent(this, HistorikActivity.class);
        startActivity(openHistorikScreen);

    }
}
