
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
		/*
		function jsArrChange(json){
			for (var i = 0 ; i < json.length ; i ++) {
				var arr1 = [];
				arr1[0] = json[i].id;
				arr1[1] = json[i].yhbh;
				arr1[2] = json[i].yhxm;
				arr1[3] = json[i].fpdz;
				arr1[4] = json[i].ldh;
				arr1[5] = json[i].dyh;
				arr1[6] = json[i].hh;
				arr1[7] = json[i].sdwd;
				arr1[8] = json[i].snwd;
				if(json[i].ms=="01"){
					arr1[9]="制热"
				}else{
					arr1[9]="制冷"
				}
				
				arr1[10] = json[i].yydl;
				arr1[11] = json[i].syje;
				if(json[i].dw=="03"){
					arr1[12]="高档"
				}
				if(json[i].dw=="02"){
					arr1[12]="中档"
				}
				if(json[i].dw=="01"){
					arr1[12]="低档"
				}
				if(json[i].dw=="00"){
					arr1[12]="停止"
				}
				arr1[13] = json[i].gdtime;
				arr1[14] = json[i].zdtime;
				arr1[15] = json[i].ddtime;
				arr1[16] = json[i].dgdtime;
				arr1[17] = json[i].dzdtime;
				arr1[18] = json[i].dddtime;
				
				arr1[19] = json[i].time;
				arr1[20] = json[i].mj;
				arr1[21] = json[i].lxdh;
				if(json[i].jf=="01"){
					arr1[22]="允许计费"
				}
				if(json[i].jf=="00"){
					arr1[22]="禁止计费"
				}
				
				
				
				if(json[i].kg=="01"){
					arr1[23]="自动运行"
				}
				if(json[i].kg=="00"){
					arr1[23]="强制关闭"
				}
				if(json[i].bj=="00"){
					arr1[24]="正常"
				}
				if(json[i].bj=="01"){
					arr1[24]="开盖"
				}
				if(json[i].bj=="03"){
					arr1[24]="盗热嫌疑"
				}
				if(json[i].bj=="04"){
					arr1[24]="通讯异常"
				}
				arr1[25] = json[i].bz;
				arr1[26] = json[i].xqm;
				arr1[27] = json[i].jj;
				xinwordList.push(arr1);
			};
		}
		jsArrChange(list);
		*/
		var opt = [];
		//表格写入函数
		tbodydis("",xinwordList,opt);

		
		//分页样式
		$("nav li").click(function(){
			$("nav li").css("color","");
			$(this).css("color","#C5D52B");
			
		});
		
		//小区楼栋选择
		$("#xq").change(function(){
			ldselect(xinwordList);
		});
		$("#ldh").change(function(){
			dyselect(xinwordList);
		});
		$("#ldh").click(function(){
			var xq = $('#xq  option:selected').val();
			if(xq == ""){
				alert("请先选择小区名称");
			}
		});
		$("#dyh").click(function(){
			var xq = $('#xq  option:selected').val();
			var ld = $('#ldh  option:selected').val();
			if(xq == ""){
				alert("请先选择小区名称");
				return;
			}
			if(ld == ""){
				alert("请先选择楼栋号");
			}
		});
		
		
		//工单搜索
		$("#search_btn").click(function(){
			var xq = $('#xq').val();
			var ld = $('#ldh').val();
			var dy = $('#dyh').val();
			var hh = $('#hh').val();
			var compareWordList = [];
			$('#xqspan').html(xq);
			for(var j = 0;j < xinwordList.length;j ++){
				compareWord(xq,ld,dy,hh,xinwordList,j,compareWordList);
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
					
				/*	if(y==0||y==26||y==27){

						newWordElemnet += "<td style='display:none;'>" + compareWordList[x][y] + "</td>";
    					continue;
    				}else{*/

    					newWordElemnet += "<td>" + compareWordList[x][y] + "</td>"
    				/*}*/
				}
				
				
				$("#xinword_body").append(newWordElemnet);
				
			}
			
			tbodydis(xinwordList,compareWordList,opt);



			
		});
		
		
//		查询状态
		$("#search_status_btn").click(function(){
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

			console.log(arr);
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
			
		}
		
		//树状栏点击
		$(".dyname").click(function(){
			var dyh = $(this).html();
			dyh = dyh.replace(/&nbsp;/ig, "");
			var ldh = $(this).parents("li.ld").children("a.ldname").html();
			ldh = ldh.replace(/&nbsp;/ig, "");
			var xqm = $(this).parents("li.xq").children("a.xqname").html();
			xqm = xqm.replace(/&nbsp;/ig, "");
			var treelist = [];
			for(var i = 0; i < xinwordList.length; i++) {
				if(xqm == xinwordList[i][26] && ldh == xinwordList[i][4] && dyh == xinwordList[i][5]){
					treelist.push(xinwordList[i]);
				}
			}
			tbodydis("",treelist,opt);

		});
		
		
});

