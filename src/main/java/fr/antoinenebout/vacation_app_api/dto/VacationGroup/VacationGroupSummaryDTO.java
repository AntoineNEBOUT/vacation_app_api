package fr.antoinenebout.vacation_app_api.dto.VacationGroup;

import lombok.Data;

import java.util.Date;

@Data
public class VacationGroupSummaryDTO {

    private Long id;
    private String name;
    private Date start_date;
    private Date end_date;

    private String username;
    private String state_name;

}
