package com.notes.db.services.core.question_answers;

import com.activeandroid.query.Select;
import com.notes.db.models.core.question_answers.QuestionOptions;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class QuestionOptionsService {

    public static QuestionOptions findAQuestionOptions(Long questionOptionsId) {
        return new Select().from(QuestionOptions.class).where("QUESTION_OPTIONS_ID = ?", questionOptionsId).executeSingle();
    }
}
