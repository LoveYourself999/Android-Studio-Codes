package com.example.capsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private Game game;
    private String question;
    private String answer;
    private int score = 0;
    private int qNum = 0;
    String result = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ask();
    }


    public void ask(){
        qNum++;
        Game game = new Game();
        question = game.qa();
        answer = question.substring(question.indexOf("\n")+1,question.length());
        ((TextView) findViewById(R.id.question)).setText(question);
    }


    public void onDone(View v){

        String a =((EditText) findViewById(R.id.answer)).getText().toString();
        result += "Q# " + qNum + ": " + question.substring(0,question.indexOf("\n")) +
                "\n" + "Your answer: " + a.toUpperCase() + "\n"+"Correct answer: " + answer + "\n\n";
        ((TextView) findViewById(R.id.log)).setText(result);

        if (answer.toUpperCase().equals(a.toUpperCase())) {
            score+=1;
            String s = "SCORE " + score;
            ((TextView) findViewById(R.id.score)).setText(s);
        }

        ask();
        String q = "      Q# " + qNum;
        ((TextView) findViewById(R.id.qnum)).setText(q);

        if (qNum>9){
            ((TextView) findViewById(R.id.qnum)).setText("Game Over!");
            Button button = findViewById(R.id.button);
            button.setEnabled(false);
        }

    }

}