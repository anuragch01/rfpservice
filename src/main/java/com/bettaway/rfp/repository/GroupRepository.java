package com.bettaway.rfp.repository;

import com.bettaway.rfp.modal.Group;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GroupRepository extends MongoRepository<Group, ObjectId> {
    List<Group> findByAuthId(String authId);

}
