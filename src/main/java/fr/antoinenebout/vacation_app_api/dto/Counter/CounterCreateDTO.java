package fr.antoinenebout.vacation_app_api.dto.Counter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CounterCreateDTO {

    @NotNull(message = "The total value is required")
    @Min(value = 0, message = "The total must be positive")
    private Double yearly_total;

    @Min(value = 0, message = "The requested value must be positive")
    private Double requested;

    @Min(value = 0, message = "The validated value must be positive")
    private Double validated;

    @Min(value = 0, message = "The remaining value must be positive")
    private Double remaining;

    @Min(value = 0, message = "The remaining value must be positive")
    private Double estimated;




    @NotNull(message = "Vacation_type_id value is required")
    @Min(value = 1, message = "Vacation_type_id value must be positive")
    private Long vacation_type_id;

}
