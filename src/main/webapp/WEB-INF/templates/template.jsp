<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
  <head>
    <meta charset="utf-8">
    <c:set var="titleKey">
      <tiles:getAsString name="title" />
    </c:set>
    <title>Bookstore</title>
  </head>
  <body>
    <div id="wrap">
      <tiles:insertAttribute name="header"/>
      <div class="center_content">
        <div class="left_content">
          <tiles:insertAttribute name="body" />
        </div><!--end of left content-->
      </div>
      <tiles:insertAttribute name="footer" />
    </div>
  </body>
</html>