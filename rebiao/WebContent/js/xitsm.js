$(document).ready(function() {
	/*var systemList = [];*/
	var systemList = [["测试1","测试内容1","测试","2019-03-09 22:38:26"],["测试1","测试内容1","测试","2019-03-09 22:38:26"]
	,["测试1","测试内容1","测试","2019-03-09 22:38:26"]
	,["测试1","测试内容1","测试","2019-03-09 22:38:26"]
	,["测试1","测试内容1","测试","2019-03-09 22:38:26"]
	,["测试1","测试内容1","测试","2019-03-09 22:38:26"]
	,["测试1","测试内容1","测试","2019-03-09 22:38:26"]
	,["测试1","测试内容1","测试","2019-03-09 22:38:26"]];
	/*function jsArrChange(json){
		for (var i = 0 ; i < json.length ; i ++) {
			var arr1 = [];
			arr1[0] = json[i].title;
			arr1[1] = json[i].contents;
			arr1[2] = json[i].author;
			arr1[3] = json[i].tm;
			arr1[4] = json[i].id;
			
			systemList.push(arr1);
		};
	}
	jsArrChange(zskList);*/
	

	
	var systemTbody = document.getElementById("system_body");
	for(var i = 0;i < systemList.length;i ++){
		var systemTr = document.createElement("tr");
		if(i%2 == 1){
			systemTr.className = "gradeX odd";
		}else if(i%2 == 0){
			systemTr.className = "gradeX even";
		}
		systemTr.innerHTML += "<td><input type='checkbox' value='"+systemList[i][4]+"' name='check'/></td>";

		
		for(var j = 0;j < systemList[i].length;j ++){

			systemList[i][j] = systemList[i][j]+"";

			if(j == 0){
				systemTr.innerHTML += "<td><a href='#'>" + systemList[i][j] + "<a/></td>";
				continue;
			}

			if(j == 1||j==4){

				systemTr.innerHTML += "<td style='display:none;'>" + systemList[i][j] + "</td>";
				continue;
			}
			
			systemTr.innerHTML += "<td>" + systemList[i][j] + "</td>";
		
		}
		systemTr.innerHTML += "<td><input class='del_btn system_del' type='button' value='删除' /><input class='mod_btn' type='button' value='修改' /></td>";
		systemTbody.appendChild(systemTr);
	
	}    
	//全选
	var allCheck = $(".all_system_option input[name='check']");

	allCheck.click(function(){
		$("input[type='checkbox']").prop("checked",$(this).prop("checked"));

	});
	
	//删除按钮
	$(".del_btn").click(function(){
		var xintr = $(this).parent().parent().children();
		var id=xintr[5].innerHTML
		 layer.confirm('确认删除么', function(index) {
			                 $.ajax({
			                     type: "post",
			                    url: "deleteZsk.action",
			                      dataType:'json',
			                  	data:{	
			      					"id":id,
			      					"type":"系统说明",
			      				},
			                     dataType: "json",
			                      success: function (data) {
			                    	   layer.close(index);
			                          window.location.reload();
			                     },
			  
			                 })
			              });
	});
	$("#system_option_del").click(function(){

		 layer.confirm('确认删除么', function(index) {
			 $('input[name="check"]:checked').each(function (index, item) {
				          console.log($(this).val())
				          $.ajax({
			                     type: "post",
			                    url: "deleteZsk.action",
			                      dataType:'json',
			                  	data:{	
			      					"id":$(this).val(),
			      					"type":"系统说明",
			      				},
			                     dataType: "json",
			                      success: function (data) {
			                    	   
			                     },
			  
			                 })
			                 
				    });
			 layer.close(index);
          window.location.reload();
			              });
	});
	//新增文章
	$("#system_option_cr").click(function(){
		$(".system_crea").show();
		var nowTime = getTime();
		$(".system_crea input[name='tm']").val(nowTime);
	});
	
	//修改文章
	$(".mod_btn").click(function(){
		system_change(this)
	});

	//关闭修改
	$(".system_modify .close").click(function(){
		$(".system_modify").hide();
	});
	$(".system_crea .close").click(function(){
		$(".system_crea").hide();
	});
	$(".wz_look .close").click(function(){
		$(".wz_look").hide();
	});
	
	//修改文章
	$("td a").click(function(){
		wz_look(this)
	});
})   

function system_change(p){
	
	
	$(".system_modify").show();
	var xintd = $(p).parent().parent().children();
	//修改数据
	var changenewsList = [];


	for(var x = 1 ; x < 6; x ++){
		if(x == 1){
			changenewsList.push(xintd[x].childNodes[0].innerHTML)
			continue;
		}
		changenewsList.push(xintd[x].innerHTML);
	}
	
	var changeInput = $(".system_modify .system_modify_input");
	for(var i = 0;i < changeInput.length;i ++){
		changeInput[i].value = changenewsList[i];
	}
}


function wz_look(p){
	$(".wz_look").show();
	var xintd = $(p).parent().parent().children();
	//修改数据
	var changenewsList = [];
	for(var x = 1 ; x < 5 ; x ++){
		if(x == 1){
			changenewsList.push(xintd[x].childNodes[0].innerHTML);
			continue;
		}
		changenewsList.push(xintd[x].innerHTML);
	}
	$(".wz_look_title").html(changenewsList[0]);
	$(".wz_look_content").html(changenewsList[1]);
	$(".wz_look_autor").html(changenewsList[2]);
	$(".wz_look_time").html(changenewsList[3]);
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