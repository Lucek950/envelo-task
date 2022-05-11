package michal.ulik.recruitmenttask.services;

import michal.ulik.recruitmenttask.model.dtos.NbpTableDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
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
        willDoNothing().given(logService).setLog(any());
        given(restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/A/", NbpTableDto[].class))
                .willReturn(new NbpTableDto[]{new NbpTableDto()});

        //when
        NbpTableDto actual = nbpService.getNbpTableDtoTemplate();

        //then
        then(logService).should().setLog(any());
        then(restTemplate).should().getForObject("http://api.nbp.pl/api/exchangerates/tables/A/", NbpTableDto[].class);

        assertThat(actual).isNotNull();
    }
}