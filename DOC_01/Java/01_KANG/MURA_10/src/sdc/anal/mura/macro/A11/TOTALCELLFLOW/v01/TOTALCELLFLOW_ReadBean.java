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

package sdc.anal.mura.macro.A11.TOTALCELLFLOW.v01;

import java.util.ArrayList;
import java.util.List;

import kiea.proj.sdc.anal.macro.impl.bean.AbstractBean;

/**
 * @author KangSeok
 * @date 2014. 8. 8.
 * @file_name TOTALCELLFLOW_ReadBean.java
 *
 */
public class TOTALCELLFLOW_ReadBean extends AbstractBean
{
	/*
	"IMPTSTEPGRPID:ImptStepGrpId",
	"IMPTEQPID    :ImptEqpId    ",
	"PROCHOUR     :ProcHour     ",
	"SUM_DECQTY   :SumDecQty    ",
	*/

	private String imptStepGrpId;
	private String imptEqpId    ;
	private String procHour     ;
	private String sumDecQty    ;

	public String toString()
	{
		return String.format("READ : [%s] [%s] [%s] [%s]"
			, imptStepGrpId
			, imptEqpId    
			, procHour     
			, sumDecQty    
		);
	}

	public static String[] getHeader()
	{
		List<String> list = new ArrayList<String>();
		list.add("IMPTSTEPGRPID");
		list.add("IMPTEQPID"    );
		list.add("PROCHOUR"     );
		list.add("SUM_DECQTY"   );

		return list.toArray(new String[list.size()]);
	}

	public String[] getStringArray()
	{
		List<String> list = new ArrayList<String>();
		list.add(imptStepGrpId);
		list.add(imptEqpId    );
		list.add(procHour     );
		list.add(sumDecQty    );

		return list.toArray(new String[list.size()]);
	}

	/**
	 * @return the imptStepGrpId
	 */
	public String getImptStepGrpId()
	{
		return imptStepGrpId;
	}

	/**
	 * @return the imptEqpId
	 */
	public String getImptEqpId()
	{
		return imptEqpId;
	}

	/**
	 * @return the procHour
	 */
	public String getProcHour()
	{
		return procHour;
	}

	/**
	 * @return the sumDecQty
	 */
	public String getSumDecQty()
	{
		return sumDecQty;
	}

	/**
	 * @param imptStepGrpId the imptStepGrpId to set
	 */
	public void setImptStepGrpId(String imptStepGrpId)
	{
		this.imptStepGrpId = imptStepGrpId;
	}

	/**
	 * @param imptEqpId the imptEqpId to set
	 */
	public void setImptEqpId(String imptEqpId)
	{
		this.imptEqpId = imptEqpId;
	}

	/**
	 * @param procHour the procHour to set
	 */
	public void setProcHour(String procHour)
	{
		this.procHour = procHour;
	}

	/**
	 * @param sumDecQty the sumDecQty to set
	 */
	public void setSumDecQty(String sumDecQty)
	{
		this.sumDecQty = sumDecQty;
	}
}