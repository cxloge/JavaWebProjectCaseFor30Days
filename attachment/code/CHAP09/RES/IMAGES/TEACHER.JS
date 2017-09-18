String.prototype.trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
function checkLogin()
{
	var uid=document.getElementById("myform:uid").value.trim();
	if(uid=="")
	{
		alert("用户名不能为空");
		return false;
	}
	var pwd=document.getElementById("myform:pwd").value.trim();
	if(pwd=="")
	{
		alert("密码不能为空");
		return false;
	}
	return true;
}		     
function check(id,msg)
{
	var com=document.getElementById(id);

	if(com.value.trim()=="")
	{
   		alert(msg);
   		return false;
	}
	return true;
}

function checknewpwd(id)
{
	var com=document.getElementById(id);
	var values=com.value.trim();
	var pat=/^[a-zA-Z0-9]{6,12}$/;
	if(pat.exec(values))
	{
		return true;
	}
	else
	{
		alert("密码必须为6~12位数字和英文字母组成");
		return false;
	}
}
function pwd()
{
	var newpwd=document.getElementById("myform:newpwd").value.trim();
	var renewpwd=document.getElementById("myform:renewpwd").value.trim();
	if(newpwd==renewpwd)
	{
		return true;
	}
	else
	{
		alert("新密码两次输入不匹配");
		return false;
	}

}
function stucheck()
{
	var sno=document.getElementById("stuform:sno").value.trim();
	var pat=/^[0-9]{12,12}$/;
	if(!pat.exec(sno))
	{
		alert("学号应该由12位数字组成");
		document.getElementById("stuform:sno").focus();
		return false;
	}
	var sname=document.getElementById("stuform:sname").value.trim();
	if(sname=="")
	{
		alert("姓名不能为空");
		document.getElementById("stuform:sname").focus();
		return false;
	}
	var nativepalce=document.getElementById("stuform:nativeplace").value.trim();
	if(nativepalce=="")
	{
		alert("籍贯不能为空");
		document.getElementById("stuform:nativeplace").focus();
		return false;
	}
	return true;
}
function coursemsgcheck()
{
	var courseNo=document.getElementById("manageform:courseNo").value.trim();
	if(courseNo=="")
	{
		alert("请输入要操作的课程号");
		return false;
	}
	var teacher=document.getElementById("manageform:teacher").value.trim();
	if(teacher=="")
	{
		alert("请输入任课教师");
		return false;
	}
	return true;
}
function updateDate()
{
	var yearindex=document.getElementById("stuform:biryear").selectedIndex;
	var year=document.getElementById("stuform:biryear")[yearindex].value;
	var monthindex=document.getElementById("stuform:birmonth").selectedIndex;
	var month=document.getElementById("stuform:birmonth")[monthindex].value;
	var date=new Date(year,month,0);
	var number=date.getDate();
	var length=document.getElementById("stuform:birday").length;
	while(document.getElementById("stuform:birday").length>0)
	{document.getElementById("stuform:birday")[0]=null;}
	for(var i=0;i<number;i++){document.getElementById("stuform:birday").options[i]=new Option(i+1+"日",i+1);}
}
function updateDate1()
{
	var yearindex=document.getElementById("stuform:comeyear").selectedIndex;
	var year=document.getElementById("stuform:comeyear")[yearindex].value;
	var monthindex=document.getElementById("stuform:comemonth").selectedIndex;
	var month=document.getElementById("stuform:comemonth")[monthindex].value;
	var date=new Date(year,month,0);
	var number=date.getDate();
	var length=document.getElementById("stuform:comeday").length;
	while(document.getElementById("stuform:comeday").length>0)
	{document.getElementById("stuform:comeday")[0]=null;}
	for(var i=0;i<number;i++){document.getElementById("stuform:comeday").options[i]=new Option(i+1+"日",i+1);}
}
function checkpre()
{
	var sno=document.getElementById("stuform:sno").value.trim();
	if(sno=="")
	{
		alert("学号不能为空");
		document.getElementById("stuform:sno").focus();
		return;
	}
	if(sno.length!=12)
	{
		alert("学号长度为");
		document.getElementById("stuform:sno").focus();
		return;
	}
	if(sno.length>12)
	{
		alert("学号长度不能大于12位");
		document.getElementById("stuform:sno").focus();
		return;
	}

	var sname=document.getElementById("stuform:sname").value.trim();
	if(sname=="")
	{
		alert("姓名不能为空");
		document.getElementById("stuform:sname").focus();
		return;
	}
	var nativeplace=document.getElementById("stuform:nativeplace").value.trim();
	if(nativeplace=="")
	{
		alert("籍贯不能为空");
		document.getElementById("stuform:nativeplace").focus();
		return;
	}
}
function checksno()
{
	var sno=document.getElementById("searchform:search").value.trim();
	if(sno=="")
	{
		alert("请输入要查询的学生的学号");
		return false;
	}
	var pat=/^[0-9]{12,12}$/;
	if(!pat.exec(sno))
	{
		alert("您输入的学号格式不正确，应该为12位数字，请检查");
		document.getElementById("searchform:search").focus();
		return false;
	}
	return true;
}

function checkscore(com)
{
	var score=com.value;
	var pat=/^\d+(\.\d+)?$/;
	if(!pat.exec(score))
	{
		alert("您输入的分数有误");
		com.focus();
		return false;
	}
	if(score<0||score>100)
	{
		alert("分数应该在0~100之间");
		com.focus();
		return false;
	}
	
	return true;
}
function checkallscore()
{
	alert(document.getElementById("scoreform").value.length+"sssss");
	
    for(i=0;i<document.getElementById("scoreform").rows.length;i++)   
    {   
    	alert(i+"行");
        for(j=0;j<document.getElementById("scoreform").rows(i).cells.length;j++)   
        {   
        	alert(i+"行"+j+"列");
           var value=document.getElementById("scoreform").rows(i).cells(j).value; 
            alert(value);
        }   
    }   
	return false;
}

function checkss()
{   
 var pat=/^\d+(\.\d+)?$/; 
 var oo = document.getElementById("scoreform").getElementsByTagName("input");  
 var len=oo.length;
  var number=1;     
 for(var k = 0; k < len; k++)    
 {        
  
    var t = oo[k].type;  
    var value=oo[k].value;
    if(t=="text")
    {
    	if(!pat.exec(value))
		{
			alert("第"+number+"行您输入的分数有误");
			oo[k].focus();
			return false;
		}
		if(value<0||value>100)
		{
			alert("第"+number+"行分数应该在0~100之间");
			oo[k].focus();
			return false;
		}
		number=number+1;   
    }
 }
 return true;
}


function checkcourse()
{
	var cno=document.getElementById("myform:cno").value.trim();
	if(cno=="")
	{
		alert("课程号不能为空！！");
		return false;
	}
	var cname=document.getElementById("myform:cname").value.trim();
	if(cname=="")
	{
		alert("课程名称不能为空！！");
		return false;
	}
	var xuefen=document.getElementById("myform:xuefen").value.trim();
	if(xuefen=="")
	{
		alert("学分不能为空！！");
		return false;
	}
	var pat=/^\d+(\.\d+)?$/;
	if(!pat.exec(xuefen))
	{
		alert("学分的格式不争取");
		return false;
	}
}




