package com.notes.db.services.core.question_answers;

import com.activeandroid.query.Select;
import com.notes.db.models.core.question_answers.ModuleQuestionAnswer;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class ModuleQuestionsAnswerService {

    public static ModuleQuestionAnswer findAModuleQuestionsAnswers(Long moduleId, Long questionAnswerId) {
        return new Select().from(ModuleQuestionAnswer.class).where("MODULE_QUESTIONS_ANSWERS.QUESTION_ANSWER = ?", questionAnswerId)
                .and("MODULE_QUESTIONS_ANSWERS.MODULE = ?", moduleId).executeSingle();
    }
}
