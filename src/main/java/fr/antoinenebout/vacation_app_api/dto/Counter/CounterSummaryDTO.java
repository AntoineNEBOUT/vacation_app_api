package fr.antoinenebout.vacation_app_api.dto.Counter;

import lombok.Data;

@Data
public class CounterSummaryDTO {

    private Long id;
    private Long yearly_total;
    private Long requested;
    private Long validated;
    private Long remaining;

    private String username;
    private String type;

}
