package com.bookworm.bookwormauth.api.adapter.out.persistence.repository;

import com.bookworm.bookwormauth.api.adapter.out.persistence.entity.WormEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WormRepository extends CrudRepository<WormEntity, Long> {
}
