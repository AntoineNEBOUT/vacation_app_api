package fr.antoinenebout.vacation_app_api.dto.Counter;

import lombok.Data;

@Data
public class CounterSummaryDTO {

    private Long id;
    private Double yearly_total;
    private Double requested;
    private Double validated;
    private Double remaining;
    private Double estimated;

    private String username;
    private String type;

}
