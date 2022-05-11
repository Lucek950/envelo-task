package michal.ulik.recruitmenttask.services;

import michal.ulik.recruitmenttask.TestData;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.dtos.ResultDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ResultServiceTest {
    @Mock
    private LogService logService;
    @Mock
    private RateService rateService;
    @InjectMocks
    private ResultService resultService;

    @Test
    void convertCurrency_shouldReturnResultDto_givenCodeFromToAndAmount() {
        //given
        BigDecimal amount = new BigDecimal("13.5");
        BigDecimal value = new BigDecimal("12.78");

        RateDto rateDtoFrom = TestData.getFirstRateDto();
        RateDto rateDtoTo = TestData.getSecondRateDto();

        ResultDto expected = ResultDto.builder()
                .from(rateDtoFrom.getCurrency())
                .to(rateDtoTo.getCurrency())
                .amount(amount)
                .value(value)
                .build();

        given(rateService.getRate(any())).willReturn(rateDtoFrom, rateDtoTo);

        //when
        ResultDto actual = resultService.convertCurrency(rateDtoFrom.getCode(), rateDtoTo.getCode(), amount);

        //then
        then(rateService).should(times(2)).getRate(any());

        assertThat(actual).isNotNull();
        assertThat(actual.getFrom()).isEqualTo(expected.getFrom());
        assertThat(actual.getTo()).isEqualTo(expected.getTo());
        assertThat(actual.getAmount()).isEqualTo(expected.getAmount());
        assertThat(actual.getValue()).isEqualTo(expected.getValue());
    }

    @Test
    void convertCurrencies() {
        //given
        RateDto rateDtoFrom = TestData.getFirstRateDto();
        RateDto rateDtoFirst = TestData.getSecondRateDto();
        RateDto rateDtoSecond = TestData.getThirdRateDto();

        List<RateDto> ratesDto = List.of(rateDtoFrom, rateDtoFirst, rateDtoSecond);

        given(rateService.getRate(any())).willReturn(rateDtoFrom, rateDtoFirst);
        given(rateService.getAllRates()).willReturn(ratesDto);

        //when
        resultService.convertCurrencies("usd");

        //then
        then(rateService).should(times(ratesDto.size() + 1)).getRate(any());
        then(rateService).should().getAllRates();
    }
}