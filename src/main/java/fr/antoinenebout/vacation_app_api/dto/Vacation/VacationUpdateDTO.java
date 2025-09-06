package fr.antoinenebout.vacation_app_api.dto.Vacation;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;

@Data
public class VacationUpdateDTO {

    @Min(value = 0, message = "Requested value must be greater than 0")
    private Double requested;


    @Min(value = 1, message = "Vacation_type_id value must be greater than 1")
    private Long vacation_type_id;

    @Min(value = 1, message = "Vacation_group_id value must be greater than 1")
    private Long vacation_group_id;


}
