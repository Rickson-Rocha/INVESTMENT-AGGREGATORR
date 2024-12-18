package big.investiment.investimentagregator.controllers;

import big.investiment.investimentagregator.dto.UpdateUserDto;
import big.investiment.investimentagregator.dto.UserCreateDto;
import big.investiment.investimentagregator.models.User;
import big.investiment.investimentagregator.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateDto userCreateDto) {
       var userId =  userService.createUser(userCreateDto);
        return ResponseEntity.created(URI.create("v1/users/" + userId.toString())).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
       var user = userService.getUserById(id);
       if(user.isPresent()){
           return ResponseEntity.ok(user.get());
       }else{
           return ResponseEntity.notFound().build();
       }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        var allUsers = userService.listAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") String userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity<Void> updateUserById(@PathVariable("id")String id, @RequestBody UpdateUserDto updateUserDto) {
        userService.updateUserId(id,updateUserDto);
        return ResponseEntity.noContent().build();

    }




}
