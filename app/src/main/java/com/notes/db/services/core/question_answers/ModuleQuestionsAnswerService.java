package com.notes.db.services.core.question_answers;

import com.activeandroid.query.Select;
import com.notes.db.models.core.question_answers.ModuleQuestionAnswer;

import java.util.List;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class ModuleQuestionsAnswerService {

    /**
     * Send the Internal Id of Module and QuestionAnswer to get ModuleQuestionAnswers
     * @param module
     * @param questionAnswer
     * @return
     */
    public static ModuleQuestionAnswer findAModuleQuestionsAnswers(Long module, Long questionAnswer) {
        return new Select().from(ModuleQuestionAnswer.class).where("MODULE_QUESTIONS_ANSWERS.QUESTION_ANSWER = ?", questionAnswer)
                .and("MODULE_QUESTIONS_ANSWERS.MODULE = ?", module).executeSingle();
    }

    public static List<ModuleQuestionAnswer> findModuleQuestionsAnswers(Long module) {
        return new Select().from(ModuleQuestionAnswer.class).and("MODULE_QUESTIONS_ANSWERS.MODULE = ?", module).execute();
    }

}
