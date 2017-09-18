package wyf.cgq;
import java.util.*;
import javax.faces.model.SelectItem;
import javax.faces.model.*;
public class ChosingCourseBean
{
	private LoginBean lb;//声明LoginBean的引用
	private int size;//可选课程的数量
	public void setLb(LoginBean lb)
	{
		this.lb=lb;
	}
	public int getSize()
	{
		this.getCourseMsgItem();
		return this.size;
	}
	private DataModel model;//声明DataModel的引用
	public DataModel getCourseMsgItem(){//获得可选课程课程数据模型的方法
		ArrayList al=TeacherDB.getCourseMsgItemList(lb.getId());//调用TeacherDB的方法获得列表
		size=al.size();
		if(model==null){model=new ListDataModel();}//如果是第一次，则初始化model
		model.setWrappedData(al);//设置数据模型
		return model;//返回数据模型
	}
	public void gongBu(){//公布课程的方法
		String courseno=((CourseMsgItem)model.getRowData()).getCourNo();//获得被操作的课程的课程号
		int day=((CourseMsgItem)model.getRowData()).getDay();//获得星期几
		int times=((CourseMsgItem)model.getRowData()).getTimes();//获得第几讲
		TeacherDB.gongBu(courseno,day,times);//调用TeacherDB的方法进行公布
	}
	public void delete(){//删除课程的方法
		String courseno=((CourseMsgItem)model.getRowData()).getCourNo();//获得被删除课程的课程号
		int day=((CourseMsgItem)model.getRowData()).getDay();//获得被删除课程的上课时间
		int times=((CourseMsgItem)model.getRowData()).getTimes();//获得被删除课程的上课讲次
		TeacherDB.delete(courseno,day,times);//调用TeacherDB的方法进行删除
	}
	public void stop(){//停止选课的方法
		TeacherDB.stopChoseCourse(lb.getId());//调用TeacherDB的方法停止选课
	}
}