package liga.medical.common.core.service;

import liga.medical.dto.LogDto;

public interface LogService {

    void saveDebugLog(LogDto logDto);

    void saveExceptionLog(LogDto logDto);

}
