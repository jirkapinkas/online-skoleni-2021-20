package com.example.hellospring;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    private String message;

    private int code;

}
