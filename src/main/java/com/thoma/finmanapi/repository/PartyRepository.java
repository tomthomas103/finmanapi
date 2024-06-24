package com.thoma.finmanapi.repository;

import com.thoma.finmanapi.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {
    Party findByPartyId(String partyId);
}
