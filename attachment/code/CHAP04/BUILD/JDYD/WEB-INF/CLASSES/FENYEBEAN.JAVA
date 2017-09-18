package wyf;
import java.util.*;
import javax.faces.model.*;
public class FenYeBean extends BaseBean{
    protected int span = 4;			//每页显示多少条记录
	protected int curPage = 1;		//当前显示第一页
	protected int maxPage;			//最大页数
	protected String sql;			//搜索的SQL语句
    protected DataModel dm=new ListDataModel();		//页面显示的数据模型	
    protected Vector al = new Vector();				//显示记录的集合
    public int getMaxPage(){						//得到最大页数的方法    	
		this.maxPage = dbu.getTotal(this.getSql(),this.getSpan());
		return this.maxPage;						//返回查询得到的最大页数
	}

	public void setSpan(int span) {				//span属性的setter方法
		this.span = span;						//设置span属性值
		this.setCurPage(1);						//设置当前显示第一页
	}
	public int getSpan() {
		return (this.span); 					//span属性的getter方法
	}
	
	public void setCurPage(int curPage){
		this.curPage = curPage;					//curPage的setter方法
	}
	public int getCurPage(){
		return this.curPage;					//curPage的getter方法
	}
	
	public String getSql() {
		return (this.sql);						//sql属性的getter方法
	}
	
	public void prePage(){				//上一页
		this.curPage -= 1;				//当前页数减一
		if(curPage<0){					//如果计算出的当前页小于0
			this.curPage = 1;			//则显示第一页
		}
	}
	public void nextPage(){					//下一页
		this.curPage += 1;					//当前页数加一
		if(this.curPage>this.maxPage){		//如果计算出的当前页大于最大页数
			this.curPage = this.maxPage;	//则显示最后一页
		}
	}
	
	public SelectItem[] getPageSpanList(){		//得到每页显示多少条的下拉列表选项数组
		SelectItem[] list=new SelectItem[9];	//创建下拉列表选项数组
		for(int i=0;i<9;i++){					//循环9次
			list[i]=new SelectItem(Integer.valueOf(i+1),(i+1)+"条/页");
		}
		return list;							//返回下拉列表数组对象
	}
	
	public SelectItem[] getPageList(){					//返回换页下拉列表框选项数组
		SelectItem[] list=new SelectItem[this.maxPage];	//创建下拉列表选项数组
		for(int i=0;i<this.maxPage;i++){
			list[i]=new SelectItem(Integer.valueOf(i+1),"第"+(i+1)+"页");
		}
		return list;									//返回下拉列表数组对象
	}
	
	public int getSize(){
		return al.size();					//返回页面显示信息向量的大小
	}
}