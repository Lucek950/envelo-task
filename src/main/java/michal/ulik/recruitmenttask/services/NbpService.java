package michal.ulik.recruitmenttask.services;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.exceptions.ExternalApiCallException;
import michal.ulik.recruitmenttask.model.dtos.nbpRate.NbpRateDto;
import michal.ulik.recruitmenttask.model.dtos.NbpTableDto;
import michal.ulik.recruitmenttask.model.enums.ExceptionMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class NbpService{
    private final LogService logService;
    private final RestTemplate restTemplate;

    public NbpTableDto getNbpTableDtoTemplate(){
        try {
            logService.setLog("getNbpTableDtoTemplate()");
            String url = "http://api.nbp.pl/api/exchangerates/tables/A/";
            NbpTableDto[] nbpTableDto = restTemplate.getForObject(url, NbpTableDto[].class);
            return Objects.requireNonNull(nbpTableDto)[0];
        } catch (ExternalApiCallException ex){
            String message = ExceptionMessage.NBP_TABLE_NOT_FOUND.getMessage();
            logService.setLog("ERROR: " + message);
            throw new ExternalApiCallException(message);
        }
    }

    public NbpRateDto getRateDtoTemplate(String code){
        try {
            logService.setLog("getRateDtoTemplate(String code)", code);
            String url = "http://api.nbp.pl/api/exchangerates/rates/A/" + code;
            return restTemplate.getForObject(url, NbpRateDto.class);
        } catch (ExternalApiCallException ex){
            String message = ExceptionMessage.EXTERNAL_API_NOT_FOUND.getMessage() + code;
            logService.setLog("ERROR: " + message);
            throw new ExternalApiCallException(message);
        }
    }
}
