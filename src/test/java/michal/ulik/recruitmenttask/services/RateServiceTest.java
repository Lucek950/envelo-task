package michal.ulik.recruitmenttask.services;

import michal.ulik.recruitmenttask.TestData;
import michal.ulik.recruitmenttask.model.dtos.NbpTableDto;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.dtos.nbpRate.NbpRateDto;
import michal.ulik.recruitmenttask.model.dtos.nbpRate.ValueNbpRateDto;
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
        RateDto rateDtoFirst = TestData.getFirstRateDto();
        RateDto rateDtoSecond = TestData.getSecondRateDto();

        List<RateDto> ratesDto = List.of(rateDtoFirst, rateDtoSecond);

        given(nbpService.getNbpTableDtoTemplate()).willReturn(new NbpTableDto(ratesDto));

        //when
        List<RateDto> actual = rateService.getAllRates();

        //then
        then(nbpService).should().getNbpTableDtoTemplate();

        assertThat(actual).isNotNull();
        assertThat(actual).size().isEqualTo(ratesDto.size());
    }

    @Test
    void getRate_shouldReturnRateDto_and_checkIsNotNull() {
        //given
        NbpRateDto nbpRateDto = TestData.getFirstNbpTableDto();

        given(nbpService.getRateDtoTemplate(any())).willReturn(nbpRateDto);

        //when
        RateDto actual = rateService.getRate(nbpRateDto.getCode());

        //then
        then(nbpService).should().getRateDtoTemplate(any());

        assertThat(actual).isNotNull();
    }
}