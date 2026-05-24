package ru.z.kegerestwebservice.service;

import org.springframework.stereotype.Service;
import ru.z.kegerestwebservice.entity.Works;
import ru.z.kegerestwebservice.repository.WorksRepository;
import ru.z.kegerestwebservice.service.common.CommonService;

import java.util.List;

@Service
public class WorksService extends CommonService<Works, Long> {
    private final WorksRepository worksRepository;
    public WorksService(WorksRepository worksRepository){
        super(worksRepository);
        this.worksRepository=worksRepository;
    }

    public List<Works> findWorksByName(String fragment){
        return worksRepository.findWorksByName(fragment);
    }
}
