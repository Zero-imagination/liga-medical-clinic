package liga.medical.medicalmonitoring.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.dto.LogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class LoggingAdvice {

    @Pointcut(value = "execution(* liga.medical.medicalmonitoring.core.listener.*.*(..))")
    public void listenerPointCut() {

    }

    @Around(value = "listenerPointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String logId = "db-logger";
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().getName();

        log.info("\n[{}] invoked method {}() from class {}",
                logId,  methodName, className);

        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        LogDto logDto = new LogDto();
        logDto.setUuid(UUID.randomUUID().toString());
        logDto.setSystemTypeId(1L);
        logDto.setMethodParams(mapper.writeValueAsString(obj));
        //LogService.save(logDto) не получается подключить
        log.info("\n" + className + " with method " + methodName + " response: " + mapper.writeValueAsString(obj));
        return  obj;
    }
}
