$(document).ready(function() {


	/*var nationalList = [];*/
	var nationalList = [["测试1","测试内容1","测试","2019-03-09 22:38:26"],["测试1","测试内容1","测试","2019-03-09 22:38:26"]
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
			
			nationalList.push(arr1);
		};
	}
	jsArrChange(zskList);
	*/
	
	

	
	var naTbody = document.getElementById("na_body");
	for(var i = 0;i < nationalList.length;i ++){
		var naTr = document.createElement("tr");
		if(i%2 == 1){
			naTr.className = "gradeX odd";
		}else if(i%2 == 0){
			naTr.className = "gradeX even";
		}
		naTr.innerHTML += "<td><input type='checkbox' value='"+nationalList[i][4]+"' name='check'/></td>";

		
		for(var j = 0;j < nationalList[i].length;j ++){

			nationalList[i][j] = nationalList[i][j]+"";
//			if(newsList[i][j].length > 15){
//				var new_newsList = newsList[i][j].slice(0,14);
//				newsTr.innerHTML += "<td>" + new_newsList + "···</td>";
//			}else{
//				newsTr.innerHTML += "<td>" + newsList[i][j] + "</td>";
//			}

			if(j == 0){
				naTr.innerHTML += "<td><a href='#'>" + nationalList[i][j] + "<a/></td>";
				continue;
			}

			if(j == 1||j==4){

				naTr.innerHTML += "<td style='display:none;'>" + nationalList[i][j] + "</td>";
				continue;
			}
			
			naTr.innerHTML += "<td>" + nationalList[i][j] + "</td>";
		
		}
		naTr.innerHTML += "<td><input class='del_btn na_del' type='button' value='删除' /><input class='mod_btn' type='button' value='修改' /></td>";
		naTbody.appendChild(naTr);
	
	}
	//全选
	var allCheck = $(".all_na_option input[name='check']");

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
			      					"type":"国家法规",
			      				},
			                     dataType: "json",
			                      success: function (data) {
			                    	   layer.close(index);
			                          window.location.reload();
			                     },
			  
			                 })
			              });
	});
	$("#na_del").click(function(){

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
	$("#na_option_cr").click(function(){
		$(".na_crea").show();
		var nowTime = getTime();
		$(".na_crea input[name='tm']").val(nowTime);
	});
	
	//修改文章
	$(".mod_btn").click(function(){
		wz_change(this)
	});

	//关闭修改
	$(".na_modify .close").click(function(){
		$(".na_modify").hide();
	});
	$(".na_crea .close").click(function(){
		$(".na_crea").hide();
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
	$(".na_modify").show();
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
	
	var changeInput = $(".na_modify .na_modify_input");
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