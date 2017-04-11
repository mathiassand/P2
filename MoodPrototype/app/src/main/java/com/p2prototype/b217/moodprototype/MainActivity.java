package com.p2prototype.b217.moodprototype;

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
    public void testMethod(View view)
    {
        Toast.makeText(this,"It works!",Toast.LENGTH_LONG).show();
    }
}
