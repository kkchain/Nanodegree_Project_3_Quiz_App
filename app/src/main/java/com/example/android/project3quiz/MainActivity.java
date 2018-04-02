package com.example.android.project3quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Initialized
    int totalScore = 0;
    String userName;
    String favoriteFruits;
    String displayResult;
    EditText nameInput;
    EditText fruitInput;
    RadioButton question_1Button;
    RadioButton question_2Button;
    RadioButton question_4Button;
    RadioButton question_5Button;
    RadioButton question_6Button;
    CheckBox indonesia_Checkbox;
    CheckBox malaysia_Checkbox;
    CheckBox thailand_Checkbox;
    CheckBox native_Checkbox;
    CheckBox spikes_Checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide Android EditTExt Keyboard Each Time the app started
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void submitAnswers(View view) {
        // get user name
        nameInput = (findViewById(R.id.enter_name));
        // assign String to nameInput
        userName = nameInput.getText().toString();

        // get RadioButton ID from Question 1
        question_1Button = findViewById(R.id.q1_durian);
        // call method to add 1 point if Question 1 answered correctly
        calculateRadioButtonScores(question_1Button.isChecked());

        // get RadioButton ID from Question 2
        question_2Button = findViewById(R.id.q2_true);
        // call method to add 1 point if Question 2 answered correctly
        calculateRadioButtonScores(question_2Button.isChecked());

        // get CheckBox ID from Question 3
        indonesia_Checkbox = findViewById(R.id.q3_indonesia);
        malaysia_Checkbox = findViewById(R.id.q3_malaysia);
        thailand_Checkbox = findViewById(R.id.q3_thailand);

        // get CheckBox ID from Question 8
        native_Checkbox = findViewById(R.id.q8_native);
        spikes_Checkbox = findViewById(R.id.q8_spikes);
        // call method to add 1 point if Question 3 and 8 answered correctly
        calculateCheckBoxScores(indonesia_Checkbox.isChecked(), malaysia_Checkbox.isChecked(), thailand_Checkbox.isChecked(), native_Checkbox.isChecked(), spikes_Checkbox.isChecked());

        // get RadioButton ID from Question 4
        question_4Button = findViewById(R.id.q4_jackfruit);
        // call method to add 1 point if Question 4 answered correctly
        calculateRadioButtonScores(question_4Button.isChecked());

        // get RadioButton ID from Question 5
        question_5Button = findViewById(R.id.q5_artocarpus);
        // call method to add 1 point if Question 4 answered correctly
        calculateRadioButtonScores(question_5Button.isChecked());

        // get RadioButton ID from Question 6
        question_6Button = findViewById(R.id.q6_mangosteen);
        // call method to add 1 point if Question 6 answered correctly
        calculateRadioButtonScores(question_6Button.isChecked());

        // Question 7 get participant favorite fruits
        fruitInput = (findViewById(R.id.enter_fruits));
        // assign String to nameInput
        favoriteFruits = fruitInput.getText().toString();

        // toast
        displayResult = userName + "\nYou Scored " + totalScore + " out of 10" + "\n You liked " + favoriteFruits;
        Toast.makeText(this, displayResult, Toast.LENGTH_LONG).show();
    }

    /**
     * this method add point for question 1 and 2
     *
     * @param isChecked boolean, did the user check the correct answer
     * @return totalScore
     */
    private int calculateRadioButtonScores(boolean isChecked) {
        if (isChecked == true) {
            totalScore = totalScore + 1;
        }
        return totalScore;
    }

    /**
     * this method add point for question 3
     *
     * @param indonesia boolean, did the user check this box
     * @param malaysia  boolean, did the user check this box
     * @param thailand  boolean, did the user check this box
     * @return integer of sum of total score
     */
    private int calculateCheckBoxScores(boolean indonesia, boolean malaysia, boolean thailand, boolean natives, boolean spikes) {
        if (indonesia == true) {
            totalScore = totalScore + 1;
        }
        if (malaysia == true) {
            totalScore = totalScore + 1;
        }
        if (thailand == true) {
            totalScore = totalScore + 1;
        }
        if (natives == true) {
            totalScore = totalScore + 1;
        }
        if (spikes == true) {
            totalScore = totalScore + 1;
        }

        return totalScore;
    }

    // reset the quiz when RESET button is clicked, set the totalScore to 0
    public void resetButton(View view) {
        totalScore = 0;
        setContentView(R.layout.activity_main);
    }

}