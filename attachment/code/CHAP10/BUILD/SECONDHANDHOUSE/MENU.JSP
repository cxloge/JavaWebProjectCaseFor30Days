<%@ page contentType="text/html;charset=gbk"
	import="javax.faces.application.*,javax.faces.component.*,javax.faces.context.*,javax.faces.validator.*"
 %>

<ul id="Nav">
	<li class="first">
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
			<h:outputText value="首页" />
		</h:outputLink>
	</li>
	<li id="publishArea"
		onmouseover="JavaScript:showDiv('publishArea','popPublish');"
		onmouseout="JavaScript:hideDiv('popPublish');">
		<h:outputLink value="#">
			<h:outputText value="信息发布区"/>
		</h:outputLink>
	</li>
	<li id="contractArea"
		onmouseover="JavaScript:showDiv('contractArea','popContract');"
		onmouseout="JavaScript:hideDiv('popContract');">
		<h:outputLink value="#">
			<h:outputText value="标准合同查询" />
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/LawInfo.jsp" >
			<h:outputText value="法律法规查询" />
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/QuestionInfo.jsp">
			<h:outputText value="在线咨询"/>
		</h:outputLink>
	</li>
	<li id="account"
		onmouseover="JavaScript:showDiv('account','popMenu');" 
		onmouseout="JavaScript:hideDiv('popMenu');">
		<h:outputLink value="#">
			<h:outputText value="账号维护" />
		</h:outputLink>
	</li>
</ul>
<div id="popMenu"
		onmouseover="JavaScript:showDiv('account','popMenu');" 
		onmouseout="JavaScript:hideDiv('popMenu');"
		onclick="JavaScript:hideDiv('popMenu');">
	<h:panelGroup rendered="#{UserLoginBean.flag==false}">
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/UserLogin.jsp" >
				<h:outputText value="登录" />
			</h:outputLink>
		</li>
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Register.jsp">
				<h:outputText value="注册" />
			</h:outputLink>
		</li>
	</h:panelGroup>
	<h:panelGroup rendered="#{UserLoginBean.flag==true}">
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/ModifyUserPwd.jsp">
				<h:outputText value="密码修改" />
			</h:outputLink>
		</li>
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/LookUserInfo.jsp">
				<h:outputText value="资料查看" />
			</h:outputLink>
		</li>
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/MyQiuZuInfo.jsp">
				<h:outputText value="求租信息" />
			</h:outputLink>
		</li>
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/MyRentInfo.jsp">
				<h:outputText value="出租信息" />
			</h:outputLink>
		</li>
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/MySaleInfo.jsp">
				<h:outputText value="出售信息" />
			</h:outputLink>
		</li>
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/MyQiuGouInfo.jsp">
				<h:outputText value="求购信息" />
			</h:outputLink>
		</li>
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/MyApplyInfo.jsp">
				<h:outputText value="查看预约" />
			</h:outputLink>
		</li>
		<li>
			<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/MyQuestion.jsp">
				<h:outputText value="我的问题"/>
			</h:outputLink>
		</li>
		<li>
			<h:form>
				<h:commandLink value="注销" action="#{IndexBean.logout}"/>
			</h:form>
		</li>
	</h:panelGroup>
</div>
<div id="popPublish"
		onmouseover="JavaScript:showDiv('publishArea','popPublish');"
		onmouseout="JavaScript:hideDiv('popPublish');"
		onclick="JavaScript:hideDiv('popPublish');">
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/RentPublish.jsp">
			<h:outputText value="出租信息登记"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/QiuZuPublish.jsp">
			<h:outputText value="求租信息登记"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/QiuGouPublish.jsp">
			<h:outputText value="求购信息登记"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/SalePublish.jsp">
			<h:outputText value="出售信息登记"/>
		</h:outputLink>	
	</li>
</div>

<div id="popContract"
		onmouseover="JavaScript:showDiv('contractArea','popContract');"
		onmouseout="JavaScript:hideDiv('popContract');"
		onclick="JavaScript:hideDiv('popContract');">
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/RentContract.jsp">
			<h:outputText value="房屋租赁合同样本"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/SaleContract.jsp">
			<h:outputText value="二手房屋买卖合同样本"/>
		</h:outputLink>
	</li>
</div>