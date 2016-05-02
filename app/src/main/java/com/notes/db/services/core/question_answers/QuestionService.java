package com.notes.db.services.core.question_answers;

import com.activeandroid.query.Select;
import com.notes.db.models.core.Author;
import com.notes.db.models.core.question_answers.Question;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class QuestionService {

    public static Question findAQuestion(Long questionId) {
        return new Select().from(Question.class).where("QUESTION_ID = ?", questionId).executeSingle();
    }
}
