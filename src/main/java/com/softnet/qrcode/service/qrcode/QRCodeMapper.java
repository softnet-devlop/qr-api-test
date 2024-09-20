package com.softnet.qrcode.service.qrcode;

import com.softnet.qrcode.model.member.MemberDto;
import com.softnet.qrcode.model.qrcode.QRCodeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QRCodeMapper {

    void insertQRCode(List<QRCodeDTO> qrCodeList);

    List<QRCodeDTO> getQrCode();

}
