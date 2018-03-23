package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Initializes Answer variables with correct answers. Checkbox is excluded for later checking.
    final int question1Answer = R.id.radio_button_q1a2;
    final int question2Answer = R.id.radio_button_q2a2;
    final String question4Answer = "Michael";
    String contestantName;
    int numberOfCorrectAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //The following method will be called upon pressing the final result button
    public String printResults(View view) {

        //Checks Answers one by one

        numberOfCorrectAnswers = 0;

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

        //Prints the name
        printName(contestantName);
        return (contestantName);
    }

    // Method that checks correctness of question 1 answer
    public boolean checkQuestion1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group_q1);
        return (rg.getCheckedRadioButtonId() == question1Answer);
    }

    // Method that checks correctness of question 2 answer
    public boolean checkQuestion2() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group_q2);
        return (rg.getCheckedRadioButtonId() == question2Answer);
    }

    //Method that checks correctness of question 3 answer
    public boolean checkQuestion3() {
        CheckBox cb1 = findViewById(R.id.checkbox_q3a1);
        CheckBox cb2 = findViewById(R.id.checkbox_q3a2);
        CheckBox cb3 = findViewById(R.id.checkbox_q3a3);
        CheckBox cb4 = findViewById(R.id.checkbox_q3a4);
        return (cb1.isChecked() && !cb2.isChecked() && cb3.isChecked() && cb4.isChecked());
    }

    //Method that checks correctness of question 4 answer
    public boolean checkQuestion4() {
        EditText editText = (EditText) findViewById(R.id.edit_text_q4a);
        String textValue = editText.getText().toString();
        return (textValue.equalsIgnoreCase(question4Answer));
    }

    //    Method that displays contestant name.
    public void printName(String contestantName) {
        TextView displayResults = (TextView) findViewById(R.id.results);
        displayResults.setText(contestantName + ", you've answered " + numberOfCorrectAnswers + " of 4 questions correctly. Bravo!" + "\nHere are the correct answers. \nQ1. Donald Trump\nQ2. Vladimir Putin\nQ3. You shoud probably make your tea without Soy Sauce\nQ4. Okay, next time ask Michael for phone suggestions.");
    }


}