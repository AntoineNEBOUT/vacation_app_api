package fr.antoinenebout.vacation_app_api.dto.Counter;

import fr.antoinenebout.vacation_app_api.dto.User.UserDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationTypeDTO;
import lombok.Data;

@Data
public class CounterDetailDTO {

    private Long id;
    private Long yearly_total;
    private Long requested;
    private Long validated;
    private Long remaining;

    private UserDetailDTO user;
    private VacationTypeDTO vacationType;

}
