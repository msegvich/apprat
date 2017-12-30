package com.pragmatic.apprat.repositories;

import com.pragmatic.apprat.domain.Server;
import org.springframework.data.repository.CrudRepository;

public interface ServerRepository extends CrudRepository <Server, Long> {
}
