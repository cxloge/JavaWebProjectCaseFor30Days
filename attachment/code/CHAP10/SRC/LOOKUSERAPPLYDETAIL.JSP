<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>申请房源列表明细</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/admin.css"/>
			<link type="text/css" rel="stylesheet" href="css/showmsg.css"/>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="AdminMenu.jsp" %>
				<h:outputText value="#{LookUserApplyDetailBean.initList}" style="display:none;"/>
				<p style="text-align:left;padding-top:10px;">
					&nbsp;&nbsp;<h:outputText value="当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/AdminIndex.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>申请房源列表明细"/>
				</p><br/>
				<h:outputText value="申请房源列表明细" style="font-size:25px;width:100%;"/>
				<div class="content" style="float:left;width:49%;height:200px;"><br/>
					<li>
						<h:outputText value="信息类型："/>
						<h:outputText value="#{LookUserApplyDetailBean.msgType}"/>
					</li>
					<li>
						<h:outputText value="房源位置："/>
						<h:outputText value="#{LookUserApplyDetailBean.location}"/>
					</li>
					<li>
						<h:outputText value="物业类型："/>
						<h:outputText value="#{LookUserApplyDetailBean.wuye}"/>
					</li>
					<li>
						<h:outputText value="户型："/>
						<h:outputText value="#{LookUserApplyDetailBean.houseType}"/>
					</li>
					<li>
						<h:outputText value="楼层高度："/>
						<h:outputText value="#{LookUserApplyDetailBean.high}"/>
					</li>
					<li>
						<h:outputText value="房屋面积："/>
						<h:outputText value="#{LookUserApplyDetailBean.area}"/>
					</li>
				</div>
				
				<div class="content" style="width:49%;height:200px;"><br/>
					<li>
						<h:outputText value="联系人："/>
						<h:outputText value="#{LookUserApplyDetailBean.linkman}"/>
					</li>
					<li>
						<h:outputText value="电话："/>
						<h:outputText value="#{LookUserApplyDetailBean.tel}"/>
					</li>
					<li>
						<h:outputText value="E-mail："/>
						<h:outputText value="#{LookUserApplyDetailBean.email}"/>
					</li>
				</div>		
				<h:outputText value="是否同意该用户查看该房源？" style="font-size:18px;"/>
				<h:form>
					<h:commandButton value="同意" styleClass="btn" action="#{LookUserApplyDetailBean.agree}"/>
				</h:form>
			</div>
		</body>
	</html>
</f:view>