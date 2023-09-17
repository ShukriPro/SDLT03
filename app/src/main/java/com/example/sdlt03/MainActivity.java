package com.example.sdlt03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    boolean colorChanged = false;
    TextView textViewGameTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewGameTitle = findViewById(R.id.gameTitleText);

        textViewGameTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Number Game Rules");
                builder.setMessage("User needs to click on the Button with a bigger number to gain 5 points. " +
                        "If the user has clicked on the wrong button, then he will lose 5 points.");

                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.create().show();
                return false;
            }
        });
    }


    public void buttonStartGame(View view) {
        EditText editTextNameInput = findViewById(R.id.editTextNameInput);
        String playerName = editTextNameInput.getText().toString().trim();
        if (playerName.isEmpty()) {
            // Show a toast message if the player name is not entered
            Toast.makeText(this, "Please enter player name", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("playerName", playerName);
            startActivity(intent);
        }
    }






    public void buttonWelcomeMessageClicked(View view) {
        Snackbar.make(view, "Welcome to Number Game!",
                        Snackbar.LENGTH_LONG)
                .setAction("ACTION", null).show();
    }


}