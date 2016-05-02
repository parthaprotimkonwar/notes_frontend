package com.notes.db.services.core.question_answers;

import com.activeandroid.query.Select;
import com.notes.db.models.core.question_answers.Answer;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class AnswerService {

    public static Answer findAAnswer(Long answerId) {
        return new Select().from(Answer.class).where("ANSWER_ID = ?", answerId).executeSingle();
    }

}
