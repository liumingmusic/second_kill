var seckill = {
	URL : {
		timeUrl:'/secondKill/seckill/time/now',
		exporse:function(seckillId){
			return '/secondKill/seckill/'+ seckillId +'/exposer';
		},
		execution: function(seckillId, md5){
			return '/secondKill/seckill/' + seckillId + '/' + md5 + '/execution';
		}
	},
	/**验证手机号*/
	validationPhone : function(killPhone) {
		// 验证手机号是否填写并且，等于十一为数字
		if (killPhone && killPhone.length === 11 && !isNaN(killPhone)) {
			return true;
		} else {
			return false;
		}
	},
	/**倒计时业务处理*/
	countDown: function(seckillId, startTime, endTime, nowTime){
		var $seckillBox = $('#seckill-box');
		if(nowTime > endTime){
			$seckillBox.html('秒杀结束!');
		} else if(nowTime < startTime){
			//倒计时
			var killTime = new Date(startTime +1000);
			$seckillBox.countdown(killTime, function(event){
				//控制时间格式,只做计时操作
				var format = event.strftime('秒杀倒计时:%D天 %H时 %M分 %S秒');
				$seckillBox.html(format);
			}).on('finish.countdown', function(){
				//时间完成后回调函数
				//获取秒杀地址，控制实现逻辑，执行秒杀操作
				seckill.handleSeckill(seckillId, $seckillBox);
			});
		} else {
			seckill.handleSeckill(seckillId, $seckillBox);
		}
	},
	/**秒杀业务*/
	handleSeckill: function(seckillId, $seckillBox){
		//1、秒杀开始，显示按钮
		$seckillBox.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
		//2、获取秒杀地址
		$.post(seckill.URL.exporse(seckillId),{}, function(result){
			//在回调函数中执行交互作用
			if(result && result['success']){
				// 秒杀核心业务代码
				seckill.seckillCore(seckillId, $seckillBox, result);
			}else{
				console.log('result=' + result);
			}
		});
	},
	/** 秒杀详细业务逻辑 */
	seckillCore: function(seckillId, $seckillBox, result){
		var exposer = result['data'];
		if(exposer.exposed){
			//获取秒杀地址
			var md5 = exposer['md5'];
			var killUrl = seckill.URL.execution(seckillId, md5);
			//对对按钮绑定一次时间
			$("#killBtn").one("click", function(){
				//1、按钮禁用
				$(this).addClass('disabled');
				//2、发送请求执行秒杀
				$.post(killUrl, {}, function(result){
					if(result && result['success']){
						var killResult = result['data'];
						var state = killResult['state'];
						var stateInfo = killResult['stateInfo'];
						//显示秒杀结果
						$seckillBox.html('<span class="label label-success">'+ stateInfo +'</span>');
					} else {
						//用户没有登录情况处理
						seckill.detail.validationInput();
					}
				});
			});
			//显示按钮
			$seckillBox.show();
		}else{
			// 秒杀未开始，各个设备对系统时间和用户设备时间不一致的情况进行处理
			var now = exposer['now'];
			var start = exposer['start'];
			var end = exposer['end'];
			//重新时间判断，计时交互
			seckill.countDown(seckillId, startTime, endTime, nowTime);
		}
	},
	detail : {
		/** 初始胡方法 */
		init : function(param) {
			// 详情页，初始化
			var killPhone = $.cookie("killPhone");
			// 1、验证用户手机是否填写
			if (!seckill.validationPhone(killPhone)) {
				seckill.detail.validationInput();
			}
			// 2、已经登录,没有开启，计时交互
			var seckillId = param.seckillId;
			var startTime = param.startTime;
			var endTime = param.endTime;
			seckill.detail.countDown(seckillId, startTime, endTime);
		},
		/**倒计时业务*/
		countDown: function(seckillId, startTime, endTime){
			$.get(seckill.URL.timeUrl, {}, function(result){
				if(result && result['success']){
					var nowTime = result['data'];
					//时间判断，计时交互
					seckill.countDown(seckillId, startTime, endTime, nowTime);
				}else{
					console.log('result=' + result);
				}
			});
		},
		/**用户登录验证*/
		validationInput: function(){
			var $killPhoneModal = $("#killPhoneModal");
			$killPhoneModal.modal({
				backdrop : 'static',
				show : true,
				keyboard : false
			});
			// 绑定按钮事件
			$("#killPhoneBtn").click(function() {
				var killphoneKey = $("#killphoneKey").val();
				if (seckill.validationPhone(killphoneKey)) {
					// 刷新页面之前,将值存在cookie中
					$.cookie("killPhone", killphoneKey, {
						expires : 7,
						path : '/secondKill/'
					});
					window.location.reload();
				} else {
					var $killphoneMessage = $("#killphoneMessage");
					$killphoneMessage.hide().html("<label class='label label-danger'>手机号码输入有误!</label>").show(300);
				}
			});
		}
	}
};