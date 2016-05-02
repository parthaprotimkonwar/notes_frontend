package com.notes.db.services.core;

import com.activeandroid.query.Select;
import com.notes.db.models.core.Chapter;
import com.notes.db.models.core.Module;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class ModuleService {

    public static Module findAModule(Long moduleId) {
        return new Select().from(Module.class).where("MODULE_ID = ?", moduleId).executeSingle();
    }
}
