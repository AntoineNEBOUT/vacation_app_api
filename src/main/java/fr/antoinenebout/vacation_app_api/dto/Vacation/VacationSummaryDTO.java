package fr.antoinenebout.vacation_app_api.dto.Vacation;

import lombok.Data;

import java.util.Date;

@Data
public class VacationSummaryDTO {

    private Long id;
    private Long requested;

    private String type;
    private String group;

}