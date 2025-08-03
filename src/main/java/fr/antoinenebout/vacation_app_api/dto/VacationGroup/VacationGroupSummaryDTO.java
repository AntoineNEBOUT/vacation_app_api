package fr.antoinenebout.vacation_app_api.dto.VacationGroup;

import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationSummaryDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VacationGroupSummaryDTO {

    private Long id;
    private String name;
    private Date start_date;
    private Date end_date;

    private String username;
    private String state_name;

    private List<VacationSummaryDTO> vacations;

}
