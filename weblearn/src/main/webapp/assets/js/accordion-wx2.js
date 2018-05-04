(function(){
	var Accordion = function(accordion , config){
		// 强制this是jQuery实例
		if(!(this instanceof Accordion)) {
			return new Accordion(accordion);
		}
		var _this_ = this;
		this.accordion = accordion;

		// 默认配置
		this.config = {
			"triggerType":"click",/*默认事件*/
			"url":"none"
		}


		// 0.初始化参数 === 如果有配置参数，则扩展默认配置
		if (this.getConfig() ) {
			$.extend(this.config, this.getConfig())
		}
		var config = this.config;

		// 1.事件绑定功能
		// 拿到事件源元素 和 事件处理元素
		// 此处事件源ul>span
		var $accordion_head = this.accordion.find(".accordion-head");
		if (config.triggerType === 'click') {
			$accordion_head.bind('click', function(){
				_this_.toggle($(this));
			});
		}
	}





	Accordion.prototype = {
		// 处理配置参数方法，转为参数对象，创建Tab实例初始化参数时调用。
		getConfig:function(){
			// 获得tab元素的data-config属性
			var config = this.accordion.attr("data-config");

			if (config&&config != "") {
				return $.parseJSON(config);
			}else{
				return null;
			}
		},

		// 事件驱动方法
		toggle : function(active_head){
			if(active_head.siblings("li").hasClass('on')){
		        // 判断属于on类（on类名是随便起的），表示已展开
		        // 则收拢，并移除on类
		        active_head.siblings("li").slideUp(200).removeClass("on");  
		    }else{  
		        // 没有展开
		        // 首先要关闭其他ul下的li，并移除on类
		        active_head.parent().siblings().children("li").slideUp(200).removeClass("on");
		        // 然后展开兄弟li，并设置on类
		        active_head.siblings("li").slideDown(200).addClass("on");
		    }  
		}

	}

	$.fn.extend({
		accordion:function(config){
			new Accordion( $(this), config)
		}
	});

})(jQuery)