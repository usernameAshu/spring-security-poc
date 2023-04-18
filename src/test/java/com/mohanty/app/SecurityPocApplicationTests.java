package com.mohanty.app;

import java.util.Base64;

import org.junit.jupiter.api.Test;

//@SpringBootTest
class SecurityPocApplicationTests {

	@Test
	void contextLoads() {
		String authHeader = "YXNodXRvc2g6cGFzc3dvcmQ=";
		byte[] decodeBytes = Base64.getDecoder().decode(authHeader);
    
		String str = new String(decodeBytes);
		String username = str.substring(0, str.indexOf(":"));
		String password = str.substring(str.indexOf(":")+1);
		
		System.out.println(username+ "," + password);
	}

}
