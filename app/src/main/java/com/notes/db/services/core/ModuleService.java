package com.notes.db.services.core;

import com.activeandroid.query.Select;
import com.notes.db.models.core.Module;

import java.util.List;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class ModuleService {

    public static Module findAModule(Long moduleId) {
        return new Select().from(Module.class).where("MODULE_ID = ?", moduleId).executeSingle();
    }

    /**
     * Find modules
     * @param chapter
     * @return
     */
    public static List<Module> modules(Long chapter) {
        return new Select().from(Module.class).where("CHAPTER = ?", chapter).execute();
    }
}
