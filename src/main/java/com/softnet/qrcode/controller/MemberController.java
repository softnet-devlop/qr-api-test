package com.softnet.qrcode.controller;

import com.softnet.qrcode.code.StatusCode;
import com.softnet.qrcode.common.ResponseObject;
import com.softnet.qrcode.model.member.MemberDto;
import com.softnet.qrcode.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/list")
    public ResponseObject getMemberList(MemberDto memberDto) {

        ResponseObject ret = new ResponseObject();

        try {
            List<MemberDto> memberList = memberService.getMemberList(memberDto.getMemberSeqNo());
            ret.setData(memberList);
            ret.setCode(StatusCode.OK);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return ret;

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody MemberDto memberDto) {
        try {
            memberService.insertMember(memberDto);
            return ResponseEntity.ok("Member registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to register member");
        }
    }


}
