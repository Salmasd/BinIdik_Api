package ma.ensate.binidik.controller;

import ma.ensate.binidik.model.User;
import ma.ensate.binidik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userservice;
    @GetMapping("/{id}")
    Optional<User> one(@PathVariable int id) {

        return userservice.findById(id);
    }

    @GetMapping("allUsers")
    public List<User> get() { return userservice.getAllUsers(); }

    @DeleteMapping("deleteUser/{id}")
    public void delete(@PathVariable Integer id){
        userservice.RemoveUser(id);
    }

    @GetMapping("/count")
    public long countUser() {
        long count = userservice.getCountOfUsers();
        return count;
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userservice.addUser(user);
    }

    @GetMapping("/getuser/{email}")
    Optional<User> one(@PathVariable String email) {

        return userservice.findByEmail(email);
    }

}
