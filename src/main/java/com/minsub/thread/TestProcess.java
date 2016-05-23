package com.minsub.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class TestProcess {
	static Logger logger = Logger.getLogger(TestProcess.class.getName());

	public static void main(String[] args) {
		
		if (TestProcess.isRunnungProcess("sublime_text.exe")) {
			System.out.println("sublime_text !!");
		} else {
			System.out.println("not !!");
		}
		
		logger.debug("anohter deeee");
		logger.info("anohter deeee");
	}
	
	/**
	 * 해당 프로세스가 현재 작동중인지를 체크
	 * @param processName
	 * @return
	 */
	public static boolean isRunnungProcess(String processName) {
		try {
			Process proc = Runtime.getRuntime().exec("tasklist");
			if (proc == null) {
				return false;
			} else {
				BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				String line   = "";
			    StringTokenizer st = null;

				while ((line = br.readLine()) != null) {
					st = new StringTokenizer(line, " ", false);
					
					if (st.hasMoreTokens() && (st.nextToken()).equals(processName)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	/**
	 * 해당 프로세스 이름을 가진 프로세스의 작동을 중지시킴
	 * @param processName
	 * @throws IOException
	 */
	public static void killProcess(String processName) throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM " + processName);
	}

}
