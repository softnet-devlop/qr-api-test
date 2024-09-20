package com.softnet.qrcode.service.member;

import com.softnet.qrcode.model.member.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements MemberMapper {

    @Autowired
    private MemberMapper mapper;

    @Override
    public List<MemberDto> getMemberList(Long memberSeqNo) throws Throwable {
        return mapper.getMemberList(memberSeqNo);
    }

    @Override
    public void insertMember(MemberDto memberDto) {
        mapper.insertMember(memberDto);
    }


}
