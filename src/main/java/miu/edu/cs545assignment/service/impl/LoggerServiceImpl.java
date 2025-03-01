package miu.edu.cs545assignment.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cs545assignment.domain.Logger;
import miu.edu.cs545assignment.repository.LoggerRepository;
import miu.edu.cs545assignment.service.LoggerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggerServiceImpl implements LoggerService {

    private final LoggerRepository loggerRepo;


    @Override
    public void save(Logger logger) {
        loggerRepo.save(logger);
    }
}
