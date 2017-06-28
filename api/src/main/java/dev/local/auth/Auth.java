package dev.local.auth;

import dev.local.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Auth {
    private String token;
    private User user;
}
