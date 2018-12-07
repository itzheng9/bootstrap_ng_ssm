/**
 * 
 */


function userListCtrl($scope, $http,$location,$window ) {
	 
	$scope.pageNum =1;
	$scope.pageSize = 2;
	$scope.pageCount =1;
	
	
	
	
	//点新增按钮
	$scope.gotoAdd = function(){
		$location.path("/user/register");
		
	};
	
	 
	
	 
	//JSON.stringfy($scope.uuu)
	
	//第一页  $scope.pageNum =1;
	//、、下一页：$scope.pageNum +1 判断范围 
	//上页页：$scope.pageNum -1 判断 》0
	//最后页：$scope.pageNum = $scope.pageCount
    $scope.getUserList=function(){
    	 $http.get("userList.action", 
    			 { params:
    			     {
    				    userName: $scope.username==null ||
    				              $scope.username == undefined?'%':$scope.username+'%',
    				    pageNum:$scope.pageNum,
    				    pageSize:$scope.pageSize
    				 
    			     }
    		 
    	         }
    	 )
		.then(function(resp) { 
			 
			if (resp.data.retCode ==1  ){
				
				 
				
				$scope.pageNum = resp.data.data.pageNum;
				$scope.pageSize = resp.data.data.pageSize;
				$scope.pageCount = resp.data.data.pages;
				
				
				
				$scope.us =   resp.data.data.list;				  
				
			}
			
		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		}); 
    };
	
    //页面打开是，马上执行查询
    $scope.getUserList();
    
    
    //点页面编辑按钮
    $scope.editUser= function(userId){
    	
		
		$location.path('/user/edit/'+userId);
		
		
    };
    
    
    //删除用户函数
    $scope.deleteUser= function(uuuId){
    	
    	if  ( false == $window.confirm('要删除用户吗？','提示', "no" ) ) {
    		return;
    	} 
              
    	
    	 $http.get("deleteUserById.action", 
    			 { params:
    			     {
    				    userId:uuuId,
    				      
    			     }
    		 
    	         }
    	 )
		.then(function(resp) { 
			 
			if (resp.data.retCode ==1  ){
				
				$scope.getUserList();		  
				
			}
			
		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		}); 
    };
    
    //给页面增加分页的按钮
    $(function(){
    	appUtils.setPageFooter($scope, '#pageFooter' ,$scope.getUserList );
    	 
    	
    });
	
    //有数据后才可以绑定
    /*$('td button .editUser').on('click', function(btnEvt){
			
			//alert('edituesrTODO');
			var btn = $(btnEvt);
			var userId = btn.attr("id");
			alert(userId);
			
			
			//发ajajx请求  查询用户信息  展示到form界面  。
			//使用新增的页面来 实现修改功能？？？？
		 
    	
    } );*/
    
   
	  
}