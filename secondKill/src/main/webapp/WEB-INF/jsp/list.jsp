<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<title>秒杀列表页</title>
    <%@include file="common/header.jsp" %>
  </head>
  <body>
	<br><br><br><br>
    <div class="container">
		<div class="panel panel-success">
			<div class="panel-heading text-center">
				<h3>秒杀列表</h3>
			</div>
			<div class="panel-body">
			  	<table class="table table-hover">
			  		<thead>
			  			<tr>
			  				<th>名称</th>	
			  				<th>库存</th>
			  				<th>开始时间</th>
			  				<th>结束时间</th>
			  				<th>创建时间</th>
			  				<th>详情页</th>
			  			</tr>
			  		</thead>
			  		<tbody>
			  			<c:forEach var="sk" items="${list}">
			  				<tr>
				  				<td>${sk.name}</td>
				  				<td>${sk.number}</td>
				  				<td><fmt:formatDate value="${sk.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				  				<td><fmt:formatDate value="${sk.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				  				<td><fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				  				<c:if test="${sk.number > 0 }">
				  					<td align="center"><a href="${ctx }/seckill/${ sk.seckillId}/detail" class="btn btn-primary">详情</a></td>
				  				</c:if>
				  				<c:if test="${sk.number == 0 }">
				  					<td align="center"><a href="#" class="btn btn-info" target="_blank">已经抢完,查看列表</a></td>
				  				</c:if>
				  			</tr>
			  			</c:forEach>
			  		</tbody>
				</table>
			</div>
		</div>
    </div>
    <script src="${ctx }/js/lib/jquery/jquery-1.12.3.js"></script>
    <script src="${ctx }/js/lib/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>