<%@ page contentType="text/html;charset=gbk" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
		<head>
			<title>租赁信息明细</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css"/>
			<link type="text/css" rel="stylesheet" href="css/showmsg.css"/>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/lookdetail.js"></script>			
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>房屋#{ShowRentMsgBean.msgtype}信息明细" />
				</p>
				<div class="content" style="float:left;"><br/>
					<li>
						<h:outputText value="信息类型："/>
						<h:outputText value="#{ShowRentMsgBean.msgtype}"/>
					</li>
					<li>
						<h:outputText value="房源位置："/>
						<h:outputText value="#{ShowRentMsgBean.location}"/>
					</li>
					<li>
						<h:outputText value="物业类型："/>
						<h:outputText value="#{ShowRentMsgBean.wuye}"/>
					</li>
					<li>
						<h:outputText value="户型："/>
						<h:outputText value="#{ShowRentMsgBean.type}"/>
					</li>
					<li>
						<h:outputText value="楼层高度："/>
						<h:outputText value="#{ShowRentMsgBean.high}"/>
					</li>
					<li>
						<h:outputText value="房屋面积："/>
						<h:outputText value="#{ShowRentMsgBean.area}"/>
					</li>
					<li>
						<h:outputText value="价格（元/月）："/>
						<h:outputText value="#{ShowRentMsgBean.price}"/>
					</li>
					<li>
						<h:outputText value="租期(月)："/>
						<h:outputText value="#{ShowRentMsgBean.lease}"/>
					</li>
					<li>
						<h:outputText value="信息发布日期："/>
						<h:outputText value="#{ShowRentMsgBean.publishtime}"/>
					</li>
				</div>				
				<div style="list-style:none;width:50%;margin:40px 0;font-size:14px;float:right;;">
					<div><li style="background-color:gray;">如果您想查看该房源的具体信息，<br/>请在下表中填写正确的信息(在提交信息前，请你先登录)。</li></div>
					<br/>
					<h:form id="mf_lookdetail" onsubmit="JavaScript:return checkRent();">
						<h:panelGrid columns="2" style="font-size:14px;">
							<h:outputText value="联系人："/>
							<h:inputText id="linkman" value="#{ShowRentMsgBean.linkman}"/>
							<h:outputText value="联系电话："/>
							<h:inputText id="tel" value="#{ShowRentMsgBean.tel}"/>
							<h:outputText value="E-mail："/>
							<h:inputText id="email" value="#{ShowRentMsgBean.email}"/>
						</h:panelGrid>
						<h:panelGroup>
							<h:commandButton value="提交" styleClass="btn" action="#{ShowRentMsgBean.save}"/>&nbsp;
							<h:commandButton value="重置" styleClass="btn" type="reset" />
						</h:panelGroup>
						<h:inputText id="errMsg" value="#{ShowRentMsgBean.errMsg}" style="display:none"/>
					</h:form>
					<h:form id="login" style="display:none;">
						<h:inputText id="url" value="#{UserLoginBean.url}" style="display:none;"/>
					</h:form>
				</div>
				<%@ include file="Tip.jsp" %>
			</div>			
			<script type="text/javascript">
				function showMsg(){
					var msg = document.getElementById("mf_lookdetail:errMsg").value;
					if(msg.trim()!=""){
						alert(msg);
					}
					if(msg=="对不起，请您先登录！") {
						document.getElementById("login:url").value="showqiuzumsg";
						document.getElementById("login").submit();
						window.location.href = "UserLogin.jsp";
					}
				}
				window.onload=showMsg;
			</script>
			
		</body>
	</html>

</f:view>