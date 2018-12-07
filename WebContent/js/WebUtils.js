/**
 *     2018-04-16 ,web页面帮助类模块 
 *     
 *      1. 主菜单点击样式
 *      
 */


var  appUtils = {
		
		setPageFooter:function($scope,footerElement,queryListData){
			var footerHtml ='';
			// 拼接 row样式
			footerHtml += '<div class="row col-md-12"   >' ; 
//				'style="position: fixed; margin-top: -50px;' +
//						'   bottom: 0px; ">' ;
						 
						
			
			footerHtml += '<div class="col-md-12 ">';
			
			
			footerHtml +=	'<div class="panel panel-default">';
			footerHtml +=	'<div class="col-md-7" id = "pageInfo" ><br />第0 '
			     +'页共0页</div>';

				footerHtml +=	'<nav style="text-algin:right;" class="col-md-5" aria-label="Page navigation">';
					footerHtml +=	'<ul class="pagination">';
				footerHtml +=	'	<li class="active"><a class="prev"> <span ';
				footerHtml +=	'			aria-hidden="true">&laquo;</span>';
				footerHtml +=	'		</a></li>';
				footerHtml +=	'		<li><a>1</a></li>';
				footerHtml +=	'		<li><a>2</a></li>';
				footerHtml +=	'		<li><a>3</a></li>';
				footerHtml +=	'		<li><a>4</a></li>';
				footerHtml +=	'		<li><a>5</a></li>';
				footerHtml +=	'		<li><a class="next"> <span aria-hidden="true">&laquo;</span>';
				footerHtml +=	'	</a></li>';
				footerHtml +=	'</ul>';
				footerHtml +=	'	</nav>';				
				footerHtml +=	'	</div>';
				footerHtml +=	'</div>';
				 
			
			$(footerElement).html(footerHtml);
			
			
			//给页面分页按钮绑定事件
	    	$('.pagination li a').on('click',function(btn){
	    		var  pageno = $(btn.currentTarget).html();
	    		//1,2,3  <span
	    		if ( isNaN(pageno) ){
	    			var  pageNext= $(btn.currentTarget).attr('class') ;
	    			if (pageNext =='next'){
	    				$scope.pageNum =
	    					$scope.pageNum < $scope.pageCount ?
	    						++$scope.pageNum:$scope.pageCount;
	    			}
	    			if (pageNext =='prev'){
	    				$scope.pageNum =$scope.pageNum > 1 ?
	    						--$scope.pageNum:1;
	    			}
	    		} else{
	    			console.log(pageno);
	    			$scope.pageNum = pageno <= $scope.pageCount ?
	    					pageno:$scope.pageNum;
	    		}    		
	    		
	    		 
	    		queryListData();
	    		
	    		$("#pageInfo").html('<br /><br /><span  >第'+$scope.pageNum+'页，共'+$scope.pageCount+'页');
	    		
	    	});
			
		},
		setMenuCss:function  (clickEvt){
			
			var   clickedMenu = $(clickEvt.currentTarget);
			//点击菜单  被点击菜单背景色
			$("#main-menu li a").removeClass("active-menu");
			clickedMenu.addClass("active-menu");
			
			
			//点击菜单 修改view内的标题
			var  sss= clickedMenu.html();
			//alter(sss);
			//$("#pageViewTitle").html(sss.substring(sss.lastIndexOf('>')+1,sss.length).trim());
		 
			
			//点击菜单 ，修改 修改view内的面包屑导航
			//alert( clickedMenu.attr("href") );
			$("#navTips").html( "Home  " + clickedMenu.attr("href") );
			
			
			
		
		}	
}


$(document).ready(function(){
	$("#main-menu li a").on("click", appUtils.setMenuCss);
	
});
