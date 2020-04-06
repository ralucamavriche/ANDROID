package com.example.onlineshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    Button writeButton;
    ListView listView;
    TextView textView;
    TextView text;
    String[] listValue = new String[]{
            "Item1", "Item2", "Item3", "Item4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView2);
        writeButton = findViewById(R.id.button3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, listValue);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("Descriere pentru produsul: " + listValue[position]);
            }
        });
        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getCharSequence("Text"));
        }
//        writeButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                writeFile();
//            }
//        });


    }

//    private void writeFile() {
//        String textToSave = textView.getText().toString();
//        try{
//            FileOutputStream fileOutputStream = openFileOutput("File.txt", MODE_PRIVATE);
//            fileOutputStream.write(textToSave.getBytes());
//            fileOutputStream.close();
//
//            Toast.makeText(getApplicationContext(),"Text Saved", Toast.LENGTH_SHORT).show();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("Text", textView.getText());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meniu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //    4
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                return true;
            case R.id.About:
                openAboutMenu();
                return true;
            case R.id.Help:
                openHelpMenu();
                return true;
            case R.id.Settings:
                openSettingsMenu();
                return true;
            case R.id.Sensor:
                openSensorMenu();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openAboutMenu() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void openHelpMenu() {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void openSettingsMenu() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openSensorMenu() {
        Intent intent = new Intent(this, SensorActivity.class);
        startActivity(intent);
    }

    public void onSaveButtonCliked(View view) {
        String textToSave = "File.txt";
        text = findViewById(R.id.textView2);
        Context context = getApplicationContext();

        File file = new File(context.getFilesDir(), textToSave);


        try {

            FileOutputStream fileOutputStream = openFileOutput("File.txt", MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();

            Toast.makeText(getApplicationContext(), "Text Saved", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fileInputStream.read(data);
            fileInputStream.close();
            System.out.println(new String(data));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
