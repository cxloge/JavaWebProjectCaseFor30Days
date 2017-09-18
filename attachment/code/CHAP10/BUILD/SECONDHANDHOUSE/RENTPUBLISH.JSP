<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
		<head>
			<title>出租信息发布</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/rent.js"></script>
		</head>
		<body onload="JavaScript:login();">
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>出租信息发布" />
				</p>
				<h:form id="mf_login" style="display:none;">
					<h:inputText value="#{UserLoginBean.flag}" id="flag" style="display:none;"/>
					<h:inputText value="#{UserLoginBean.url}" id="url" style="display:none;"/>
				</h:form>
				<h:panelGroup rendered="#{UserLoginBean.flag}">
				<div style="border:1px solid gray;width:85%;margin:20px;padding-bottom:20px;">
					<div style="background-color:#F7AE31;">出租信息发布</div><br/>
					<h:form id="mf_rent" onsubmit="JavaScript:return check();">
						<h:inputText value="#{RentPublishBean.msgtype}" id="msgtype" style="display:none;"/>
						<h:panelGrid columns="2" style="font-size:14px;">
				   			<h:outputText value="房源坐落位置：" style="text-align:right;width:100%;"/>
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.location}" id="location" required="true" />
				   				<h:message for="location" style="color:red;"/>
				   				<h:outputText value=" 请填写粒度到您要求(出)租房屋的小区" style="font-size:12px;color:#909090" />
				   			</h:panelGroup>
				   			<h:outputText value="房源具体位置：" style="text-align:right;width:100%;" />
				   			<h:panelGroup>
				   				<h:inputText id="detail" value="#{RentPublishBean.detail}" required="true"/>
				   				<h:message for="detail" style="color:red;"/>
				   				<h:outputText value=" 请填写粒度到您要出租房屋的门牌号" style="font-size:12px;color:#909090"/>
				   			</h:panelGroup>
				   			<h:outputText value=" 请输入经度：" style="text-align:right;width:100%;"/>
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.longitude}" id="longitude" required="true"/>
				   				<h:message for="longitude" style="color:red;"/>
				   				<h:outputText value=" 请填写房屋坐落位置的经度" style="font-size:12px;color:#909090"/>
				   			</h:panelGroup>
				   			<h:outputText value=" 请输入纬度：" style="text-align:right;width:100%;"/>
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.latitude}" id="latitude" required="true"/>
				   				<h:message for="latitude" style="color:red;"/>
				   				<h:outputText value=" 请填写房屋坐落位置的纬度" style="font-size:12px;color:#909090"/>
				   			</h:panelGroup>
				   			<h:outputText value=" 请选择物业类型：" style="text-align:right;width:100%;" />
		   					<h:selectOneMenu value="#{RentPublishBean.wuye}" id="wuye" required="true">
   								<f:selectItems value="#{MsgSearchBean.houseType}" />
   							</h:selectOneMenu>
				   			<h:outputText value=" 请选择房屋的户型：" style="text-align:right;width:100%;"/>
				   			<h:selectOneMenu value="#{RentPublishBean.type}">
				   				<f:selectItems value="#{MsgSearchBean.houseSize}" />
				   			</h:selectOneMenu>
				   			<h:outputText value="请填写房屋的面积：" style="text-align:right;width:100%;"/>
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.area}" id="area" required="true"/>
				   				<h:outputText value="平方米" />
				   				<h:message for="area" style="color:red;"/>
				   			</h:panelGroup>
				   			<h:outputText value="请填写楼层：" style="text-align:right;width:100%;"/>
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.high}" id="high" required="true"/>
				   				<h:outputText value=" 例如：4/5" style="font-size:12px;color:#909090"/>
				   				<h:message for="high" style="color:red;"/>
				   			</h:panelGroup>
				   			<h:outputText value="请输入房屋的租期：" style="text-align:right;width:100%;"/>
					   		<h:panelGroup>
					   			<h:inputText value="#{RentPublishBean.lease}" id="lease" required="true"/>
					   			<h:outputText value="个月"/>
				   				<h:message for="lease" style="color:red;"/>
				   			</h:panelGroup>
				   			<h:outputText value="请输入价格：" style="text-align:right;width:100%;" />
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.price}" id="price" required="true"/>
				   				<h:outputText value="元/月"/>
				   				<h:message for="price" style="color:red;"/>
				   			</h:panelGroup>
				   			<h:outputText value="请填写联系人姓名：" style="text-align:right;width:100%;"/>
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.linkman}" id="linkman" required="true" />
				   				<h:message for="linkman" style="color:red;"/>
				   			</h:panelGroup>
				   			<h:outputText value="请填写联系人地址：" style="text-align:right;width:100%;"/>
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.address}" id="address" required="true"/>
				   				<h:message for="address" style="color:red;"/>
				   			</h:panelGroup>
				   			<h:outputText value="请填写联系人电话：" style="text-align:right;width:100%;"/>
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.tel}" id="tel" required="true"/>
				   				<h:message for="tel" style="color:red;"/>
				   			</h:panelGroup>
				   			<h:outputText value="请填写联系人E-mail：" style="text-align:right;width:100%;"/>
				   			<h:panelGroup>
				   				<h:inputText value="#{RentPublishBean.email}" id="email" required="true" />
				   				<h:message for="email" style="color:red;"/>
				   			</h:panelGroup>
				   			<h:outputText value="备注：" style="text-align:right;width:100%;" />
				   			<h:panelGroup>
				   				<h:inputTextarea value="#{RentPublishBean.remark}" id="remark" cols="30"/>
								<h:message for="remark" style="color:red;" />
							</h:panelGroup>
						</h:panelGrid>
						<h:panelGroup><br/>
							<h:commandButton value="发布" styleClass="btn" action="#{RentPublishBean.publish}"/>&nbsp;
							<h:commandButton value="重置" styleClass="btn" type="reset"/>
						</h:panelGroup>
					</h:form>
				</div>
				</h:panelGroup>
				<%@ include file="Tip.jsp" %>
			</div>
		</body>
	</html>
</f:view>