package com.rudik.library.controllers;

import com.rudik.library.models.Member;
import com.rudik.library.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping
    public void addMember(@RequestBody @Valid Member member){
        memberService.add(member);
    }

    @DeleteMapping("/{id}")
    public void removeMember(@PathVariable int id){
        memberService.remove(id);
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable int id){
        return memberService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Member> getByName(@PathVariable String name){
        return memberService.findByName(name);
    }

    @GetMapping("/email/{email}")
    public List<Member> getByEmail(@PathVariable String email){
        return memberService.findByEmail(email);
    }
}
