package com.example.onlineproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//    private List<Question> questions;
//    private int currentQuestionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        binding.nextBtm.setOnClickListener(v -> {
//            currentQuestionIndex++;
//            showQuestion(currentQuestionIndex);
//        });
    }

//    private void fetchQuestions() {
//        // MAke api call
//        // in onResponse write below login
//        questions = response.body();
//    }
//
//    private void showQuestion(int index) {
//        currentQuestionIndex = index;
//        Question question = questions.get(index);
//        // Set the data in textViews based on api data
//        binding.questionTxt.setText(question.description);
//        binding.option1Rb.setText(question.options.get(0).text);
//        binding.option2Rb.setText(question.options.get(0).text);
//        binding.option3Rb.setText(question.options.get(0).text);
//        binding.option4Rb.setText(question.options.get(0).text);
//    }
}