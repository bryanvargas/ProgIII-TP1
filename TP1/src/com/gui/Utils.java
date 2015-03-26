package com.gui;

public class Utils {
	public static String getFileExtension(String name){
		int $pointIdex = name.lastIndexOf(".");
		
		if ($pointIdex == -1) {
			return null;
		}
		if ($pointIdex == name.length()-1) {
			return null;
		}
		return name.substring($pointIdex+1, name.length());
	}
}
