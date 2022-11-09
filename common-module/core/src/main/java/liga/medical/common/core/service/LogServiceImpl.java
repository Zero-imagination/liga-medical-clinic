package liga.medical.common.core.service;

import liga.medical.common.core.repository.LogRepository;
import liga.medical.dto.LogDto;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void saveDebugLog(LogDto logDto) {
        logRepository.saveDebugLog(logDto.getUuid(), logDto.getSystemTypeId(), logDto.getMethodParams());
    }

    @Override
    public void saveExceptionLog(LogDto logDto) {
        logRepository.saveExceptionLog(logDto.getUuid(), logDto.getSystemTypeId(), logDto.getMethodParams());
    }
}
