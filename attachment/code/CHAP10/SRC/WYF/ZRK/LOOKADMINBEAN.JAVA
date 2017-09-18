package wyf.zrk;

import java.util.*;
import javax.faces.event.*;
import javax.faces.model.*;

public class LookAdminBean {
	private DataModel dm = new ListDataModel();
	private DButilDAOImpl db;
	
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	
	public List<AdminInfo> getAdminList() {
		String hql = "from AdminInfo";
		List<AdminInfo> ls = (List<AdminInfo>)db.getInfo(hql);
		try {
			for(AdminInfo ai:ls) {
				ai.setA_gender(new String(ai.getA_gender().getBytes("ISO-8859-1"),"gbk"));
				ai.setA_level(new String(ai.getA_level().getBytes("ISO-8859-1"),"gbk"));
				ai.setA_name(new String(ai.getA_name().getBytes("ISO-8859-1"),"gbk"));
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ls;
	}	
	
	public DataModel getAdminObj() {
		this.dm.setWrappedData(this.getAdminList());
		return dm;
	}
	
	public void deleteAdminObj() {
		AdminInfo ai = (AdminInfo)dm.getRowData();
		if(!ai.getA_level().equals("³¬¼¶")) {
			String msg = db.deleteObj("admininfo",ai);
		}		
	}
	
	
}
