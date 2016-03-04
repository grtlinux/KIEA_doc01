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

package sdc.anal.mura.macro.A90.SEND_FTP_REPORT.v03;

import java.util.ArrayList;
import java.util.List;

import kiea.kr.co.tain.base.Flag;

/**
 * @author KangSeok
 * @date 2014. 9. 28.
 * @file_name FtpInfo.java
 *
 */
public class FtpInfo
{
	private String date = null;
	private String rdate = null;
	private String jobId = null;
	private List<FtpBean> listBean = null;
	
	public FtpInfo(String jobId)
	{
		// TODO : 2014.09.28 : need the validation
		
		if (Flag.TRUE) {
			this.jobId = jobId;  // AR 010 140928 A 0000
			this.date = "20" + this.jobId.substring(5, 11);
			// this.rdate = this.jobId.substring(5, 11);
			this.rdate = "A" + this.jobId.substring(5, 11);    // TODO : 2014.09.28 : 확인하고 나중에 위에 것으로
			this.listBean = new ArrayList<FtpBean>();
		}
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public String getRDate()
	{
		return this.rdate;
	}
	
	public String getJobId()
	{
		return this.jobId;
	}
	
	public List<FtpBean> getList()
	{
		return this.listBean;
	}
	
	public void addBean(FtpBean bean)
	{
		this.listBean.add(bean);
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append(String.format("[JOBID=%s]\n", this.jobId));
		sb.append(String.format("[DATE=%s]\n", this.date));
		sb.append(String.format("[RDATE=%s]\n", this.rdate));
		for (int i=0; i < this.listBean.size(); i++) {
			sb.append(String.format("\t(%03d) %s\n", i, this.listBean.get(i)));
		}
		
		return sb.toString();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)
	{
		if (Flag.TRUE) {
		}
	}
}
