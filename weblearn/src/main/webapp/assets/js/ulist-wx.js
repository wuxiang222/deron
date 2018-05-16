(function ($) {
    // PLUGIN CLASS DEFINITION
    var UList = function (ulist, config) {
        // 强制this是jQuery实例
        if (!(this instanceof UList)) {
            return new UList(ulist);
        }
        var _this_ = this;
        this.ulist = ulist;

        /************** start 参数处理 ****************/
        /*
         默认参数配置
         */
        this.config = {
            "triggerType": "click",  // 默认事件

        }

        /*
         初始化参数 === 如果有配置参数，则扩展默认配置
         */
        /*
         this.config      -- 默认参数对象
         this.getconfig() -- 返回元素上定制参数对象
         config           -- js定制对象
         */
        var dataconfig = this.getConfig()
        $.extend(this.config, dataconfig, config)
        /*
         结果参数对象
         */
        var config = this.config;
        /************** end 参数处理 ****************/
        ulist.load(config.url, function (data, status, xhr) {
            $ulist = $(this);
            // data ====  [{"content":"111111","id":1,"menuId":1,"title":"222"} , {}, ... ]
            // js添加<ul><li>
            if (status == "success") {
                var jsonArr = JSON.parse(data);
                $ulist.html('');
                $.each(jsonArr, function (index, item) {

                    $ul = $("<ul></ul>");
                    $.each(item, function (key, val) {
                        if (key === "title") {
                            $li = $("<li></li>");
                            $a = $("<a></a>");
                            $a.append(val);
                            $li.append($a);
                            $ul.append($li)
                        }
                    });
                    $ulist.append($ul);
                });
            }

        });

        // 1.事件绑定功能
        // 拿到事件源元素 [事件处理元素]
        var $eventSource = this.ulist.find("ul>li");

        if (config.triggerType !== 'click') {
            $eventSource.bind(config.triggerType, function (e) {
                _this_.invoke($(this));
            });
        } else {         /* 默认事件 */
            $eventSource.bind('click', function () {
                _this_.invoke($(this));
            });
        }


    };


    UList.prototype = {

        // 处理配置参数方法，转为参数对象，创建ulist实例初始化参数时调用。
        getConfig: function () {
            // 获得ulist元素的data-config属性
            var config = this.ulist.attr("data-config");
            if (config && config != "") {
                config = config.replace(/\s/g, "");
                config = config.replace(/^|\'|\b(?=:)/g, "\"");
                config = config.replace(/,/g, ",\"");
                config = "{" + config + "}";
                return JSON.parse(config);
            } else {
                return null;
            }
        },

        // 事件驱动方法
        invoke: function (currentTab_li) {

            var _this_ = this;
            var index = currentTab_li.index();
            var effect = this.config.effect;
            var $tab_item = this.tab_item;

            /*
             将选中tab_li设置为白底，即是加active类。
             将对应的content-item切换显示，切换效果跟据effect参数
             */
            if (!currentTab_li.hasClass('active')) {
                // 切换tab标题
                currentTab_li.addClass('active').siblings().removeClass('active');
                // 切换内容
                if (effect === "fade") {
                    $tab_item.eq(index).fadeIn().siblings().fadeOut();
                } else if (effect === "slide") {
                    $tab_item.eq(index).slideDown().siblings().slideUp();
                } else {  /* 默认切换效果 */
                    $tab_item.eq(index).addClass("current").siblings().removeClass('current');
                }
            }

            // 同步自动轮播计数器
            if (this.config.auto) {
                this.loop = index;
            }
        },


        // 各种功能方法


    };

    $.fn.extend({
        ulist: function (config) {

            this.each(function () {

                new UList($(this), config);
            })


            return this;  // 返回调用者，为了链式调用
        }

    })

})(jQuery);