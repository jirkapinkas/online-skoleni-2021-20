package com.example.hellospring;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RootController {

//    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    // http://localhost:8080/
    @GetMapping("/")
    public Message message(@RequestHeader(name = "User-Agent", required = false)
                                       String userAgent) {
        log.info("Requested message");
        log.info(userAgent);
//        return new Message("Spring Boot Rocks", 200);
        return Message.builder()
                .message("Spring Boot Rocks")
                .code(200)
                .build();
    }

}
