/*------------------------------------------------------
    Author : www.webthemez.com
    License: Commons Attribution 3.0
    http://creativecommons.org/licenses/by/3.0/
---------------------------------------------------------  */

(function ($) {
    "use strict";
    var mainApp = {

        initFunction: function () {
            /*MENU 
            ------------------------------------*/
            $('#main-menu').metisMenu();
			
            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse')
                } else {
                    $('div.sidebar-collapse').removeClass('collapse')
                }
            });

            
	 
        },

        initialization: function () {
            mainApp.initFunction();

        }

    }
    // Initializing ///

    $(document).ready(function () {
    	//console.log(window);
    	
        mainApp.initFunction(); 
		$("#sideNav").click(function(){
			if($(this).hasClass('closed')){
				$('.navbar-side').animate({left: '0px'});
				$(this).removeClass('closed');
				$('#page-wrapper').animate({'margin-left' : '260px'});
				
			}
			else{
			    $(this).addClass('closed');
				$('.navbar-side').animate({left: '-260px'});
				$('#page-wrapper').animate({'margin-left' : '0px'}); 
			}
		});
		
		//动态指定左侧菜单栏高度
		//<div class="sidebar-collapse" style="overflow:scroll;height:400px;">
		 
		$('.sidebar-collapse').css("height", (window.innerHeight-66)+"px");
		
		
    });

}(jQuery));
