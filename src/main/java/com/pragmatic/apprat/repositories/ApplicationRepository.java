package com.pragmatic.apprat.repositories;

import com.pragmatic.apprat.domain.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
