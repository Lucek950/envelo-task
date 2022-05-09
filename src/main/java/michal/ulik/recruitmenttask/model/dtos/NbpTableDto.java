package michal.ulik.recruitmenttask.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class NbpTableDto {
    private Long id;
    private String table;
    private List<RateDto> rates;
}
