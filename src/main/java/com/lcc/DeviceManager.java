package com.lcc;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class DeviceManager {

	public void sendIntensity(int intensity, String channel, String output) {
		String command = determineCommand(intensity);

		if ("2".equals(command)) {
			intensity = -intensity;
		}
		callInfraredApplication(command, String.valueOf(intensity), channel, output);
	}

	private String determineCommand(int intensity) {
		String command;
		if (intensity < 0) {
			command = "2";
		} else if (intensity > 0) {
			command = "1";
		} else {
			command = "0";
		}
		return command;
	}

	private void callInfraredApplication(String command, String intensity, String channel, String output) {
		String cmd = String.format("/home/pi/LCCInstallScript/infrared %s %s %s %s", channel, output, command,
				intensity);
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
