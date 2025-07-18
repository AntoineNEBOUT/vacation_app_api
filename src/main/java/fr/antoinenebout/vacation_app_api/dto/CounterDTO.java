package fr.antoinenebout.vacation_app_api.dto;

import lombok.Data;

@Data
public class CounterDTO {

    private Long id;
    private Long yearly_total;
    private Long requested;
    private Long validated;
    private Long remaining;

//    private UserDTO user;
//    private VacationTypeDTO vacation_type;

    private Long user_id;
    private Long vacation_type_id;

}
