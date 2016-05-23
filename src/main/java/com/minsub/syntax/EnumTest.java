package com.minsub.syntax;

public class EnumTest {

	public static void main(String[] args) {
		
		test();
	}
	
	public static void test() {
		DBMS db = DBMS.Oracle;
		switch(db) {
			case Oracle:
				System.out.println(db.getName());
				break;
			case MySQL:
				System.out.println(db.getName());
				break;
			case MariaDB:
				System.out.println(db.getName());
				break;
			default:
				break;
		}
	}

	
	public enum DBMS {
		Oracle("oracle"),
		MySQL("mysql"),
		MariaDB("mariadb");
		
		String str;
		DBMS(String name) {
			this.str = name;
		}
		
		String getName() {
			return str;
		}
	}
	
	public enum Languages {
		JAVA(1),
		C(2),
		Python(3);
		
		int n;
		Languages(int n) {
			this.n = n;
		}
		
		int getNumber() {
			return this.n;
		}
		
	}
}
