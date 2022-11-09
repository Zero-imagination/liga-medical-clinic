package liga.medical.personservice.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.dto.LogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class LoggingAdvice {

    @Pointcut(value = "execution(* liga.medical.personservice.core.controller.*.*(..))")
    public void generalPointCut() {

    }

    @Pointcut(value = "execution(* liga.medical.personservice.core.listener.*.*(..))")
    public void listenerPointCut() {

    }

    @Pointcut("@annotation(liga.medical.personservice.core.annotations.Loggable)")
    public void loggableMethods() {

    }

    @Before(value = "loggableMethods()")
    public void authLogger(JoinPoint joinPoint) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String logId = "auth-logger";
        String args = mapper.writeValueAsString(joinPoint.getArgs());

        log.info("\n[{}] User {} trying to log in time: {}",
                logId, args, DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));

    }

    @Around(value = "generalPointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        ObjectMapper mapper = new ObjectMapper();
        String logId = "rest-logger";
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().getName();

        log.info("\n[{}] User [{}] invoked method {}() from class {} time: {}",
                logId, username, methodName, className, DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));

        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info(className + " with method " + methodName + " response: " + mapper.writeValueAsString(obj));
        return  obj;
    }

    @Around(value = "listenerPointCut()")
    public Object listenerLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
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
        log.info("\n"+className + " with method " + methodName + " response: " + mapper.writeValueAsString(obj));
        return  obj;
    }
}
