<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="top.jsp" %>
	  	<span style="margin-left:5px;">
	  		<h:outputText value="首页 >> " rendered="#{UserLogin.uname!=null}"></h:outputText>
	  		<h:outputText value="#{UserLogin.message}" rendered="#{UserLogin.uname!=null}"></h:outputText>
	  	</span>
	  	<div style="font-size:13px;word-break: break-all;line-height:24px;padding:15px;8px;">
							<img border="0" src="images/index.jpg" hspace="10"style="margin-right: 4px" align="left" width="300" height="200">

								 &nbsp;&nbsp;&nbsp;&nbsp; A10酒店由A10国际发展有限公司投资4.5亿元，按五星级标准兴建。占地面积58亩，
								 主楼高20层（含负一层），总建筑面积6万㎡，其中主楼4.5万㎡,拥有客房共508间（套），
								 18套豪华商务套房和八套总统套房。配备有独立中央空调、高档沐浴系统、国际卫星电视频道、
								 数字电视、迷你吧、冰箱、电子保险箱、国际互联网、宽带上网。酒店设计人性化：有残疾人士
								 专用客房、家庭用房以及单人房。<br/>								
								  &nbsp;&nbsp;&nbsp;&nbsp;餐饮有徽、川、湘、粤、杭帮等菜系。设有48间豪华包厢；
								  八楼西餐厅让您品尝异域美食；四楼宴会厅，可同时容纳600人大型宴会；酒店设有大型多
								  功能厅6个，大会堂可容纳千人大型会议，小型会议室9个，接见厅6个，各项配套设施高档，
								  满足不同类型会议的需求，具有千人餐饮及会务的接待能力。网球场、游泳池、健身房、
								  SPA、咖啡吧、棋牌室、音乐茶座、舞厅、KTV包厢、美容美发等设施一应俱全。
								<br/>
								&nbsp;&nbsp;&nbsp;&nbsp;A10酒店全体员工将竭诚为您提供舒适温馨的客房，美味可口的菜肴，现代便捷的设施和
								尽善尽美的服务，令您在旅行逗留期间舒适安逸。我们将为您的满意而不懈努力。愿我们早日相聚在A10！



						</div>
  	</div>
  	</body>
 </html>
 </f:view>