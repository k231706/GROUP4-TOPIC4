package com.swp_group4.back_end.requests;

import com.swp_group4.back_end.enums.Role;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CreateAccountRequest {

    @Size(min = 8, message = "USERNAME_NOT_VALID_1")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$", message = "USERNAME_NOT_VALID_2")
    String username;

    @Size(min = 8, message = "PASSWORD_NOT_VALID")
    String password;

}
