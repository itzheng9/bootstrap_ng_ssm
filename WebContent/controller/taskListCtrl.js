/**
 * 
 */


function taskListCtrl($scope, $http,$location,$window ) {
	 
	$scope.pageNum =1;
	$scope.pageSize = 2;
	$scope.pageCount =1;
	
	
	
	
	//点新增按钮
	$scope.gotoAdd = function(){
		$location.path("/task/add/0");
		
	};
	
	 
	
	 
	 //查询
    $scope.getTaskList=function(){
    	 $http.get("taskList.action",
    			 { params:
    			     {
    				    taskName: $scope.name==null ||
    				              $scope.name == undefined?'%':$scope.name+'%',
    				    pageNum:$scope.pageNum,
    				    pageSize:$scope.pageSize
    				 
    			     }
    		 
    	         }
    	 )
		.then(function(resp) { 
			 
			if (resp.data.retCode ==1  ){
				
				console.log(resp.data.data);
				
				$scope.pageNum = resp.data.data.pageNum;
				$scope.pageSize = resp.data.data.pageSize;
				$scope.pageCount = resp.data.data.pages;
				
				$scope.taskList =   resp.data.data.list;
				
			}
			
		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		}); 
    };
	
    //页面打开是，马上执行查询
    $scope.getTaskList();
    
    
    //点页面编辑按钮
    $scope.editTask= function(tId){
    	
		
		$location.path('/task/add/'+tId);
		
		
    };


    
    
    //删除用户函数
    $scope.deleteTask= function(tId){
    	
    	if  ( false == $window.confirm('要删除任务吗？','提示', "no" ) ) {
    		return;
    	} 
              
    	
    	 $http.get("deleteTaskById.action",
    			 { params:
    			     {
    				    tId:tId,
    				      
    			     }
    		 
    	         }
    	 )
		.then(function(resp) { 
			 
			if (resp.data.retCode ==1  ){
				
				$scope.getTaskList();
				
			}
			
		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		}); 
    };
    
    //给页面增加分页的按钮
    $(function(){
    	appUtils.setPageFooter($scope, '#pageFooter' ,$scope.getTaskList );
    	 
    	
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