package com.p2prototype.b217.moodprototype;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

public class HistorikActivity extends MoodLogging {
ArrayList<RelativeLayout> visual= new ArrayList<>(0);
    ArrayList<VisualObject> visualObjects=new ArrayList<>(0);
    LayoutInflater inflateVisual;
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historik);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        container = (LinearLayout) findViewById(R.id.visual_container);
        inflateVisual=(LayoutInflater) HistorikActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i=0; i<visualObjects.size();i++){
            visual.add((RelativeLayout)inflateVisual.inflate(R.layout.visualisation,null,true));
        }
        drawVisual();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    private void convertCSV(){
        for (int i=0;i<20;i++){
            List<String> lines = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("myfile.csv"));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch(Exception e){

            }
            Random r=new Random();
            visualObjects.add(new VisualObject(r.nextInt(101),r.nextInt(101),r.nextInt(24),r.nextInt(60),r.nextInt(200),r.nextInt(10),"bullshit","03/05"));
        }
    }
    private void drawVisual(){
                for (int i=0;i<visual.size();i++){
                    final int index=i;
                    int mood =visualObjects.get(i).getMood();
                    if(mood>=95){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(255,0,0));
                    }else if(mood<95&&mood>=85){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(255,46,1));
                    }else if(mood<85&&mood>=75){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(255,97,1));
                    }else if(mood<75&&mood>=65){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(255,146,1));
                    }else if(mood<65&&mood>=55){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(255,186,1));
                    }else if(mood<55&&mood>=45){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(255,255,0));
                    }else if(mood<45&&mood>=35){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(1,210,255));
                    }else if(mood<35&&mood>=25){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(1,165,255));
                    }else if(mood<25&&mood>=15){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(1,123,255));
                    }else if(mood<15&&mood>5){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(1,83,255));
                    }else if(mood<=5){
                        visual.get(i).findViewById(R.id.visual_background).setBackgroundColor(Color.rgb(0,0,255));
                    }
                    if (visualObjects.get(i).getNoteBoolean()){
                        ImageView  view =(ImageView)visual.get(i).findViewById(R.id.icon_3);
                        view.setImageResource(R.drawable.ic_note);
                    }
                    int anx =Double.valueOf(visualObjects.get(i).getAnxiety()*2.55).intValue();
                    visual.get(i).findViewById(R.id.anxiety_visual).setBackgroundColor(Color.rgb(anx,anx,anx));
                    TextView date= (TextView)visual.get(i).findViewById(R.id.date_text);
                    date.setText(visualObjects.get(i).getDate());
                    TextView sleep=(TextView)visual.get(i).findViewById(R.id.sleep_text);
                    sleep.setText(visualObjects.get(i).getSleep());
                    TextView weight=(TextView)visual.get(i).findViewById(R.id.weight_visual);
                    weight.setText(visualObjects.get(i).getWeight());
                    visual.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            new AlertDialog.Builder(HistorikActivity.this)
                                    .setTitle("Noter for dagen")
                                    .setMessage(visualObjects.get(index).getNote())
                                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            // continue with delete
                                        }
                                    })
                                    .setIcon(R.drawable.ic_note)
                                    .show();
                        }
                    });
                    container.addView(visual.get(i));
                }

    }
}
