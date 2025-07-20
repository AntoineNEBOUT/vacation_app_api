package fr.antoinenebout.vacation_app_api.dto.Vacation;

import fr.antoinenebout.vacation_app_api.dto.StateDTO;
import fr.antoinenebout.vacation_app_api.dto.User.UserDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationTypeDTO;
import lombok.Data;

import java.util.Date;

@Data
public class VacationDetailDTO {

    private Long id;
    private Long requested;
    private Date start_date;
    private Date end_date;

    private UserDetailDTO user;
    private VacationTypeDTO vacationType;
    private StateDTO state;

}
