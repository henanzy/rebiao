
$(document).ready(function() {
	//表头固定
	var myDate = new Date()
	myDate.toLocaleString();
	$('#tjTime').val(myDate.toLocaleString()); 
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
		var xinwordList = [];
		function jsArrChange(json){
			for (var i = 0 ; i < json.length ; i ++) {
				var arr1 = [];
				/*arr1[0] = json[i].id;*/
				arr1[1] = json[i].fpbh;
				arr1[2] = json[i].yhbh;
				arr1[3] = json[i].xh;
				arr1[4] = json[i].wz;
				arr1[5] = json[i].bz;
				arr1[0] = json[i].id;
				xinwordList.push(arr1);
			};
		}
		/*alert(xinwordListj)*/
		jsArrChange(xinwordListj);
		for(var i = 0;i < xinwordList.length;i ++){
			var xinwordTr = "";
			if(i%2 == 1){
				xinwordTr = "<tr class='gradeX odd'>";
			}else if(i%2 == 0){
				xinwordTr = "<tr class='gradeX even'>";
			}
			for(var y = 0;y < xinwordList[i].length;y ++){
				if(y==0){
					xinwordTr += "<td style='display:none'>" + xinwordList[i][y] + "</td>";
					continue;
				}
				xinwordTr += "<td>" + xinwordList[i][y] + "</td>";
			}
			var id='"'+xinwordList[i][0]+'"';
			xinwordTr += "<td><input class='xinjgd_change' type='button' value='修改' /><input class='xinjgd_del' type='button' value='删除' /></td></tr>";
		
			$("#xinword_body").append(xinwordTr);
		
		}
		
		//工单搜索
	/*	$("#xin_search_btn").click(function(){
			var wordType = $(".increase select").val();
			var compareWordList = [];
			var WordListTime = "";
			for(var j = 0;j < xinwordList.length;j ++){
				WordListTime = new Date(xinwordList[j][6]).getTime();
				compareWord(wordType,WordListTime,compareWordList,xinwordList,j);
			};
			$("#xinword_body").empty();
			for(var x = 0;x < compareWordList.length;x ++){
				
				var newWordElemnet = "";
				if(x%2 == 1){
					newWordElemnet = "<tr class='gradeX odd'>";
				}else if(x%2 == 0){
					newWordElemnet = "<tr class='gradeX even'>";
				}
				
				for(var y = 0;y < compareWordList[x].length;y ++){
					
					newWordElemnet += "<td>" + compareWordList[x][y] + "</td>";
				}
					var id='"'+compareWordList[x][0]+'"';
				newWordElemnet += "<td><input class='xinjgd_show' onclick='shower("+id+")' type='button' value='查看意见' /><input class='xinjgd_change' type='button' value='修改' /><input class='xinjgd_del' type='button' value='删除' /></td></tr>";
				$("#xinword_body").append(newWordElemnet);
				
			}
			
			//修改按钮
			$(".xinjgd_change").click(function(){
				xin_change(this);
			});
			
			$("#word_change_btn").click(function(){
				change_btn();
			});
			
		});*/
		
		
		//新增按钮
		$("#increase_btn").click(function(){
			//获取时间
			var nowTime = getTime();
				
			$("#increase_word input[name='tjTime']").val(nowTime);
			$("#increase_word").show();
		});
		
		//关闭新增
		$(".close").click(function(){
			$("#increase_word").hide();
			$("#change_word").hide();
		});
		//确定新增
		$("#word_increase_btn").click(function(){
			//获取到新增表单的信息
			var increainp = $("#increase_word .increase_word_input");
			var increaseValue = [];
			for(var i = 0 ; i < increainp.length ; i ++){
				increaseValue.push(increainp[i].value);
			}
			
			/*alert(increaseValue);*/
			$("#increase_word").hide();
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
			
		}
		
		
		
		
		
		//修改按钮
		$(".xinjgd_change").click(function(){
			xin_change(this);
		});
		
		$("#word_change_btn").click(function(){
			change_btn();
		});
		
		
		//删除按钮
		$(".xinjgd_del").click(function(){
			xin_del(this);
		});
		
		
	});


function xin_change(p){
	$("#change_word").show();
	var xintr = $(p).parent().parent().children();
	//修改数据
	var changewordList = [];
	for(var x = 0 ; x <6 ; x ++){
		changewordList.push(xintr[x].innerHTML);
	}
	
	var changeInput = $("#change_word .change_word_input");
	for(var i = 0;i < changeInput.length;i ++){
		$("#change_word .change_word_input")[i].value = changewordList[i];
	}
}


function change_btn(){

	//获取到修改表单的信息
	var changeinp = $("#change_word .change_word_input");
	var changeValue = [];
	for(var i = 0 ; i < changeinp.length ; i ++){
		changeValue.push(changeinp[i].value);
	}
	
	/*alert(changeValue);*/
	$("#change_word").hide();
}


function xin_del(p){
	var xintr = $(p).parent().parent().children();
	var id=xintr[0].innerHTML
	 layer.confirm('确认删除么', function(index) {
		                 $.ajax({
		                     type: "post",
		                    url: "deleteFp.action",
		                      dataType:'json',
		                  	data:{	
		      					"id":id,
		      				},
		                     dataType: "json",
		                      success: function (data) {
		                    	   layer.close(index);
		                          window.location.reload();
		                     },
		  
		                 })
		              });
}


function getTime() {  
	var nS = new Date();
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



function compareWord(wordType,WordListTime,compareWordList,wordList,j){
	if(wordType == "全部"){
		compareWordList.push(wordList[j]);
	}
	if(wordType == "未审核"){
		if(wordList[j][10] == "未审核"){
			compareWordList.push(wordList[j]);
		}
	}
	if(wordType == "回退修改"){
		if(wordList[j][10] == "回退修改"){
			compareWordList.push(wordList[j]);
		}
	}
}	