package com.example.app.service;

import com.example.app.entity.FamilyMember;
import com.example.app.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyMemberService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    public FamilyMember addFamilyMember(FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }

    public FamilyMember updateFamilyMember(FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }

    public void deleteFamilyMember(Long familyMemberId) {
        familyMemberRepository.deleteById(familyMemberId);
    }

    public List<FamilyMember> listFamilyMembers(Long userId) {
        return familyMemberRepository.findByUserId(userId);
    }
}
