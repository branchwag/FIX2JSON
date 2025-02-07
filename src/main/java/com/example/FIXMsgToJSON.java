package com.example;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class FIXMsgToJSON {
	public static void main(String[] args) {

		String fixMsg = "8=FIX.4.49=28935=834=109049=TESTSELL152=20180920-18:23:53.67156=TESTBUY16=113.3511=63673064027889863414=3500.000000000015=USD17=2063673064633531000021=231=113.3532=350037=2063673064633531000038=700039=140=154=155=MSFT60=20180920-18:23:53.531150=F151=3500453=1448=BRK2447=D452=110=151";

		//mebbe replace with xml dictionary later
		Map<String, String> fieldNames = new HashMap<>();
		fieldNames.put("8", "BeginString");
		fieldNames.put("9", "BodyLength");
		fieldNames.put("35", "MessageType");
		fieldNames.put("34", "MsgSeqNum");
		fieldNames.put("49", "SenderCompID");
		fieldNames.put("52", "SendingTime");
		fieldNames.put("56", "TargetCompID");
		fieldNames.put("6", "Price");
		fieldNames.put("11", "ClOrdID");
		fieldNames.put("14", "OrderQty");
		fieldNames.put("15", "Currency");
		fieldNames.put("17", "ExecTransType");
		fieldNames.put("21", "HandlInst");
		fieldNames.put("31", "LastPx");
		fieldNames.put("32", "LastShares");
		fieldNames.put("37", "OrderID");
		fieldNames.put("38", "OrderQty2");
		fieldNames.put("39", "OrdStatus");
		fieldNames.put("40", "OrdType");
		fieldNames.put("54", "Side");
		fieldNames.put("55", "Symbol");
		fieldNames.put("60", "TransactTime");
		fieldNames.put("150", "ExecType");
		fieldNames.put("151", "LeavesQty");
		fieldNames.put("453", "NoLinesOfText");
		fieldNames.put("448", "OtherPartyID");
		fieldNames.put("447", "OtherPartyIDSource");
		fieldNames.put("452", "NoPartyIDs");
		fieldNames.put("10", "CheckSum");

		String[] fields = fixMsg.split("\u0001");

		JSONObject json = new JSONObject();

		for (String field : fields) {
			String[] keyValue = field.split("=");
			if (keyValue.length == 2) {
				String tag = keyValue[0];
				String value = keyValue[1];

				String fieldName = fieldNames.get(tag);
				if (fieldName != null) {
					json.put(fieldName, value);
				} else {
					json.put(tag, value);
				}
			}
		}

		System.out.println(json.toString(4)); //4 space indent
	}
}
