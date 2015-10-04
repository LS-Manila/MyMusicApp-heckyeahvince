package com.example.heckyeahvince.lss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

            public void onm1Click(View view){
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                intent.putExtra("filename", "m1.mp3");
                intent.setAction(MusicService.ACTION_PLAY);
                startService(intent);
            }

            public void onm2Click(View view){
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                intent.putExtra("filename", "m2.mp3");
                    intent.setAction(MusicService.ACTION_PLAY);
                startService(intent);
            }

            public void onm3Click(View view){
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                intent.putExtra("filename", "m3.mp3");
                    intent.setAction(MusicService.ACTION_PLAY);
                startService(intent);
             }

    public void onClickStop(View view) {
        Intent intent = new Intent(this, MusicService.class);
        intent.setAction(MusicService.ACTION_STOP);
        startService(intent);
        Toast.makeText(this, "The audio has stopped playing.", Toast.LENGTH_SHORT).show();
    }
}