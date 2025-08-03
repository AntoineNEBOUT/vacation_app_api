package fr.antoinenebout.vacation_app_api.dto.Counter;

import fr.antoinenebout.vacation_app_api.dto.User.UserDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationType.VacationTypeDetailDTO;
import lombok.Data;

@Data
public class CounterDetailDTO {

    private Long id;
    private Double yearly_total;
    private Double requested;
    private Double validated;
    private Double remaining;
    private Double estimated;

    private UserDetailDTO user;
    private VacationTypeDetailDTO vacationType;

}
