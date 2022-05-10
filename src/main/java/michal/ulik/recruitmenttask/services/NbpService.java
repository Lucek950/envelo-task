package michal.ulik.recruitmenttask.services;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.model.dtos.nbpRate.NbpRateDto;
import michal.ulik.recruitmenttask.model.dtos.NbpTableDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class NbpService {
    private final LogService logService;

    public NbpTableDto getNbpTableDtoTemplate(){
        logService.setLog("getNbpTableDtoTemplate()");
        String url = "http://api.nbp.pl/api/exchangerates/tables/A/";
        NbpTableDto[] nbpTableDto = new RestTemplate().getForObject(url, NbpTableDto[].class);
        assert nbpTableDto != null;
        return nbpTableDto[0];
    }

    public NbpRateDto getRateDtoTemplate(String code){
        logService.setLog("getRateDtoTemplate(String code)", code);
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + code;
        return new RestTemplate().getForObject(url, NbpRateDto.class);
    }
}
