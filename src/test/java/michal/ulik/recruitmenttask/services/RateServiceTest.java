package michal.ulik.recruitmenttask.services;

import michal.ulik.recruitmenttask.model.dtos.NbpTableDto;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class RateServiceTest {
    @InjectMocks
    private RateService rateService;
    @Mock
    private LogService logService;
    @Mock
    private NbpService nbpService;

    @Test
    void getAllRates_shouldReturnListRateDto_and_checkIsNotNull_and_compereSize() {
        //given
        RateDto rateDtoFirst = RateDto.builder().code("usd").currency("dolar amerykański").mid(BigDecimal.TEN).build();
        RateDto rateDtoSecond = RateDto.builder().code("eur").currency("euro").mid(BigDecimal.TEN).build();

        List<RateDto> ratesDto = List.of(rateDtoFirst, rateDtoSecond);

        willDoNothing().given(logService).setLog(any());
        given(nbpService.getNbpTableDtoTemplate()).willReturn(new NbpTableDto(ratesDto));

        //when
        List<RateDto> actual = rateService.getAllRates();

        //then
        then(logService).should().setLog(any());
        then(nbpService).should().getNbpTableDtoTemplate();

        assertThat(actual).isNotNull();
        assertThat(actual).size().isEqualTo(ratesDto.size());
    }
}