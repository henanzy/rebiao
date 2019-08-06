$(document).ready(function() {



	
	var questionList =[["测试1","测试内容1","测试","2019-03-09 22:38:26"],["测试1","测试内容1","测试","2019-03-09 22:38:26"]
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
			
			questionList.push(arr1);
		};
	}
	jsArrChange(zskList);*/
	

	
	var questionTbody = document.getElementById("question_body");
	for(var i = 0;i < questionList.length;i ++){
		var questionTr = document.createElement("tr");
		if(i%2 == 1){
			questionTr.className = "gradeX odd";
		}else if(i%2 == 0){
			questionTr.className = "gradeX even";
		}
		questionTr.innerHTML += "<td><input type='checkbox' value='"+questionList[i][4]+"' name='check'/></td>";

		
		for(var j = 0;j < questionList[i].length;j ++){

			questionList[i][j] = questionList[i][j]+"";

			if(j == 0){
				questionTr.innerHTML += "<td><a href='#'>" + questionList[i][j] + "<a/></td>";
				continue;
			}

			if(j == 1||j==4){

				questionTr.innerHTML += "<td style='display:none;'>" + questionList[i][j] + "</td>";
				continue;
			}
			
			questionTr.innerHTML += "<td>" + questionList[i][j] + "</td>";
		
		}
		questionTr.innerHTML += "<td><input class='del_btn question_del' type='button' value='删除' /><input class='mod_btn' type='button' value='修改' /></td>";
		questionTbody.appendChild(questionTr);
	
	}
	//全选
	var allCheck = $(".all_question_option input[name='check']");

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
			      					"type":"问题解答",
			      				},
			                     dataType: "json",
			                      success: function (data) {
			                    	   layer.close(index);
			                          window.location.reload();
			                     },
			  
			                 })
			              });
	});
	$("#question_option_del").click(function(){

		 layer.confirm('确认删除么', function(index) {
			 $('input[name="check"]:checked').each(function (index, item) {
				          console.log($(this).val())
				          $.ajax({
			                     type: "post",
			                    url: "deleteZsk.action",
			                      dataType:'json',
			                  	data:{	
			      					"id":$(this).val(),
			      					"type":"国家法规",
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
	$("#question_option_cr").click(function(){
		$(".question_crea").show();
		var nowTime = getTime();
		$(".question_crea input[name='tm']").val(nowTime);
	});
	
	//修改文章
	$(".mod_btn").click(function(){
		wz_change(this)
	});

	//关闭修改
	$(".question_modify .close").click(function(){
		$(".question_modify").hide();
	});
	$(".question_crea .close").click(function(){
		$(".question_crea").hide();
	});
	$(".wz_look .close").click(function(){
		$(".wz_look").hide();
	});
	
	//修改文章
	$("td a").click(function(){
		wz_look(this)
	});
})   

function wz_change(p){
	
	
	$(".question_modify").show();
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
	
	var changeInput = $(".question_modify .question_modify_input");
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