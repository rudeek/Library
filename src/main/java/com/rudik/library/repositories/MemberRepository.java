package com.rudik.library.repositories;

import com.rudik.library.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findByName(String name);
    List<Member> findByEmail(String email);
}
