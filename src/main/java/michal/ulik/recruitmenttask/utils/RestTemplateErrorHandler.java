package michal.ulik.recruitmenttask.utils;

import michal.ulik.recruitmenttask.exceptions.ExternalApiCallException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class RestTemplateErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if(response.getStatusCode() == HttpStatus.NOT_FOUND)
            throw new ExternalApiCallException();
    }
}
