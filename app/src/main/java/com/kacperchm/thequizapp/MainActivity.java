package com.kacperchm.thequizapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.kacperchm.thequizapp.databinding.ActivityMainBinding;
import com.kacperchm.thequizapp.model.Question;
import com.kacperchm.thequizapp.model.QuestionList;
import com.kacperchm.thequizapp.viewmodel.QuizViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    QuizViewModel quizViewModel;
    List<Question> questionList;

    static int result = 0;
    static int totalQuestions = 0;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        result = 0;
        totalQuestions = 0;

        quizViewModel = new ViewModelProvider(this).get(QuizViewModel.class);

        displayFirstQuestion();
    }

    public void displayFirstQuestion() {
        quizViewModel.getQuestionListLiveData().observe(this, new Observer<QuestionList>() {
            @Override
            public void onChanged(QuestionList questions) {
                questionList = questions;

                binding.txtQuestion.setText("Question 1: " + questions.get(0).getQuestion());
                binding.radio1.setText(questions.get(0).getOption1());
                binding.radio2.setText(questions.get(0).getOption2());
                binding.radio3.setText(questions.get(0).getOption3());
                binding.radio4.setText(questions.get(0).getOption4());
            }
        });
    }
}