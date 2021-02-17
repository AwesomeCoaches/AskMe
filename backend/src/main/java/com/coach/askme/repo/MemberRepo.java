package com.coach.askme.repo;

import com.coach.askme.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface MemberRepo extends MongoRepository<Member, Long> {
    Optional<Member> findByMid(Long mid);
    Optional<Member> findByNameAndPassword(String name, String password);
    Optional<Member> findByName(String name);
}
