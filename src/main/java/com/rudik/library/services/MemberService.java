package com.rudik.library.services;

import com.rudik.library.exceptions.MemberNotFoundException;
import com.rudik.library.models.Member;
import com.rudik.library.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements Manageable<Member>{
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void add(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void remove(int id) {
        if(!memberRepository.existsById(id))
            throw new MemberNotFoundException("Member not found: " + id);
        memberRepository.deleteById(id);
    }

    @Override
    public Member findById(int id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Member not found: " + id));
    }

    public List<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

    public List<Member> findByEmail(String email){
        return memberRepository.findByEmail(email);
    }

    public void increaseBalance(int id, double balance){
        Member member = findById(id);
        if(balance <= 0)
            throw new IllegalArgumentException("Balance should be greater than 0!");
        member.setBalance(member.getBalance() + balance);
        memberRepository.save(member);
    }
}
