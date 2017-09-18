package wyf.cgq;
import java.util.*;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
public class WriteScoreBean{
	private LoginBean lb;//LoginBean的引用
	private String courseNo;//当前操作的课程的课程号
	private DataModel model;//数据模型
	private String result="";//存放操作结果的字符串
	private boolean dual;//用于判断当前课程是否已经提交
	ArrayList courseItem;//没处理课程的列表
	private int courseSize;
	public void setLb(LoginBean lb){this.lb=lb;}//lb的setter方法
	public LoginBean getLb(){return this.lb;}//lb的getter方法
	public ArrayList getCourseItem(){//获得为公布成绩的课程的列表
		courseItem=TeacherDB.getCourseItem(lb.getId());
		this.courseSize=courseItem.size();
		return courseItem;}//返回该课程列表
	public void setCourseNo(String courseNo){//设置courseNo的方法
		dual=false;result="";this.courseNo=courseNo;}//充值相关属性
	public String getCourseNo(){
		courseItem=TeacherDB.getCourseItem(lb.getId());//获得课程列表
		if(courseNo==null||dual){//如果是第一次获得或者是当前课程号已被公布
			if(courseItem.size()>0){//如果未公布的课程还存在则将第一个值赋值给courseNo
				courseNo=(String)((SelectItem)courseItem.get(0)).getValue();
			}else{courseNo=null;}//否则赋值一个null
		}return this.courseNo;}//返回courseNo
	public String getResult(){String result1=result;result="";
		return result1;}//获得点击公布成绩后的结果字符串
	public void setResult(String result){this.result="";}//result的setter方法
	public DataModel getGradeList(){//获得成绩列表的方法
		ArrayList al=TeacherDB.getGradeItemList(courseNo);//获得指定课程号课程的成绩列表
		
		if(model==null){model=new ListDataModel();}//如果数据模型为null则创建数据模型
		model.setWrappedData(al);return model;//设置模型数据并返回
	}
	public int getCourseSize(){this.getCourseItem();
		return this.courseSize;}//获得可操作课程的数量
	public void gongbu(){//点击公布该科成绩按钮的处理方法
		result="";boolean b=TeacherDB.gongBuScore(courseNo);//调用TeacherDB的方法公布成绩
		if(b==true){result="操作成功";this.dual=true;}//如果公布成功，则设置相关属性的值
		else{result="操作失败";}//公布失败则将result设为"操作失败"
	}
	public String saveScore(){//保存成绩的方法
		List list=(List)model.getWrappedData();//获得要保存的成绩列表
		TeacherDB.saveScore(list);//调用saveScore方法保存成绩
		return "success";//返回结果字符串
	}
}