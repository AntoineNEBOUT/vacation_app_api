package fr.antoinenebout.vacation_app_api.dto.User;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserUpdateDTO {

    private String first_name;

    private String last_name;

    @Email(message = "Email format is not valid")
    private String email;

    private String company_name;

}
