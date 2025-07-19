package fr.antoinenebout.vacation_app_api.dto.Counter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CounterUpdateDTO {

    @Min(value = 0, message = "The total must be positive")
    private Long yearly_total;

    @Min(value = 0, message = "The requested value must be positive")
    private Long requested;

    @Min(value = 0, message = "The validated value must be positive")
    private Long validated;

    @Min(value = 0, message = "The remaining value must be positive")
    private Long remaining;



    @Min(value = 1, message = "User_id value must be greater than 1")
    private Long user_id;

    @Min(value = 1, message = "Vacation_type_id value must be greater than 1")
    private Long vacation_type_id;

}
