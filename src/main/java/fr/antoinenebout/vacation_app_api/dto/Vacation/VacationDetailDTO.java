package fr.antoinenebout.vacation_app_api.dto.Vacation;

import fr.antoinenebout.vacation_app_api.dto.StateDTO;
import fr.antoinenebout.vacation_app_api.dto.User.UserDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationType.VacationTypeDetailDTO;
import lombok.Data;

import java.util.Date;

@Data
public class VacationDetailDTO {

    private Long id;
    private Long requested;

    private VacationTypeDetailDTO vacationType;
    private VacationGroupDetailDTO vacationGroup;

}
