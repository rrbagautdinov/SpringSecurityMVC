package ru.geekbrains.security.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.security.demo.entity.User;
import ru.geekbrains.security.demo.service.UserService;

import java.security.Principal;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/login")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/score")
    public String getCurrentScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "Your score: " + user.getScore();
    }

    @GetMapping("/score/inc")
    public String incrementScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        user.setScore(user.getScore() + 1);
        userService.update(user);
        return "Your score: " + user.getScore();
    }

    @GetMapping("/score/dec")
    public String decrementScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        user.setScore(user.getScore() - 1);
        userService.update(user);
        return "Your score: " + user.getScore();
    }

    @GetMapping("/score/info/{id}")
    public StringBuilder getScoreInfoByUserId(@PathVariable(required = true) Long id) {
        User user = userService.findById(id);
        StringBuilder sb = new StringBuilder();
        sb.append("User with id: ")
                .append(user.getId())
                .append(" | ")
                .append("User with name: ")
                .append(user.getUsername())
                .append(" | ")
                .append("User has score: ")
                .append(user.getScore());
        return sb;
    }
}
