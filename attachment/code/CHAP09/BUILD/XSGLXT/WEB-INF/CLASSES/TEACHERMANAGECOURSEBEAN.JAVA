package wyf.cgq;
import java.util.*;
import javax.faces.model.SelectItem;
import javax.faces.model.*;
public class TeacherManageCourseBean{
	private LoginBean lb;//声明LoginBean的引用
	public void setLb(LoginBean lb){this.lb=lb;}//lb的setter方法
	public LoginBean getLb(){return this.lb;}//lb的getter方法
	public List getCourseItemList(){ //获得课程列表的方法
		ArrayList al=TeacherDB.getCourseItemList(lb.getId());//调用TeacherDB的方法获得课程列表
		return al;}//返回课程列表
	private String courseNo;//封装用户输入的课程号
	private String teacher;//封装用户输入的任课教师
	private int day;//封装用户选择的星期几
	private int times;//封装用户选择的讲次
	private String result;//封装操作后的结构字符串
	private SelectItem[] dayItem={//声明并初始化星期列表
		new SelectItem(1,"星期1"),new SelectItem(2,"星期2"),
		new SelectItem(3,"星期3"),new SelectItem(4,"星期4"),
		new SelectItem(5,"星期5"),new SelectItem(6,"星期6"),
		new SelectItem(7,"星期7")};
	private SelectItem[] timesItem={//声明并初始化讲次列表
		new SelectItem(1,"第1讲"),new SelectItem(2,"第2讲"),
		new SelectItem(3,"第3讲"),new SelectItem(4,"第4讲"),
		new SelectItem(5,"第5讲")};
	public void setCourseNo(String courseNo){this.courseNo=courseNo;}//courseNo的setter属性
	public String getCourseNo()
	{
		return this.courseNo;
	}
	public void setTeacher(String teacher)
	{
		this.teacher=teacher;
	}
	public String getTeacher()
	{
		return this.teacher;
	}
	public void setDay(int day)
	{
		this.day=day;
	}
	public int getDay()
	{
		return this.day;	
	}
	public void setTimes(int times)
	{
		this.times=times;
	}
	public int getTimes()
	{
		return this.times;
	}
	public SelectItem[] getDayItem()
	{
		return dayItem;
	}
	public SelectItem[] getTimesItem()
	{
		return timesItem;
	}
	public String getResult(){
		String result1=result;
		result="";
		return result1;
	}//result的getter方法
	public void setResult(String result){result="";	}
	public String addToDB(){//对添加课程到可选列表的按钮的相应方法
		String s=TeacherDB.addToDB(courseNo,day,times,teacher,lb.getId());//调用TeacherDB的方法处理
		if(s.equals("addfail")){	//如果添加失败
			result="添加失败,请检查是否重复添加了该课程";}//给信息属性赋值
		else if(s.equals("addok")){result="添加成功";}//如果添加成功，则也给信息赋值
		else if(s.equals("nocourse")){result="未找到相应课程";}//未找到相应的课程信息
		return "success";//返回导航字符串
	}
	
}