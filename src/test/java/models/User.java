package models;

import lombok.Data;
import lombok.Getter;

@Data
public class User {

    // private String firstName field + add properties ?????
    // private String lastName field + add properties ?????
    private final String email;
    private final String password;
}
