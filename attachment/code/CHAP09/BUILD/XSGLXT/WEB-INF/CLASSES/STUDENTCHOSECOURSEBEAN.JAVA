package wyf.cgq;
import javax.faces.model.*;
import java.util.*;
public class StudentChoseCourseBean{
	private LoginBean lb;		//声明LoginBean的引用
	private DataModel model;	//声明数据模型引用
	private String result;		//声明操作后的结果字符串的引用
	private int size;
	public void setLb(LoginBean lb){this.lb=lb;}//lb的set方法
	public LoginBean getLb(){return this.lb;}//lb的get方法
	public int getSize()
	{
		this.getCourseMsgItem();
		return this.size;
	}
	public DataModel getCourseMsgItem(){//获得课程列表的方法
		ArrayList al=StudentDB.getCourseMsgItemList(lb.getId());
		size=al.size();
		if(model==null){model=new ListDataModel();}//如果模型为空，则创建模型
		model.setWrappedData(al);//设置模型数据
		return model;//返回模型
	}
	public String getResult(){
		String result1=result;
		result="";
		return result1;}//result属性的get方法
	public void setResult(String result){this.result="";
	}
	public void chose(){//点击了选课按钮后的处理方法
		result="";//还原result的值
		CourseMsgItem cmi=(CourseMsgItem)model.getRowData();//获得所选择的课程对象
		String courseNo=cmi.getCourNo();//获得该课程的课程号
		String stuNo=lb.getId();		//获得选择该课程的学生的学号
		String s=StudentDB.choseCourse(stuNo,courseNo);//调用相应方法选课
		if(s.equals("success")){result="选课成功";}//选课成功
		else if(s.equals("fail")){result="选课失败";}//选课失败
		else if(s.equals("rechose")){result="已经选过该课程";//已经选过该课程
		}
		else{result="该课程与"+s+"冲突";}//与其他课程时间冲突
	}}