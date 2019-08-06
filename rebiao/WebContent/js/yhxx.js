


$(document).ready(function() {

	var xq;
	 $.ajax({
			url : "findXqName.action", 
			async : false,
			dataType : "json",
			data : {
				
			},
			success : function(data) {
				var opt="";
				 xq=data.xqList;
				
				 for(var i=0; i<xq.length; i++){
						
						$("#xqName").append("<option value='"+xq[i].xqName+"'>"+xq[i].xqName+"</option>");	
					}
			}

		});
	 
	 $("#xqName").change(function(){
		 $.ajax({
				url : "findBuildNO.action", 
				async : false,
				dataType : "json",
				data : {
					"xqName" : $("#xqName").val(),
				},
				success : function(data) {
					$("#buildNo option:gt(0)").remove();
					$("#cellNo option:gt(0)").remove();
					var ld=data.ldList;
					for(var i=0; i<ld.length; i++){
						
						$("#buildNo").append("<option value='"+ld[i].ldh+"'>"+ld[i].ldh+"</option>");
					}	
				}

			});
		});
	 
	 $("#buildNo").change(function(){
		 $.ajax({
				url : "findCellNO.action", 
				async : false,
				dataType : "json",
				data : {
					"xqName" : $("xqName").val(),
					"buildNo" : $("#buildNo").val(),
				},
				success : function(data) {
					$("#cellNo option:gt(0)").remove();
					var dy=data.dyList;
					for(var i=0; i<dy.length; i++){
						
						$("#cellNo").append("<option value='"+dy[i].dyh+"'>"+dy[i].dyh+"</option>");
					}	
				}
			});
		});
	 
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
		
		
		var xinwordList = [["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
		                   ["杨亚平","市政小区","1","2栋","303","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
		                   ["张丽","市政小区","1","2栋","401","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
		                   ["田春华","市政小区","1","2栋","501","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
		                   ["刘文川","市政小区","1","2栋","201","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
		                   ["马璇","市政小区","1","2栋","202","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
		["赵敏","涧河小区","15","7栋","201","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["王建","涧河小区","15","2栋","103","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["何秀","涧河小区","15","2栋","302","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["张丽","涧河小区","15","2栋","301","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["李玲","涧河小区","16","2栋","601","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["王思","涧河小区","16","2栋","602","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
		["陈立","涧河小区","16","2栋","701","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["程远明","涧河小区","16","2栋","702","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["李磊","涧河小区","16","2栋","302","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["陈瑶","涧河小区","16","2栋","303","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["赵贤","涧河小区","17","2栋","503","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["王伟","涧河小区","17","2栋","502","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"]
		["李莉","涧河小区","17","2栋","501","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["夏冬","涧河小区","1","2栋","301","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["徐进","涧河小区","1","2栋","302","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["东光","涧河小区","1","2栋","401","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"]
		["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
		["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","涧河小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
		["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"],
        ["魏红星","市政小区","1","2栋","203","37515443","3043","0","3990.23","0","24.2","23.9","0.1","流量","正常","77920","荷德鲁美特"]];
		
		
		/*function jsArrChange(json){
			for (var i = 0 ; i < json.length ; i ++) {
				var arr1 = [];
				arr1[0] = json[i].yhbh;
				arr1[1] = json[i].cgbh;
				if(json[i].ssgs==null||json[i].ssgs==""){
					arr1[2]=""
				}else{
					arr1[2] = json[i].ssgs;	
				}
				
				arr1[3] = json[i].xqm;
				arr1[4] = json[i].ldh;
				arr1[5] = json[i].dyh;
				arr1[6] = json[i].hh;
				arr1[7] = json[i].fpdz;
				arr1[8] = json[i].mj;
				if(json[i].yhlx=="01"){
					arr1[9] = "住宅";
				}
				if(json[i].yhlx=="02"){
					arr1[9] = "商用";
				}
				if(json[i].yhlx=="03"){
					arr1[9] = "廉租房";
				}
				if(json[i].yhlx=="04"){
					arr1[9] = "其它";
				}
				
				arr1[10] = json[i].yhxm;
				arr1[11] = json[i].lxdh;
				arr1[12] = json[i].bz;
				arr1[13] = json[i].id;
				xinwordList.push(arr1);
			};
		}*/
		/*jsArrChange(yhLsitSer);*/
		
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
					html += "<td><input class='xinjgd_change'  type='button' value='修改' /><input class='xinjgd_del' type='button' value='删除' /></td></tr>";
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
		
		//工单搜索
		$("#xin_search_btn").click(function(){
		
			
			$("#xinword_body").empty();
			$.ajax({
                type: "post",
               url: "findByTerm.action",
                 dataType:'json',
             	data:{	
 					"yhbh":$('#yhbh').val(),
 					"yhxm":$('#yhxm').val(),
 					"xqm":$('#xqm').val(),
 				},
                dataType: "json",
                 success: function (data) {
                	 yhLsitSer=data.yhLsitSer;
                	 xinwordList.length=0;
                	 jsArrChange(yhLsitSer);
                	 pageInit(1, 15);
                	 $(".xinjgd_change").click(function(){
         				
         				xin_change(this);
         			});
         			
         			$("#word_change_btn").click(function(){
         				change_btn();
         			});
         			$(".xinjgd_del").click(function(){
         				xin_del(this);
         			});
                },

            })
			
		    //修改按钮
			
			
			
		});

		
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
			$(".xinjgd_del").click(function(){
				xin_del(this);
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
	for(var x = 0 ; x < 16 ; x ++){
		changewordList.push(xintr[x].innerHTML);
	}
	
	var changeInput = $("#change_word .change_word_input");
	for(var i = 0;i < changeInput.length;i ++){
		if(i!=9)
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
	var id=xintr[13].innerHTML
	 layer.confirm('确认删除么', function(index) {
		                 $.ajax({
		                     type: "post",
		                    url: "deleteYh.action",
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



function compareWord(wordType,compareWordList,wordList,j){
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
	xinwordList.length=0;
	xinwordList=xinwordList.concat(compareWordList);
	
}	