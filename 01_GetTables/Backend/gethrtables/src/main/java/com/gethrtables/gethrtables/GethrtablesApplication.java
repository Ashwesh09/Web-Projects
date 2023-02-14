package com.gethrtables.gethrtables;

import com.jio.digitalapi.app.platform.autoconfigure.DigitalApiPlatform;
import com.jio.digitalworks.apps.platform.DigitalApiPlatformApp;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@DigitalApiPlatform
public class GethrtablesApplication extends DigitalApiPlatformApp{

	public static void main(String[] args) {
		init(GethrtablesApplication.class, args);
	}

}
