package test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.xhay1122.ImageGucas;
import com.xhay1122.MatrixToImageWriter;
import java.awt.image.BufferedImage;

public class Test {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//生成二维码
		matrixToImage();
		//解析二维码
		imageToMatrix();
	}
	
	/**
	 * 生成二维码
	 */
	public static void matrixToImage() throws Exception{
		String text = "http://xhay1122.com";
		int width = 300;
		int height = 300;
		//二维码的图片格式
		String format = "gif";
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
				BarcodeFormat.QR_CODE, width, height, hints);
		// 生成二维码
		File outputFile = new File("d:" + File.separator + "new.gif");
		System.out.println("生成二维码");
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
	}
	
	/**
	 * 解析二维码
	 */
	public static void imageToMatrix() {  
		QRCodeDecoder decoder = new QRCodeDecoder();  
		
		File imageFile = new File("D://new.gif");  
		BufferedImage image = null;  
		try {  
			image = ImageIO.read(imageFile);  
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());  
		}  

		System.out.println("识别二维码");  

       try { 
            String decodedData = new String(decoder.decode(new ImageGucas(image)), "UTF-8"); 
            System.out.println(decodedData); 
        } catch (DecodingFailedException dfe) { 
            System.out.println("Error: " + dfe.getMessage()); 
        } catch (UnsupportedEncodingException e) { 
            e.printStackTrace(); 
        }
		
//		String decodedData = new String(decoder.decode(new J2SEImageGucas(image)));  
//		System.out.println(decodedData);  
	}
	
}