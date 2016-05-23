package com.minsub.jdbc.db2;

public class Query20141205 {

	public static final String DEFAULT_PATH = "C:/jiminsub/tmp.csv";
	
	public static void main(String[] args) {
		ExportToExcelByQuery obj = new ExportToExcelByQuery(new AS400());
		try{		
			obj.excute(DEFAULT_PATH, getQuery());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	/**
	 * yyyymmdd형식의 시작날짜와 끝날짜를 입력해서 실행
	 */

	public static String getQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT BMSBDT, BMSBKN, BMSTRD, BMSLIN, BMSROT, BMSVVD, TRIM(VALUE(VSLDES,''))||'   V   '||SUBSTR(BMSVVD,5,4) VSL_DES ");
		sb.append("     , BMSPOR, VALUE(POR.LOCDES,'') POR_DES ");
		sb.append("     , BMSPOL, VALUE(POL.LOCDES,'') POL_DES ");
		sb.append("     , BMSPOD, VALUE(POD.LOCDES,'') POD_DES ");
		sb.append("     , BMSPVY, VALUE(PVY.LOCDES,'') PVY_DES ");
		sb.append("     , BMSSHP, BMSSHD, BMSASH, BMSASD, BMSSAL, VALUE(SALDES,'') SAL_DES, BMSBPS ");
		sb.append("     , BMSINP, BMSIND, BMSINT, BMSUPP, BMSUPD, BMSUPT ");
		sb.append(" FROM PLIBBK.BKGAMSTR ");
		sb.append(" LEFT OUTER JOIN PLIBCD.CODAVESL VSL ON SUBSTR(BMSVVD,1,4)=VSLCOD ");
		sb.append(" LEFT OUTER JOIN PLIBCD.CODALOCA POR ON POR.LOCCOD=BMSPOR ");
		sb.append(" LEFT OUTER JOIN PLIBCD.CODALOCA POL ON POL.LOCCOD=BMSPOL ");
		sb.append(" LEFT OUTER JOIN PLIBCD.CODALOCA POD ON POD.LOCCOD=BMSPOD ");
		sb.append(" LEFT OUTER JOIN PLIBCD.CODALOCA PVY ON PVY.LOCCOD=BMSPVY ");
		sb.append(" LEFT OUTER JOIN PLIBCD.CODAZSAL SAL ON BMSSAL=SALCOD ");
		sb.append(" WHERE BMSIND >= 20140101 AND 'CNSHA' IN (BMSPOR, BMSPOL) ");
		sb.append(" ORDER BY BMSBDT, BMSBKN ");

		
		return sb.toString();
	}

}
