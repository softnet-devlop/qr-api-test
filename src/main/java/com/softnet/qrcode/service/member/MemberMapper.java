package com.softnet.qrcode.service.member;

import com.softnet.qrcode.model.member.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

     public List<MemberDto> getMemberList(Long memberSeqNo) throws Throwable;

//    void insertMember(MemberDto memberDto);

        void insertMember(MemberDto memberDto);

}
