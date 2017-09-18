<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>出租信息</title>
			<script type="text/javascript" src="dojo-release-1.1.1/dojo/dojo.js" djConfig="isDebug:false, parseOnLoad: true"></script>
			<link href="dojo-release-1.1.1/dojo/resources/dojo.css" rel="stylesheet" type="text/css" />
			<link href="dojo-release-1.1.1/dijit/themes/tundra/tundra.css" rel="stylesheet" type="text/css" />
			<link href="dojo-release-1.1.1/dojox/widget/FisheyeList/FisheyeList.css" rel="stylesheet" type="text/css" />
			<link href="css/index.css" rel="stylesheet" type="text/css" />
			<link href="css/search.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/allinfo.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
			<link href="css/tip.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript">
				dojo.require("dojox.widget.FisheyeList");
				dojo.require("dojo.parser");
			</script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<h:outputText value="#{AllRentInfoBean.initList}" style="display:none;"/>
				<p style="text-align:left;">&nbsp;
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>出租信息" />
				</p>
				<div style="width:80%;">
					<div style="float:left;width:375px;margin:5px 0;">
						<div style="background:url(images/cz.gif) no-repeat left bottom;width:375px;height:30px;padding-right:50px;padding-top:5px;">
							<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/RentPublish.jsp" style="float:right;width:60;">
								<h:outputText value=""/>
							</h:outputLink>
						</div>
						<div class="outer" style="margin:0 0;padding:0;height:400px;">
							<h:panelGroup rendered="#{AllRentInfoBean.showList}">
							<div>
								<li style="width:25%;">物业地址/名称</li>
								<li style="width:25%;">户型</li>
								<li style="width:25%;">建筑面积(m<sup>2</sup>)</li>
								<li style="width:25%;">租金(元/月)</li>
							</div>
							<h:form>
							<h:dataTable value="#{AllRentInfoBean.objList}" var="ri" width="100%" rowClasses="evenRow,oddRow" columnClasses="perCol,perCol,perCol,perCol,perCol">								
						        <h:column>
						        	<h:commandLink value="#{ri.r_location}" action="#{AllRentInfoBean.getSelectRentObj}"/>
						        </h:column>						        
						        <h:column>
						            <h:outputText value="#{ri.r_type}"/>
						        </h:column>
						        <h:column>
						            <h:outputText value="#{ri.r_area}"/>
						        </h:column>
						        <h:column>
						        	<h:outputText value="#{ri.r_price}"/>
						        </h:column>
						    </h:dataTable>
						    </h:form>
						    <h:panelGrid columns="4" style="width:100%;">
						    	<h:panelGroup>
						    		<h:outputText value="当前页：第#{AllRentInfoBean.nowPage}页"/>&nbsp;&nbsp;
						    		<h:outputText value="共#{AllRentInfoBean.totalPage}页"/>
								</h:panelGroup>
								<h:form>
									<h:commandButton image="/images/pre.gif" action="#{AllRentInfoBean.prePage}" rendered="#{AllRentInfoBean.nowPage>1}"/>
									<h:outputText value="" rendered="#{AllRentInfoBean.nowPage==1}"/>
								</h:form>
								<h:form>
									<h:commandButton image="/images/next.gif" action="#{AllRentInfoBean.nextPage}" rendered="#{AllRentInfoBean.nowPage<AllRentInfoBean.totalPage}"/>
									<h:outputText value="" rendered="#{AllRentInfoBean.nowPage==AllRentInfoBean.totalPage}"/>
								</h:form>
								<h:form id="mf" onsubmit="JavaScript:return checkPage();">
									<h:outputText value="第"/>
									<h:inputText id="page" value="#{AllRentInfoBean.nowPage}" style="width:20px;" onclick="JavaScript:clearPage();"/>
									<h:outputText value="页"/>
									<h:inputText value="#{AllRentInfoBean.totalPage}" id="totalPage" style="display:none;"/>
									<h:commandButton image="/images/go.gif"/>
								</h:form>
						    </h:panelGrid>
						</h:panelGroup>
						<h:outputText value="没有您要查看的信息！" rendered="#{!AllRentInfoBean.showList}"/>
						</div>
					</div>
					<div style="float:right;width:30%;height:430px;background-color:white;">
						<div style="background:url(images/fabu.jpg);">
							信息发布
						</div>
						<div class="outer">
							<br/><br/>
							<div dojoType="dojox.widget.FisheyeList"
								itemWidth="85" itemHeight="60"
								itemMaxWidth="111" itemMaxHeight="84"
								orientation="vertical"
								effectUnits="1"
								itemPadding="10"
								attachEdge="top"
								labelEdge="right"
								id="fisheye1"
							>
								<div dojoType="dojox.widget.FisheyeListItem"
									label="出租"
									style="cursor:hand;"
									onclick="JavaScript:window.location.href='RentPublish.jsp'"
									iconSrc="images/chuzu.jpg">
								</div>
								<div dojoType="dojox.widget.FisheyeListItem"
									label="求租"
									style="cursor:hand;"
									onclick="JavaScript:window.location.href='QiuZuPublish.jsp'"
									iconSrc="images/qiuzu.jpg">
								</div>					
								<div dojoType="dojox.widget.FisheyeListItem"
									label="出售"
									style="cursor:hand;"
									onclick="JavaScript:window.location.href='SalePublish.jsp'"
									iconSrc="images/chushou.jpg">
								</div>
								<div dojoType="dojox.widget.FisheyeListItem"
									label="求购"
									style="cursor:hand;"
									onclick="JavaScript:window.location.href='QiuGouPublish.jsp'"
									iconSrc="images/qiugou.jpg">
								</div>
							</div>
							<div style="float:bottom"><br/><br/>
								在输入要发布信息时，<br/>请您输入正确的信息，<br/>以保证我们的服务质量！
							</div>
						</div>
					</div>
					<%@ include file="Tip.jsp" %>
				</div>
			</div>
		</body>
	</html>
</f:view>