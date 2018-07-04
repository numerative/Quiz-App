package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Initializes Answer variables with correct answers. Checkbox is excluded for later checking.
    final int question1Answer = R.id.radio_button_q1a2;
    final int question2Answer = R.id.radio_button_q2a2;
    CheckBox q3CheckBox1, q3CheckBox2, q3CheckBox3, q3CheckBox4;
    String question4Answer;
    String contestantName;
    int numberOfCorrectAnswers = 0;
    RadioGroup radioGroup1, radioGroup2;
    EditText q4EditText;
    TextView displayResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializing expensive tasks
        q3CheckBox1 = findViewById(R.id.checkbox_q3a1);
        q3CheckBox2 = findViewById(R.id.checkbox_q3a2);
        q3CheckBox3 = findViewById(R.id.checkbox_q3a3);
        q3CheckBox4 = findViewById(R.id.checkbox_q3a4);
        radioGroup1 = findViewById(R.id.radio_group_q1);
        radioGroup2 = findViewById(R.id.radio_group_q2);
        q4EditText = findViewById(R.id.edit_text_q4a);
        displayResults = findViewById(R.id.results); //Answers

        question4Answer = getResources().getString(R.string.star);
    }

    //Method called upon pressing Result button
    public String printResults(View view) {

        //Checks Answers one by one
        numberOfCorrectAnswers = 0;

        displayResults.setText(null); //Reset display result TextView

        //Adding value by 1 if correct answer to question 1 is selected.
        if (checkQuestion1()) {
            numberOfCorrectAnswers++;
        }

        //Adding value by 1 if correct answer to question 2 is selected.
        if (checkQuestion2()) {
            numberOfCorrectAnswers++;
        }

        //Adding value by 1 if correct answer to question 3 is selected.
        if (checkQuestion3()) {
            numberOfCorrectAnswers++;
        }

        //Adding value by 1 if correct answer to question 4 is selected.
        if (checkQuestion4()) {
            numberOfCorrectAnswers++;
        }

        //gets the text Entered in the EditText field
        final EditText nameBox = (EditText) findViewById(R.id.contestant_name);
        contestantName = nameBox.getText().toString();

        if (checkUnattemptedAnswers()) {
            //Prints the name
            displayResult(contestantName);
            return (contestantName);
        } else {
            Toast.makeText(this, R.string.answer_it, Toast.LENGTH_SHORT).show();
            return contestantName;
        }
    }

    public boolean checkQuestion1() {
        return (radioGroup1.getCheckedRadioButtonId() == question1Answer);
    }

    public boolean checkQuestion2() {
        return (radioGroup2.getCheckedRadioButtonId() == question2Answer);
    }

    public boolean checkQuestion3() {
        return (q3CheckBox1.isChecked() &&
                !q3CheckBox2.isChecked() &&
                q3CheckBox3.isChecked() &&
                q3CheckBox4.isChecked());
    }

    public boolean checkQuestion4() {
        String q4Answer = q4EditText.getText().toString().trim();
        return (q4Answer.equalsIgnoreCase(question4Answer));
    }

    public void displayResult(String contestantName) {
        displayResults.setText(getResources().
                getString(R.string.answers, contestantName, numberOfCorrectAnswers));
    }

    public boolean checkUnattemptedAnswers() {
        if (radioGroup1.getCheckedRadioButtonId() == -1 ||
                radioGroup2.getCheckedRadioButtonId() == -1 ||
                (!q3CheckBox1.isChecked() &&
                        !q3CheckBox2.isChecked() &&
                        !q3CheckBox3.isChecked() &&
                        !q3CheckBox4.isChecked()) ||
                q4EditText.getText().length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}