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

    @Size(min = 8, message = "Username must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$", message = "Username must contain both letters and numbers")
    String username;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    String password;

}
