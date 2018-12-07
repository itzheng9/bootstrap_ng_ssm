/**
 * 
 *   日期：2018-04-14
 *   组着：嘻嘻嘻嘻
 *   功能：ng 应用定义、路由配置
 *   
 *   修改记录：
 *    111：水电费沙发垫师傅师傅的说法  ，修改人：yyy
 *    2222：水电费沙发垫师傅师傅的说法  ，修改人：hhhh
 *    
 *    
 *    
 *   
 */


//定义主模块并注入依赖
var masterApp = angular.module("pmApp", ["ngRoute","ngSanitize"]);

 

//路由配置
angular.module("pmApp").
config(["$routeProvider", function($routeProvider) {
	$routeProvider.when("/user/login",{
		templateUrl: "login.html" ,
		controller: userCtrl		 
	}). when("/user/register",{
		templateUrl: "pages/registerUser.html" ,
		controller: userCtrl		 
	}).when("/user/edit/:userId",{
		templateUrl: "pages/registerUser.html" ,
		controller: userCtrl		 
	})
	. when("/user/list",{
		templateUrl: "pages/userList.html" ,
		controller: userListCtrl		 
	})
	. when("/project/list",{
		templateUrl: "pages/projectList.html" ,
		controller: projectListCtrl
	})
    . when("/project/add/:pid",{
        templateUrl: "pages/editProject.html" ,
        controller: projectEditCtrl
      })

	. when("/task/list",{
		templateUrl: "pages/taskList.html" ,
		controller: taskListCtrl
	})
	. when("/task/add/:tid",{
		templateUrl: "pages/editTask.html" ,
		controller: taskEditCtrl
	})
	. when("/project/tree",{
		templateUrl: "pages/projectTree.html" ,
		controller: projectTreeCtrl
	})
	.otherwise({
		redirectTo: "/user/register"
	});
}]).
filter('transfer', function() {
	return function(input, defaultStata) {
	    return   input=='1'?'成功':(input=='0'?'失败':defaultStata==undefined ?'未知':defaultStata);
		
	}
}).
filter('transferDate', function() {
    return function(input, defaultStata) {
    	 //'1970-1-1'
        var  ddd= new Date(input)
        return   ddd.toLocaleDateString().replace('/','-').replace('/','-').replace('/','-');

    }
}).factory('userList', ['$http','$window', function(http,win) {

    return function(nextFun,params,scope ) {
        http.get("userList.action" ,{
            params:{
                userName:'%',
                pageNum:1,
                pageSize:99999
            }
        })
            .then(function(resp) {

                if (resp.data.retCode ==1  ){

                    scope.uList = resp.data.data.list;

                    //当查询用户列表结束后，业务上需要执行的其他函数
					if(nextFun!=null && nextFun != undefined)
					     nextFun(params);

                }


            }, function(resp) {
                 win.alert( resp.data.msg);
            });
    };
}]);;
