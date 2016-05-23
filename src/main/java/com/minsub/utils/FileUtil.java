package com.minsub.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtil {
	/**
	 * Serialization을 이용한 File저장. 입력받은 map object를 입력받은 file에 저장 
	 * @param file 저장할 파일 객체
	 * @param map 저장할 map object
	 */
	public static void writeObject(File file, Object object) {
		if (file == null || object == null) {
			return;
		}
		ObjectOutputStream ous = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ous = new ObjectOutputStream(fos);
			ous.writeObject(object);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ous != null) {
				try {
					ous.flush();
					ous.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Serialization으로 저장된 파일을 Object객체로 읽어 들임, 1개의 Object이 저장되어 있음
	 * @param file
	 * @return
	 */
	public static Object readObject(File file) {
		if (file == null || !file.exists()) {
			return null;
		}
//		Map<String, User> map = null;
		Object map = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			map = ois.readObject();
			ois.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
}
