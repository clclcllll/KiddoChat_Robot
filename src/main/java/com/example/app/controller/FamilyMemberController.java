package com.example.app.controller;

import com.example.app.entity.FamilyMember;
import com.example.app.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/familyMember")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberService familyMemberService;

    @PostMapping("/add")
    public FamilyMember addFamilyMember(@RequestBody FamilyMember familyMember) {
        return familyMemberService.addFamilyMember(familyMember);
    }

    @PostMapping("/update")
    public FamilyMember updateFamilyMember(@RequestBody FamilyMember familyMember) {
        return familyMemberService.updateFamilyMember(familyMember);
    }

    @PostMapping("/delete")
    public void deleteFamilyMember(@RequestParam Long familyMemberId) {
        familyMemberService.deleteFamilyMember(familyMemberId);
    }

    @GetMapping("/list")
    public List<FamilyMember> listFamilyMembers(@RequestParam Long userId) {
        return familyMemberService.listFamilyMembers(userId);
    }
}
