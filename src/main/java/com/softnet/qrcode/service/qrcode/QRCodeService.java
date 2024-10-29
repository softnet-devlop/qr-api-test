package com.softnet.qrcode.service.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.softnet.qrcode.model.qrcode.QRCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
public class QRCodeService implements QRCodeMapper {

    @Autowired
    private QRCodeMapper qrCodeMapper;

    public byte[] generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }

    public String generateQRCodeBase64(String text, int width, int height) throws WriterException, IOException {
        byte[] pngData = generateQRCodeImage(text, width, height);
        return Base64.getEncoder().encodeToString(pngData);
    }

    @Override
    public List<QRCodeDTO> getQrCode() {
        return qrCodeMapper.getQrCode();
    }

    @Transactional
    public List<QRCodeDTO> createQRCode(int count) throws WriterException, IOException {
        List<QRCodeDTO> qrCodeList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            String uniqueText = UUID.randomUUID().toString();
            QRCodeDTO qrCodeDTO = new QRCodeDTO();
//            qrCodeDTO.setQrCodeEncoder(generateQRCodeBase64(uniqueText, 100, 100));
            qrCodeDTO.setQrCodeEncoder(generateQRCodeBase64(uniqueText, 100, 100));
//            qrCodeDTO.setMember("member" + i);
            qrCodeList.add(qrCodeDTO);
        }

        try {
            qrCodeMapper.insertQRCode(qrCodeList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return qrCodeList;
    }


    @Override
    public void insertQRCode(List<QRCodeDTO> qrCodeList) {

    }

}
