package com.example.demo.model.loginResponse;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginType {

    private String user_name;
    private String password;
}
