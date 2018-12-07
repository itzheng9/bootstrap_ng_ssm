/**
 * 
 */


function projectEditCtrl($scope, $http,$location,
                         $window ,$routeParams,userList) {


	 //根据id查询项目
    $scope.getProjectById=function(pid){

        if ($routeParams.pid   ==0) return;
    	 $http.get("getProjectById.action",
    			 { params:
    			     {
    				    pid: pid

    			     }

    	         }
    	 )
		.then(function(resp) {

			if (resp.data.retCode ==1  ){

				//console.log(resp.data.data);
				//在页面显示项目信息，供编辑使用
                $scope.pro= resp.data.data;

                //将后台给的字符串日期转换为js date 赋值给页面 type='date'

                $scope.pro.begintime = new Date($scope.pro.begintime);
                $scope.pro.endtime = new Date($scope.pro.endtime);
			}

		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		});
    };


     userList($scope.getProjectById,$routeParams.pid ,$scope);
    //$scope.getUserList();


    
    
    ////点页面提交按钮
    $scope.saveProject= function(pId){

    	//数据提交给后台前  进行格式转换 转为spring需要的格式
    	$scope.pro.begintime =
			$scope.pro.begintime.toLocaleDateString()
				.replace('/','-').replace('/','-');

        $scope.pro.endtime =
            $scope.pro.endtime.toLocaleDateString()
                .replace('/','-').replace('/','-');
    	
    	 $http.post("saveProject.action",  $scope.pro )
		.then(function(resp) { 
			 
			if (resp.data.retCode ==1  ){

			    //TODO 跳转到列表后，继续保存在第10页？？？
			    $location.path('/project/list');
				//$scope.getProjectList();
				
			}
			
		}, function(resp) {
			console.log("resp status: " + resp.data.msg);
			$scope.result = resp.data.msg;
		}); 
    };
    

   
	  
}