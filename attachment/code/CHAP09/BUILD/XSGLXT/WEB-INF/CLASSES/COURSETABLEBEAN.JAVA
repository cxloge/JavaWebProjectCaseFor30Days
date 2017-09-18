package wyf.cgq;
import javax.faces.model.*;
import java.util.*;
public class CourseTableBean{
	private LoginBean lb;//LoginBean的声明应用
	private DataModel model;//声明数据表格的引用
	private boolean onchosing;//控制删除列的显示或隐藏
	private int size;
	public int getSize()
	{
		this.getMyCourseMsgItem();
		return size;
	}
	public void setLb(LoginBean lb){this.lb=lb;}//lb的set方法
	public LoginBean getLb(){return this.lb;}//lb的get方法
	public boolean getOnchosing(){return this.onchosing;}//onChosing的get方法
	public DataModel getMyCourseMsgItem(){//获得课程列表的方法
		ArrayList al=StudentDB.getMyCourseMsgItemList(lb.getId());//通过调用StudentDB的方法进行查询
		this.size=al.size();
		if(al.size()>0){//如果查询结果不为空
			onchosing=!((CourseMsgItem)al.get(0)).getState();}//给onchosing赋值
		if(model==null){model=new ListDataModel();}//如果模型是空则常见模型
		model.setWrappedData(al);//设置模型数据
		return model;//返回模型
	
		
	}
	public List getCourTable()
	{
		ArrayList al=StudentDB.getMyCourseMsgItemList(lb.getId());
		if(al.size()>0){//如果查询结果不为空
			onchosing=!((CourseMsgItem)al.get(0)).getState();}
		CourseTime[] ct=new CourseTime[5];
		for(int i=0;i<ct.length;i++)
		{
			ct[i]=new CourseTime();
			ct[i].setZero("第"+(i+1)+"讲");
		}
		for(Object o:al)
		{
			CourseMsgItem cmi=(CourseMsgItem)o;
			int day=cmi.getDay();
			int time=cmi.getTimes();
			String name=cmi.getCourName();
			ct[time].addCourse(day,name);
		}
		ArrayList ctable=new ArrayList();
		for(int i=0;i<ct.length;i++)
		{
			ctable.add(ct[i]);
		}
		return ctable;
	}
	public void delete(){//处理删除课程的方法
		CourseMsgItem cmi=(CourseMsgItem)model.getRowData();//获得用户要删除的课程
		String courseNo=cmi.getCourNo();//或的该课程的课程号
		String stuNo=lb.getId();//获得该学生的学号
		StudentDB.deleteCourse(courseNo,stuNo);//执行删除的业务方法
	}}