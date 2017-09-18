package wyf.cgq;
import org.hibernate.usertype.*;
import org.hibernate.*;
import java.util.*;
import org.hibernate.type.*;
import java.sql.*;
public class ReceiveList implements UserType{
	private List receivers;
	private static final char SPLITCHAR=';';
	private static final int[] TYPES=new int[]{Types.VARCHAR};
	public boolean isMutable(){
		return false;
	}
	public int[] sqlTypes(){
		return TYPES;
	}
	public Class returnedClass(){
		return List.class;
	}
	public Object deepCopy(Object value) throws HibernateException{
		List source=(List)value;
		List target=new ArrayList();
		target.addAll(source);
		return target;
	}
	public boolean equals(Object x,Object y) throws HibernateException{
		if(x==y) return true;
		if(x!=null&&y!=null){
			List xList=(List)x;
			List yList=(List)y;
			if(xList.size()!=yList.size()) return false;
			for(int i=0;i<xList.size();i++){
				String str1=(String)xList.get(i);
				String str2=(String)yList.get(i);
				if(!str1.equals(str2)) return false;
			}
			return true;
		}
		return false;
	}
	public Object nullSafeGet(ResultSet rs,String[] names,Object owner) throws HibernateException,SQLException{
		String value=(String)Hibernate.STRING.nullSafeGet(rs,names[0]);
		if(value!=null){
			return parse(value);
		}else{
			return null;
		}
	}
	public void nullSafeSet(PreparedStatement st,Object value,int index) throws HibernateException,SQLException{
		if(value!=null){
			String str=assemble((List)value);
			Hibernate.STRING.nullSafeSet(st,value,index);
		}
	}
	private String assemble(List receivers){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<receivers.size();i++){
			sb.append(receivers.get(i)).append(SPLITCHAR);
		}
		return sb.toString();
	}
	private List parse(String value){
		String[] strs=value.split(""+SPLITCHAR);
		List receivers=new ArrayList();
		for(int i=0;i<strs.length;i++){
			receivers.add(strs[i]);
		}
		return receivers;
	}
	public String replace(java.lang.Object o1,java.lang.Object o2,java.lang.Object o3){
		return "";	
	}
}