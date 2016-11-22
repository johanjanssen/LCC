package com.lcc;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class DeviceManager {

	private String channel = "0";
	private String output = "1";

	public void sendIntensity(int intensity) {
		String command;
		if (intensity < 0) {
			command = "2";
			intensity = -intensity;
		} else if (intensity > 0) {
			command = "1";
		} else {
			command = "0";
		}
		callCApplication(command, String.valueOf(intensity));
	}

	private void callCApplication(String command, String intensity) {
		String cmd = String.format("./infrared %s %s %s %s", channel, output, command, intensity);
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
