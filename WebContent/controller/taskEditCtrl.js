/**
 * 
 */


function taskEditCtrl($scope, $http,$location,
                      $window ,$routeParams,userList) {

    $scope.task={
        createtime:new Date(),
        finishtime:new Date()
    };



	 //根据id查询项目
    $scope.getTaskById=function(tid){
        if ($routeParams.tid   ==0)
            return;
    	 $http.get("getTaskById.action",
    			 { params:
    			     {
    				    tid: tid

    			     }

    	         }
    	 )
		.then(function(resp) {

			if (resp.data.retCode ==1  ){

				//console.log(resp.data.data);
				//在页面显示项目信息，供编辑使用
                $scope.task= resp.data.data;

                //将后台给的字符串日期转换为js date 赋值给页面 type='date'

                $scope.task.createtime = new Date($scope.task.createtime);
                $scope.task.finishtime = new Date($scope.task.finishtime);
			}

		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		});
    };


    userList($scope.getTaskById,$routeParams.tid,$scope  );
    ///$scope.getUserList();


    
    
    ////点页面提交按钮
    $scope.saveTask= function(tId){

    	//数据提交给后台前  进行格式转换 转为spring需要的格式
    	$scope.task.createtime =
			$scope.task.createtime.toLocaleDateString()
				.replace('/','-').replace('/','-');

        $scope.task.finishtime =
            $scope.task.finishtime.toLocaleDateString()
                .replace('/','-').replace('/','-');
    	
    	 $http.post("saveTask.action",  $scope.task )
		.then(function(resp) { 
			 
			if (resp.data.retCode ==1  ){

			    //TODO 跳转到列表后，继续保存在第10页？？？
			    $location.path('/task/list');
				//$scope.getTaskList();
				
			}
			
		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		}); 
    };
    

   
	  
}