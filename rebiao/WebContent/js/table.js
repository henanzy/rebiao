    function initScrollBar(mainSelector, leftBlankSelector, rightScrollBarSelector, theadTableSelector, tbodyTableSelector, width, height){
        // initStyle
        var w = null;
        if(width){
            w = width + 'px';
        }else{
            w = 'auto';
        }
        var h = null;
        if(height){
            h = height + 'px';
        }else{
            h = 'auto';
        }
        $(mainSelector).css({
            "position":"relative"
        });
        $(leftBlankSelector).css({
            "overflow-x": "auto",
            "position": "relative",
            "width": w
        });
        $(theadTableSelector).css({
            "display": "block",
            "background-color": "#dedede",
            "position": "absolute",
            "background-color": "#dedede",
            "top":"0"
        });
        $(theadTableSelector + " thead").css({
            "display": "block"
        });
        $(tbodyTableSelector).css({
            "overflow-y": "auto",
            "display": "block",
            "height": h
        });

        // initTableUI
        var ttttt = [];
        $(tbodyTableSelector + " thead tr th").each(function(index, jq){
            jq = $(jq);
            ttttt[index] = jq.width();
        });

        $(theadTableSelector + " thead tr th").each(function(index, jq){
            jq = $(jq);
            jq.css("width", ttttt[index]+"px");
        });
        $(theadTableSelector + " thead").css({"width":$(tbodyTableSelector + " thead").width()});
        $(theadTableSelector).css("width", $(theadTableSelector + " thead").width() + "px");

        if(($(tbodyTableSelector + " thead").height()+$(tbodyTableSelector + " tbody").height())>$(tbodyTableSelector).height() ){
            var scrollBarWidth = $(tbodyTableSelector).width() - $(tbodyTableSelector)[0].clientWidth;
            $(tbodyTableSelector).css("width", ($(theadTableSelector + " thead").width() + scrollBarWidth) + "px");
        }else{
            $(tbodyTableSelector).css("width", ($(theadTableSelector + " thead").width() + 0) + "px");
        }

        //initBg2UI
        var scrollBarWidth = $(tbodyTableSelector).width() - $(tbodyTableSelector)[0].clientWidth;
        $(rightScrollBarSelector).css({
            "position":"absolute",
            "height":$(tbodyTableSelector).height()+"px",
            "width":"18px",
            "top":"0",
            "left":($(leftBlankSelector).width()<$(theadTableSelector).width()?$(leftBlankSelector).width()-scrollBarWidth:$(theadTableSelector).width())+"px",
            "overflow-y":"auto"
        });
        $(rightScrollBarSelector).children().css({
            "width":"1px",
            "height":($(tbodyTableSelector + " thead").height() + $(tbodyTableSelector + " tbody").height())+"px",
            "overflow-y":"auto"
        });

        var flag1 = false;
        var flag2 = false;
        $(rightScrollBarSelector).scroll(function(){
            if(!flag2){
                flag1 = true;
                $(tbodyTableSelector)[0].scrollTop = $(rightScrollBarSelector)[0].scrollTop;
            }else{
                flag2 = false;
            }
        });
        $(tbodyTableSelector).scroll(function(){
            if(!flag1){
                flag2 = true;
                $(rightScrollBarSelector)[0].scrollTop = $(tbodyTableSelector)[0].scrollTop;
            }else{
                flag1 = false;
            }
        });
    }
    initScrollBar("#main", "#bg1", "#bg2", "#table2", "#table1", 600, 350);