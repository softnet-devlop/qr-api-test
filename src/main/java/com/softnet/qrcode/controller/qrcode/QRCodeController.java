package com.softnet.qrcode.controller.qrcode;

import com.google.zxing.WriterException;
import com.softnet.qrcode.model.qrcode.QRCodeDTO;
import com.softnet.qrcode.service.qrcode.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/create-qr")
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String text) {
        try {
            byte[] qrImage = qrCodeService.generateQRCodeImage(text, 100, 100);
            return ResponseEntity.ok()
                    .header("Content-Type", "image/png")
                    .body(qrImage);
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/encoder-qr")
    public ResponseEntity<String> generateQRCodeBase64(@RequestParam String text) {
        try {
            String qrImageBase64 = qrCodeService.generateQRCodeBase64(text, 100, 100);
            return ResponseEntity.ok(qrImageBase64);
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/insert-qr")
    public ResponseEntity<List<QRCodeDTO>> createQRCode() {
        try {
            List<QRCodeDTO> qrCodeList = qrCodeService.createQRCode(10);
            return ResponseEntity.ok(qrCodeList);
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/get-qr")


    public ResponseEntity<List<QRCodeDTO>> getQrCode() {
        List<QRCodeDTO> qrCodeDTOList = qrCodeService.getQrCode();
        return ResponseEntity.ok(qrCodeDTOList);
    }


}
