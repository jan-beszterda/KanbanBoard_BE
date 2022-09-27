package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Card;
import com.grupp3.ooad_projekt_backend.models.User;
import com.grupp3.ooad_projekt_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
     * Returns user information if username and password is correct.
     * @param maybeUser     A userName and a passWord
     * @return      The user if it is found, null otherwise
     */
    @PostMapping("/login")
    public User getUserByLogin(@RequestBody User maybeUser) {
        return userService.getLoginUser(maybeUser);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
