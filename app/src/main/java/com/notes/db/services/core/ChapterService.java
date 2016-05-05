package com.notes.db.services.core;

import com.activeandroid.query.Select;
import com.notes.app.enums.QA_TYPE;
import com.notes.db.models.core.Chapter;
import com.notes.db.models.core.Module;
import com.notes.db.models.core.question_answers.Answer;
import com.notes.db.models.core.question_answers.ModuleQuestionAnswer;
import com.notes.db.models.core.question_answers.Question;
import com.notes.db.models.ui.QuestionAnswersModal;
import com.notes.db.services.core.question_answers.ModuleQuestionsAnswerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class ChapterService {

    /**
     * Find a Chapter from the Database
     * @param chapterId
     * @return
     */
    public static Chapter findAChapter(Long chapterId) {
        return new Select().from(Chapter.class).where("CHAPTER_ID = ?", chapterId).executeSingle();
    }

    /**
     * Find chapters for a Subject
     * @param subject
     * @return
     */
    public static List<Chapter> chapters(Long subject) {
        return new Select().from(Chapter.class).where("SUBJECT = ?", subject).execute();
    }


    /**
     * Find QuestionAnswerForSubject
     * @param
     * @return
     */
    public static List<QuestionAnswersModal> findQuestionAnswerForChapter(Long chapterId) {
        Chapter chapter = findAChapter(chapterId);
        List<QuestionAnswersModal> questionAnswerModalList = new ArrayList<>();
        List<Module> modules = ModuleService.modules(chapter.getId());

        for(Module module : modules) {
            List<ModuleQuestionAnswer> moduleQuestionAnswerList = ModuleQuestionsAnswerService.findModuleQuestionsAnswers(module.getId());
            for(ModuleQuestionAnswer moduleQuestionAnswer : moduleQuestionAnswerList) {
                Question question = moduleQuestionAnswer.getQuestionAnswer().getQuestion();
                Answer answer = moduleQuestionAnswer.getQuestionAnswer().getAnswer();
                QA_TYPE type = moduleQuestionAnswer.getQuestionAnswer().getType();
                QuestionAnswersModal questionAnswersModal = new QuestionAnswersModal(moduleQuestionAnswer.getQuestionAnswer().getQuestionAnswerId(),
                        question.getQuestion(), answer.getAnswer(), type, null);
                questionAnswerModalList.add(questionAnswersModal);
            }
        }
        return questionAnswerModalList;
    }
}
