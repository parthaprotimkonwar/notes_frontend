package com.notes.db.services.core.question_answers;

import com.activeandroid.query.Select;
import com.notes.db.models.core.question_answers.QuestionAnswer;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class QuestionAnswerService {

    public static QuestionAnswer findAQuestionAnswer(Long questionAnswerId) {
        return new Select().from(QuestionAnswer.class).where("QUESTION_ANSWER_ID = ?", questionAnswerId).executeSingle();
    }
}
