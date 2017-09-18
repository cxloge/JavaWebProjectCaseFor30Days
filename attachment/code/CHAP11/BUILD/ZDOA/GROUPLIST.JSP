<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:select id="group" name="group" onchange="updateRole();" cssStyle="width:200px;" list="groupList" listKey="groupNumber" listValue="groupName"/>