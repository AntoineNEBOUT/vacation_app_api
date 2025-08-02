package fr.antoinenebout.vacation_app_api.dto.VacationGroup;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class VacationGroupCreateDTO {

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Start date is required")
    private Date start_date;

    @NotNull(message = "End date is required")
    private Date end_date;


    @NotNull(message = "State_id value is required")
    @Min(value = 1, message = "State_id value must be greater than 1")
    private Long state_id;

}
