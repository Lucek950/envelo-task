package michal.ulik.recruitmenttask.services;

import michal.ulik.recruitmenttask.TestData;
import michal.ulik.recruitmenttask.model.dtos.NbpTableDto;
import michal.ulik.recruitmenttask.model.dtos.RateDto;
import michal.ulik.recruitmenttask.model.dtos.nbpRate.NbpRateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class NbpServiceTest {
    @Mock
    private LogService logService;
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private NbpService nbpService;

    @Test
    void getNbpTableDtoTemplate_shouldReturnNbpTableDto_whenGivenExternalApi() {
        //given
        RateDto rateDtoFirst = TestData.getFirstRateDto();
        RateDto rateDtoSecond = TestData.getSecondRateDto();

        List<RateDto> ratesDto = List.of(rateDtoFirst, rateDtoSecond);

        NbpTableDto nbpTableDto = NbpTableDto.builder().rates(ratesDto).build();

        given(restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/A/", NbpTableDto[].class))
                .willReturn(new NbpTableDto[]{nbpTableDto});

        //when
        NbpTableDto actual = nbpService.getNbpTableDtoTemplate();

        //then
        then(restTemplate).should().getForObject("http://api.nbp.pl/api/exchangerates/tables/A/", NbpTableDto[].class);

        assertThat(actual).isNotNull();
        assertThat(actual.getRates().size()).isEqualTo(nbpTableDto.getRates().size());
        for(int i = 0; i < actual.getRates().size(); i++) {
            assertThat(actual.getRates().get(i).getCode()).isEqualTo(nbpTableDto.getRates().get(i).getCode());
            assertThat(actual.getRates().get(i).getCurrency()).isEqualTo(nbpTableDto.getRates().get(i).getCurrency());
            assertThat(actual.getRates().get(i).getMid()).isEqualTo(nbpTableDto.getRates().get(i).getMid());
        }
    }

    @Test
    void getRateDtoTemplate_shouldReturnNbpRateDto_whenGivenExternalApi() {
        //given
        String code = "usd";
        String url = "http://api.nbp.pl/api/exchangerates/rates/A/" + code;

        given(restTemplate.getForObject(url, NbpRateDto.class))
                .willReturn(new NbpRateDto());

        //when
        NbpRateDto actual = nbpService.getRateDtoTemplate(code);

        //then
        then(restTemplate).should().getForObject(url, NbpRateDto.class);

        assertThat(actual).isNotNull();
    }
}