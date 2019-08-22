package healthAndFitAPI.restconteollers;

import healthAndFitAPI.models.UserModel;
import healthAndFitAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserConteoller {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{email}")
    public UserModel getUser(@PathVariable String email){
        return userService.getUser(email);
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT, produces = "application/json")
    public Integer createUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }

    @PostMapping(value = "/update")
    public Integer updateUser(@RequestBody UserModel user){
        return userService.updateUser(user);
    }

}
