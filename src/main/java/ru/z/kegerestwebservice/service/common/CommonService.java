package ru.z.kegerestwebservice.service.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.z.kegerestwebservice.entity.common.CommonEntity;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Slf4j
public class CommonService<T extends CommonEntity<ID>, ID extends Serializable> {
    private final JpaRepository<T, ID> repository;

    public CommonService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        //Pageable pageable = PageRequest.of(1, 5, Sort.by("id"));
        //return repository.findAll(pageable).stream().toList();
         return repository.findAll();
    }

    public T getById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public String delete(T entity) {
        String msg = "";
        Optional<T> tryFindUnit = repository.findById(entity.getId());
        tryFindUnit.ifPresent(t -> repository.delete(t));
        msg = tryFindUnit.map(t -> new StringBuilder()
                        .append("deleted  \n")
                        .append(t.toString())
                        .toString())
                .orElse(new StringBuilder()
                        .append("not found \n")
                        .append(entity.toString())
                        .toString());
        log.info(msg);
        return msg;

    }
}