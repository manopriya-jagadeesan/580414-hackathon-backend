package com.hackathon.hackathonbackend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.vo.AssociateDetailsVO;

@Repository
public interface AssociateDetailsRepository extends MongoRepository<AssociateDetailsVO, Long> {

}
