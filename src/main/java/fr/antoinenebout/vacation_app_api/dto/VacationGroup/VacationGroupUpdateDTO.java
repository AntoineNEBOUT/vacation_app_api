package fr.antoinenebout.vacation_app_api.dto.VacationGroup;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;

@Data
public class VacationGroupUpdateDTO {

    private String name;

    private Date start_date;
    private Date end_date;


    @Min(value = 1, message = "State_id value must be greater than 1")
    private Long state_id;

}
