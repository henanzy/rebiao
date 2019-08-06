$(document).ready(function(){
//初始化地图
    var map = new AMap.Map('container', {
      resizeEnable: true, //是否监控地图容器尺寸变化
      zoom: 12, //初始地图级别
      center: [111.18747, 34.77141], //初始地图中心点
      showIndoorMap: false //关闭室内地图
    });

    map.on("complete", function(){
       log.success("地图加载完成！");  
    });
    
     map.clearMap();
     
	var mapList = [
		[[116.205467, 39.907761],"张三","2019-14-28"],
		[[116.368904, 39.913423],"李四","2019-14-28"],
		[[116.305467, 39.807761],"王五","2019-14-28"],
		[[116.38201890478518, 39.88615631552293],"赵六","2019-14-28"]
	];
	
//	var markers = [{
//        icon: '../images/dw/dwblue1.png',
//        position: mapList[0][0]
//    }, {
//        icon: '../images/dw/dwblue2.png',
//        position: mapList[1][0]
//    }, {
//        icon: '../images/dw/dwblue3.png',
//        position: mapList[2][0]
//    }, {
//        icon: '../images/dw/dwblue4.png',
//        position: mapList[3][0]
//    }];
	
	var markers = [];
	for(var i = 0 ; i < mapList.length ; i ++ ){
		markers.push({icon: "../images/dw/dwblue" + (i+1) + ".png",position: mapList[i][0]});
	}
	
	
    // 添加一些分布不均的点到地图上,地图上添加三个点标记，作为参照
    markers.forEach(function(marker) {
        new AMap.Marker({
            map: map,
            icon: marker.icon,
            position: [marker.position[0], marker.position[1]],
            offset: new AMap.Pixel(-13, -30)
        });
    });
    var newCenter = map.setFitView();//地图自适应

    //标签
    var ele = "<div id='maptext'>";
    for(var j = 0 ; j < mapList.length ; j ++ ){
    		 ele += "<p><span class='mapnum'>" + (j+1) + "</span><span class='mappeo'>" + mapList[j][1]+ " : " + mapList[j][2] + "</span></p>";
    }
    ele += "</div>";
    $("#container").after(ele);
    
}); 