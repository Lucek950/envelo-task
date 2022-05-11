package michal.ulik.recruitmenttask;

import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.dtos.nbpRate.NbpRateDto;
import michal.ulik.recruitmenttask.model.dtos.nbpRate.ValueNbpRateDto;

import java.math.BigDecimal;
import java.util.List;

public class TestData {
    public static RateDto getFirstRateDto(){
            return  RateDto.builder()
            .code("usd")
            .currency("dolar amerykański")
            .mid(new BigDecimal("4.4190"))
            .build();
    }

    public static RateDto getSecondRateDto(){
        return  RateDto.builder()
                .code("eur")
                .currency("euro")
                .mid(new BigDecimal("4.6700"))
                .build();
    }

    public static RateDto getThirdRateDto(){
        return  RateDto.builder()
                .code("huf")
                .currency("forint (Węgry)")
                .mid(new BigDecimal("0.012307"))
                .build();
    }

    public static NbpRateDto getFirstNbpTableDto(){
        return  NbpRateDto.builder()
                .code("usd")
                .currency("dolar amerykański")
                .rates(List.of(new ValueNbpRateDto(new BigDecimal("4.4190"))))
                .build();
    }
}
