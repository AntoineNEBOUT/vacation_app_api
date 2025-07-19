package fr.antoinenebout.vacation_app_api.dto.Vacation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class VacationUpdateDTO {

    @Min(value = 1, message = "Requested value must be greater than 1")
    private Long requested;

    private Date start_date;
    private Date end_date;



    @Min(value = 1, message = "User_id value must be greater than 1")
    private Long user_id;

    @Min(value = 1, message = "Vacation_type_id value must be greater than 1")
    private Long vacation_type_id;

    @Min(value = 1, message = "State_id value must be greater than 1")
    private Long state_id;

}
