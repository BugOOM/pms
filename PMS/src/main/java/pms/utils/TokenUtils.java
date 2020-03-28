package pms.utils;

import java.util.UUID;

public class TokenUtils {
	public static String getToken(String username) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return username + uuid;
	}
}
