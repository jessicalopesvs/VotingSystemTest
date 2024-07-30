package org.jessicalopes.votingsystem.api.repository;

import org.jessicalopes.votingsystem.api.model.ParameterModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParameterRepo extends MongoRepository<ParameterModel, String> {
}
