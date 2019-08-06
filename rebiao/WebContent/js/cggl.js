
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
		
		var xinwordList = [["1","d1d1d11d","47200211","涧河小区","涧河小区8号楼西面墙","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d11e","47200211","涧河小区","涧河小区8号楼东单元2楼楼梯间","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d11f","47200211","涧河小区","	涧河小区21栋2单元2楼楼梯间","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d130","47200211","交警队","1栋十楼(崤山路办公楼后)一体机热力管道井","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d101","47200211","金盾小区","1栋十楼(崤山路办公楼后)一体机热力管道井","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d102","47200211","金盾小区","8号楼4单元1楼楼梯间","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d103","47200211","金盾小区","1栋十楼(崤山路办公楼后)一体机热力管道井","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d104","47200211","金盾小区","8号楼4单元1楼楼梯间","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d105","47200211","金盾小区","9号楼3单元1楼楼梯间","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d106","47200211","金盾小区","10号楼4单元1楼楼梯间","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","d1d1d107","47200211","金盾小区","15号楼4单元1楼楼梯间","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","D1D1D311","47200211","金盾苑","涧河小区8号楼西面墙","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","D1D1D312","47200211","金盾苑","涧河小区8号楼西面墙","2019-03-09 22:38:26","d2d2d207"],
		                   ["1","D1D1D313","47200211","金盾苑","涧河小区8号楼西面墙","2019-03-09 22:38:26","d2d2d207"]
			 ];
		
		/*function jsArrChange(json){
			for (var i = 0 ; i < json.length ; i ++) {
				var arr1 = [];
				arr1[0] = json[i].id;
				arr1[1] = json[i].cgbh;
				arr1[2] = json[i].jzqnet;
				arr1[3] = json[i].azdz;
				arr1[4] = json[i].bz;
				
				xinwordList.push(arr1);
			};
		}
		jsArrChange(cgLsit);*/

		//表格写入函数
		tbodydis("",xinwordList);

		
		//分页样式
		$("nav li").click(function(){
			$("nav li").css("color","");
			$(this).css("color","#C5D52B");
			
		});
		
		
		//关闭新增
		$(".close").click(function(){
			$("#change_word").hide();
		});
		
//		单一风盘操作
		$("#operation_one_btn").click(function(){
			var kg = $('#kg  option:selected').val();
			var jf = $('#jf  option:selected').val();
			var jj = $('#jj  option:selected').val();

			var arr = [];
			var checkBox=  $("input[type='checkbox']:checked");
			if(checkBox.length == 0){
				alert("请勾选信息");
				return;
			}
			checkBox.each(function(i, n){
				var tdarr = [];
				var td =  $(this).parent().parent().children();
				for(var i = 1; i < td.length-1; i ++){
					tdarr.push(td[i].innerHTML);
				}
				arr.push(tdarr);
			});

			$.ajax({
				type:"POST",
				url : "CgFp.action",
				async : false,
				dataType : "json",
				 traditional: true,
				data : {
					"arr" : arr,
					"kg" : kg,
					"jf" : jf,
					"jj" : jj,
				},
				success : function(data) {

					var msg = data.js
					if(msg==0){
						alert("发送成功");
					}else{
						alert("发送失败");
					}
				}

				})
		});
//		单元发送
		$("#operation_DY_btn").click(function(){
			var kg = $('#kg  option:selected').val();
			var jf = $('#jf  option:selected').val();
			var jj = $('#jj  option:selected').val();
		
			var arr = [];
			var checkBox=  $("input[type='checkbox']:checked");
			if(checkBox.length == 0){
				alert("请勾选信息");
				return;
			}
			if(checkBox.length != 1){
				alert("只能勾选一组信息");
				return;
			}
			checkBox.each(function(i, n){
				var tdarr = [];
				var td =  $(this).parent().parent().children();
				for(var i = 1; i < td.length; i ++){
					tdarr.push(td[i].innerHTML);
				}
				arr.push(tdarr);
			});
			/*arr.push([kg,jf,jj]);*/
			$.ajax({
				type:"POST",
				url : "dyFp.action",
				async : false,
				dataType : "json",
				 traditional: true,
				data : {
					"arr" : arr,
					"kg" : kg,
					"jf" : jf,
					"jj" : jj,
				},
				success : function(data) {
					var msg = data.js
					if(msg==0){
						alert("发送成功");
					}else{
						alert("发送失败");
					}
				}

				})
		});
