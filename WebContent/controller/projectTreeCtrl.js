/**
 * 
 */


function projectTreeCtrl($scope, $http,$location,
                         userList) {

    covertDate = function (objList) {
        objList.forEach(function(obj){
            obj.text = obj.name;

            //加图标
            obj.icon=   "glyphicon glyphicon-cloud-download";//"assert/img/jimao.ico"
        });

    };

    //给编辑页面用户下拉框查询数据
    $scope.getProjectList = function(){
        $http.get("getProjectListWithJoinInfo.action",
            { params:
                    {
                        projectName: '%' ,
                        pageNum:1,
                        pageSize:3

                    }

            }
        )
            .then(function(resp) {

                if (resp.data.retCode ==1  ){

                    // [{id:1,name:'神五',employeeList:[{},{},....]},
                       //{},{}]


                    covertDate(resp.data.data.list);
                    //转数据格式 供treeview使用
                    resp.data.data.list.forEach(
                        function(ppp){

                            covertDate(ppp.employeeList);
                            covertDate(ppp.taskList);
                            covertDate(ppp.bugList);


                            ppp.nodes=
                                [{text:'项目组',nodes:ppp.employeeList},
                                {text:"任务",nodes:ppp.taskList},
                                {text:"bug",nodes:ppp.bugList}];

                        }
                    );

                    //当以上所有请求都完成后，在构造树；
                    $('#pTree').treeview({
                        data: resp.data.data.list
                    });








                }

            }, function(resp) {
                console.log("resp status: " + resp.data.msg);
                $scope.result = resp.data.msg;
            });
    };



    $scope.getProjectList();
    //



    
    

    

   
	  
}