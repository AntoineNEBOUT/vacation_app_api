package fr.antoinenebout.vacation_app_api.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String company_name;

}
