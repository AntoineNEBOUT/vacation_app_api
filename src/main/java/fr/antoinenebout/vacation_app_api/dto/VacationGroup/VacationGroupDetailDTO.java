package fr.antoinenebout.vacation_app_api.dto.VacationGroup;

import fr.antoinenebout.vacation_app_api.dto.StateDTO;
import fr.antoinenebout.vacation_app_api.dto.User.UserDetailDTO;
import lombok.Data;

import java.util.Date;

@Data
public class VacationGroupDetailDTO {

    private Long id;
    private String name;
    private Date start_date;
    private Date end_date;

    private UserDetailDTO user;
    private StateDTO state;

}
