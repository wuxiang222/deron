(function($){
	/* 单击事件函数 */
	var toggle = function(){
		if($(this).siblings("li").hasClass('on')){
	        // 判断属于on类（on类名是随便起的），表示已展开
	        // 则收拢，并移除on类
	        $(this).siblings("li").slideUp(200).removeClass("on");  
	    }else{  
	        // 没有展开
	        // 首先要关闭其他ul下的li，并移除on类
	        $(this).parent().siblings().children("li").slideUp(200).removeClass("on");
	        // 然后展开兄弟li，并设置on类
	        $(this).siblings("li").slideDown(200).addClass("on");
	    }  
	}

	$.fn.extend({
		/* $('div-id').accordion(url)*/
		accordion: function(url){
			this.load(url, function(data, status, xhr){
				$accordion = $(this)
				if(status=="success"){
				var jsonArr = JSON.parse(data);
					$accordion.html('');
					$.each(jsonArr,function(index, item){
						// item = {"":[]}
						$ul = $("<ul></ul>");  //111111111
						$.each(item, function(key, val){
							// val = [x,x,x];
							
							$span = $("<span></span>");//222222
							$span.click(toggle);
							$span.append(key);
							$ul.append($span);//2222222end
							$.each(val, function(i, t){
								$li = $("<li></li>");//33333333
								$li.append(t);
								$ul.append($li);//3333333end
							});
						} );
						$accordion.append($ul);//1111111end
						
					} );
				}
				if(status=="error"){
					console.log("Error: "+xhr.status+": "+xhr.data);
				}
			} );
		
			return this;  // 为了链式调用
		}
	})
})(jQuery);