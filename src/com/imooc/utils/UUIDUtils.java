package com.imooc.utils;

import java.util.UUID;

/**
 * ��������ַ����Ĺ�����
 * @author zjz
 *
 */
public class UUIDUtils {

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
