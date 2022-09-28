package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Team;
import com.grupp3.ooad_projekt_backend.models.User;
import com.grupp3.ooad_projekt_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Returns the user information by id
     * @param id    userId of the user to get information on
     * @return user or null     user object or null if the user cannot be found
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()){
            return null;
        }
        return user.get();
    }

    /**
     * Returns a list of users information by name
     * @param userName    Name of the users to get information on
     * @return user or null     user object or null if the user cannot be found
     */
    @GetMapping("/searchName/{name}")
    public List<User> getUsersByName(@PathVariable("name") String userName) {
        return userService.getUsersByName(userName);
    }

    /**
     * Returns a list of users information by email
     * @param userEmail    Name of the users to get information on
     * @return user or null     user object or null if the user cannot be found
     */
    @GetMapping("/searchName/{email}")
    public List<User> getUsersByEmail(@PathVariable("email") String userEmail) {
        return userService.getUsersByEmail(userEmail);
    }


    /**
     * Returns user information if username and password is correct.
     * @param maybeUser     A userName and a passWord
     * @return      The user if it is found, null otherwise
     */
    @PostMapping("/login")
    public User getUserByLogin(@RequestBody User maybeUser) {
        return userService.getLoginUser(maybeUser);
    }

    @GetMapping("/accept/{user_id}/{team_id}")
    public Team acceptInvite(@PathVariable("user_id") Long userId, @PathVariable("team_id") Long teamId){
        return userService.acceptInvite(userId, teamId);
    }


}
