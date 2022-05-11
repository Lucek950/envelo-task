package michal.ulik.recruitmenttask.services;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.model.LogRepository;
import michal.ulik.recruitmenttask.model.enitities.Log;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class LogService {
    private final LogRepository logRepository;

    public void setLog(String message){
        Log log = Log.builder().method(message).dateTime(LocalDateTime.now()).build();
        logRepository.save(log);
    }

    public void setLog(String message, Object obj){
        Log log = Log.builder().method(message).params(obj.toString()).dateTime(LocalDateTime.now()).build();
        logRepository.save(log);
    }

    public void setLog(String message, Object... obj3){
        Log log = Log.builder().method(message).params(Arrays.toString(obj3)).dateTime(LocalDateTime.now()).build();
        logRepository.save(log);
    }
}
