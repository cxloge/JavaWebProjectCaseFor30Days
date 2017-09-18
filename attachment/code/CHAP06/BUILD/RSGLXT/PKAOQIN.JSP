<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/qiandao.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript">
		function mymouseout(id,styleclass)
		{
			document.getElementById(id).className=styleclass;
		}
		function checkmax1()
		{
			var total=<s:property value="maxPage"/>
			var page=document.getElementById("aimpage").value;
			if(page>total)
			{
				alert("超过最大页数");
				
				return false;
			}
			else
			{
				return true;
			}
		}
		</script>
	<s:head/>
	</head>
	<body>
	<div id="container">
		<div id="tophead">
			<s:include value="Top.jsp"/>
		</div>
		<div id="leftcontent">
			<s:include value="LeftTree2.jsp"/>
		</div>
		<div id="maincontent">
			
			
			<div>
				<s:form theme="simple" action="pKaoQin" >
				<table width="100%" style="font-size:14px;color:#404040;">
				<tr>
					<td>
					选择状态:
					<s:select name="stateType" label="请选择状态：" labelposition="left" 
					list="stateList" listKey="key" listValue="value"/>
					</td>
					<td>
					起始时间:<s:datetimepicker name="from_day" toggleType="explode" />
					</td>
					<td>
					终止时间:<s:datetimepicker name="to_day" toggleType="explode" />
					</td>
					<td>
						<s:submit value="确定"/>
					</td>
				</tr>
				</table>
					
					
				</s:form>
				<s:if test="recordList.size()>0">
				<table border="1" bgcolor="#e2e2e2" cellspacing="1" align="center" width="770px">
				<caption><h4>考勤表</h4></caption>
					<tr class="headerClass">
						<th>职工编号</th>
						<th>职工姓名</th>
						<th>所属部门</th>
						<th>日期</th>
						<th>状态</th>
						
					</tr>
					<s:iterator id="recordList" value="recordList" status="qiandaorecord">
						<tr id="qiandaorecord<s:property value="#qiandaorecord.index"/>"
							<s:if test="#qiandaorecord.odd">class="oddRow"</s:if>
							<s:else>class="evenRow"</s:else>
							onmouseover="this.className='selectedRow';" 
							onmouseout="mymouseout('qiandaorecord<s:property value='#qiandaorecord.index'/>',
							<s:if test='#qiandaorecord.odd'>'oddRow'</s:if>
							<s:else>'evenRow'</s:else>);" 
							>
							<td><s:property value="impId"/></td>
							<td><s:property value="impName"/></td>
							<td><s:property value="departName"/></td>
							<td><s:property value="date"/></td>
							<td>
								<s:property value="state==0?'缺勤':(state==1?'在职':'')"/>
								<a href="qingJiaDetail.action?impId=<s:property value="impId"/>&date=<s:property value="date"/>" target="_blank"><s:property value="state==2?'请假':''"/></a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<div>
				<s:form theme="simple" action="pKaoQin" onsubmit="return checkmax1();">	
					<table width="770px">
						<td style="width:400px;font-size:14px;color:#404040">共<s:property value="maxPage"/>页
						<s:property value="totalMessage"/>条记录</td>
						<td>
						
						<s:select name="pageSpan" 
						list="spanList" listKey="key" listValue="value" onchange="this.form.submit();"/>
						
						</td>
						<td style="width:400px;font-size:14px;">
							<s:if test="currenPage>1">
								<a href="pKaoQin.action?currenPage=<s:property value="currenPage-1"/>">上一页</a>
							</s:if>
						</td>
						<td style="width:400px;font-size:14px;">
							<s:if test="currenPage<maxPage">
							<a href="pKaoQin.action?currenPage=<s:property value="currenPage+1"/>">下一页</a>
							</s:if>
						</td>
						<td style="width:400px;font-size:14px;color:#404040">
							跳转到第<s:textfield id="aimpage" name="currenPage" cssStyle="width:20px;height:20px;" onmouseover="this.select();"/>页
							<s:submit value="跳转" cssClass="tiaozhuan"/>
						</td>
					</table>
				</s:form>	
				</div>
				</s:if>
			<s:else>
				<span style="font-size:25;color:red;">暂没有相关的考勤信息</span>
			</s:else>
			<s:fielderror cssClass="fielderr"/>
			</div>
			
		</div>
	</div>
	</body>
</html>