package com.example.DeveloperProjeect.Controller;


import com.example.DeveloperProjeect.Entity.User;
import com.example.DeveloperProjeect.Model.UserUpdateRequestModel;
import com.example.DeveloperProjeect.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<User> get(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/post")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestModel userUpdateRequestModel) {
        return userService.update(id, userUpdateRequestModel);
    }

}
