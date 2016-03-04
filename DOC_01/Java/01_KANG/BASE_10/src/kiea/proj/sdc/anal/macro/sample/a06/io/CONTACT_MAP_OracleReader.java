/* Copyright (c) 2008-2014, KangSeok
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of the HSQL Development Group nor the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL HSQL DEVELOPMENT GROUP, HSQLDB.ORG,
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package kiea.proj.sdc.anal.macro.sample.a06.io;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kiea.kr.co.tain.base.Flag;
import kiea.proj.sdc.anal.common.Connection;
import kiea.proj.sdc.anal.common.Parameter;
import kiea.proj.sdc.anal.macro.impl.io.AbstractOracleReader;
import kiea.proj.sdc.anal.macro.sample.a06.bean.CONTACT_MAP_ReadBean;
import kiea.proj.sdc.anal.util.StrUtil;
import oracle.jdbc.OracleConnection;

/**
 * @author KangSeok
 * @date 2014. 8. 8.
 * @file_name CONTACT_MAP_OracleReader.java
 *
 */
public class CONTACT_MAP_OracleReader extends AbstractOracleReader
{
	private List<CONTACT_MAP_ReadBean> list = new ArrayList<CONTACT_MAP_ReadBean>();
	
	@SuppressWarnings("unused")
	private String strFromDateTime    = null;
	@SuppressWarnings("unused")
	private String strToDateTime      = null;
	private String strLine            = null;
	@SuppressWarnings("unused")
	private String strAreaCode        = null;
	@SuppressWarnings("unused")
	private String strUserGroupCode   = null;
	@SuppressWarnings("unused")
	private String strDefectGroupCode = null;
	
	/**
	 * Sample02OracleReader
	 */
	public CONTACT_MAP_OracleReader(String strFromDateTime, String strToDateTime, String strLine, String strAreaCode, String strUserGroupCode, String strDefectGroupCode)
	{
		if (Flag.TRUE) {
			this.strFromDateTime    = strFromDateTime;
			this.strToDateTime      = strToDateTime;
			this.strLine            = strLine;
			this.strAreaCode        = strAreaCode;
			this.strUserGroupCode   = strUserGroupCode;
			this.strDefectGroupCode = strDefectGroupCode;
		}
	}

	/**
	 * 
	 * getLine56LC
	 *
	 * @return
	 */
	private String getLine56()
	{
		String query = null;
		
		query = String.format("" +
				"/* CONTACT_MAP : L5FAB, L6FAB  */                                           \n" +
				"SELECT                                                                      \n" +
				"    LINE||'_'||PART||'_'||MAKER||'_'||UNITNAME||'_'||CONTACTMAP AS EQP_NAME \n" +
				"    , T1.*                                                                  \n" +
				"FROM                                                                        \n" +
				"    YMS_DM.D_CONTACTMAP_INFO T1                                             \n" +
				"    /* 테스트용 TABLE 로 적용시 바꿔야함*/                                  \n" +
				"WHERE                                                                       \n" +
				"    LINE = %s                                                               \n" +  // LINE
				""
				, StrUtil.quote(Parameter.getInstance().getStrLine           ())
				);

		return query;
	}

	/**
	 * 
	 * getLine78MOD
	 *
	 * @return
	 */
	private String getLine78()
	{
		String query = null;
		
		query = String.format("" +
				"/* CONTACT_MAP : L7AFAB, L7BFAB, L8AFAB, L8ZFAB */                          \n" +
				"SELECT                                                                      \n" +
				"    LINE||'_'||PART||'_'||MAKER||'_'||UNITNAME||'_'||CONTACTMAP AS EQP_NAME \n" +
				"    , T1.*                                                                  \n" +
				"FROM                                                                        \n" +
				"    YMS_DM.D_CONTACTMAP_INFO T1                                             \n" +
				"    /* 테스트용 TABLE 로 적용시 바꿔야함*/                                  \n" +
				"WHERE                                                                       \n" +
				"    LINE = %s                                                               \n" +  // LINE
				""
				, StrUtil.quote(Parameter.getInstance().getStrLine           ())
				);

		return query;
	}

