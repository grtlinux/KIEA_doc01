package sdc.anal.lya.macro.A23.SO_SYS_MOD_WORKID_CP.v01;

import java.util.List;

import kiea.kr.co.tain.base.Flag;
import kiea.proj.sdc.anal.macro.impl.job.AbstractMacroJob;
import kiea.proj.sdc.anal.util.BasePath;
import kiea.proj.sdc.anal.util.FileUtil;
import kiea.proj.sdc.anal.util.StrUtil;
import kiea.proj.sdc.anal.util.log.v02.Logger;

public class SO_SYS_MOD_WORKID_CP_MacroJob extends AbstractMacroJob
{
	private MOD_WORKID_CsvIo reader1 = null;
	private SO_SYS_MOD_WORKID_CP_CsvIo writer1 = null;
	
	private List<MOD_WORKID_Bean> inList1  = null;
	private List<SO_SYS_MOD_WORKID_CP_Bean> outList1 = null;
	
	private String filePath = null;

	private String jobId = null;

	public SO_SYS_MOD_WORKID_CP_MacroJob(String jobId)
	{
		this.jobId = jobId;
		
		this.filePath = FileUtil.makeDataDir(BasePath.getInstance().getDataPath(), StrUtil.getDateFromJobId(this.jobId), this.jobId);
	}
	
	/**
	 * generateDataSet
	 */
	public void generateDataSet()
	{
	}

	/**
	 * beforeMacroJob
	 */
	public void beforeMacroJob()
	{
		if (Flag.TRUE) Logger.info("beforeMacroJob : " + this.getClass());
		
		if (Flag.TRUE) {
			try {
				reader1 = new MOD_WORKID_CsvIo(this.filePath);
				writer1 = new SO_SYS_MOD_WORKID_CP_CsvIo(this.filePath);
				
				inList1  = reader1.getList(true);
				outList1 = writer1.getList();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * macroJob
	 */
	public void macroJob()
	{
		if (Flag.TRUE) Logger.info("macroJob : " + this.getClass());

		if (Flag.TRUE) {
			try {
				/*
				 * Job
				 */
				if (Flag.TRUE) {
					
					for (MOD_WORKID_Bean inBean1 : inList1) {

						SO_SYS_MOD_WORKID_CP_Bean outBean1 = new SO_SYS_MOD_WORKID_CP_Bean();
						
						outBean1.setInspStepType(inBean1.getInspStepType());
						outBean1.setInspEqpId   (inBean1.getInspEqpId   ());
						outBean1.setWorkerId    (inBean1.getWorkerId    ());
						outBean1.setTot         (inBean1.getTot         ());
						outBean1.setBad         (inBean1.getBad         ());

						outList1.add(outBean1);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * afterMacroJob
	 */
	public void afterMacroJob()
	{
		if (Flag.TRUE) Logger.info("afterMacroJob : " + this.getClass());
		
		if (Flag.TRUE) {
			try {
				
				writer1.writeList();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
