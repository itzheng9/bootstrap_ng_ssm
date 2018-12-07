/**
 * 
 */


function projectListCtrl($scope, $http,$location,$window ) {
	 
	$scope.pageNum =1;
	$scope.pageSize = 2;
	$scope.pageCount =1;
	
	
	
	
	//点新增按钮
	$scope.gotoAdd = function(){
		$location.path("/project/add/0");
		
	};
	
	 
	
	 
	 //查询项目
    $scope.getProjectList=function(){
    	 $http.get("projectList.action", 
    			 { params:
    			     {
    				    projectName: $scope.projectName==null ||
    				              $scope.projectName == undefined?'%':$scope.projectName+'%',
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
				
				$scope.projectList =   resp.data.data.list;				  
				
			}
			
		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		}); 
    };
	
    //页面打开是，马上执行查询
    $scope.getProjectList();
    
    
    //点页面编辑按钮
    $scope.editProject= function(projectId){
    	
		
		$location.path('/project/add/'+projectId);
		
		
    };


    
    
    //删除用户函数
    $scope.deleteProject= function(pId){
    	
    	if  ( false == $window.confirm('要删除项目吗？','提示', "no" ) ) {
    		return;
    	} 
              
    	
    	 $http.get("deleteProjectById.action", 
    			 { params:
    			     {
    				    projectId:pId,
    				      
    			     }
    		 
    	         }
    	 )
		.then(function(resp) { 
			 
			if (resp.data.retCode ==1  ){
				
				$scope.getProjectList();		  
				
			}
			
		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		}); 
    };
    
    //给页面增加分页的按钮
    $(function(){
    	appUtils.setPageFooter($scope, '#pageFooter' ,$scope.getProjectList );
    	 
    	
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