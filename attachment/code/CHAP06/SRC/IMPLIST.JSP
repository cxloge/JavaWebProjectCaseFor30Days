<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/impListstyle.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="images/manage.js"></script>
		<script language="JavaScript">
		function mymouseout(id,styleclass)
		{
			document.getElementById(id).className=styleclass;
		}
		</script>
	</head>
	<body>
	<div id="container">
		<div id="tophead">
			<s:include value="Top.jsp"/>
		</div>
		<div id="leftcontent">
			<s:include value="LeftTree.jsp"/>
		</div>
		<div id="maincontent">
			<div id="topop">
				<s:form action="impleeyList" >
				<s:select name="departId" label="%{getText(\"impleeyList.xuanbumen\")}" labelposition="left" 
				list="departList" listKey="key" listValue="value" onchange="this.form.submit();"/>
				</s:form>
				
				<span class="xinzipai"><s:text name="impleeyList.xinzipai"/>
				<a href="impleeyList.action?orderBySalary=1">
				<s:text name="impleeyList.shengxu"/></a>
				<img src="images/sheng.gif" style="height:14px;width:7px;">
				<img src="images/jiang.gif" style="height:14px;width:7px;">
				<a href="impleeyList.action?orderBySalary=-1">
				<s:text name="impleeyList.jiangxu"/></a></span>
				<s:text name="impleeyList.nianlingpai"/><a href="impleeyList.action?orderByAge=1">
				<s:text name="impleeyList.shengxu"/></a>
				<img src="images/sheng.gif" style="height:14px;width:7px;">
				<img src="images/jiang.gif" style="height:14px;width:7px;">
				<a href="impleeyList.action?orderByAge=-1"><s:text name="impleeyList.jiangxu"/></a>
				
			</div>
			<s:if test="impList.size()!=0">
				
				<table border="1" bgcolor="#e2e2e2" cellspacing="1" align="center" width="770px">
				
					<tr class="headerClass">
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>出生日期</th>
						<th>所属部门</th>
						<th>职位</th>
						<th>基本薪资</th>
						<th>电话</th>
						<th>详细信息</th>
					</tr>
					<s:iterator id="impList" value="impList" status="imp">
						<tr id="imp<s:property value="#imp.index"/>"
							<s:if test="#imp.odd">class="oddRow"</s:if>
							<s:else>class="evenRow"</s:else>
							onmouseover="this.className='selectedRow';" 
							onmouseout="mymouseout('imp<s:property value='#imp.index'/>',
							<s:if test='#imp.odd'>'oddRow'</s:if>
							<s:else>'evenRow'</s:else>);" 
							>
							<td><s:property value="impId"/></td>
							<td><s:property value="impName"/></td>
							<td><s:property value="impGender"/></td>
							<td><s:property value="impBirth"/></td>
							<td><s:property value="departName"/></td>
							<td><s:property value="impRoll"/></td>
							<td><s:property value="impSalary"/></td>
							<td><s:property value="impTel"/></td>
							<td><a href="impDetail.action?impId=<s:property value="impId"/>" target="_blank">查看</a></td>
						</tr>
					</s:iterator>
				</table>
				
				<div id="buttomop">
				<div class="info">
				<span class="totalpage"><s:text name="impleeyList.gong"/><s:property value="maxPageNo"/><s:text name="impleeyList.ye"/></span>
				<span class="totalnum"><s:property value="totalMessage"/><s:text name="impleeyList.jilushu"/></span>
				</div>
				<div class="pageop">
				<s:form action="impleeyList" >
				<s:select name="pageSpan" id="pagespan"
				list="spanList" listKey="key" listValue="value" onchange="this.form.submit();"/>
				</s:form>
				<span class="shangye">
					<s:if test="currenPageNo>1">
						<a href="impleeyList.action?currenPageNo=<s:property value="currenPageNo-1"/>"><s:text name="impleeyList.shangye"/></a>
					</s:if>
				</span>
				<span class="xiaye">
				<s:if test="currenPageNo<maxPageNo">
					<a href="impleeyList.action?currenPageNo=<s:property value="currenPageNo+1"/>"><s:text name="impleeyList.xiaye"/></a>
				</s:if>
				</span>
				
				<s:form action="impleeyList" theme="simple" >
					<span class="tiaozhuan"><s:text name="impleeyList.tiaozhuan"/></span>
					<s:textfield id="tiaoye" name="currenPageNo" cssClass="yefield" onmouseover="this.select();"/><span class="ye"><s:text name="impleeyList.ye"/></span>
					<s:submit value="%{getText(\"impleeyList.queding\")}" cssClass="queding" 
					onmouseover="this.className='quedingover';" onmouseout="this.className='queding';"/>
					
				</s:form>
				
				</div>
			
				</div>	
				
			</s:if>
			<s:else>
				<p>没有相应的职工信息</p>
			</s:else>
		</div>
	</div>	
	</body>
</html>