package wyf.zrk;

import java.util.*;

public interface DButil{							//业务接口
	public List<String[]> getInfo(String sql);		//业务方法
	public int updateDb(String sql);
	public int getTotalPage(String sql);
	public List<String[]> getPageContent(String sql,int page);
	public List<String[]> zzcx(String start,String end);
	public List<String[]> czcx(String station);
	public List<String[]> cccx(String train);
	public List<String> searchMidStation(String start,String end);
}