	/**
	 * getList
	 */
	public List<CONTACT_MAP_ReadBean> getList()
	{
		if (Flag.TRUE) {
			try {
				String query = null;
				
				if ("L5FAB".equals(strLine) || "L6FAB".equals(strLine)) {
						query = getLine56();
				} else if ("L7AFAB".equals(strLine) || "L7BFAB".equals(strLine) || "L8AFAB".equals(strLine) || "L8ZFAB".equals(strLine)) {
						query = getLine78();
				} else {
					return list;
				}
				
				if (!Flag.TRUE) System.out.println("[" + query + "]");
				
				OracleConnection conn = Connection.getOracleConnection();

				if (Flag.TRUE) {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					for (int i=0; i < 1000000 && rs.next(); i++) {
						if (!Flag.TRUE) {
							System.out.println(String.format("%3d) --------------------------------------", i));
							System.out.println(String.format("    EQP_NAME         = [%s]", rs.getString("EQP_NAME"        )));
							System.out.println(String.format("    LINE             = [%s]", rs.getString("LINE"            )));
							System.out.println(String.format("    AREAID           = [%s]", rs.getString("AREAID"          )));
							System.out.println(String.format("    PART             = [%s]", rs.getString("PART"            )));
							System.out.println(String.format("    MAKER            = [%s]", rs.getString("MAKER"           )));
							System.out.println(String.format("    UNITNAME         = [%s]", rs.getString("UNITNAME"        )));
							System.out.println(String.format("    CONTACTMAP       = [%s]", rs.getString("CONTACTMAP"      )));
							System.out.println(String.format("    COORD_X1         = [%s]", rs.getString("COORD_X1"        )));
							System.out.println(String.format("    COORD_Y1         = [%s]", rs.getString("COORD_Y1"        )));
							System.out.println(String.format("    COORD_X2         = [%s]", rs.getString("COORD_X2"        )));
							System.out.println(String.format("    COORD_Y2         = [%s]", rs.getString("COORD_Y2"        )));
							System.out.println(String.format("    MATERIAL         = [%s]", rs.getString("MATERIAL"        )));
							System.out.println(String.format("    TYPE             = [%s]", rs.getString("TYPE"            )));
							System.out.println(String.format("    VERSION          = [%s]", rs.getString("VERSION"         )));
							System.out.println(String.format("    CONTACTMAP_ATTR1 = [%s]", rs.getString("CONTACTMAP_ATTR1")));
							System.out.println(String.format("    CONTACTMAP_ATTR2 = [%s]", rs.getString("CONTACTMAP_ATTR2")));
							System.out.println(String.format("    USERID           = [%s]", rs.getString("USERID"          )));
							System.out.println(String.format("    UPDATETIME       = [%s]", rs.getString("UPDATETIME"      )));
						}
						
						if (Flag.TRUE) {
							CONTACT_MAP_ReadBean bean = new CONTACT_MAP_ReadBean();

							bean.setEqpName        (rs.getString("EQP_NAME"        ));
							bean.setLine           (rs.getString("LINE"            ));
							bean.setAreaId         (rs.getString("AREAID"          ));
							bean.setPart           (rs.getString("PART"            ));
							bean.setMaker          (rs.getString("MAKER"           ));
							bean.setUnitName       (rs.getString("UNITNAME"        ));
							bean.setContactMap     (rs.getString("CONTACTMAP"      ));
							bean.setCoordX1        (rs.getString("COORD_X1"        ));
							bean.setCoordY1        (rs.getString("COORD_Y1"        ));
							bean.setCoordX2        (rs.getString("COORD_X2"        ));
							bean.setCoordY2        (rs.getString("COORD_Y2"        ));
							bean.setMaterial       (rs.getString("MATERIAL"        ));
							bean.setType           (rs.getString("TYPE"            ));
							bean.setVersion        (rs.getString("VERSION"         ));
							bean.setContactMapAttr1(rs.getString("CONTACTMAP_ATTR1"));
							bean.setContactMapAttr2(rs.getString("CONTACTMAP_ATTR2"));
							bean.setUserId         (rs.getString("USERID"          ));
							bean.setUpdateTime     (rs.getString("UPDATETIME"      ));
							
							list.add(bean);
						}
					}
					
					if (!Flag.TRUE) {
						System.out.println();
						ResultSetMetaData md = rs.getMetaData();
						for (int i=1; i <= md.getColumnCount(); i++) {
							System.out.println(String.format("%d) [%s] [%s] [%s] [%s]", i, md.getColumnName(i), md.getColumnLabel(i), md.getColumnClassName(i), md.getCatalogName(i)));
						}
					}
				}
				
				conn.close();
				if (!Flag.TRUE) System.out.println("OK!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	private static void test01()
	{
		if (Flag.TRUE) {

			String strFromDateTime    = null;
			String strToDateTime      = null;
			String strLine            = null;
			String strAreaCode        = null;
			String strUserGroupCode   = null;
			String strDefectGroupCode = null;

			if (!Flag.TRUE) {
				/*
				 * L5FAB, L6FAB - LC
				 */
				strFromDateTime    = "20140805090000";
				strToDateTime      = "20140806085959";
				strLine            = "L6FAB";
				strAreaCode        = "LC";
				strUserGroupCode   = "L6156H11";
				strDefectGroupCode = "POR";
			}

			if (!Flag.TRUE) {
				/*
				 * L5FAB, L6FAB - MOD
				 */
				strFromDateTime    = "20140701110000";
				strToDateTime      = "20140702105959";
				strLine            = "L6FAB";
				strAreaCode        = "MOD";
				strUserGroupCode   = "LTL097QL01-A01";
				strDefectGroupCode = "32PR";
			}

			if (!Flag.TRUE) {
				/*
				 * L7AFAB, L7BFAB, L8AFAB, L8ZFAB - LC
				 */
				strFromDateTime    = "20140702110000";
				strToDateTime      = "20140703105959";
				strLine            = "L8AFAB";
				strAreaCode        = "LC";
				strUserGroupCode   = "L8480F71";
				strDefectGroupCode = "32PR";
			}

			if (Flag.TRUE) {
				/*
				 * L7AFAB, L7BFAB, L8AFAB, L8ZFAB - MOD
				 */
				strFromDateTime    = "20140702070000";
				strToDateTime      = "20140703065959";
				strLine            = "L8AFAB";
				strAreaCode        = "MOD";
				strUserGroupCode   = "LSC480HN02-G01";
				strDefectGroupCode = "32BOR";
			}

			CONTACT_MAP_OracleReader reader = new CONTACT_MAP_OracleReader(strFromDateTime, strToDateTime, strLine, strAreaCode, strUserGroupCode, strDefectGroupCode);
			reader.getList();
		}
	}
	
	public static void main(String[] args)
	{
		if (Flag.TRUE) test01();
	}
}
