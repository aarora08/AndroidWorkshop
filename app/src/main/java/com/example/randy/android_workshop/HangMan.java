package com.example.randy.android_workshop;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HangMan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hang_man);

        //This is where you will be naming all of your items in the screen.
        //Step 1: create an ImageView object, this is done for you as an example.
        final ImageView imageView = (ImageView)findViewById(R.id.imageView3);

        //Step 2: create a textswitcher object
        final TextSwitcher textSwitcher = (TextSwitcher)findViewById(R.id.text);
        //Step 3: create a Textview object
        final TextView textView  = new TextView(this);
        textView.setText("Your word will show up here");
        //Step 4: create a button
        Button button = (Button)findViewById(R.id.button2);

        //Step 5: create an Edittext
        final EditText editText = (EditText)findViewById(R.id.editText);

        //Step 6: create a textView to keep track of wrong answers
        final TextView textView1= new TextView(this);
        final TextSwitcher textSwitcher1 = (TextSwitcher)findViewById(R.id.text2);





        //Hangman Engine initialization
        final Hangman_Engine hang = new Hangman_Engine();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSwitcher.setCurrentText(hang.getWord());

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSwitcher.setCurrentText(hang.checkTheWord(editText.getText().toString()));
                textSwitcher1.setCurrentText(hang.getTracker());
                editText.setText("");

            }
        });

        textView1.setText(hang.getTracker());

        textSwitcher1.addView(textView1);
        textSwitcher.addView(textView);
        //Step 4: create a button object

        //next you will be adding functionality to the app.
    }
}
