(function($){
	// TAB CLASS DEFINITION
	var Tab = function(tab, config){
		// 强制this是jQuery实例
		if(!(this instanceof Tab)) {
			return new Tab(tab);
		}
		var _this_ = this;
		this.tab = tab;

		// 默认配置
		this.config = {
			"triggerType":"click",/*默认事件*/
			"effect":"default",/*默认效果*/
			"invoke":1,/*默认显示编号*/
			"auto":false/*默认不自动切换*/
		}

		// 0.初始化参数 === 如果有配置参数，则扩展默认配置
		if (this.getConfig() ) {
			$.extend(this.config, this.getConfig())
		}
		var config = this.config;


		// 1.事件绑定功能
		// 拿到事件源元素 和 事件处理元素
		// 此处事件源<li>  事件处理对象<div.content-item>
		var $tab_li = this.tab_li = this.tab.find(".tab-nav>li");
		var $tab_item = this.tab_item = this.tab.find(".content-wrap .content-item");

		if (config.triggerType === 'mouseover') {   /* 鼠标覆盖事件 */
			$tab_li.bind(config.triggerType,function(e){
				_this_.invoke($(this));
			});
		} else {         /* 默认事件 */
			$tab_li.bind('click',function(){
				_this_.invoke($(this));
			});
		}


		// 2.选项卡自动切换功能，默认auto = false,例如auto = 2000,则跟据时间切换
		if (config.auto) {
			// 定义一个全局定时器属性
			this.timer = null;
			// 定义计数器
			this.loop = 0;

			this.autoPlay();

			this.tab.hover(
				function(){window.clearInterval(_this_.timer);},
				function(){_this_.autoPlay();}
			);

		}

		// 3.设置显示第几个，默认 invoke = 1,第一个
		if (config.invoke) {
			this.invoke($tab_li.eq(config.invoke-1));
		}

		

	};




	Tab.prototype = {

		// 处理配置参数方法，转为参数对象，创建Tab实例初始化参数时调用。
		getConfig:function(){
			// 获得tab元素的data-config属性
			var config = this.tab.attr("data-config");

			if (config&&config != "") {
				return $.parseJSON(config);
			}else{
				return null;
			}
		},

		// 事件驱动方法
		invoke:function(currentTab_li){

			var _this_ = this;
			var index = currentTab_li.index();
			var effect = this.config.effect;
			var $tab_item = this.tab_item;

			/* 
			将选中tab_li设置为白底，即是加active类。
			将对应的content-item切换显示，切换效果跟据effect参数
			*/
			if(!currentTab_li.hasClass('active')){
				// 切换tab标题
				currentTab_li.addClass('active').siblings().removeClass('active');
				// 切换内容
				if (effect === "fade"){
					$tab_item.eq(index).fadeIn().siblings().fadeOut();
				} else if (effect === "slide"){
					$tab_item.eq(index).slideDown().siblings().slideUp();
				} else {  /* 默认切换效果 */
					$tab_item.eq(index).addClass("current").siblings().removeClass('current');
				}
			}

			// 同步自动轮播计数器
			if(this.config.auto){
				this.loop = index;
			}
		},


		// 自动控制切换方法
		autoPlay:function(){

			var _this_   = this,
				$tab_li  = this.tab_li,
				length = $tab_li.length,
				config   = this.config;

			this.timer = window.setInterval(function(){
				_this_.loop = (_this_.loop+1)%length;
				var auto = $tab_li.eq(_this_.loop);
				auto.trigger(config.triggerType);
				if (config.triggerType === "mouseover") {
					auto.trigger('mouseout');
				}

			}, config.auto);
		}


	};

	$.fn.extend({
		tab: function(config){

			this.each(function(){

				new Tab( $(this), config );
			})


			return this;  // 返回调用者，为了链式调用
		}

	})

})(jQuery);