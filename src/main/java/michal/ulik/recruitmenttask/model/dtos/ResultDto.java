package michal.ulik.recruitmenttask.model.dtos;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResultDto {
    private String from;
    private String to;
    private BigDecimal value;
}
