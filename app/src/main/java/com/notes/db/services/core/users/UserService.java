package com.notes.db.services.core.users;

import com.activeandroid.query.Select;
import com.notes.app.enums.STATUS;
import com.notes.db.models.users.User;

/**
 * Created by pkonwar on 5/29/2016.
 */
public class UserService {

    public static User currentUser(long userId){
        return new Select().from(User.class).where("USER_ID = ?", userId).executeSingle();
    }

    public static User findCurrentUser(){
        User user = currentUser(100L);
        if(user == null) {
            user = new User(100L, "partha", "partha@gmail.com", "123123", "password", "12312asdasd", STATUS.ACTIVE);
            user.save();
        }
        return user;
    }

}
