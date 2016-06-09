<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<title>秒杀详情页</title>
    <%@include file="common/header.jsp" %>
  </head>
  <body>
    <br><br><br><br>
    <div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading text-center">
				<h1>${seckill.name}</h1>
			</div>
			<div class="panel-body">
				<c:if test="${seckill.number == 0 }">
					<h2 class="text-danger text-center">
						<span class="glyphicon" id="seckill-finish">你来晚了，已经被抢完。</span>
					</h2>
				</c:if>
				<c:if test="${seckill.number > 0 }">
					<h2 class="text-danger text-center">
						<span class="glyphicon glyphicon-time"></span>
						<span class="glyphicon" id="seckill-box"></span>
					</h2>		
				</c:if>
			</div>
		</div>
	</div>  
	  
	<!-- 登录弹出层，输入用户名和电话号码 -->
	<div class="modal fade" id="killPhoneModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
				  	<h3 class="modal-title text-center">
				  		<span class="glyphicon glyphicon-phone"></span>秒杀电话：
				  	</h3>
				</div>
				<div class="modal-body">
				  	<div class="row">
				  		<div class="col-xs-12">
				  			<input type="text" name="killphone" id="killphoneKey" placeholder="填手机号^O^" class="form-control"/>
				  		</div>
				  	</div>
				</div>
				<div class="modal-footer">
                    <span id="killphoneMessage" class="glyphicon"></span>
                    <button type="button" id="killPhoneBtn" class="btn btn-success">
                        <span class="glyphicon glyphicon-phone"></span>
                        Submit
                    </button>
                </div>
			</div>
		</div>
	</div>
	
    <script src="${ctx }/js/lib/jquery/jquery-1.12.3.js"></script>
    <script src="${ctx }/js/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
    <script src="//cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
    <!-- 开始编写交互逻辑 -->
    <script src="${ctx }/js/seckill.js"></script>
    <script type="text/javascript">
    	$(function(){
    		var id = ${seckill.seckillId};
    		var startTime = ${seckill.startTime.time};
    		var endTime = ${seckill.endTime.time};
    		seckill.detail.init({
    			seckillId: id,
    			startTime: startTime,
    			endTime: endTime
    		});
    	});
    </script>
  </body>
</html>