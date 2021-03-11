package com.yummyyum.Model.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

    @NotNull
    private String password;

    @NotNull
    private String email;

    public UserDTO() {
    }

    public UserDTO(String password, String email) {
        this.password = password;
        this.email = email;
    }

}
