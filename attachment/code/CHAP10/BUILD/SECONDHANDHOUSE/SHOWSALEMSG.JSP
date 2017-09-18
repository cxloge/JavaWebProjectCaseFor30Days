<%@ page contentType="text/html;charset=gbk" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
		<head>
			<title>出售信息明细</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css"/>
			<link type="text/css" rel="stylesheet" href="css/showmsg.css"/>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/lookdetail.js"></script>
			<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAA0DBHEJH01_0VNMudvDaa6xTnXSjFu29eJd6cbMAcBwfCDrkn8RTOtwnL4wJ4A6GZWdE82cQ6geLv4Q" type="text/javascript"></script>
			<script src="http://www.google.com/jsapi?key=ABQIAAAA0DBHEJH01_0VNMudvDaa6xTnXSjFu29eJd6cbMAcBwfCDrkn8RTOtwnL4wJ4A6GZWdE82cQ6geLv4Q" type="text/javascript"></script>
			<script src="http://www.google.com/uds/solutions/slideshow/gfslideshow.js" type="text/javascript"></script>
			<script src="script/map.js" type="text/javascript"></script>
		</head>
		<body onload="load()" onunload="GUnload()">
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>房屋#{ShowSaleMsgBean.msgtype}信息明细" />
				</p>
				<div class="content"><br/>
					<li>
						<h:outputText value="信息类型："/>
						<h:outputText value="#{ShowSaleMsgBean.msgtype}"/>
					</li>
					<li>
						<h:outputText value="房源位置："/>
						<h:outputText value="#{ShowSaleMsgBean.location}"/>
					</li>
					<li>
						<h:outputText value="物业类型："/>
						<h:outputText value="#{ShowSaleMsgBean.wuye}"/>
					</li>
					<li>
						<h:outputText value="户型："/>
						<h:outputText value="#{ShowSaleMsgBean.type}"/>
					</li>
					<li>
						<h:outputText value="楼层高度："/>
						<h:outputText value="#{ShowSaleMsgBean.high}"/>
					</li>
					<li>
						<h:outputText value="房屋面积（平方米）："/>
						<h:outputText value="#{ShowSaleMsgBean.area}"/>
					</li>
					<li>
						<h:outputText value="价格（万元）："/>
						<h:outputText value="#{ShowSaleMsgBean.price}"/>
					</li>
					<li>
						<h:outputText value="信息发布日期："/>
						<h:outputText value="#{ShowSaleMsgBean.publishtime}"/>
					</li>
				</div>
				<div style="float:left;list-style:none;">
					<li>
						<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/SaleMap.jsp" target="_blank">
							<h:outputText value="查看大图"/>
						</h:outputLink>							
					</li>
					<h:form id="mf_map" style="display:none;">
						<h:inputText id="longitude" value="#{ShowSaleMsgBean.longitude}"/>
						<h:inputText id="latitude" value="#{ShowSaleMsgBean.latitude}"/>
					</h:form>
					<div id="MapDiv" style="height:300px;border:solid 1px #000000;"></div>
				</div>
				<div style="list-style:none;width:80%;margin:20px 0;font-size:14px;">
					<div><li style="background-color:gray;">如果您想查看该房源的具体信息，请在下表中填写正确的信息(在提交信息前，请你先登录)。</li></div>
					<h:form id="mf_lookdetail" onsubmit="JavaScript:return checkRent();">
						<h:panelGrid columns="2" style="font-size:14px;">
							<h:outputText value="联系人："/>
							<h:inputText id="linkman" value="#{ShowSaleMsgBean.linkman}"/>
							<h:outputText value="联系电话："/>
							<h:inputText id="tel" value="#{ShowSaleMsgBean.tel}"/>
							<h:outputText value="E-mail："/>
							<h:inputText id="email" value="#{ShowSaleMsgBean.email}"/>
						</h:panelGrid>
						<h:panelGroup>
							<h:commandButton value="提交" styleClass="btn" action="#{ShowSaleMsgBean.save}"/>&nbsp;
							<h:commandButton value="重置" styleClass="btn" type="reset" />
						</h:panelGroup>
						<h:inputText id="errMsg" value="#{ShowSaleMsgBean.errMsg}" style="display:none"/>
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
						document.getElementById("login:url").value="showsalemsg";
						document.getElementById("login").submit();
						window.location.href = "UserLogin.jsp";
					}
				}
				showMsg();
			</script>
		</body>
	</html>
</f:view>