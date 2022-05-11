package michal.ulik.recruitmenttask.model.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class NbpTableDto{
    private List<RateDto> rates;
}
