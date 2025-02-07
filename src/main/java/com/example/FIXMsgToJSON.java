package com.example;

import org.json.JSONObject;

public class FIXMsgToJSON {
	public static void main(String[] args) {
		String fixMsg = "8=FIX.4.49=28935=834=109049=TESTSELL152=20180920-18:23:53.67156=TESTBUY16=113.3511=63673064027889863414=3500.000000000015=USD17=2063673064633531000021=231=113.3532=350037=2063673064633531000038=700039=140=154=155=MSFT60=20180920-18:23:53.531150=F151=3500453=1448=BRK2447=D452=110=151";

		String[] fields = fixMsg.split("\u0001");

		JSONObject json = new JSONObject();

		for (String field : fields) {
			String[] keyValue = field.split("=");
			if (keyValue.length == 2) {
				String key = keyValue[0];
				String value = keyValue[1];
				json.put(key, value);
			}
		}

		System.out.println(json.toString(4)); //4 space indent
	}
}
