package com.lcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

	@Autowired
	private DeviceManager deviceManager;

	@RequestMapping("/intensity/{value}")
	public void setIntensity(@PathVariable("value") int intensity, @RequestParam(value="channel", defaultValue="0") String channel,
			@RequestParam(value="output", defaultValue="1") String output) {
		deviceManager.sendIntensity(intensity, channel, output);
	}
}
