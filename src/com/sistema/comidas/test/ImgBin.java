package com.sistema.comidas.test;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ImgBin {
	private static File[] inputfiles;
	private static File outputfile;
	private static GUIClass gui;
	private static byte[] bin;
	private static List<byte[]> listBin = new ArrayList<>();
	private static String userDir;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			//Start app here
			userDir = System.getProperty("user.home");
			gui = new GUIClass();
			gui.setVisible(true);
			gui.pack();
		});
	}
	public static void OpenFile() throws IOException{
		   JFileChooser chooser = new JFileChooser();
		   	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		   	chooser.setMultiSelectionEnabled(true);
			chooser.setCurrentDirectory(new File(userDir + "/Desktop"));
			chooser.showOpenDialog(gui);
			inputfiles = chooser.getSelectedFiles();
		   	System.out.println("Value of input files: " + inputfiles.length);
			for(int x = 0; x < inputfiles.length; x++){
				try {
					System.out.println("Load list: " + x);
					bin = Files.readAllBytes(inputfiles[x].toPath());
					listBin.add(bin);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
	   }
	   
	   public static void ConvertFile() throws IOException{
		Path path = Paths.get(userDir + "/Desktop/PNG" + (int)(Math.random() * 100));
		Files.createDirectories(path);
		   try {
			   for(int x = 0; x < inputfiles.length; x++ ){
				outputfile = new File(path + "/"
						+ inputfiles[x].getName().replace(".bin", ".png"));
				ImageIO.write(createImageFromBytes(listBin.get(x)), "png", outputfile);
				System.out.println("Convert: " + x);
			   }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	   }
	   
	   private static BufferedImage createImageFromBytes(byte[] imageData){
		   ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
		   try{
			   return ImageIO.read(bais);
		   }catch(IOException e){
			   throw new RuntimeException(e);
		   }
	   }
}
