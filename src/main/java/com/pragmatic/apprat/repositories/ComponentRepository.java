package com.pragmatic.apprat.repositories;

import com.pragmatic.apprat.domain.Component;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepository extends CrudRepository<Component, Long> {
}
