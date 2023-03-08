package com.example.thepuck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Integer meteor = 0;
    private Integer pennant = 0;
    private TextView meteorTextView;
    private TextView pennantTextView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
        Toast.makeText(this, "onResume()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meteorTextView = findViewById(R.id.num_1);
        pennantTextView = findViewById(R.id.num_2);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
    }

    public void onClickAddMeteor(View view) {
        meteor++;
        meteorTextView.setText(meteor.toString());
    }

    public void onClickAddPennant(View view) {
        pennant++;
        pennantTextView.setText(pennant.toString());
    }

    public void onClickButtonDropping(View view) {
        meteor = 0;
        pennant = 0;
        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("meteor", meteor);
        outState.putInt("pennant", pennant);

        TextView counterView = findViewById(R.id.num_1);
        counterView.setText(meteor.toString());
        Toast.makeText(this, "onSaveInstanceState()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("meteor")) {
            meteor = savedInstanceState.getInt("meteor");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("pennant"))) {
            pennant = savedInstanceState.getInt("pennant");
        }
        TextView counterView = findViewById(R.id.num_1);
        counterView.setText(meteor.toString());
        Toast.makeText(this, "onRestoreInstanceState()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onRestoreInstanceState");
    }
    private void resetUI() {
        meteorTextView.setText(meteor.toString());
        pennantTextView.setText(pennant.toString());
        Toast.makeText(this, "resetUI()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "resetUI");
    }

}