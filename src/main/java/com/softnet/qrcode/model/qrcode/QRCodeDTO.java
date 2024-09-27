package com.softnet.qrcode.model.qrcode;

import lombok.Data;

@Data
public class QRCodeDTO {

    private Long codeSeqno;
    private String qrCodeEncoder;
    private String macAddress;
    private Long memberSeqNo;
    private String loginId;
}