//		楼栋发送
		$("#operation_all_btn").click(function(){
			var kg = $('#kg  option:selected').val();
			var jf = $('#jf  option:selected').val();
			var jj = $('#jj  option:selected').val();
			
			var arr = [];
			var checkBox=  $("input[type='checkbox']:checked");
			if(checkBox.length == 0){
				alert("请勾选信息");
				return;
			}
			if(checkBox.length != 1){
				alert("只能勾选一组信息");
				return;
			}
			checkBox.each(function(i, n){
				var tdarr = [];
				var td =  $(this).parent().parent().children();
				for(var i = 1; i < td.length; i ++){
					tdarr.push(td[i].innerHTML);
				}
				arr.push(tdarr);
			});
			/*arr.push([kg,jf,jj]);*/
			$.ajax({
				type:"POST",
				url : "LdFp.action",
				async : false,
				dataType : "json",
				 traditional: true,
				data : {
					"arr" : arr,
					"kg" : kg,
					"jf" : jf,
					"jj" : jj,
				},
				success : function(data) {
					var msg = data.js
					if(msg==0){
						alert("发送成功");
					}else{
						alert("发送失败");
					}
				}

				})
			
			/*console.log(arr);*/
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
				var table = $('table'); 
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
			$("#increase_btn").click(function(){
				$("#increase_word").show();
			});
			
			//关闭新增
			$(".close").click(function(){
				$("#increase_word").hide();
				$("#change_word").hide();
			});
		}
		
		
		
		
		//修改按钮
		$(".xinjgd_change").click(function(){
			xin_change(this);
		});
		
		$("#word_change_btn").click(function(){
			change_btn();
		});
		
		$("#increase_btn").click(function(){
			$("#increase_word").show();
		});
		
		//关闭新增
		$(".close").click(function(){
			$("#increase_word").hide();
			$("#change_word").hide();
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
	for(var x = 1 ; x < 6 ; x ++){
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
	var id=xintr[1].innerHTML
	 layer.confirm('确认删除么', function(index) {
		                 $.ajax({
		                     type: "post",
		                    url: "deleteCg.action",
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

	

//表格写入函数
function tbodydis(oldlist,newlist){

	var current = 1;

	function pageInit(currentPage, pagesize) {
		current = currentPage; //将当前页存储全局变量
		pageCount = Math.ceil(newlist.length / pagesize); //一共分多少页
		currentNum.innerHTML = currentPage;
		num.innerHTML = newlist.length + "条";
		pages.innerHTML = pageCount;
		var startRow = (currentPage - 1) * pagesize; //开始显示的行
		var endRow = currentPage * pagesize - 1; //结束显示的行
		var endRow = (endRow > newlist.length) ? newlist.length : endRow; //如果结束行数大于总数目，显示总数目，否则结束行
		
		var html = "";
		var opt = [];
		for(var i = 0; i < newlist.length; i++) {
			if(i >= startRow && i <= endRow) { //通过间隔分隔数组
				if(i%2 == 1){
					html += "<tr class='gradeX odd'>";
				}else if(i%2 == 0){
					html += "<tr class='gradeX even'>";
				}
				html += "<td><input type='checkbox' value='' name='check'/></td>";

				for (var j = 0 ; j <newlist[i].length ; j ++) {
					if( opt.indexOf(newlist[i][26]) == -1){
						opt.push(newlist[i][26]);
					}
					if(j==0||j==26||j==27){

	                  	html += "<td style='display:none;'>" + newlist[i][j] + "</td>";
	  				}else{
	
	                      html += "<td>" + newlist[i][j] + "</td>"
	  				}
				}
				html += "<td><input class='xinjgd_change'  type='button' value='修改' /><input class='xinjgd_del' type='button' value='删除' /></td></tr>";
				
			}
		}
		
		xinword_body.innerHTML = html;

		

		if(oldlist == ""){
			oldlist = newlist;
		}
		for(var i = 0; i < oldlist.length; i++) {
			for (var j = 0 ; j <oldlist[i].length ; j ++) {
				if(j == 26 && opt.indexOf(oldlist[i][26]) == -1){
					opt.push(oldlist[i][26]);
				} 
			}
		}
		$("#xq").html("<option value='' disabled selected hidden>--小区名称--</option>");
		$("#ldh").html("<option value='' disabled selected hidden>--选择楼栋号--</option>");
		$("#dyh").html("<option value='' disabled selected hidden>--选择单元号--</option>");
		$("#hh").val("");
		for(var i = 0; i < opt.length; i++) {
			$("#xq").append("<option>"+opt[i]+"</option>");
		}

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
}