


$(document).ready(function() {
	//表头固定
		var xincreatetableCont = $('#xincreate_table_body table tr th'); //获取th
		var xincreatetableScroll = $('#xincreate_table_body'); //获取滚动条同级
		xincreatetableScroll.on('scroll', scrollHandlexincreate);

		function scrollHandlexincreate() {
			var scrollTop = xincreatetableScroll.scrollTop();
			// 当滚动距离大于0时设置top及相应的样式
			if (scrollTop > 0) {
				xincreatetableCont.css({
					"top" : scrollTop + 'px',
					"marginTop" : "-1px",
					"backgroundColor" : "#EBEBEB"
				})
			} else { // 当滚动距离小于0时设置top及相应的样式 
				xincreatetableCont.css({
					"top" : scrollTop + 'px',
					"marginTop" : "0",
					"backgroundColor" : "#EBEBEB"
				})
			}
		}
		
		
		var xinwordList = [["hnzy","原来表号为37515443修改表号34281456","2019-03-09 22:38:26"],
		                  [ "hnzy","原来表号为37515443修改表号34281456","2019-03-09 22:38:26"],
		                  [ "hnzy","原来表号为37515443修改表号34281456","2019-03-09 22:38:26"],
		                  [ "hnzy","原来表号为37515443修改表号34281456","2019-03-09 22:38:26"],
		                  [ "hnzy","原来表号为37515443修改表号34281456","2019-03-09 22:38:26"],
		                   ["hnzy","原来表号为37515443修改表号34281456","2019-03-09 22:38:26"],
          ["hnzy","hnzyxt登录成功","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"],
          ["hnzy","修改备注为：热表黑屏","2019-03-09 22:38:26"]
		 ];
		
		/*function jsArrChange(json){
			for (var i = 0 ; i < json.length ; i ++) {
				var arr1 = [];
				arr1[0] = json[i].czr;
				arr1[1] = json[i].cz;
				arr1[2] = getTime(json[i].czsj);
				xinwordList.push(arr1);
			};
		}*/
		function getTime(s) { 
			var nS = new Date(s);
		    var year=nS.getFullYear(); 
		    var mon = nS.getMonth()+1; 
		    if(mon < 10){
		    	mon = "0"+mon;
		    }
		    var day = nS.getDate(); 
		    if(day < 10){
		    	day = "0"+day;
		    }
		    var hours = nS.getHours(); 
		    if(hours < 10){
		    	hours = "0"+hours;
		    }
		    var minu = nS.getMinutes(); 
		    if(minu < 10){
		    	minu = "0"+minu;
		    }
		    var sec = nS.getSeconds(); 
		    if(sec < 10){
		    	sec = "0"+sec;
		    }
		     
		    return year+'-'+mon+'-'+day+' '+hours+':'+minu+':'+sec; 
		} 
		
		/*jsArrChange(rzListSer);*/
		
		var current = 1;

		function pageInit(currentPage, pagesize) {
			current = currentPage; //将当前页存储全局变量
			pageCount = Math.ceil(xinwordList.length / pagesize); //一共分多少页
			currentNum.innerHTML = currentPage;
			num.innerHTML = xinwordList.length + "条";
			pages.innerHTML = pageCount;
			var startRow = (currentPage - 1) * pagesize; //开始显示的行
			var endRow = currentPage * pagesize - 1; //结束显示的行
			var endRow = (endRow > xinwordList.length) ? xinwordList.length : endRow; //如果结束行数大于总数目，显示总数目，否则结束行
			
			var html = "";
			for(var i = 0; i < xinwordList.length; i++) {
				if(i >= startRow && i <= endRow) { //通过间隔分隔数组
					if(i%2 == 1){
						html += "<tr class='gradeX odd'>";
					}else if(i%2 == 0){
						html += "<tr class='gradeX even'>";
					}
					
					for (var j = 0 ; j <xinwordList[i].length ; j ++) {

                                html += "<td>" + xinwordList[i][j] + "</td>"
					}
				}
			}

			xinword_body.innerHTML = html;
		}

		select.onchange = function(ev) {
			pageInit(1, this.value)
		}
		first.onclick = function() {
			pageInit(1, select.value)
		}
		end.onclick = function() {
			pageInit(pageCount, select.value)
		}

		next.onclick = function() {
			var curr = current + 1;
			if(curr > pageCount) {
				return
			}
			pageInit(curr, select.value)
		}

		last.onclick = function() {
			var curr = current - 1;
			if(curr < 1) {
				return
			}
			pageInit(curr, select.value)
		}
		pageInit(1, 15);
		
		//分页样式
		$("nav li").click(function(){
			$("nav li").css("color","");
			$(this).css("color","#C5D52B");
			
		});
		
		//日志搜索
		$("#xin_search_btn").click(function(){
		
			
			$("#xinword_body").empty();
			$.ajax({
                type: "post",
               url: "findRz.action",
                 dataType:'json',
             	data:{	
 					"cz":$('#cz').val(),
 				},
                dataType: "json",
                 success: function (data) {
                	 json=data.findCz;
                	 xinwordList.length=0;
                	 jsArrChange(json);
                	 pageInit(1, 15);
                },

            })
		});
		
		//排序
		var tableObject = $('#xincreate_table_body table'); //获取id为xincreate_table_body的table对象
		var tbHead = tableObject.children('thead'); //获取table对象下的thead
		var tbHeadTh = tbHead.find('tr th'); //获取thead下的tr下的th
		var tbBody = tableObject.children('tbody'); //获取table对象下的tbody
		var tbBodyTr = tbBody.find('tr'); //获取tbody下的tr
		
		var sortIndex = 1;
		
		tbHeadTh.each(function() { //遍历thead的tr下的th
			var thisIndex = tbHeadTh.index($(this)); //获取th所在的列号

			var type ="";
			$(this).click(function() { //给当前表头th增加点击事件
				tbHeadTh.find("span").show();
				if(sortIndex%2 == 1){//奇数偶数显示
					$(this).find(".span-up").show();
					$(this).find(".span-down").hide();
				}else{
					$(this).find(".span-up").hide();
					$(this).find(".span-down").show();
				}
				var table = $('#xincreate_table_body table'); 
				var body = table.children('tbody'); 
				var bodytr = body.find('tr');
				checkColumnValue(thisIndex,table,bodytr);
			});
			
		});

		//对表格排序
		function checkColumnValue(index,table,bodytr) {
			var trsValue = new Array();

			bodytr.each(function() {
				var tds = $(this).find('td');
				//获取行号为index列的某一行的单元格内容与该单元格所在行的行内容添加到数组trsValue中
				var data = $(tds[index]).html();//parseFloat($(tds[index]).html()) || 
				if(isNaN(data)&&!isNaN(Date.parse(data))){
				　　type = "string";
				}else if (parseFloat(data)) {
					type = "number";
				}else{
					type = "string";
				}
				
				trsValue.push(type + ".separator" + $(tds[index]).html() + ".separator" + $(this).html());
				$(this).html("");
			});

			var len = trsValue.length;

			if(sortIndex%2 == 0) {
				//如果已经排序了则直接倒序
				trsValue.reverse();
			} else {
				for(var i = 0; i < len; i++) {
					//split() 方法用于把一个字符串分割成字符串数组
					//获取每行分割后数组的第一个值,即此列的数组类型,定义了字符串\数字\Ip
					type = trsValue[i].split(".separator")[0];
					for(var j = i + 1; j < len; j++) {
						//获取每行分割后数组的第二个值,即文本值
						value1 = trsValue[i].split(".separator")[1];
						//获取下一行分割后数组的第二个值,即文本值
						value2 = trsValue[j].split(".separator")[1];
						//接下来是数字\字符串等的比较
						if(type == "number") {
							value1 = value1 == "" ? 0 : value1;
							value2 = value2 == "" ? 0 : value2;
							if(parseFloat(value1) > parseFloat(value2)) {
								var temp = trsValue[j];
								trsValue[j] = trsValue[i];
								trsValue[i] = temp;
							}
						} else {
							if(value1.localeCompare(value2) > 0) { //该方法不兼容谷歌浏览器
								var temp = trsValue[j];
								trsValue[j] = trsValue[i];
								trsValue[i] = temp;
							}
						}
					}
				}
			}

			for(var i = 0; i < len; i++) {
				table.find("tbody tr:eq(" + i + ")").html(trsValue[i].split(".separator")[2]);
			}

			sortIndex += 1;
			
			//修改按钮
			$(".xinjgd_change").click(function(){
				xin_change(this);
			});
			
			$("#word_change_btn").click(function(){
				change_btn();
			});
			$(".xinjgd_del").click(function(){
				xin_del(this);
			});
		}	
		
});