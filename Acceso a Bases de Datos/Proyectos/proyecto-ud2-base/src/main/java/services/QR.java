package services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.File;
import java.io.IOException;

public class QR {
    public static void generate(String data, String path) throws WriterException, IOException {
        String imgFormat = path.substring(path.lastIndexOf('.') + 1);
        int size = 200;
        BitMatrix matrix = (new MultiFormatWriter()).encode(data, BarcodeFormat.QR_CODE, size, size);
        MatrixToImageWriter.writeToFile(matrix, imgFormat, new File(path));
    }
}

