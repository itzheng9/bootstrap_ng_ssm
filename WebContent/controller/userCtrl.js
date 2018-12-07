/**
 * 
 */


function userCtrl($scope, $http,$location ,$routeParams) {
	  
	
	//JSON.stringfy($scope.uuu)
	
    $scope.saveUser=function(){
    	$http.post("updateUser.action", 	   			  
		     {
			    id: $scope.id,
			    loginname: $scope.loginname,
		        pwd:$scope.pwd,
		        name:$scope.name,
		        role:$scope.role,
		        email:$scope.email			 
		     }	   		 
	   	          
	   	 ).then(function(resp) { 
				
				if (resp.data.retCode == "1" ){
					alert('修改成功');					
					$location.path("/user/list");  
				}
				
			}, function(resp) {
				console.log("resp status: " + resp.status);
				$scope.result = resp.data.msg;
			});
    	 
    	  
    	  
    };
	
    
    //根据给顶的id查询用户 给修改form使用
    if ($routeParams.userId != null && $routeParams.userId != undefined){
    	$http.get("getUserById.action", 
   			 { params:
   			     {
   				    id: $routeParams.userId
   				     
   			     }
   		 
   	         }
	   	 ).then(function(resp) { 
				$scope.id = resp.data.data.id;
				$scope.loginname = resp.data.data.loginname;
				$scope.pwd = resp.data.data.pwd;
				$scope.email = resp.data.data.email;
				$scope.name = resp.data.data.name;
				$scope.role = resp.data.data.role;
				 
				
			}, function(resp) {
				console.log("resp status: " + resp.status);
				$scope.result = resp.status;
			});
    }
    
	
	$scope.login = function() {			 
			  
			  //给java后台发送请求  get
			  $http.get('login.action', 
				{params:
				    {
					    uName:$scope.uName,
					      pwd:$scope.pwd
				    }
				   
				  
				})
			  .then(function(ddd) {
			       //console.log(ddd);
			       
			       $scope.uuu= ddd.data;
			  });
			  
			   
		 
		
		
		
	};
	  
}