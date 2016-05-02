package com.notes.rest.service.callbacks;

import android.util.Log;

import com.notes.db.models.core.Module;
import com.notes.db.models.core.question_answers.Answer;
import com.notes.db.models.core.question_answers.ModuleQuestionAnswer;
import com.notes.db.models.core.question_answers.Question;
import com.notes.db.models.core.question_answers.QuestionAnswer;
import com.notes.db.models.core.question_answers.QuestionOptions;
import com.notes.db.services.core.ModuleService;
import com.notes.db.services.core.question_answers.AnswerService;
import com.notes.db.services.core.question_answers.ModuleQuestionsAnswerService;
import com.notes.db.services.core.question_answers.QuestionAnswerService;
import com.notes.db.services.core.question_answers.QuestionOptionsService;
import com.notes.db.services.core.question_answers.QuestionService;
import com.notes.rest.bean.core.question_answers.AnswerBean;
import com.notes.rest.bean.core.question_answers.ModuleQuestionsAnswersBean;
import com.notes.rest.bean.core.question_answers.QuestionAnswerBean;
import com.notes.rest.bean.core.question_answers.QuestionBean;
import com.notes.rest.bean.core.question_answers.QuestionOptionsBean;
import com.notes.rest.service.dto.QuestionAnswerDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class QuestionAnswerCallback implements Callback<QuestionAnswerDto> {
    @Override
    public void onResponse(Call<QuestionAnswerDto> call, Response<QuestionAnswerDto> response) {
        QuestionAnswerDto questionAnswerDto = response.body();
        Log.d("NOTES", "onResponse: " + questionAnswerDto.questions);

        List<QuestionBean> questionsBeanList = questionAnswerDto.questions;
        for(QuestionBean questionBean : questionsBeanList) {
            Question question = QuestionService.findAQuestion(questionBean.getQuestionId());
            if(question == null) {
                question = new Question(questionBean.getQuestionId(), questionBean.getQuestion());
                question.save();
                System.out.println("Question saved" + question.getQuestionId());
            } else {
                System.out.println("Question with id " + question.getQuestionId() + " already present");
            }
        }

        List<AnswerBean> answersBeanList = questionAnswerDto.answers;
        for(AnswerBean answerBean : answersBeanList) {
            Answer answer = AnswerService.findAAnswer(answerBean.getAnswerId());
            if(answer == null) {
                answer = new Answer(answerBean.getAnswerId(), answerBean.getAnswer());
                answer.save();
                System.out.println("Asnwer with id : " + answer.getAnswerId() + " saved");
            } else {
                System.out.println("Answer with id : " + answer.getAnswerId() + " already present");
            }
        }


        List<QuestionAnswerBean> questionAnswerBeanList = questionAnswerDto.questionAnswer;
        for(QuestionAnswerBean questionAnswerBean  : questionAnswerBeanList) {
            QuestionAnswer questionAnswer = QuestionAnswerService.findAQuestionAnswer(questionAnswerBean.getQuestionAnswerId());
            if(questionAnswer == null) {
                Question question = QuestionService.findAQuestion(questionAnswerBean.getQuestionId());
                Answer answer = AnswerService.findAAnswer(questionAnswerBean.getAnswerId());
                questionAnswer = new QuestionAnswer(questionAnswerBean.getQuestionAnswerId(), question, answer, questionAnswerBean.getType());
                questionAnswer.save();
                System.out.println("About to save questionAnwer");
            } else {
                System.out.println("QuestionAnswer " + questionAnswer.getQuestion().getQuestionId() + "present");
            }
        }


        List<QuestionOptionsBean> questionOptionsBeanList = questionAnswerDto.questionOptions;
        for(QuestionOptionsBean questionOptionsBean : questionOptionsBeanList) {
            QuestionOptions questionOptions = QuestionOptionsService.findAQuestionOptions(questionOptionsBean.getQuestionOptionsId());
            if(questionOptions == null) {
                Question question = QuestionService.findAQuestion(questionOptionsBean.getQuestionId());
                questionOptions = new QuestionOptions(question, questionOptionsBean.getOption1(), questionOptionsBean.getOption2(), questionOptionsBean.getOption3(), questionOptionsBean.getOption4(), questionOptionsBean.getAdditionalOptions());
                questionOptions.save();
                System.out.println("Saved Question Options");
            }
        }


        List<ModuleQuestionsAnswersBean> moduleQuestionsAnswersBeanList = questionAnswerDto.moduleQuestionAnswer;
        for(ModuleQuestionsAnswersBean moduleQuestionsAnswersBean : moduleQuestionsAnswersBeanList) {

            Module module = ModuleService.findAModule(moduleQuestionsAnswersBean.getModuleId());
            QuestionAnswer questionAnswer = QuestionAnswerService.findAQuestionAnswer(moduleQuestionsAnswersBean.getQuestionsAnswerId());
            ModuleQuestionAnswer moduleQuestionAnswer = ModuleQuestionsAnswerService.findAModuleQuestionsAnswers(module.getId(), questionAnswer.getId());

            if(moduleQuestionAnswer == null && module != null && questionAnswer!= null) {
                moduleQuestionAnswer = new ModuleQuestionAnswer(questionAnswer, module, moduleQuestionsAnswersBean.getIndexing());
                moduleQuestionAnswer.save();
                System.out.println("Saved ModuleQuestionAnswers");
            } else {
                System.out.println("ModuleQuestionAnswers found." + moduleQuestionAnswer.getQuestionAnswer().getQuestionAnswerId());
            }
        }

    }

    @Override
    public void onFailure(Call<QuestionAnswerDto> call, Throwable t) {
        Log.d("NOTES", "MAY DAY in QuestionAnswer!" + t.getMessage() + t.fillInStackTrace());
    }
}
