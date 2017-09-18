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
		<s:form theme="simple" action="personEW">
			<table width="700px" style="font-size:14px;color:#404040;" align="center">
				<tr>
					<td>职工编号:<s:textfield name="impId"/></td>
					<td>起始时间:<s:datetimepicker name="startTime" toggleType="explode" value="today"/></td>
					<td>终止时间:<s:datetimepicker name="endTime" toggleType="explode" value="today"/></td>
					<td><s:submit value="查询"/></td>
				</tr>
			</table>
		</s:form>
		<s:if test="first==false">
			<s:if test="totalMessage>0">
			<table border="1" bgcolor="#e2e2e2" cellspacing="1" align="center" width="700px">
				<caption><h4>个人加班列表</h4></caption>
				<tr class="headerClass">
					<th>职工编号</th>
					<th>职工姓名</th>
					<th>所属部门</th>
					<th>加班日期</th>
					<th>加班原因</th>
					<th>^_^</th>
					<th>^_^</th>
				</tr>
				<s:iterator id="pEWRecordList" value="pEWRecordList" status="EWRecord">
					<tr id="EWRecord<s:property value="#EWRecord.index"/>"
						<s:if test="#EWRecord.odd">class="oddRow"</s:if>
						<s:else>class="evenRow"</s:else>
						onmouseover="this.className='selectedRow';" 
						onmouseout="mymouseout('EWRecord<s:property value='#EWRecord.index'/>',
						<s:if test='#EWRecord.odd'>'oddRow'</s:if>
						<s:else>'evenRow'</s:else>);" 
						>
						<td><s:property value="impId"/></td>
						<td><s:property value="impName"/></td>
						<td><s:property value="departName"/></td>
						<td><s:property value="workTime"/></td>
						<td><s:property value="executes"/></td>
						<td><a href="extraworkDetail.action?impId=<s:property value="impId"/>&workTime=<s:property value="workTime"/>" target="_blank">详情</a></td>
						<td><a href="delExtrawork.action?delImpId=<s:property value="impId"/>&workTime=<s:property value="workTime"/>">删除</a></td>
					</tr>
				</s:iterator>
			</table>
	
			<table border="0" align="center" width="700px" cellspacing="0" cellpadding="0">
				<tr>
					<td><span class="gongye"><s:text name="impleeyList.gong"/><s:property value="maxPage"/><s:text name="impleeyList.ye"/></span></td>
					<td><span class="gongye"><s:property value="totalMessage"/><s:text name="impleeyList.jilushu"/></span></td>
					<td style="width:100px;">
					<s:form action="personEW" >
						<s:select name="pageSpan" 
						list="spanList" listKey="key" listValue="value" onchange="this.form.submit();"/>
					</s:form>
					</td>
					<td style="width:60px;">
						<span style="font-size:14px;">
						<s:if test="currenPage>1">
							<a href="personEW.action?currenPage=<s:property value="currenPage-1"/>"><s:text name="impleeyList.shangye"/></a>
						</s:if>
						</span>
					</td>
					<td style="width:60px;">
						<span style="font-size:14px;">
						<s:if test="currenPage<maxPage">
						<a href="personEW.action?currenPage=<s:property value="currenPage+1"/>"><s:text name="impleeyList.xiaye"/></a>
						</s:if>
						</span>
					</td>
					<td>
						<span class="gongye">
						<s:form action="personEW" theme="simple">
						<s:text name="impleeyList.tiaozhuan"/><s:textfield name="currenPage" onmouseover="this.select();" cssClass="yeinput"/><s:text name="impleeyList.ye"/>
						<s:submit value="%{getText(\"impleeyList.queding\")}" cssClass="queding"/>
						</s:form>
						</span>
					</td>
				</tr>
			</table>
			</s:if>
			<s:else>
			<p class="fielderr" style="margin-left:40px;">
				没有相关信息
				<s:fielderror cssClass="fielderr" cssStyle="margin-left:40px;"/>
			</p>
			</s:else>
			</s:if>
		</div>
	</div>
	</body>
</html>