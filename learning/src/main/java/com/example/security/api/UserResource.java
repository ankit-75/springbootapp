package com.example.security.api;

//https://www.youtube.com/watch?v=VVn9OG9nfH0&list=PLwvrYc43l1MzeA2bBYQhCWr2gvWLs9A7S&index=9

import com.example.security.model.Role;
import com.example.security.model.User;
import com.example.security.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping(value = "/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping(value = "/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping(value = "/role/addtouser")
    public ResponseEntity<Role> addRoleToUser(@RequestBody RoleToUser roleToUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/addtouser").toUriString());
        userService.addRoleToUser(roleToUser.getUsername(), roleToUser.getRoleName());
        return ResponseEntity.ok().build();
    }

    @Data
    class RoleToUser{
        private String username;
        private String roleName;
    }
}
