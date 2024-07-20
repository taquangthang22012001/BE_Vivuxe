package com.vti.vivuxe.utils;
import org.springframework.stereotype.Component;

@Component
public class PathUtil {
	private String imagePath = "src/main/resources/static/images";

	public String getImagePath() {
		return imagePath;
	}
}
