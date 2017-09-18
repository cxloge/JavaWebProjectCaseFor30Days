<%@ page contentType="text/html;charset=gbk" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
		<head>
			<title>二手房</title>
			<script type="text/javascript" src="dojo-release-1.1.1/dojo/dojo.js" djConfig="isDebug:false, parseOnLoad: true"></script>
			<link href="dojo-release-1.1.1/dojo/resources/dojo.css" rel="stylesheet" type="text/css" />
			<link href="dojo-release-1.1.1/dijit/themes/tundra/tundra.css" rel="stylesheet" type="text/css" />
			<link href="dojo-release-1.1.1/dojox/widget/FisheyeList/FisheyeList.css" rel="stylesheet" type="text/css" />
			<link href="css/index.css" rel="stylesheet" type="text/css" />
			<link href="css/search.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/tab.js"></script>
			<script type="text/javascript">
				dojo.require("dojox.widget.FisheyeList");
				dojo.require("dojo.parser");
			</script>
		</head>
		<body>
		<center>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<h:outputText value="#{IndexBean.initList}" style="display:none;"/>
				<div style="float:left;width:75%;height:450px;">
					<div style="margin-top:4px;margin-top:10px;width:576px;">
						<%@ include file="MsgSearch.jsp" %>
					</div>
					
					<div style="width:567px;margin:5px 0;">
						<div style="background:url(images/cs.jpg) no-repeat left bottom;width:567px;height:30px;padding-right:20px;padding-top:5px;">
							<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/SalePublish.jsp" style="float:right;width:60;">
								<h:outputText value=""/>
							</h:outputLink>
						</div>
						<div class="outer" style="margin:0 0;padding:0;height:160px;">
						<h:panelGroup rendered="#{IndexBean.saleShow}">
							<div>
								<li>物业地址/名称</li>
								<li>户型</li>
								<li>楼层</li>
								<li>建筑面积(m<sup>2</sup>)</li>
								<li>售价(万)</li>
							</div>
							<h:form>
							<h:dataTable value="#{IndexBean.saleList}" var="si" width="100%" rowClasses="evenRow,oddRow" columnClasses="perCol,perCol,perCol,perCol,perCol">								
						        <h:column>
						        	<h:commandLink value="#{si.s_location}" action="#{IndexBean.getSelectSaleObj}"/>
						        </h:column>
						        
						        <h:column>
						            <h:outputText value="#{si.s_type}"/>
						        </h:column>
						        <h:column>
						            <h:outputText value="#{si.s_high}"/>
						        </h:column>  
						        <h:column>
						            <h:outputText value="#{si.s_area}"/>
						        </h:column>
						        <h:column>
						        	<h:outputText value="#{si.s_price}"/>
						        </h:column>
						    </h:dataTable>
						    </h:form>
						    <li style="float:right;border:none;">
						    	<h:form>
						    		<h:commandLink value=">>更多信息" action="#{IndexBean.allSaleInfo}"/>
						    	</h:form>
						    </li>
						</h:panelGroup>
						<h:outputText value="暂无信息" rendered="#{!IndexBean.saleShow}"/>
						</div>
					</div>
					<div style="width:567px;margin:5px 0;">
						<div style="background:url(images/qg.jpg) no-repeat left bottom;width:567px;height:30px;padding-right:30px;padding-top:5px;">
							<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/QiuGouPublish.jsp" style="float:right;width:60;">
								<h:outputText value=""/>
							</h:outputLink>
						</div>
						<div class="outer" style="margin:0 0;padding:0;height:160px;">
						<h:panelGroup rendered="#{IndexBean.qiuGouShow}">
							<div>
								<li>物业地址/名称</li>
								<li>户型</li>
								<li>楼层</li>
								<li>建筑面积(m<sup>2</sup>)</li>
								<li>售价(万)</li>
							</div>
							<h:form>
							<h:dataTable value="#{IndexBean.qiuGouList}" var="si" width="100%" rowClasses="other,oddRow" columnClasses="perCol,perCol,perCol,perCol,perCol">								
						        <h:column>
						        	<h:commandLink value="#{si.s_location}" action="#{IndexBean.getSelectQiuGouObj}"/>
						        </h:column>						        
						        <h:column>
						            <h:outputText value="#{si.s_type}"/>
						        </h:column>
						        <h:column>
						            <h:outputText value="#{si.s_high}"/>
						        </h:column>  
						        <h:column>
						            <h:outputText value="#{si.s_area}"/>
						        </h:column>
						        <h:column>
						        	<h:outputText value="#{si.s_price}"/>
						        </h:column>
						    </h:dataTable>
						    </h:form>
						    <li style="float:right;border:none;">
						    	<h:form>
						    		<h:commandLink value=">>更多信息" action="#{IndexBean.allQiuGouInfo}"/>
						    	</h:form>
						    </li>
						</h:panelGroup>
						<h:outputText value="暂无信息" rendered="#{!IndexBean.qiuGouShow}"/>
						</div>
					</div>
				</div>
				<div style="float:right;width:23%;height:430px;background-color:white;margin-top:10px;">
					<div style="background:url(images/fabu.jpg)">
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
				<div style="float:left;width:375px;margin:5px 0;">
					<div style="background:url(images/cz.gif) no-repeat left bottom;width:375px;height:30px;padding-right:50px;padding-top:5px;">
						<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/RentPublish.jsp" style="float:right;width:60;">
							<h:outputText value=""/>
						</h:outputLink>
					</div>
					<div class="outer" style="margin:0 0;padding:0;height:160px;">
					<h:panelGroup rendered="#{IndexBean.rentShow}">
						<div>
							<li style="width:25%;">物业地址/名称</li>
							<li style="width:25%;">户型</li>
							<li style="width:25%;">建筑面积(m<sup>2</sup>)</li>
							<li style="width:25%;">租金(元/月)</li>
						</div>
						<h:form>
						<h:dataTable value="#{IndexBean.rentList}" var="ri" width="100%" rowClasses="evenRow,oddRow" columnClasses="perCol,perCol,perCol,perCol,perCol">								
					        <h:column>
					        	<h:commandLink value="#{ri.r_location}" action="#{IndexBean.getSelectRentObj}"/>
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
					    <li style="float:right;border:none;">
					    	<h:form>
					    		<h:commandLink value=">>更多信息" action="#{IndexBean.allRentInfo}"/>
					    	</h:form>
					    </li>
					</h:panelGroup>
					<h:outputText value="暂无信息" rendered="#{!IndexBean.rentShow}"/>
					</div>
				</div>
				<div style="float:right;width:375px;margin:5px 0;">
					<div style="background:url(images/qz.gif) no-repeat left bottom;width:375px;height:30px;padding-right:50px;padding-top:5px;">
						<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/QiuZuPublish.jsp" style="float:right;width:60;">
							<h:outputText value=""/>
						</h:outputLink>
					</div>
					<div class="outer" style="margin:0 0;padding:0;height:160px;">
					<h:panelGroup rendered="#{IndexBean.qiuZuShow}">
						<div>
							<li style="width:25%;">物业地址/名称</li>
							<li style="width:25%;">户型</li>
							<li style="width:25%;">建筑面积(m<sup>2</sup>)</li>
							<li style="width:25%;">租金(元/月)</li>
						</div>
						<h:form>
						<h:dataTable value="#{IndexBean.qiuZuList}" var="ri" width="100%" rowClasses="other,oddRow" columnClasses="perCol,perCol,perCol,perCol,perCol">
					        <h:column>
					        	<h:commandLink value="#{ri.r_location}" action="#{IndexBean.getSelectQiuZuObj}"/>
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
					    <li style="float:right;border:none;">
					    	<h:form>
					    		<h:commandLink value=">>更多信息" action="#{IndexBean.allQiuZuInfo}"/>
					    	</h:form>
					    </li>
					</h:panelGroup>
					<h:outputText value="暂无信息" rendered="#{!IndexBean.qiuZuShow}"/>
					</div>
				</div>
			</div>
			</center>
		</body>
	</html>
</f:view>