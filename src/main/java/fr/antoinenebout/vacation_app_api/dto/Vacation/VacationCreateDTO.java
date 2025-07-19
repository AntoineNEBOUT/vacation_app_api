package fr.antoinenebout.vacation_app_api.dto.Vacation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class VacationCreateDTO {

    @NotNull(message = "Request value is required")
    @Min(value = 1, message = "Requested value must be greater than 1")
    private Long requested;

    @NotNull(message = "Start date is required")
    private Date start_date;

    @NotNull(message = "End date is required")
    private Date end_date;



    @NotNull(message = "User_id value is required")
    @Min(value = 1, message = "User_id value must be greater than 1")
    private Long user_id;

    @NotNull(message = "Vacation_type_id value is required")
    @Min(value = 1, message = "Vacation_type_id value must be greater than 1")
    private Long vacation_type_id;

    @NotNull(message = "State_id value is required")
    @Min(value = 1, message = "State_id value must be greater than 1")
    private Long state_id;

}
