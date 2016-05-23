package com.minsub.jdbc.db2;

public class Query20140715 implements QueryBuilder{

	public static final String DEFAULT_PATH = "C:/jiminsub/";
	public static String[][] arr =  { {"20130101","20130199"}, 
									  {"20130201","20130299"},
									  {"20130301","20130399"},
									  {"20130401","20130499"},
									  {"20130501","20130599"},
									  {"20130601","20130699"},
									  {"20130701","20130799"},
									  {"20130801","20130899"},
									  {"20130901","20130999"},
									  {"20131001","20131099"},
									  {"20131101","20131199"},
									  {"20131201","20131299"}, };
	
	public static void main(String[] args) {
		ExportToExcelByQuery obj = new ExportToExcelByQuery(new AS400());
		try{		
			// Sql
			QueryBuilder sqlBuilder = new Query20140715();
			String path = null;
			for (int i=0; i < arr.length; i++) {
				path = DEFAULT_PATH + "BKG_DATA_"+ arr[i][0]+ "_" + arr[i][1] + ".csv";
				obj.excute(path, sqlBuilder.getQuery(arr[i][0], arr[i][1]));
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	@Override
	public String getQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * ");
		sb.append("FROM PLIBMK.MPLAFDTL ");
		sb.append("where DTLBNO = 'HTOH1246550' ");
		
		return null;
	}
	
	/**
	 * yyyymmdd형식의 시작날짜와 끝날짜를 입력해서 실행
	 */
	@Override
	public String getQuery(String StartDate, String EndDate) {
		StringBuilder sb = new StringBuilder();
		sb.append("  WITH BASE_RAW AS (  ");
		sb.append("  SELECT BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, SCH_VVD, SCH_POT  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN MAX(DIGITS(DEC(VALUE(LTDEDT,0),8,0))||DIGITS(DEC(VALUE(LTDEDH,0),4,0))) ELSE ETA END) ETA  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN VALUE(LTDVVD,'') ELSE CHK_SCH END) CHK_SCH  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN MAX(DIGITS(DEC(VALUE(LTDCDT,0),8,0))||DIGITS(DEC(VALUE(LTDCDH,0),4,0))) ELSE CUT_OFF_DRY END) CUT_OFF_DRY  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN MAX(DIGITS(DEC(VALUE(LTDCRT,0),8,0))||DIGITS(DEC(VALUE(LTDCRH,0),4,0))) ELSE CUT_OFF_RF END) CUT_OFF_RF  ");
		sb.append("  FROM(  ");
		sb.append("  SELECT BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, SCH_VVD, SCH_POT  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN MAX(DIGITS(DEC(VALUE(LTDEDT,0),8,0))||DIGITS(DEC(VALUE(LTDEDH,0),4,0))) ELSE ETA END) ETA  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN VALUE(LTDVVD,'') ELSE CHK_SCH END) CHK_SCH  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN MAX(DIGITS(DEC(VALUE(LTDCDT,0),8,0))||DIGITS(DEC(VALUE(LTDCDH,0),4,0))) ELSE CUT_OFF_DRY END) CUT_OFF_DRY  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN MAX(DIGITS(DEC(VALUE(LTDCRT,0),8,0))||DIGITS(DEC(VALUE(LTDCRH,0),4,0))) ELSE CUT_OFF_RF END) CUT_OFF_RF  ");
		sb.append("  FROM(  ");
		sb.append("  SELECT BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, SCH_VVD, SCH_POT  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN MAX(DIGITS(DEC(VALUE(LTDEDT,0),8,0))||DIGITS(DEC(VALUE(LTDEDH,0),4,0))) ELSE ETA END) ETA  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN VALUE(LTDVVD,'') ELSE CHK_SCH END) CHK_SCH  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN MAX(DIGITS(DEC(VALUE(LTDCDT,0),8,0))||DIGITS(DEC(VALUE(LTDCDH,0),4,0))) ELSE CUT_OFF_DRY END) CUT_OFF_DRY  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN MAX(DIGITS(DEC(VALUE(LTDCRT,0),8,0))||DIGITS(DEC(VALUE(LTDCRH,0),4,0))) ELSE CUT_OFF_RF END) CUT_OFF_RF  ");
		sb.append("  FROM(  ");
		sb.append("  SELECT BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, SCH_VVD, SCH_POT  ");
		sb.append("      , MAX(DIGITS(DEC(VALUE(LTDEDT,0),8,0))||DIGITS(DEC(VALUE(LTDEDH,0),4,0))) ETA, VALUE(LTDVVD,'') CHK_SCH  ");
		sb.append("      , MAX(DIGITS(DEC(VALUE(LTDCDT,0),8,0))||DIGITS(DEC(VALUE(LTDCDH,0),4,0))) CUT_OFF_DRY  ");
		sb.append("      , MAX(DIGITS(DEC(VALUE(LTDCRT,0),8,0))||DIGITS(DEC(VALUE(LTDCRH,0),4,0))) CUT_OFF_RF  ");
		sb.append("  FROM(  ");
		sb.append("  SELECT BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD  ");
		sb.append("      , (CASE WHEN BMSPVD='' THEN BMSVVD ELSE BMSPVD END) SCH_VVD  ");
		sb.append("      , (CASE WHEN BMSFOL<>'' THEN BMSFOL WHEN BMSPOR<>'' THEN BMSPOR WHEN BMSPOL<>'' THEN BMSPOL END) SCH_POT  ");
		sb.append("  FROM PLIBBK.BKGAMSTR A, PLIBMK.MKTATRD B  ");
		sb.append("  WHERE BMSIND BETWEEN " + StartDate + " AND " + EndDate);
		sb.append("      AND BMSTRD=TMPTRD AND SUBSTR(BMSVVD,8,1)=TMPBND AND BMSROT=TMPROT  ");
		sb.append("  ) A  ");
		sb.append("  LEFT OUTER JOIN PLIBOP.VOPALTMD B ON LTDKND='A' AND LTDVVD=SCH_VVD AND LTDPOT=SCH_POT  ");
		sb.append("  GROUP BY BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, SCH_VVD, SCH_POT, VALUE(LTDVVD,'')  ");
		sb.append("  ) A  ");
		sb.append("  LEFT OUTER JOIN PLIBOP.VOPALTMD B ON LTDKND='C' AND LTDVVD=SCH_VVD AND LTDPOT=SCH_POT AND CHK_SCH=''  ");
		sb.append("  GROUP BY BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, SCH_VVD, SCH_POT, ETA, CHK_SCH  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN VALUE(LTDVVD,'') ELSE CHK_SCH END), CUT_OFF_DRY, CUT_OFF_RF  ");
		sb.append("  ) A  ");
		sb.append("  LEFT OUTER JOIN PLIBOP.VOPALTMD B ON LTDKND='L' AND LTDVVD=SCH_VVD AND LTDPOT=SCH_POT AND CHK_SCH=''  ");
		sb.append("  GROUP BY BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, SCH_VVD, SCH_POT, ETA, CHK_SCH  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN VALUE(LTDVVD,'') ELSE CHK_SCH END), CUT_OFF_DRY, CUT_OFF_RF  ");
		sb.append("  ) A  ");
		sb.append("  LEFT OUTER JOIN PLIBOP.VOPALTMD B ON LTDKND='F' AND LTDVVD=SCH_VVD AND LTDPOT=SCH_POT AND CHK_SCH=''  ");
		sb.append("  GROUP BY BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, SCH_VVD, SCH_POT, ETA, CHK_SCH  ");
		sb.append("      , (CASE WHEN CHK_SCH='' THEN VALUE(LTDVVD,'') ELSE CHK_SCH END), CUT_OFF_DRY, CUT_OFF_RF  ");
		sb.append("  )   ");
		sb.append("  SELECT BMSCAN BKG_CANCEL, BMSBKN BKG_NUMBER, BMSIND BKG_DATE, BMSINT BKG_TIME, BMSAGT AGENT, TMPTRD TRADE, TMPBND BOUND, TMPHNB Haul, BMSVVD VVD  ");
		sb.append("      , BDSTYP TYPE, BDSSIZ SIZE, BDSQTY QTY, BKG_TEU, CUT_OFF_DRY, CUT_OFF_RF, ETA, VALUE(BINBNO,'') BL_NUMBER  ");
		sb.append("      , DTLTOT FREIGHT, DTLTYP TYPE_BL, DTLSIZ SIZE_BL, DTLTEU TEU_BL, DTLC2T CM2_PER_TEU   ");
		sb.append("  FROM(  ");
		sb.append("  SELECT BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, ETA, CUT_OFF_DRY, CUT_OFF_RF  ");
		sb.append("      , BDSTYP, BDSSIZ, SUM(BDSQTY) BDSQTY, SUM(CASE WHEN BDSTYP LIKE '2%' THEN BDSQTY ELSE BDSQTY*2 END) BKG_TEU  ");
		sb.append("  FROM BASE_RAW A, PLIBBK.BKGACNTR B  ");
		sb.append("  WHERE BMSBKN=BDSBKN  ");
		sb.append("  GROUP BY BMSCAN, BMSBKN, BMSIND, BMSINT, BMSAGT, TMPTRD, TMPBND, TMPHNB, TMPROT, BMSVVD, ETA, CUT_OFF_DRY, CUT_OFF_RF  ");
		sb.append("          , BDSTYP, BDSSIZ  ");
		sb.append("  ) A  ");
		sb.append("  LEFT OUTER JOIN PLIBSD.BKGAINDX C ON BINBKN = BMSBKN  ");
		sb.append("  LEFT OUTER JOIN PLIBMK.MPLAFDTL D ON BINBNO = DTLBNO  ");

		
		return sb.toString();
	}

}
