package lk.ijse.weavybackend.controller;

import lk.ijse.weavybackend.service.WeavyClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public String createUser(@RequestParam String uid, @RequestParam String name) throws Exception {
        WeavyClient.createUser(uid, name);
        return "User created";
    }

    @GetMapping
    public String listUsers() throws Exception {
        WeavyClient.listUsers();
        return "Users listed (check console)";
    }

    @GetMapping("/{uid}")
    public String getUser(@PathVariable String uid) throws Exception {
        WeavyClient.getUser(uid);
        return "User retrieved (check console)";
    }

    @PutMapping("/{uid}")
    public String updateUser(@PathVariable String uid, @RequestParam String name) throws Exception {
        WeavyClient.updateUser(uid, name);
        return "User updated";
    }

    @DeleteMapping("/{uid}")
    public String deleteUser(@PathVariable String uid) throws Exception {
        WeavyClient.deleteUser(uid);
        return "User deleted";
    }
}