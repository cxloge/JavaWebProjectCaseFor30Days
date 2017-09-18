package wyf.wyy;

public class StatusBean {
	private int curPage = 1;			//记录当前页默认为1
	private int total =1;				//总共多少页默认为1
	private int span = 5;				//每页显示记录条数
	private String money;				//记录已缴罚款
	private String sql;
    public StatusBean() {}				//无参构造器    
    public void setCurPage(int curPage){
    	this.curPage=curPage;
    }
    public int getCurPage(){
    	return this.curPage;
    } 
    public void setTotal(int total){
    	this.total=total;
    }    	
    public int getTotal(){
    	System.out.println("get total"+this.total);
    	return this.total;    	
    }
   	public void setSql(String sql){
   		this.sql=sql;
   		System.out.println("set sql \n"+sql);
   	}
   	public String getSql(){
   		return this.sql=sql;
   	}
   	public void setSpan(int span){
   		this.span=span;
   	}
   	public int getSpan(){
   		return this.span;
   	}
   	public void setMoney(String money){
   		this.money=money;
   	}
   	public String getMoney(){
   		return this.money;
   	}
}