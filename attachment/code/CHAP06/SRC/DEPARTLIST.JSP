<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/departListstyle.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript">
			function mymouseout(id,styleclass)
			{
				document.getElementById(id).className=styleclass;
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
			<s:include value="LeftTree.jsp"/>
		</div>
		<div id="maincontent">
		
			<table border="1" bgcolor="#e2e2e2" cellspacing="1" align="center" width="500px">
				<caption><h4>部门列表</h4></caption>
				<tr class="headerClass">
					<th>部门编号</th>
					<th>部门姓名</th>
					<th>职工人数</th>
					<th>部门描述</th>
					<th>^_^</th>
					<th>^_^</th>
				</tr>
				<s:iterator id="departList" value="departList" status="depart">
					<tr id="depart<s:property value="#depart.index"/>"
						<s:if test="#depart.odd">class="oddRow"</s:if>
						<s:else>class="evenRow"</s:else>
						onmouseover="this.className='selectedRow';" 
						onmouseout="mymouseout('depart<s:property value='#depart.index'/>',
						<s:if test='#depart.odd'>'oddRow'</s:if>
						<s:else>'evenRow'</s:else>);" 
						>
						<td><s:property value="departId"/></td>
						<td><s:property value="departName"/></td>
						<td><a href="departImp.action?departId=<s:property value="departId"/>" target="_blank" alt="点击查看详细职工信息"><s:property value="departNum"/></a></td>
						<td>
							<a href="departDetail.action?departId=<s:property value="departId"/>" target="_blank"><s:property value="departDescrip"/></a>
						</td>
						<td><a href="delDepart.action?departId=<s:property value="departId"/>">删除</a></td>
						<td><a href="editDepart.action?departId=<s:property value="departId"/>" target="_blank">编辑</a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div>
			<table border="0" align="center" width="500px" cellspacing="0" cellpadding="0">
				<tr>
					<td><span class="gongye"><s:text name="impleeyList.gong"/><s:property value="maxPageNo"/><s:text name="impleeyList.ye"/></span></td>
					<td><span class="gongye"><s:property value="totalMessage"/><s:text name="impleeyList.jilushu"/></span></td>
					<td style="width:100px;">
					<s:form action="departmentList" >
					<s:select name="pageSpan" id="pagespan"
					list="spanList" listKey="key" listValue="value" onchange="this.form.submit();"/>
					</s:form>
					</td>
					<td style="width:60px;">
						<span style="font-size:14px;">
						<s:if test="currenPage>1">
							<a href="departmentList.action?currenPage=<s:property value="currenPage-1"/>"><s:text name="impleeyList.shangye"/></a>
						</s:if>
						</span>
					</td>
					<td style="width:60px;">
						<span style="font-size:14px;">
						<s:if test="currenPage<maxPageNo">
						<a href="departmentList.action?currenPage=<s:property value="currenPage+1"/>"><s:text name="impleeyList.xiaye"/></a>
						</s:if>
						</span>
					</td>
					<td>
						<span class="gongye">
						<s:form action="departmentList" theme="simple">
						<s:text name="impleeyList.tiaozhuan"/><s:textfield name="currenPage" onmouseover="this.select();" cssClass="yeinput"/><s:text name="impleeyList.ye"/>
						<s:submit value="%{getText(\"impleeyList.queding\")}" cssClass="queding"/>
						</s:form>
						</span>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<s:if test="(read==false)">
	<script language="JavaScript">
	
		window.onload=alertResult;
		
		function alertResult()
		{
			alert("<s:property value="result"/>");
		}
		
	</script>
	</s:if>
	</body>
</html>