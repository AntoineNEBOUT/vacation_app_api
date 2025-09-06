package fr.antoinenebout.vacation_app_api.dto.Vacation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class VacationCreateDTO {

    @NotNull(message = "Request value is required")
    @Min(value = 1, message = "Requested value must be greater than 1")
    private Double requested;


    @NotNull(message = "Vacation_type_id value is required")
    @Min(value = 1, message = "Vacation_type_id value must be greater than 1")
    private Long vacation_type_id;

    @NotNull(message = "Vacation_group_id value is required")
    @Min(value = 1, message = "Vacation_group_id value must be greater than 1")
    private Long vacation_group_id;



}
