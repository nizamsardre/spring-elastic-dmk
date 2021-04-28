package com.dhamaka.pay.repository;

import org.bson.types.ObjectId;
import com.dhamaka.pay.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    public Boolean existsAdminBy_id(ObjectId id);
}
