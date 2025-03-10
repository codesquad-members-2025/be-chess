package org.chess.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

}
