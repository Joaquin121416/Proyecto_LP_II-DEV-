package com.sistema.comidas.test;


import  java.awt.image.BufferedImage ;
import java.io.ByteArrayOutputStream;
import java.io.File;

import  javax.imageio.ImageIO ;

import  com.sun.org.apache.xerces.internal.impl.dv.util.Base64 ;


public class Bin {
	
	public static void main(String[] args) {
		try {
		     BufferedImage image = ImageIO.read(new File("E:\\images.jpg"));
		     ByteArrayOutputStream baos = new ByteArrayOutputStream();
		     ImageIO.write(image, "png", baos);
		     String encodedImage = Base64.encode(baos.toByteArray());
		     System.out.println(encodedImage);
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		
	}		
	
	public static String ImgCastBlob(File img) {
		 String encodedImage = null;
		try {
		     BufferedImage image = ImageIO.read(new File(img.getAbsolutePath()));
		     ByteArrayOutputStream baos = new ByteArrayOutputStream();
		     ImageIO.write(image, "png", baos);
		     encodedImage = Base64.encode(baos.toByteArray());
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		return encodedImage;
		
	}		
	
}
