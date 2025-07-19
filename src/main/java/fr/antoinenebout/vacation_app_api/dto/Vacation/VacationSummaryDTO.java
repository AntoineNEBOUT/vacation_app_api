package fr.antoinenebout.vacation_app_api.dto.Vacation;

import lombok.Data;

import java.util.Date;

@Data
public class VacationSummaryDTO {

    private Long id;
    private Long requested;
    private Date start_date;
    private Date end_date;

    private String username;
    private String type;
    private String state_name;

}