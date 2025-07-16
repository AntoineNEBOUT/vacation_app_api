package fr.antoinenebout.vacation_app_api.dto;

import fr.antoinenebout.vacation_app_api.model.User;
import lombok.Data;

@Data
public class VacationDTO {

    private Long id;
    private Long yearly_total;
    private Long requested;
    private Long validated;
    private Long remaining;

    private UserDTO user;
    private VacationTypeDTO vacation_type;
//    private VacationTypeDTO vacation_type;

}
