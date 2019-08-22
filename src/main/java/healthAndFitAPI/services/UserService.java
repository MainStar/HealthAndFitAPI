package healthAndFitAPI.services;

import healthAndFitAPI.dao.UserDao;
import healthAndFitAPI.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserModel getUser(String email){
        if (checkForScript(email))
            return null;
        return userDao.getUser(email);
    }

    public Integer createUser(UserModel user){
        return userDao.createUser(user);
    }

    public Integer updateUser(UserModel user){
        return userDao.updateUser(user);
    }

    private boolean checkForScript(String input) {
        return input.contains("<") | input.contains(">") | input.contains("script");
    }

}
