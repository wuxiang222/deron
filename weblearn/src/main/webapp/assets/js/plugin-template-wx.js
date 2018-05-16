(function($){
	// PLUGIN CLASS DEFINITION
	var Plugin = function(plugin, config){
		// 强制this是jQuery实例
		if(!(this instanceof Plugin)) {
			return new Plugin(plugin);
		}
		var _this_ = this;
		this.plugin = plugin;

		/************** start 参数处理 ****************/
		/*
			默认参数配置
		*/
		this.config = {
			"triggerType":"click",  // 默认事件
			
		}

		/*
			初始化参数 === 如果有配置参数，则扩展默认配置
		*/
		/*
		 this.config      -- 默认参数对象
		 this.getconfig() -- 返回元素上定制参数对象
		 config           -- js定制对象
		 */
        var dataconfig =this.getConfig()
        $.extend(this.config, dataconfig, config)
		/*
			结果参数对象
		*/
		var config = this.config;
		/************** end 参数处理 ****************/

		// 1.事件绑定功能
		// 拿到事件源元素 [事件处理元素]
		var $eventSource = this.plugin.find("选择器");

		if (false) {  
			
		} else {         /* 默认事件 */
			$eventSource.bind('click',function(){
				_this_.invoke($(this));
			});
		}
		

	};




	Plugin.prototype = {

		// 处理配置参数方法，转为参数对象，创建plugin实例初始化参数时调用。
		getConfig:function(){
			// 获得plugin元素的data-config属性
			var config = this.plugin.attr("data-config");
			if (config&&config != "") {
				return $.parseJSON(config);
			}else{
				return null;
			}
		}

		// 事件驱动方法
		

			
		// 各种功能方法

		


	};

	$.fn.extend({
		plugin: function(config){

			this.each(function(){

				new Plugin( $(this), config );
			})


			return this;  // 返回调用者，为了链式调用
		}

	})

})(jQuery);