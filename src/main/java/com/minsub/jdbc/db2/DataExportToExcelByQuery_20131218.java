package com.minsub.jdbc.db2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DataExportToExcelByQuery_20131218 {

	private Connection con = null;
	
	public static void main(String[] args){
		DataExportToExcelByQuery_20131218 obj = new DataExportToExcelByQuery_20131218();
		try{		
			obj.excute();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
		}
	}
	
	public void excute(){
		
		Statement stmt = null;
		ResultSet rs = null;
		
		BufferedWriter bw = null;
		String[] sysData = null;
		
		try{
			
			//����� Excel File ��ġ ����
			String as400ID  = "DPBIZOYH";
			String as400PWD = "";
			//sysData = CommonUtil.getSystemDate(this.getConnection(as400ID, as400PWD));
			bw = new BufferedWriter(new FileWriter("D:\\ExportByQuery_"+sysData[0]+sysData[1]+".csv"));
	
			
			stmt= this.getConnection(as400ID, as400PWD).createStatement();
			
			/////////////////////////////////////////////////////////////////////////////
			// ���⸸ ����
			// Main ����
			//String query = getQueryDemDetTemp_Import_20131218_LeeSukJun("A041242413"); //Import
			//String query = getQueryDemDetTemp_Import_20131218_LeeSukJun("A041242417"); //Export
			//String query = getQueryDemDetInvoiceFromLeeSukJun_20131227("20130701", "20131231"); //Export			
			//String query = getQueryDemDetReceiptFromLeeSukJun_20131227("20130701", "20131231");
			//String query = getQueryInvoiceTermAnal_20140415_KimHyungKi();
			//String query = getQueryIRN_CJAC_ALL_20140418_JoTaeYeon();
			//String query = getQueryChassisUseDays_LEEJIHYUN_20140429();
			
			//String query = getQueryRF_TATime_SongHyundBok_20140513("IN", "S", "20140101", "20140431");
			//String query = getQueryRF_TATime_SongHyundBok_20140513("IN", "D", "20140101", "20140431");
			
			//String query = getQueryRF_TATime_SongHyundBok_20140513("OUT", "S", "20140101", "20140431");
			//String query = getQueryRF_TATime_SongHyundBok_20140513("OUT", "D", "20140101", "20140431");
			
			//String query = getQueryRF_TATime_SongHyundBok_20140513("TS", "S", "20140101", "20140431");
			//String query = getQueryRF_TATime_SongHyundBok_20140513("TS", "D", "20140101", "20140431");
			
			//String query = getQueryRF_TATime_SongHyundBok_20140513("IN", "S", "20130101", "20131231");
			//String query = getQueryRF_TATime_SongHyundBok_20140513("OUT", "S", "20130101", "20131231");
			//String query = getQueryRF_TATime_SongHyundBok_20140513("TS", "S", "20130101", "20131231");

			//String query = "SELECT * FROM PLIBTEMP.DEMAT50711 WHERE TMPID='B003557934'" ;//�迵�� ���� 5071 ������ ��û
			//String query = "SELECT * FROM PLIBTEMP.DEMAT50711 WHERE TMPID='B003566867'";
			
			//String query = getQuery5071Result("B003566867");
			
			
			//String query = getQueryRFDwellTimeAtVN_ParkJungSu_20140521("20100101","20131231");
			//String query = getQueryRFDwellTimeAtVN_ParkJungSu_20140522("20100101","20131231");
			//String query = "SELECT ITADSC FROM PLIBWINS.ITAMST WHERE ITADAT=20140106";

			//String query = getQueryVFGap_ChoiWonKyu_20140611("11");
			//String query = getQueryVFGap_ChoiWonKyu_20140611("12");
			//String query = getQueryVFGap_ChoiWonKyu_20140611("13");
			
			//String query =  getQueryDemDetSummaryByCustomer_KimByundSu_20140620("20110101","20111231");
			//String query =  getQueryDemDetSummaryByCustomer_KimByundSu_20140620("20120101","20121231");
			//String query =  getQueryDemDetSummaryByCustomer_KimByundSu_20140620("20130101","20131231");
			//String query =  getQueryDemDetSummaryByCustomer_KimByundSu_20140620("20140101","20140430");
			
			//String query = getQuery_Mkt("201101","201106");
			//String query = getQuery_Mkt("201107","201112");
			//String query = getQuery_Mkt("201201","201206");
			//String query = getQuery_Mkt("201207","201212");
			//String query = getQuery_Mkt("201301","201306");
			//String query = getQuery_Mkt("201307","201312");
			String query = getQuery_Mkt("201401","201404");
		
			
			/////////////////////////////////////////////////////////////////////////////
			
			System.out.println(query);
			
			//Main ���� ����
			System.out.println("Master Query Start....");
			rs = stmt.executeQuery( query );
			System.out.println("Master Query End....");
			
			boolean isFirst = true;
			ResultSetMetaData meta = null;
			int cnt = 0;
			while(rs.next()){
				
				//Head Column ���
				if(isFirst){
					meta = rs.getMetaData();
					//Column ���� Write
					for(int i=0; i<meta.getColumnCount(); i++){
						bw.write(meta.getColumnName(i+1));
						bw.write(",");
					}
					bw.write("\n");
					isFirst = false;
				}
				
				cnt++;
				if(cnt%100==0){
					System.out.println("Count : " + cnt);
					bw.flush();
				}
				
				//Column ���� Write
				for(int i=0; i<meta.getColumnCount(); i++){
					String temp= rs.getString(i+1);
					if(temp!=null){
						bw.write(rs.getString(i+1).replace(',', ' '));
					}else{
						bw.write(" ");
					}
					bw.write(",");
				}
				bw.write("\n");
				/*
				int dGap = 0;
				int hGap = 0;
				String from = rs.getString("CMVMDT") + com.hmm.eqp.common.util.CommonUtil.lpad(rs.getString("CMVTIM"), '0', 4) + "00";
				String to   = rs.getString("VFDATE") + com.hmm.eqp.common.util.CommonUtil.lpad(rs.getString("VFTIME"), '0', 4) + "00";
				dGap = com.hmm.eqp.common.util.CommonUtil.daysBetween(from.substring(0,8), to.substring(0,8));
				hGap = com.hmm.eqp.common.util.CommonUtil.hoursBetween(from, to);
				bw.write(",");
				bw.write(String.valueOf(dGap));
				bw.write(",");
				bw.write(String.valueOf(hGap));
								
				
				*/
			}			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
				try {
					bw.close();
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	private String getQueryIRN_CJAC_ALL_20140418_JoTaeYeon() {
		// TODO Auto-generated method stub
		
		return "SELECT * FROM PLIBEQ.DEMASUMM WHERE OUTSNO='CJAC' AND OUTAGT='IRN' AND OUTDD1>=20130101";
	}

	private String getQueryDemDetInvoiceFromLeeSukJun_20131227(String from, String to){
		StringBuffer buf = new StringBuffer();
		buf.append(" SELECT  INMAGT AS Agent                                                             \n");
		buf.append("        ,IVDIVO AS InvoiceNo                                                        \n");
		buf.append("        ,IVDBNO AS BLNo                                                           \n");
		buf.append("        ,IVDCNO AS ContainerNo                                                     \n");
		buf.append("        ,IVDKIN AS Kind                                                              \n");
		buf.append("        ,(CASE WHEN IVDADA<>0 THEN IVDADA                                              \n");
		buf.append("               WHEN IVDAM1=0 AND IVDAM2=0 AND IVDAM3=0 AND IVDAM4=0 THEN IVDADA        \n");
		buf.append("               ELSE IVDUAM                                                             \n");
		buf.append("          END) AS Amount                                                             \n");
		buf.append("        ,INMIND AS InvoiceDate                                                      \n");
		buf.append("        ,(CASE WHEN IVDCNO='ADMINFEE' THEN (SELECT MAX(DCNDT2)                         \n");
		buf.append("                                              FROM PLIBEQ.DEMACNTF S1                  \n");
		buf.append("                                             WHERE S1.DCNBNO=IVDBNO                    \n");
		buf.append("                                               AND S1.DCNAGT=IVDAGT                    \n");
		buf.append("                                               AND IVDKIN=S1.DCNKIN                    \n");
		buf.append("                                               AND IVDBND=DCNBND )                     \n");
		buf.append("               ELSE (SELECT DCNDT2 FROM PLIBEQ.DEMACNTF S1                             \n");
		buf.append("                      WHERE S1.DCNBNO=IVDBNO AND S1.DCNCNO=IVDCNO                      \n");
		buf.append("                        AND S1.DCNAGT=IVDAGT AND IVDKIN=S1.DCNKIN AND IVDBND=DCNBND )  \n");
		buf.append("          END) AS EndDate                                                           \n");
		buf.append("        ,IVDBND AS Bound                                                             \n");
		buf.append(" FROM PLIBAR.WARAINVM                                                                  \n");
		buf.append(" JOIN PLIBEQ.DEMAIVDF                                                                  \n");
		buf.append("   ON INMAGT=IVDAGT                                                                    \n");
		buf.append("  AND INMINO=IVDIVO                                                                    \n");
		buf.append(" WHERE INMCLS='DEM' AND INMIND>="+from+"                                               \n");
		buf.append("   AND INMIND<="+to+"                                                                \n");
		buf.append("   AND IVDCNO NOT IN ('BSS','EDS')                                                     \n");
		buf.append(" WITH UR                                                                               \n");
		
		return buf.toString();
	}
	private String getQueryDemDetReceiptFromLeeSukJun_20131227(String from, String to){
		StringBuffer buf = new StringBuffer();
		
		buf.append(" SELECT INMAGT AS Agent                                               \n");
		buf.append("       ,INMINO as InvoiceNo                                               \n");
		buf.append("       ,RCDBNO as BLNo                                               \n");
		buf.append("       ,RCDCNO as ContainerNo                                               \n");
		buf.append("       ,RCDKND as Kind                                               \n");
		buf.append("       ,RCDUAM as Amount                                               \n");
		buf.append("       ,INMIND as InvoiceDate                                               \n");
		buf.append("       ,RCMRDT as ReceiptDate                                               \n");
		buf.append("       ,(SELECT MAX(DCNDT2) FROM PLIBEQ.DEMACNTF S1           \n");
		buf.append("          WHERE S1.DCNBNO=RCDBNO                              \n");
		buf.append("            AND S1.DCNCNO=RCDCNO                              \n");
		buf.append("            AND S1.DCNAGT=INMAGT ) as EndDate                            \n");
		buf.append("   FROM PLIBAR.WARARCPM A                                     \n");
		buf.append("       ,PLIBAR.WARARCPD B                                     \n");
		buf.append("       ,PLIBAR.WARAINVM C                                     \n");
		buf.append(" WHERE RCMRNO=RCDRNO                                          \n");
		buf.append("    AND INMINO=RCDINO                                         \n");
		buf.append("    AND RCMCLS='DEM'                                          \n");
		buf.append("    AND RCMRDT>="+from+"                                      \n");
		buf.append("    AND RCMRDT<="+to+"                                        \n");
		buf.append("    AND RCDCNO NOT IN ('BSS','EDS')                           \n");
		buf.append(" WITH UR                                                      \n");

		
		return buf.toString();
	}
	private String getQueryDemDetTemp_Import_20131218_LeeSukJun(String tmpid) {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		
		buf.append(" SELECT    OUTKIN,                                             \n");
		buf.append("           OUTDEP,                                             \n");
		buf.append("           OUTTRD,                                             \n");
		buf.append("           OUTLIN,                                             \n");
		buf.append("           OUTROT,                                             \n");
		buf.append("           OUTPORARA,                                          \n");
		buf.append("           OUTPOR,                                             \n");
		buf.append("           OUTPVYARA,                                          \n");
		buf.append("           OUTPVY,                                             \n");
		buf.append("           OUTCNO, OUTTYP, OUTSIZ,                             \n");
		buf.append("           OUTSNO, OUTSCD,                                     \n");
		buf.append("           FRTPOL,FRTPOD,                                      \n");
		buf.append("                                                               \n");
		buf.append("           SUM(OUTOVD)     OUTOVD,                             \n");
		buf.append("           SUM(OUTDFD)     OUTDFD,                             \n");
		buf.append("           SUM(OUTUNT)     OUTUNT,                             \n");
		buf.append("           SUM(OUTTEU)     OUTTEU,                             \n");
		buf.append("           SUM(OUTBAM)     OUTBAM,                             \n");
		buf.append("           SUM(OUTGTTL)    OUTGTTL,                            \n");
		buf.append("           SUM(OUTCAM)     OUTCAM,                             \n");
		buf.append("           SUM(OUTIAM)     OUTIAM,                             \n");
		buf.append("           SUM(OUTRAM)     OUTRAM,                             \n");
		buf.append("           SUM(OUTSAM)     OUTSAM                              \n");
		buf.append("                                                               \n");
		buf.append("      FROM   PLIBTEMP.DEMAT51306 A                             \n");
		buf.append("            ,PLIBSD.WSDAMST B                                  \n");
		buf.append("      WHERE  OUTBNO = FRTBNO                                   \n");
		buf.append("      AND    OUTDEP<>'ZZ' AND TMPID='"+tmpid+"'                \n");
		buf.append("                                                               \n");
		buf.append("                                                               \n");
		buf.append("      GROUP BY                                                 \n");
		buf.append("                                                               \n");
		buf.append("             OUTDEP,                                           \n");
		buf.append("             OUTTRD,                                           \n");
		buf.append("             OUTLIN,                                           \n");
		buf.append("             OUTROT,                                           \n");
		buf.append("             OUTPOR,                                           \n");
		buf.append("             OUTPORARA,                                        \n");
		buf.append("             OUTPVY,                                           \n");
		buf.append("             OUTPVYARA,                                        \n");
		buf.append("             OUTCNO,                                           \n");
		buf.append("             OUTTYP, OUTSIZ,                                   \n");
		buf.append("             OUTSNO, OUTSCD,                                   \n");
		buf.append("             FRTPOL, FRTPOD,                                   \n");		
		buf.append("             OUTKIN                                            \n");
		buf.append("                                                               \n");
		buf.append("      ORDER  BY                                                \n");
		buf.append("             OUTKIN,OUTSNO                                     \n");
	
		buf.append("    WITH UR                                                         \n");
		
		
		return buf.toString();
	}
	
	private String getQueryInvoiceTermAnal_20140415_KimHyungKi() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		
		buf.append(" SELECT OUTAGT                       \n");
		buf.append("       ,OUTKIN                       \n");
		buf.append("       ,OUTBND                       \n");
		buf.append("       ,OUTBNO                       \n");
		buf.append("       ,OUTCNO                       \n");
		buf.append("       ,OUTIAM AS INVOID_AMT         \n");
		buf.append("       ,OUTDD1 AS START_DATE         \n");
		buf.append("       ,OUTDD2 AS END_DATE           \n");
		buf.append("       ,OUTCH_IV AS INVOICE_GAP      \n");
		buf.append("       ,OUTRE_IV AS INV_RECV_GAP      \n");
		buf.append("       ,OUTRM_RE AS RECV_REMM_GAP      \n");
		buf.append("   FROM PLIBEQ.DEMASUMM              \n");
		buf.append("  WHERE OUTDD2>=20140101             \n");
		buf.append("    AND OUTDD2<=20140331             \n");
		buf.append("    AND OUTIAM<>0                    \n");
		buf.append(" WITH UR                             \n");

	
		
		
		return buf.toString();
	}

	public static String addDays(String src, int days){
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
		try {
			Date a = sf.parse(src);
			Date b = new Date(a.getTime() + (60*1000*60*24*days));
			//System.out.println(sf.format(a));
			return sf.format(b);			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return src;
	}
	
	private Connection getConnection(String id, String pwd) throws Exception
	{
		
		if(this.con == null){		
			try
			{
				String DRIVER_NAME = "com.ibm.as400.access.AS400JDBCDriver";		
				//String url = "jdbc:as400://203.242.35.200";
				//Class.forName(DRIVER_NAME);
				//con_AS400 = DriverManager.getConnection(url,"DPBIZOYH", "SUNG10041");
				
				String url = "jdbc:as400://203.242.32.18";
				Class.forName(DRIVER_NAME);
				con = DriverManager.getConnection(url,id, pwd);				
			}
			catch (SQLException e)
			{
				System.out.println("AS400 Ŀ�ؼ��� ���� ���߽��ϴ�.");
				e.printStackTrace();
			}
		}
	    return con;
	}		


	private String getQueryChassisUseDays_LEEJIHYUN_20140429(){
		StringBuffer buf = new StringBuffer();
		buf.append(" SELECT A.*, B.FRTSTA ||'-'|| FRTSTB AS SVC                       \n");
		buf.append("   FROM PLIBTEMP.EQPATOYH A                                       \n");
		buf.append("        LEFT OUTER JOIN                                           \n");
		buf.append("        PLIBSD.WSDAMST B                                          \n");
		buf.append("        ON A.BNO=B.FRTBNO                                         \n");
		buf.append("  where ((BND='I' AND FRTSTB='DR') OR (BND='E' AND FRTSTA='DR') ) \n");
		return buf.toString();
	}
	
	private String getQueryRF_TATime_SongHyundBok_20140513(String inOutTs, String summOrDetail, String fromDate, String toDate){
		StringBuffer buf = new StringBuffer();
		
		if("TS".equals(inOutTs)){
			buf.append(" WITH B_TBL AS (                                                                                    \n");
			buf.append(" SELECT A.*                                                                                         \n");
			buf.append("       ,(CASE WHEN DEEDFLC=DEEDF3LC AND DEEDFDP=DEEDF3DP THEN 2                                     \n");
			buf.append("              WHEN DEEDFLC=DEEDF2LC AND DEEDFDP=DEEDF2DP THEN 1                                     \n");
			buf.append("              WHEN DEEDFLC=DEEDF1LC AND DEEDFDP=DEEDF1DP THEN 0                                     \n");
			buf.append("              WHEN DEEVF4LC<>'' AND DEEDF3LC<>''           THEN 3                                   \n");
			buf.append("              ELSE 5                                                                                \n");
			buf.append("        END) AS TS_CNT                                                                              \n");
			buf.append("        ,SUBSTR(DEEMDT,1,6) AS MONTH                                                                \n");
			buf.append("   FROM PLIBEQ.EQPADEVE A                                                                           \n");
			buf.append("       ,PLIBEQ.EQPAMSTR B                                                                           \n");
			buf.append("       ,PLIBEQ.EQPACMOV C                                                                           \n");
			buf.append("  WHERE A.DEECNO=B.EMSENO                                                                           \n");
			buf.append("    AND C.CMVENO=A.DEECNO                                                                           \n");
			buf.append("    AND C.CMVMDT=A.DEEMDT                                                                           \n");
			buf.append("    AND C.CMVTIM=A.DEETIM                                                                           \n");
			buf.append("    AND C.CMVBTY='RF'                                                                               \n");
			buf.append("    AND A.DEEMDT>="+fromDate+"                                                                          \n");
			buf.append("    AND A.DEEMDT<="+toDate+"                                                                          \n");
			buf.append("    AND (CASE WHEN DEEDFLC=DEEDF3LC AND DEEDFDP=DEEDF3DP THEN 2                                     \n");
			buf.append("              WHEN DEEDFLC=DEEDF2LC AND DEEDFDP=DEEDF2DP THEN 1                                     \n");
			buf.append("              WHEN DEEDFLC=DEEDF1LC AND DEEDFDP=DEEDF1DP THEN 0                                     \n");
			buf.append("              WHEN DEEVF4LC<>'' AND DEEDF3LC<>''           THEN 3                                   \n");
			buf.append("              ELSE 5                                                                                \n");
			buf.append("        END) >0                                                                                     \n");
			buf.append("    AND DEEDFLC<>''                                                                                 \n");
			buf.append(" )                                                                                                  \n");
			buf.append(" ,TS3 AS (                                                                                          \n");
			buf.append(" SELECT                                                                                             \n");
			buf.append("         (DAYS(TIMESTAMP(DEEVF4D||'000000')) - DAYS(TIMESTAMP(DEEDF3D||'000000')) +1) AS TATIME     \n");
			buf.append("        ,DEEVF4D AS TDATE                                                                           \n");
			buf.append("        ,DEEDF3D AS FDATE                                                                           \n");
			buf.append("        ,DEECNO  AS CNO                                                                             \n");
			buf.append("        ,DEEBNO  AS BNO                                                                             \n");
			buf.append("        ,DEEDF3LC AS LCN                                                                            \n");
			buf.append("        ,DEEDF3DP AS DPT                                                                            \n");
			buf.append("        ,'THIRD T/S' AS ORD                                                                         \n");
			buf.append("        ,(CASE WHEN DEEVF4DP=DEEDF3DP THEN 'Y' ELSE 'N' END) AS SD                                  \n");
			buf.append("        ,MONTH                                                                                      \n");
			buf.append("   FROM B_TBL A                                                                                     \n");
			buf.append("  WHERE TS_CNT=3                                                                                    \n");
			buf.append(" )                                                                                                  \n");
			buf.append(" ,TS2 AS (                                                                                          \n");
			buf.append(" SELECT                                                                                             \n");
			buf.append("         (DAYS(TIMESTAMP(DEEVF3D||'000000')) - DAYS(TIMESTAMP(DEEDF2D||'000000')) +1) TATIME        \n");
			buf.append("        ,DEEVF3D AS TDATE                                                                           \n");
			buf.append("        ,DEEDF2D AS FDATE                                                                           \n");
			buf.append("        ,DEECNO  AS CNO                                                                             \n");
			buf.append("        ,DEEBNO  AS BNO                                                                             \n");
			buf.append("        ,DEEDF2LC AS LCN                                                                            \n");
			buf.append("        ,DEEDF2DP AS DPT                                                                            \n");
			buf.append("        ,'SECOND T/S' AS ORD                                                                        \n");
			buf.append("        ,(CASE WHEN DEEVF3DP=DEEDF2DP THEN 'Y' ELSE 'N' END) AS SD                                  \n");
			buf.append("        ,MONTH                                                                                      \n");             
			buf.append("   FROM B_TBL A                                                                                     \n");
			buf.append("  WHERE TS_CNT>=2                                                                                   \n");
			buf.append(" )                                                                                                  \n");
			buf.append(" ,TS1 AS (                                                                                          \n");
			buf.append(" SELECT                                                                                             \n");
			buf.append("         (DAYS(TIMESTAMP(DEEVF2D||'000000')) - DAYS(TIMESTAMP(DEEDF1D||'000000')) +1) TATIME        \n");
			buf.append("        ,DEEVF2D AS TDATE                                                                           \n");
			buf.append("        ,DEEDF1D AS FDATE                                                                           \n");
			buf.append("        ,DEECNO  AS CNO                                                                             \n");
			buf.append("        ,DEEBNO  AS BNO                                                                             \n");
			buf.append("        ,DEEDF1LC AS LCN                                                                            \n");
			buf.append("        ,DEEDF1DP AS DPT                                                                            \n");
			buf.append("        ,'FIRST T/S' AS ORD                                                                         \n");
			buf.append("        ,(CASE WHEN DEEVF2DP=DEEDF1DP THEN 'Y' ELSE 'N' END) AS SD                                  \n");
			buf.append("        ,MONTH                                                                                      \n");
			buf.append("   FROM B_TBL A                                                                                     \n");
			buf.append("  WHERE TS_CNT>=1                                                                                   \n");
			buf.append(" )                                                                                                  \n");
			buf.append(" ,SUM_T AS (                                                                                        \n");
			buf.append(" SELECT * FROM TS3                                                                                  \n");
			buf.append(" UNION                                                                                              \n");
			buf.append(" SELECT * FROM TS2                                                                                  \n");
			buf.append(" UNION                                                                                              \n");
			buf.append(" SELECT * FROM TS1                                                                                  \n");
			buf.append(" )                                                                                                  \n");
			
			
		}else if("OUT".equals(inOutTs)){
			buf.append(" WITH B_TBL AS (                                                                                  \n");
			buf.append(" SELECT A.*                                                                                       \n");
			buf.append("        ,SUBSTR(DEEMDT,1,6) AS MONTH                                                              \n");
			buf.append("   FROM PLIBEQ.EQPADEVE A                                                                         \n");
			buf.append("       ,PLIBEQ.EQPAMSTR B                                                                         \n");
			buf.append("       ,PLIBEQ.EQPACMOV C                                                                         \n");
			buf.append("  WHERE A.DEECNO=B.EMSENO                                                                         \n");
			buf.append("    AND C.CMVENO=A.DEECNO                                                                         \n");
			buf.append("    AND C.CMVMDT=A.DEEMDT                                                                         \n");
			buf.append("    AND C.CMVTIM=A.DEETIM                                                                         \n");
			buf.append("    AND C.CMVBTY='RF'                                                                             \n");
			buf.append("    AND A.DEEMDT>="+fromDate+"                                                                          \n");
			buf.append("    AND A.DEEMDT<="+toDate+"                                                                          \n");
			buf.append("    AND DEEVFLC<>''                                                                               \n");
			buf.append(" )                                                                                                \n");
			buf.append(" ,SUM_T AS (                                                                                      \n");
			buf.append(" SELECT                                                                                           \n");
			buf.append("         (DAYS(TIMESTAMP(DEEVFD||'000000')) - DAYS(TIMESTAMP(DEELFD||'000000')) +1) AS TATIME     \n");
			buf.append("        ,DEEVFD AS TDATE                                                                          \n");
			buf.append("        ,DEELFD AS FDATE                                                                          \n");
			buf.append("        ,DEECNO  AS CNO                                                                           \n");
			buf.append("        ,DEEBNO  AS BNO                                                                           \n");
			buf.append("        ,DEELFLC AS LCN                                                                           \n");
			buf.append("        ,DEELFDP AS DPT                                                                           \n");
			buf.append("        ,'OUTBOUND' AS ORD                                                                        \n");
			buf.append("        ,(CASE WHEN DEEVFDP=DEELFDP THEN 'Y' ELSE 'N' END) AS SD                                  \n");
			buf.append("        ,MONTH                                                                                    \n");
			buf.append("   FROM B_TBL A                                                                                   \n");
			buf.append(" )                                                                                                \n");
			
		}else if("INT".equals(inOutTs)){
			buf.append(" WITH B_TBL AS (                                                                                   \n");
			buf.append(" SELECT A.*                                                                                        \n");
			buf.append("        ,(CASE WHEN DEETID>0 THEN DEETID                                                           \n");
			buf.append("               WHEN DEEOID>0 THEN DEEOID                                                           \n");
			buf.append("               ELSE DEECFD                                                                         \n");
			buf.append("           END) AS TO_DATE                                                                         \n");
			buf.append("        ,(CASE WHEN DEETID>0 THEN DEETILC                                                          \n");
			buf.append("               WHEN DEEOID>0 THEN DEEOILC                                                          \n");
			buf.append("               ELSE DEECFLC                                                                        \n");
			buf.append("           END) AS TO_LCN                                                                          \n");
			buf.append("        ,(CASE WHEN DEETID>0 THEN DEETIDP                                                          \n");
			buf.append("               WHEN DEEOID>0 THEN DEEOIDP                                                          \n");
			buf.append("               ELSE DEECFDP                                                                        \n");
			buf.append("           END) AS TO_DPT                                                                          \n");
			buf.append("         ,SUBSTR(A.DEEMDT,1,6) AS MONTH                                                            \n");
			buf.append("   FROM PLIBEQ.EQPADEVE A                                                                          \n");
			buf.append("       ,PLIBEQ.EQPAMSTR B                                                                          \n");
			buf.append("       ,PLIBEQ.EQPACMOV C                                                                          \n");
			buf.append("  WHERE A.DEECNO=B.EMSENO                                                                          \n");
			buf.append("    AND C.CMVENO=A.DEECNO                                                                          \n");
			buf.append("    AND C.CMVMDT=A.DEEMDT                                                                          \n");
			buf.append("    AND C.CMVTIM=A.DEETIM                                                                          \n");
			buf.append("    AND C.CMVBTY='RF'                                                                              \n");
			buf.append("    AND A.DEEMDT>="+fromDate+"                                                                          \n");
			buf.append("    AND A.DEEMDT<="+toDate+"                                                                          \n");
			buf.append("    AND DEECFLC<>''                                                                                \n");
			buf.append(" )                                                                                                 \n");
			buf.append("  ,SUM_T AS (                                                                                      \n");
			buf.append(" SELECT                                                                                            \n");
			buf.append("         (DAYS(TIMESTAMP(TO_DATE||'000000')) - DAYS(TIMESTAMP(DEEDFD||'000000')) +1) AS TATIME     \n");
			buf.append("        ,TO_DATE AS TDATE                                                                          \n");
			buf.append("        ,DEEDFD AS FDATE                                                                           \n");
			buf.append("        ,DEECNO  AS CNO                                                                            \n");
			buf.append("        ,DEEBNO  AS BNO                                                                            \n");
			buf.append("        ,DEEDFLC AS LCN                                                                            \n");
			buf.append("        ,DEEDFDP AS DPT                                                                            \n");
			buf.append("        ,'INBOUND' AS ORD                                                                          \n");
			buf.append("        ,(CASE WHEN DEEDFDP=TO_DPT THEN 'Y' ELSE 'N' END) AS SD                                    \n");
			buf.append("        ,MONTH                                                                                     \n");
			buf.append("   FROM B_TBL A                                                                                    \n");
			buf.append(" )                                                                                                 \n");
		}
		
		
		
		
		if("S".equals(summOrDetail)){
			buf.append("  SELECT LCN AS Location                                                                  \n");
			buf.append("        ,DPT AS Depot                                                                     \n");
			buf.append("        ,SUM(TATIME) AS Sum_TATime                                                        \n");
			buf.append("        ,COUNT(1) AS QTY                                                                  \n");
			buf.append("        ,SUM(TATIME)/COUNT(1) AS AVG                                                      \n");
			buf.append("        ,(CASE WHEN SD='Y' THEN '�ںε�' ELSE 'Ÿ�ε�' END) AS SamePortYN                 \n");
			buf.append("        ,(SELECT FRTDEP FROM PLIBSD.WSDAMST S1 WHERE S1.FRTBNO=BNO) AS DEPT               \n");
			//buf.append("        ,MONTH                                                                            \n");
			buf.append("    FROM SUM_T                                                                            \n");
			//buf.append("  GROUP BY LCN,DPT,SD,(SELECT FRTDEP FROM PLIBSD.WSDAMST S1 WHERE S1.FRTBNO=BNO),MONTH    \n");
			buf.append("  GROUP BY LCN,DPT,SD,(SELECT FRTDEP FROM PLIBSD.WSDAMST S1 WHERE S1.FRTBNO=BNO)          \n");			
			//buf.append(" ORDER BY MONTH,LCN,DPT,SD                                                                \n");
			buf.append(" ORDER BY LCN,DPT,SD                                                                \n");			
			buf.append(" WITH UR                                                                                  \n");			
		}else{
			buf.append("  SELECT MONTH AS Month                \n");
			buf.append("        ,LCN AS Location               \n");
			buf.append("        ,DPT AS Depot                  \n");
			buf.append("        ,SD  AS SamePortYN             \n");
			buf.append("        ,CNO AS ContainerNo            \n");
			buf.append("        ,BNO AS BL_No                  \n");
			buf.append("        ,FDATE AS From_Date            \n");
			buf.append("        ,TDATE AS TO_Date              \n");
			buf.append("        ,TATIME AS TATIME             \n");
			buf.append("        ,ORD AS Sequence               \n");
			buf.append("        ,FRTDEP AS DEPT                \n");
			buf.append("        ,FRTSHC AS Shipper             \n");
			buf.append("        ,KBLSHA AS Shipper_Desc        \n");
			buf.append("        ,FRTCNC AS Consignee           \n");
			buf.append("        ,KBLCNA as Consignee_Desc      \n");
			buf.append("        ,FRTIT1 AS Commodity1          \n");
			buf.append("        ,FRTIT2 AS Commodity2          \n");
			buf.append("        ,KBLI1D AS Commodity1_Desc     \n");
			buf.append("        ,KBLI2D AS Commodity2_Desc     \n");
			buf.append("    FROM SUM_T A                       \n");
			buf.append("         LEFT OUTER JOIN               \n");
			buf.append("         PLIBSD.WSDAMST S1             \n");
			buf.append("         ON S1.FRTBNO=BNO              \n");
			buf.append("         LEFT OUTER JOIN               \n");
			buf.append("         PLIBSD.WSDASRH S2             \n");
			buf.append("         ON S1.FRTBNO = S2.KBLBNO      \n");
			buf.append("  ORDER BY MONTH, CNO,FDATE ASC        \n");
			buf.append("  WITH UR                              \n");
		}
				
				
		return buf.toString();
	}
	private String getQueryRFDwellTimeAtVN_ParkJungSu_20140521(String from, String to){
		StringBuffer buf = new StringBuffer();
		buf.append(" SELECT CMVVVD                                                                                                                                                                            \n");
		buf.append("       ,CMVLCN                                                                                                                                                                            \n");
		buf.append("       ,CMVDPT                                                                                                                                                                            \n");
		buf.append("       ,CMVENO                                                                                                                                                                            \n");
		buf.append("       ,CMVBTY                                                                                                                                                                            \n");
		buf.append("       ,EMSTYP                                                                                                                                                                            \n");
		buf.append("       ,EMSSIZ                                                                                                                                                                            \n");
		buf.append("       ,CMVMDT                                                                                                                                                                            \n");
		buf.append("       ,CMVTIM                                                                                                                                                                            \n");
		buf.append("       ,(SELECT CMVMDT FROM PLIBEQ.EQPACMOV S1 WHERE S1.CMVENO=A.CMVENO AND S1.CMVBNO=A.CMVBNO AND S1.CMVSTA='VF' AND S1.CMVLCN=A.CMVLCN FETCH FIRST 1 ROWS ONLY) AS VFDATE               \n");
		buf.append("       ,(SELECT CMVTIM FROM PLIBEQ.EQPACMOV S1 WHERE S1.CMVENO=A.CMVENO AND S1.CMVBNO=A.CMVBNO AND S1.CMVSTA='VF' AND S1.CMVLCN=A.CMVLCN FETCH FIRST 1 ROWS ONLY) AS VFTIME               \n");
		buf.append("       ,CMVBNO                                                                                                                                                                            \n");
		buf.append("   FROM PLIBEQ.EQPACMOV A                                                                                                                                                                 \n");
		buf.append("       ,PLIBEQ.EQPAMSTR B                                                                                                                                                                 \n");
		buf.append("  WHERE A.CMVENO=B.EMSENO                                                                                                                                                                 \n");
		buf.append("    AND CMVMDT>="+from+"                                                                                                                                                                  \n");
		buf.append("    AND CMVMDT<="+to+"                                                                                                                                                                  \n");
		buf.append("    AND CMVSTA='LF'                                                                                                                                                                       \n");
		buf.append("    AND CMVLCN IN ('VNSGN','VNHPH')                                                                                                                                                       \n");
		buf.append("    AND EMSTYP='RF'                                                                                                                                                                       \n");
		buf.append(" WITH UR                                                                                                                                                                                  \n");
		
		return buf.toString();
	}
	private String getQueryRFDwellTimeAtVN_ParkJungSu_20140522(String from, String to){
		StringBuffer buf = new StringBuffer();
		buf.append(" SELECT CMVVVD                                                                                                                                                                            \n");
		buf.append("       ,CMVLCN                                                                                                                                                                            \n");
		buf.append("       ,CMVDPT                                                                                                                                                                            \n");
		buf.append("       ,CMVENO                                                                                                                                                                            \n");
		buf.append("       ,CMVBTY                                                                                                                                                                            \n");
		buf.append("       ,EMSTYP                                                                                                                                                                            \n");
		buf.append("       ,EMSSIZ                                                                                                                                                                            \n");
		buf.append("       ,CMVMDT                                                                                                                                                                            \n");
		buf.append("       ,CMVTIM                                                                                                                                                                            \n");
		buf.append("       ,(SELECT CMVMDT FROM PLIBEQ.EQPACMOV S1 WHERE S1.CMVENO=A.CMVENO AND S1.CMVBNO=A.CMVBNO AND S1.CMVSTA='CF' AND S1.CMVLCN=A.CMVLCN FETCH FIRST 1 ROWS ONLY) AS CFDATE               \n");
		buf.append("       ,(SELECT CMVTIM FROM PLIBEQ.EQPACMOV S1 WHERE S1.CMVENO=A.CMVENO AND S1.CMVBNO=A.CMVBNO AND S1.CMVSTA='CF' AND S1.CMVLCN=A.CMVLCN FETCH FIRST 1 ROWS ONLY) AS CFTIME               \n");
		buf.append("       ,CMVBNO                                                                                                                                                                            \n");
		buf.append("   FROM PLIBEQ.EQPACMOV A                                                                                                                                                                 \n");
		buf.append("       ,PLIBEQ.EQPAMSTR B                                                                                                                                                                 \n");
		buf.append("  WHERE A.CMVENO=B.EMSENO                                                                                                                                                                 \n");
		buf.append("    AND CMVMDT>="+from+"                                                                                                                                                                  \n");
		buf.append("    AND CMVMDT<="+to+"                                                                                                                                                                  \n");
		buf.append("    AND CMVSTA='DF'                                                                                                                                                                       \n");
		buf.append("    AND CMVLCN IN ('VNHPH')                                                                                                                                                       \n");
		buf.append("    AND EMSTYP='RF'                                                                                                                                                                       \n");
		buf.append(" WITH UR                                                                                                                                                                                  \n");
		
		return buf.toString();
	}
	private String getQuery5071Result(String tmpID){
		StringBuffer buf = new StringBuffer();
		buf.append(" SELECT                                               \n");
		buf.append("  TAGT      AS AGENT                                  \n");
		buf.append(" ,TDAT      AS VESSEL_DATE                            \n");
		buf.append(" ,TVVD      AS VESSEL_VOYAGE                          \n");
		buf.append(" ,TBND      AS BOUND                                  \n");
		buf.append(" ,TKIN      AS KIND                                   \n");
		buf.append(" ,TBNO      AS BL_NO                                  \n");
		buf.append(" ,TSHC      AS SHIPPER_CODE                           \n");
		buf.append(" ,TSHD      AS SHIPPER_DESCRIPTION                    \n");
		buf.append(" ,TCNC      AS CONSIGNEE_CODE                         \n");
		buf.append(" ,TCND      AS CONSIGNEE_DESCRIPTION                  \n");
		buf.append(" ,TSNO      AS SC_CODE                                \n");
		buf.append(" ,TPOR      AS PLACE_OF_RECEIPT                       \n");
		buf.append(" ,TPVY      AS PLACE_OF_DELIVERY                      \n");
		buf.append(" ,TPOL      AS PORT_OF_LOADING                        \n");
		buf.append(" ,TPOD      AS PORT_OF_DISCHARGING                    \n");
		buf.append(" ,TCM2      AS COMMODITY20                           \n");
		buf.append(" ,TCM4      AS COMMODITY40                           \n");
		buf.append(" ,TCMM      AS COMMODITY                              \n");
		buf.append(" ,TTKR      AS TRUCKER_CODE                           \n");
		buf.append(" ,TOFC      AS SALE_OFFICE_CODE                       \n");
		buf.append(" ,TRCM      AS Representing_Customer                  \n");
		buf.append(" ,TRCMDES   AS R_CUSTOMER_DESC                        \n");
		buf.append(" ,TTRM      AS SERVICE_TERM_CY_DR                    \n");
		buf.append(" ,TCNO      AS CNTR_NO                                \n");
		buf.append(" ,TSIZ      AS CNTR_SIZE                              \n");
		buf.append(" ,TTYP      AS CNTR_TYPE                              \n");
		buf.append(" ,TTRD      AS TRADE                                  \n");
		buf.append(" ,TTMD      AS TRANS_MODE                             \n");
		buf.append(" ,TDD1      AS MOVEMENT_START                         \n");
		buf.append(" ,TDD2      AS MOVEMENT_END                           \n");
		buf.append(" ,TDEX      AS EXPIRY_DATE                            \n");
		buf.append(" ,TDFD      AS FREEDAY                                \n");
		buf.append(" ,TDFH      AS HOLIDAY                                \n");
		buf.append(" ,TDC1      AS DEDUCTION_PERCENT                      \n");
		buf.append(" ,TDC2      AS DEDUCTION_DAY                          \n");
		buf.append(" ,TDC3      AS DEDUCTION_CONFIRM                      \n");
		buf.append(" ,TDC4      AS DEDUCTION_AGENT                        \n");
		buf.append(" ,TDRD      AS OVERDAY                                \n");
		buf.append(" ,TDM1      AS TOTAL_AMOUNT                           \n");
		buf.append(" ,TDM11     AS BASIC_AMOUNT                           \n");
		buf.append(" ,TDM12     AS SPECIAL_AMOUNT                         \n");
		buf.append(" ,TDM2      AS DEDUCTION_AMOUNT                       \n");
		buf.append(" ,TDM3      AS INVOICE_AMOUNT                         \n");
		buf.append(" ,TDM13     AS INVOICE_AMOUNT_TAX                     \n");
		buf.append(" ,TDM4      AS RECEIPT_AMOUNT                         \n");
		buf.append(" ,TDM5      AS REMITTANCE_AMOUNT                      \n");
		buf.append(" ,TDM6      AS CHARGEABLE_AMOUNT                      \n");
		buf.append(" ,TDCU      AS CURRENCY                               \n");
		buf.append(" ,UDM1      AS USD_TOTAL_AMOUNT                       \n");
		buf.append(" ,UDM11     AS USD_BASIC_AMOUNT                       \n");
		buf.append(" ,UDM12     AS USD_SPECIAL_AMOUNT                     \n");
		buf.append(" ,UDM2      AS USD_DEDUCTION_AMOUNT                   \n");
		buf.append(" ,UDM3      AS USD_INVOICE_AMOUNT                     \n");
		buf.append(" ,UDM4      AS USD_RECEIPT_AMOUNT                     \n");
		buf.append(" ,UDM5      AS USD_REMITTANCE_AMOUNT                  \n");
		buf.append(" ,UDM6      AS CHARGEABLE_AMOUNT                      \n");
		buf.append(" ,EDM1      AS EUR_TOTAL_AMOUNT                       \n");
		buf.append(" ,EDM11     AS EUR_BASIC_AMOUNT                       \n");
		buf.append(" ,EDM12     AS EUR_SPECIAL_AMOUNT                     \n");
		buf.append(" ,EDM2      AS EUR_DEDUCTION_AMOUNT                   \n");
		buf.append(" ,EDM3      AS EUR_INVOICE_AMOUNT                     \n");
		buf.append(" ,EDM4      AS EUR_RECEIPT_AMOUNT                     \n");
		buf.append(" ,EDM5      AS EUR_REMITTANCE_AMOUNT                  \n");
		buf.append(" ,TOSO      AS CREDIT_OVERDUE                         \n");
		buf.append(" ,TOSNO     AS CREDIT_NONOVERDUE                      \n");
		buf.append(" FROM PLIBTEMP.DEMAT50711                             \n");
		buf.append(" WHERE TMPID='"+tmpID+"'                              \n");
		return buf.toString();
	}
	
	
	private String getQueryVFGap_ChoiWonKyu_20140611(String yearTwoChar){
		StringBuffer buf = new StringBuffer();
		buf.append(" SELECT MVTENO AS EquipmentNo      \n");
		buf.append("       ,MVTMDT AS VFDate           \n");
		buf.append("       ,MVTTIM AS VFtime           \n");
		buf.append("       ,MVTNMD AS NextMoveDate     \n");
		buf.append("       ,MVTNTM AS NextMoveTime     \n");
		buf.append("       ,MVTG"+yearTwoChar+" AS Gap20"+yearTwoChar+"1231      \n");
		buf.append("   FROM PLIBTEMP.EQPAOYHMG         \n");
		buf.append("  WHERE MVTG"+yearTwoChar+">0                   \n");
		buf.append("    AND MVTLTM<>'50'               \n");
		buf.append(" ORDER BY MVTMDT                   \n");
		buf.append(" with ur                           \n");
		return buf.toString();
	}
	private String getQueryDemDetSummaryByCustomer_KimByundSu_20140620(String from, String to){
		StringBuffer buf = new StringBuffer();
		buf.append(" SELECT OUTSNO AS SC_NO                        \n");
		buf.append("       ,outscd AS SC_DESC                      \n");
		buf.append("       ,SUM(OUTBAM) AS Basic_Amount            \n");
		buf.append("       ,SUM(OUTCAM) AS Chargeable_Amount       \n");
		buf.append("       ,SUM(OUTIAM) AS Invoice_Amount          \n");
		buf.append("       ,SUM(OUTRAM) AS Receipt_Amount          \n");
		buf.append("       ,SUM(OUTDAM) AS Deduction_Amount_Total  \n");
		buf.append("       ,SUM(OUTSAM) AS Contract_Deduction      \n");
		buf.append("       ,SUM(OUTSTTL1) AS Commercial_Deduction  \n");
		buf.append("       ,SUM(OUTSTTL2) AS Operational_Deduction \n");
		buf.append("   FROM PLIBEQ.DEMASUMM                        \n");
		buf.append("  WHERE OUTDD2>="+from+"                       \n");
		buf.append("    AND OUTDD2<="+to+"                         \n");
		buf.append("  GROUP BY OUTSNO, outscd                      \n");
		buf.append("  order by sum(outcam) desc                    \n");
		buf.append(" WITH UR                                       \n");

		return buf.toString();
	}	
	
	public String getQuery_Mkt(String from, String to){
		StringBuffer buf = new StringBuffer();
		
		buf.append("                                                                                                                                        \n");
		buf.append(" SELECT                                                                                                                                 \n");
		buf.append("     MSTBNO,MVPYER,MVPYMT,MVPYER*100+MVPWKY,MVPVVD,                                                                                     \n");
		buf.append("     DTLTYP,DTLSIZ,MVPTRD,MVPLIN,MVPROT,MVPBND,TMPHNB,                                                                                  \n");
		buf.append("     MSTNAR,MSTPOR,MSTPOL,MSTPOD,MSTPVY,MSTNAV,MSTSHT,                                                                                  \n");
		buf.append("     MSTILG, MSTHUB, MSTDNV,MSTSCN,SIDACN,SIDGCD,GBDESC,                                                                                \n");
		buf.append("     MSTSHC AS SHIPPER,                                                                                                                 \n");
		buf.append("     (SELECT MAX(SHPTRA) FROM PLIBCD.CODASHPR WHERE SHPCDE=MSTSHC) shipper_desc,                                                        \n");
		buf.append("     MSTIT1,                                                                                                                            \n");
		buf.append("     (SELECT CMMDES FROM PLIBCD.CODACOMM WHERE CMMCOD=MSTIT1) commodity_desc,                                                           \n");
		buf.append("     SUM(DTLTEU) TEU,                                                                                                                   \n");
		buf.append("     SUM(DTLTOT) FRT,                                                                                                                   \n");
		buf.append("     SUM(DTLTOT)/SUM(DTLTEU) M_RATE,                                                                                                    \n");
		buf.append("     SUM(DTLCM1)/SUM(DTLTEU) CM1_TEU,                                                                                                   \n");
		buf.append("     SUM(DTLCM2)/SUM(DTLTEU) CM2_TEU                                                                                                    \n");
		buf.append(" FROM                                                                                                                                   \n");
		buf.append("     PLIBMK.MPLAUMST A                                                                                                                  \n");
		buf.append(" inner join PLIBOP.MRKAVSLP                                                                                                             \n");
		buf.append(" ON                                                                                                                                     \n");
		buf.append("     MSTTRD = MVPTRD AND                                                                                                                \n");
		buf.append("     MSTVVD = MVPVVD                                                                                                                    \n");
		buf.append(" INNER JOIN PLIBMK.MPLAFDTL C                                                                                                           \n");
		buf.append(" ON                                                                                                                                     \n");
		buf.append("     A.MSTBNO = C.DTLBNO                                                                                                                \n");
		buf.append(" LEFT OUTER JOIN PLIBMK.MKTATRD                                                                                                         \n");
		buf.append(" ON                                                                                                                                     \n");
		buf.append("     MVPTR2= TMPDPT AND                                                                                                                 \n");
		buf.append("     MVPTRD= TMPTRD AND                                                                                                                 \n");
		buf.append("     MVPLIN= TMPLIN AND                                                                                                                 \n");
		buf.append("     MVPROT= TMPROT AND                                                                                                                 \n");
		buf.append("     MVPBND= TMPBND                                                                                                                     \n");
		buf.append(" LEFT OUTER  JOIN (  SELECT SIDTRD AS TRD, SIDSCN AS SCN, SIDBND AS BND, SIDGCD AS GBCODE, TRIM(SGBDES) AS GBDESC                       \n");
		buf.append("               FROM PLIBPR.SCTAINDX A                                                                                                   \n");
		buf.append("               LEFT OUTER JOIN PLIBPR.SCTAGLOB B   ON A.SIDGCD=B.SGBGCD  ) G                                                            \n");
		buf.append(" ON (  TRD = CASE WHEN (MSTDEP ='AT' OR (MSTDEP = 'ST' AND MSTTRD<>'LA')) THEN MSTDEP ELSE MSTTRD END                                   \n");
		buf.append("   AND BND = CASE WHEN (MSTDEP ='AT' OR (MSTDEP = 'ST' AND MSTTRD<>'LA')) THEN ''                                                       \n");
		buf.append("              WHEN MSTTRD IN ('US','LA') AND TMPBND IN('E','W') AND TMPHNB='H' THEN 'E'                                                 \n");
		buf.append("              WHEN MSTTRD IN ('US','LA') AND TMPBND IN('E','W') AND TMPHNB='B' THEN 'W'                                                 \n");
		buf.append("                ELSE MSTBND END                                                                                                         \n");
		buf.append("   AND SCN = MSTSCN )                                                                                                                   \n");
		buf.append(" LEFT OUTER JOIN PLIBPR.SCTAINDX                                                                                                        \n");
		buf.append(" ON                                                                                                                                     \n");
		buf.append("     SIDTRD = CASE WHEN (MSTDEP ='AT' OR (MSTDEP ='ST' AND MSTTRD<>'LA')) THEN MSTDEP ELSE MSTTRD END                                   \n");
		buf.append("     AND SIDBND = CASE WHEN (MSTDEP ='AT' OR (MSTDEP ='ST' AND MSTTRD<>'LA')) THEN ''                                                   \n");
		buf.append("                       WHEN MSTTRD IN('US','LA') AND TMPHNB='H' THEN 'E'                                                                \n");
		buf.append("                       WHEN MSTTRD IN('US','LA') AND TMPHNB='B' THEN 'W'                                                                \n");
		buf.append("                         ELSE MSTBND END                                                                                                \n");
		buf.append("     AND SIDSCN = MSTSCN                                                                                                                \n");
		buf.append(" WHERE                                                                                                                                  \n");
		buf.append("     MVPKND ='H/Q' AND MVPLOD='L' AND  MVPTYP='B'                                                                                       \n");
		buf.append("     AND MVPYMT BETWEEN "+from+" AND "+to+"                                                                                               \n");
		buf.append(" GROUP BY                                                                                                                               \n");
		buf.append("     MSTBNO,MVPYER,MVPYMT,MVPYER*100+MVPWKY,MVPVVD,                                                                                     \n");
		buf.append("     DTLTYP,DTLSIZ,MVPTRD,MVPLIN,MVPROT,MVPBND,TMPHNB,                                                                                  \n");
		buf.append("     MSTNAR,MSTPOR,MSTPOL,MSTPOD,MSTPVY,MSTNAV,MSTSHT,                                                                                  \n");
		buf.append("     MSTILG, MSTHUB, MSTDNV,MSTSCN,SIDACN,SIDGCD,GBDESC,                                                                                \n");
		buf.append("     MSTSHC,                                                                                                                            \n");
		buf.append("     (SELECT MAX(SHPTRA) FROM PLIBCD.CODASHPR WHERE SHPCDE=MSTSHC),                                                                     \n");
		buf.append("     MSTIT1,                                                                                                                            \n");
		buf.append("     (SELECT CMMDES FROM PLIBCD.CODACOMM WHERE CMMCOD=MSTIT1)                                                                           \n");
		buf.append(" order by 1,2,3,4,5,6,7,8,9,10                                                                                                          \n");

		return buf.toString();
	}
}
