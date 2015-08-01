package com.xhay1122;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class ImageGucas implements QRCodeImage {  
	private BufferedImage image;  

	public ImageGucas(BufferedImage image) {  
		this.image = image;  
	}  

	public int getWidth() {  
		return image.getWidth();  
	}  

	public int getHeight() {  
		return image.getHeight();  
	}  

	public int getPixel(int x, int y) {  
		return image.getRGB(x, y);  
	}  
}