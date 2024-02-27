package com.kacperchm.thequizapp.retrofit;

import com.kacperchm.thequizapp.model.QuestionList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionsAPI {

    @GET("all")
    Call<QuestionList> getQuestions();
}