function ldselect(xinwordList){
	 //获取被选中的option标签
	 var xq = $('#xq  option:selected').val();
	 $("#ldh").html("<option value='' disabled selected hidden>--选择楼栋号--</option>");
	$("#dyh").html("<option value='' disabled selected hidden>--选择单元号--</option>");
	$("#hh").val("");
	 var opt = [];
	 for(var i = 0 ; i < xinwordList.length ; i ++){
		 if( xq == xinwordList[i][26] && opt.indexOf(xinwordList[i][4]) == -1){
				opt.push(xinwordList[i][4]);
		 }
	 }
	
	 for(var j = 0; j < opt.length; j++) {
			$("#ldh").append("<option>"+opt[j]+"</option>");
	}
}

function dyselect(xinwordList){
	 //获取被选中的option标签
	 var xq = $('#xq  option:selected').val();
	 var ld = $('#ldh  option:selected').val();
	 var opt = [];
	 for(var i = 0 ; i < xinwordList.length ; i ++){
		 if( xq == xinwordList[i][26] && ld == xinwordList[i][4] && opt.indexOf(xinwordList[i][5]) == -1){
				opt.push(xinwordList[i][5]);
		 }
	 }
	 for(var j = 0; j < opt.length; j++) {
			$("#dyh").append("<option>"+opt[j]+"</option>");
	}
	 
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



function compareWord(xq,ld,dy,hh,wordList,j,compareWordList){
	var startTime=$('#startTime').val();
	var endTime=$('#endTime').val();
	if(hh!=""&&hh!=null){
		if(wordList[j][6] != hh){
			return;
		}
	}
	if(startTime!=null &&startTime!=""){
		
		if(wordList[j][19]<startTime){
			
			return;
		}
	}
	if(endTime!=null &&endTime!=""){
		if(wordList[j][19]>endTime){
			return;
		}
	}
	if(xq==""){
		if(hh != ""){
			if(wordList[j][6] == hh){
				compareWordList.push(wordList[j]);
			}
			return;
		}
		compareWordList.push(wordList[j]);
	}
	if(xq != "" && ld == ""){
		if(wordList[j][26] == xq){
			
			compareWordList.push(wordList[j]);
		}
		
	}
	if(xq != "" && ld != "" && dy == "" ){
		if(wordList[j][26] == xq && wordList[j][4] == ld){
		
			compareWordList.push(wordList[j]);
		}
	}
	if(xq != "" && ld != "" && dy != "" && hh == "" ){
		if(wordList[j][26] == xq && wordList[j][4] == ld && wordList[j][5] == dy){
			
			compareWordList.push(wordList[j]);
		}
	}
	if(xq != "" && ld != "" && dy != "" && hh != "" ){
		if(wordList[j][26] == xq && wordList[j][4] == ld && wordList[j][5] == dy && wordList[j][6] == hh){
		
			compareWordList.push(wordList[j]);
		}
	}
}	

//表格写入函数
function tbodydis(oldlist,newlist,opt){

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
		
		for(var i = 0; i < newlist.length; i++) {
			if(i >= startRow && i <= endRow) { //通过间隔分隔数组
				if(i%2 == 1){
					html += "<tr class='gradeX odd'>";
				}else if(i%2 == 0){
					html += "<tr class='gradeX even'>";
				}
				

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
			
			}
		}
		
		xinword_body.innerHTML = html;

		

		if(oldlist == ""){
			oldlist = newlist;
			for(var i = 0; i < oldlist.length; i++) {
				for (var j = 0 ; j <oldlist[i].length ; j ++) {
					if(j == 26 && opt.indexOf(oldlist[i][26]) == -1){
						opt.push(oldlist[i][26]);
					} 
				}
			}
			for(var i = 0; i < opt.length; i++) {
				$("#xq").append("<option>"+opt[i]+"</option>");
			}
		}
		
		

		
		var classname = "";
		$("table tbody td").hover(function() {
			classname = $(this).parent().attr("class");
			$(this).parent().removeClass(classname).addClass("blue");
			$("table tbody tr").find('td:eq(' + $(this).index() + ')').addClass('blue')
		}, function() {
			$(this).parent().removeClass("blue").addClass(classname);
			$("table tbody tr").find('td:eq(' + $(this).index() + ')').removeClass('blue')
		});

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