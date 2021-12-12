package com.example.zakatinput;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button button2;
    private MenuItem item;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ZakatActivity.class);
                startActivity(i);

            }
        });
    }
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate (R.menu.menu, menu);

            return true;
        }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:

                //Toast.makeText(getApplicationContext(), "about", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Activityabout.class);
                startActivity(intent);
                break;


        }

        return super.onOptionsItemSelected(item);
    }
}
