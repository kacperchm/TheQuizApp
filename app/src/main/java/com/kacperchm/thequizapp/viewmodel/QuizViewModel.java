package com.kacperchm.thequizapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kacperchm.thequizapp.QuizRepository;
import com.kacperchm.thequizapp.model.QuestionList;

public class QuizViewModel extends ViewModel {

    QuizRepository repository = new QuizRepository();

    LiveData<QuestionList> questionListLiveData;

    public QuizViewModel() {
        questionListLiveData = repository.getQuestionFromAPI();
    }

    public LiveData<QuestionList> getQuestionListLiveData() {
        return questionListLiveData;
    }
}
