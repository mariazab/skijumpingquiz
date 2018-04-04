package com.example.android.skijumpingquiz;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    double score = 0;

   /*
   * This method checks the answers and counts the points
   * */
    private void checkQuiz() {

        /*
        * Question 1 correct answers
        * */
        CheckBox q1_a1 = (CheckBox) findViewById(R.id.q1_a1);
        CheckBox q1_a3 = (CheckBox) findViewById(R.id.q1_a3);

         /*
        * Question 1 wrong answers
        * */
        CheckBox q1_a2 = (CheckBox) findViewById(R.id.q1_a2);
        CheckBox q1_a4 = (CheckBox) findViewById(R.id.q1_a4);
        CheckBox q1_a5 = (CheckBox) findViewById(R.id.q1_a5);

        /*
        * Question 2 correct answers
        * */
        RadioButton q2_a3 = (RadioButton) findViewById(R.id.q2_a3);

        /*
        Question 3 correct answers
        */
        CheckBox q3_a1 = (CheckBox) findViewById(R.id.q3_a1);
        CheckBox q3_a3 = (CheckBox) findViewById(R.id.q3_a3);
        CheckBox q3_a5 = (CheckBox) findViewById(R.id.q3_a5);
        CheckBox q3_a7 = (CheckBox) findViewById(R.id.q3_a7);

         /*
        * Question 3 wrong answers
        * */
        CheckBox q3_a2 = (CheckBox) findViewById(R.id.q3_a2);
        CheckBox q3_a4 = (CheckBox) findViewById(R.id.q3_a4);
        CheckBox q3_a6 = (CheckBox) findViewById(R.id.q3_a6);


        /*
        Question 4 answers
        */
        EditText q4_a1 = (EditText) findViewById(R.id.wc_winner);
        String wcWinner = q4_a1.getText().toString().trim();
        EditText q4_a2 = (EditText) findViewById(R.id.wc_points);
        String wcPoints = q4_a2.getText().toString().trim();

        /*
        Question 5 correct answers
        */
        CheckBox q5_a3 = (CheckBox) findViewById(R.id.q5_a3);
        CheckBox q5_a5 = (CheckBox) findViewById(R.id.q5_a5);

        /*
        * Question 5 wrong answers
        * */
        CheckBox q5_a1 = (CheckBox) findViewById(R.id.q5_a1);
        CheckBox q5_a2 = (CheckBox) findViewById(R.id.q5_a2);
        CheckBox q5_a4 = (CheckBox) findViewById(R.id.q5_a4);
        CheckBox q5_a6 = (CheckBox) findViewById(R.id.q5_a6);
        CheckBox q5_a7 = (CheckBox) findViewById(R.id.q5_a7);

        /*
        Question 6 correct answer
        */
        RadioButton q6_a1 = (RadioButton) findViewById(R.id.q6_a1);


        /*
        Checking if the correct answers have been chosen and adding points
        */

//        Question 1
        if(q1_a1.isChecked() && q1_a3.isChecked() && !(q1_a2.isChecked() && q1_a4.isChecked() && q1_a5.isChecked())) {
            score += 2;
        }
        else if(q1_a1.isChecked() || q1_a3.isChecked() && !(q1_a2.isChecked() && q1_a4.isChecked() && q1_a5.isChecked())) {
            score += 1;
        }

//        Question 2
        if (q2_a3.isChecked()) {
            score += 2;
        }

//        Question 3
        if (q3_a1.isChecked() && !(q3_a2.isChecked() && q3_a4.isChecked() && q3_a6.isChecked())) {
            score += 0.5;
        }

        if (q3_a3.isChecked() && !(q3_a2.isChecked() && q3_a4.isChecked() && q3_a6.isChecked())) {
            score += 0.5;
        }

        if (q3_a5.isChecked() && !(q3_a2.isChecked() && q3_a4.isChecked() && q3_a6.isChecked())) {
            score += 0.5;
        }

        if (q3_a7.isChecked() && !(q3_a2.isChecked() && q3_a4.isChecked() && q3_a6.isChecked())) {
            score += 0.5;
        }

//        Question 4
        if(wcWinner.toLowerCase().equals("severin freund") || wcWinner.toLowerCase().equals("freund")) {
            score += 1;
        }

        if(wcPoints.equals("1729")) {
            score += 1;
        }

//        Question 5
        if(q5_a3.isChecked() && q5_a5.isChecked() && !(q5_a1.isChecked() && q5_a2.isChecked() && q5_a4.isChecked() && q5_a6.isChecked() && q5_a7.isChecked())) {
            score += 2;
        }
        else if(q5_a3.isChecked() || q5_a5.isChecked() && !(q5_a1.isChecked() && q5_a2.isChecked() && q5_a4.isChecked() && q5_a6.isChecked() && q5_a7.isChecked())) {
            score += 1;
        }

//        Question 6
        if(q6_a1.isChecked()) {
            score += 2;
        }

    }

    /*
    * This method creates Toast for an awesome score
    * @return toast
    * */
    private Toast awesomeToast() {

        Context context = getApplicationContext();
        CharSequence text = getText(R.string.toast_awesome);
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);

        toast.setGravity(Gravity.CENTER, 0, 0);

        return toast;
    }

    /*
    * This method creates Toast for a great score
    * @return toast
    * */
    private Toast greatToast() {
        Context context = getApplicationContext();
        String text = getText(R.string.toast_beginning).toString() + " " + score + " " + getText(R.string.toast_great_end).toString();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);

        toast.setGravity(Gravity.CENTER, 0, 0);

        return toast;
    }

    /*
    * This method creates Toast for a bad score
    * @return toast
    * */
    private Toast loserToast() {
        Context context = getApplicationContext();
        String text = getText(R.string.toast_beginning).toString() + " " + score + " " + getText(R.string.toast_loser_end).toString();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);

        toast.setGravity(Gravity.CENTER, 0, 0);

        return toast;
    }


    /*
    * This method displays a Toast with the score and a message depending on the score
    * Resets the score and clears the answers.
    * */
    public void finishQuiz(View view) {

        Toast toast;
        checkQuiz();

        if (score == 12) {
            toast = awesomeToast();
        } else if (score < 12 && score > 4) {
            toast = greatToast();
        }
        else {
            if (score < 0) {
                score = 0;
            }
            toast = loserToast();
        }

        toast.show();

        score = 0;
        clearAll();

    }

    /*
    * This method clears checked CheckBoxes
    * */
    private void uncheck(CheckBox checkBox){
        if (checkBox.isChecked()) {
            checkBox.toggle();
        }
    }

    /*
    * This method clears RadioGroup*/

    private void clearRadioGroup(RadioGroup group) {
        group.clearCheck();
    }

    /*
    * This method clears all the RadioButtons and CheckBoxes
    * */
    private void clearAll() {

        CheckBox q1_a1 = (CheckBox) findViewById(R.id.q1_a1);
        CheckBox q1_a2 = (CheckBox) findViewById(R.id.q1_a2);
        CheckBox q1_a3 = (CheckBox) findViewById(R.id.q1_a3);
        CheckBox q1_a4 = (CheckBox) findViewById(R.id.q1_a4);
        CheckBox q1_a5 = (CheckBox) findViewById(R.id.q1_a5);

        RadioGroup q2 = (RadioGroup) findViewById(R.id.q2_radiogroup);

        CheckBox q3_a1 = (CheckBox) findViewById(R.id.q3_a1);
        CheckBox q3_a2 = (CheckBox) findViewById(R.id.q3_a2);
        CheckBox q3_a3 = (CheckBox) findViewById(R.id.q3_a3);
        CheckBox q3_a4 = (CheckBox) findViewById(R.id.q3_a4);
        CheckBox q3_a5 = (CheckBox) findViewById(R.id.q3_a5);
        CheckBox q3_a6 = (CheckBox) findViewById(R.id.q3_a6);
        CheckBox q3_a7 = (CheckBox) findViewById(R.id.q3_a7);

        EditText q4_a1 = (EditText) findViewById(R.id.wc_winner);
        EditText q4_a2 = (EditText) findViewById(R.id.wc_points);

        CheckBox q5_a1 = (CheckBox) findViewById(R.id.q5_a1);
        CheckBox q5_a2 = (CheckBox) findViewById(R.id.q5_a2);
        CheckBox q5_a3 = (CheckBox) findViewById(R.id.q5_a3);
        CheckBox q5_a4 = (CheckBox) findViewById(R.id.q5_a4);
        CheckBox q5_a5 = (CheckBox) findViewById(R.id.q5_a5);
        CheckBox q5_a6 = (CheckBox) findViewById(R.id.q5_a6);
        CheckBox q5_a7 = (CheckBox) findViewById(R.id.q5_a7);

        RadioGroup q6 = (RadioGroup) findViewById(R.id.q6_radiogroup);


        uncheck(q1_a1);
        uncheck(q1_a2);
        uncheck(q1_a3);
        uncheck(q1_a4);
        uncheck(q1_a5);

        clearRadioGroup(q2);

        uncheck(q3_a1);
        uncheck(q3_a2);
        uncheck(q3_a3);
        uncheck(q3_a4);
        uncheck(q3_a5);
        uncheck(q3_a6);
        uncheck(q3_a7);

        q4_a1.getText().clear();
        q4_a2.getText().clear();

        uncheck(q5_a1);
        uncheck(q5_a2);
        uncheck(q5_a3);
        uncheck(q5_a4);
        uncheck(q5_a5);
        uncheck(q5_a6);
        uncheck(q5_a7);

        clearRadioGroup(q6);
    }

}
