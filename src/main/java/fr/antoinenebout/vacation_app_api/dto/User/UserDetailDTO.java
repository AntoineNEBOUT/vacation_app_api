package fr.antoinenebout.vacation_app_api.dto.User;

import lombok.Data;

@Data
public class UserDetailDTO {

    private String first_name;

    private String last_name;

    private String email;

    private String company_name;

}
