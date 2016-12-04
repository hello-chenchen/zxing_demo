package com.hellochenchen.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QRCodeUtil {
	
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	private static final int WIDTH = 666;
	private static final int HEIGHT = 666;
	
	/**  
	 * createQRCode:(生成二维码图片流). <br/>  
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>  
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>  
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>  
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>  
	 *  
	 * @author hello_chenchen  
	 * @param website
	 * @param output
	 * @throws WriterException
	 * @throws IOException  
	 * @since JDK 1.8.0_111
	 */
	public static void createQRCode(String website, OutputStream output) throws WriterException, IOException {
		int width = WIDTH;
		int height = HEIGHT;
		String qrCodeType = "jpg";
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>(); 
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitsMatrix = new MultiFormatWriter().encode(website, BarcodeFormat.QR_CODE, width, height, hints);
		
		BufferedImage qrCodeBuff = bitsToQRImage(bitsMatrix);
		ImageIO.write(qrCodeBuff, qrCodeType, output);	//把二维码写到response的输出流
	}

	/**  
	 * toImage:(二进制流转换成图片). <br/>  
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>  
	 * @author hello_chenchen  
	 * @param bitsMatrixInPut
	 * @return BufferedImage 
	 * @since JDK 1.8.0_111
	 */
	private static BufferedImage bitsToQRImage(BitMatrix bitsMatrixInPut) {
		int width = bitsMatrixInPut.getWidth();
		int height = bitsMatrixInPut.getHeight();
		BufferedImage qrCodeBuffReturn = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for(int x = 0;x < width; x++){
			for(int y = 0; y < height; y++ ){
				qrCodeBuffReturn.setRGB(x, y, bitsMatrixInPut.get(x, y) ? BLACK : WHITE);
			}
		}
		return qrCodeBuffReturn;
	}

}
