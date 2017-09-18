<%@ page contentType="text/html;charset=gbk"
	import="javax.faces.application.*,javax.faces.component.*,javax.faces.context.*,javax.faces.validator.*"
 %>
 
 <ul id="Nav">
	<li class="first">
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/AdminIndex.jsp">
			<h:outputText value="首页" />
		</h:outputLink>
	</li>
	<li id="adminManage"
		onmouseover="JavaScript:showDiv('adminManage','popAdminManage');" 
		onmouseout="JavaScript:hideDiv('popAdminManage');">
		<h:outputLink value="#">
			<h:outputText value="管理员管理" />
		</h:outputLink>
	</li>
	<li id="customer"
		onmouseover="JavaScript:showDiv('customer','popCustomer');" 
		onmouseout="JavaScript:hideDiv('popCustomer');">
		<h:outputLink value="#">
			<h:outputText value="回复客户"/>
		</h:outputLink>
	</li>
	<li id="contract"
	 	onmouseover="JavaScript:showDiv('contract','popAdminContract');" 
	 	onmouseout="JavaScript:hideDiv('popAdminContract');">
		<h:outputLink value="#">
			<h:outputText value="合同管理"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/ModifyAdminPwd.jsp">
			<h:outputText value="修改密码"/>
		</h:outputLink>
	</li>
	<li>
		<h:form>
			<h:commandLink value="注销" action="#{AdminLoginBean.adminLogout}"/>
		</h:form>
	</li>
</ul>
 
<div id="popCustomer"
		onmouseover="JavaScript:showDiv('customer','popCustomer');" 
		onmouseout="JavaScript:hideDiv('popCustomer');"
		onclick="JavaScript:hideDiv('popCustomer');">
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/LookAllQuestion.jsp">
			<h:outputText value="回复客户问题"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/LookUserApply.jsp" title="是否允许客户查看某房源的具体信息">
			<h:outputText value="设置客户权限"/>
		</h:outputLink>
	</li>
</div>

<div id="popAdminManage"
		onmouseover="JavaScript:showDiv('adminManage','popAdminManage');" 
		onmouseout="JavaScript:hideDiv('popAdminManage');"
		onclick="JavaScript:hideDiv('popAdminManage');">
	<h:panelGroup rendered="#{AdminLoginBean.level}">
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/AddAdmin.jsp">
			<h:outputText value="添加管理员"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/LookAdmin.jsp">
			<h:outputText value="查看管理员"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/ResetPwd.jsp">
			<h:outputText value="密码重置"/>
		</h:outputLink>
	</li>
	</h:panelGroup>
	<h:panelGroup rendered="#{!AdminLoginBean.level}">
	<li>
		<h:outputText value="无此权限"/>
	</li>
	</h:panelGroup>
</div>
<div id="popAdminContract"
		onmouseover="JavaScript:showDiv('contract','popAdminContract');" 
		onmouseout="JavaScript:hideDiv('popAdminContract');"
		onclick="JavaScript:hideDiv('popAdminContract');">
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/RentContractInfo.jsp">
			<h:outputText value="房屋租赁合同"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/SaleContractInfo.jsp">
			<h:outputText value="房屋买卖合同"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/LookRentContract.jsp">
			<h:outputText value="查看租赁合同"/>
		</h:outputLink>
	</li>
	<li>
		<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/LookSaleContract.jsp">
			<h:outputText value="查看出售合同"/>
		</h:outputLink>
	</li>
</div>



