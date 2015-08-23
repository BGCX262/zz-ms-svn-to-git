<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<%String contextPath = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/ext-all.css">
    <script type="text/javascript" src="<%=contextPath %>/extjs/ext-all.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/app.js"></script>
<title>Insert title here</title>
<style type="text/css">
p {
    margin:5px;
}
.x-panel-header-text-default {
    font-size: 12px;
}
.x-tab-inner {
    font-size: 12px;
}
.settings {
    background-image:url(<%=contextPath %>/resources/images/icons/fam/folder_wrench.png);
}
.nav {
    background-image:url(<%=contextPath %>/resources/images/icons/fam/folder_go.png);
}
.info {
    background-image:url(<%=contextPath %>/resources/images/icons/fam/information.png);
}
.x-grid-cell-inner {
    font-size: 12px;
}
</style>
</head>
<body>
  <!-- use class="x-hide-display" to prevent a brief flicker of the content -->
    
    <div id="center1" class="x-hide-display">
        这是我的桌面
    </div>
     <div id="header" class="x-hide-display">
        <p>这里是头的信息</p>
    </div>
</body>
</html>