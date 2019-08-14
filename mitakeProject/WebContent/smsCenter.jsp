<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/sweet-alert.css">
    <link rel="stylesheet" href="css/select.css">
    
    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class="" style=""> 
  <!--<![endif]-->
<jsp:include page="sharedField.jsp"></jsp:include>

    
  
    

    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Edit User</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">Home</a> <span class="divider">/</span></li>
            <li><a href="users.html">Users</a> <span class="divider">/</span></li>
            <li class="active">User</li>
        </ul>
	
	
	
		<div class="select-wrapper">
        <div class="div-group">
            <div class="width-53 clearfix">
                <div class="form-content pink-border-color border-2px clearfix" data-bs="lead" id="leading">
                    <div class="form-left">
                        <div class="form-title pink-bg-color">部門負責</div>
                    </div>
                    <div class="form-right">
                        <div class="score-wrapper clearfix">
                            <div class="score-f">
                                <span class="score-span blue-bg"></span>
                                100 :
                            </div>
                            <div class="top-droppable pink-border-color people-group clearfix">

                            </div>
                            <div class="score-xz num-xz">
                                <span class="numSpan">0</span>/<span class="totalNum">2</span>
                            </div>
                        </div>
                        <div class="score-wrapper">
                            <div class="score-f">
                                <span class="score-span qi-bg"></span>
                                95 :
                            </div>
                            <div class="top-droppable pink-border-color people-group clearfix">

                            </div>
                            <div class="score-xz num-xz">
                                <span class="numSpan">0</span>/<span class="totalNum">5</span>
                            </div>
                        </div>
                        <div class="score-wrapper clearfix">
                            <div class="score-f">
                                <span class="score-span green-bg"></span>
                                90 :
                            </div>
                            <div class="top-droppable pink-border-color people-group clearfix">

                            </div>
                            <div class="score-xz">
                                <span class="numSpan">0</span>/<span>不限</span>
                            </div>
                        </div>
                        <div class="score-wrapper">
                            <div class="score-f">
                                <span class="score-span yellow-bg"></span>
                                90以下 :
                            </div>
                            <div class="top-droppable pink-border-color people-group clearfix">

                            </div>
                            <div class="score-xz">
                                <span class="numSpan">0</span>/<span>不限</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="width-47 clearfix">
                <div class="people-list pink-border-color border-2px ">
                    <ul class="list-wrapper clearfix" id="leader-wrapper">
                    </ul>
                </div>

            </div>
        </div>
        <div class="div-group">
            <div class="width-53 clearfix">
                <div class="form-content qblue-border-color border-2px clearfix" data-bs="own" id="owner">
                    <div class="form-left">
                        <div class="score-wrapper clearfix">
                            <div class="score-f">
                                <span class="score-span blue-bg"></span>
                                100 :
                            </div>
                            <div class="top-droppable pink-border-color people-group clearfix">

                            </div>
                            <div class="score-xz num-xz">
                                <span class="numSpan">0</span>/<span class="totalNum">2</span>
                            </div>
                        </div>
                        <div class="score-wrapper">
                            <div class="score-f">
                                <span class="score-span qi-bg"></span>
                                95 :
                            </div>
                            <div class="top-droppable pink-border-color people-group clearfix">

                            </div>
                            <div class="score-xz num-xz">
                                <span class="numSpan">0</span>/<span class="totalNum">5</span>
                            </div>
                        </div>
                        <div class="score-wrapper clearfix">
                            <div class="score-f">
                                <span class="score-span green-bg"></span>
                                90 :
                            </div>
                            <div class="top-droppable pink-border-color people-group clearfix">

                            </div>
                            <div class="score-xz">
                                <span class="numSpan">0</span>/<span>不限</span>
                            </div>
                        </div>
                        <div class="score-wrapper">
                            <div class="score-f">
                                <span class="score-span yellow-bg"></span>
                                90以下 :
                            </div>
                            <div class="top-droppable pink-border-color people-group clearfix">

                            </div>
                            <div class="score-xz">
                                <span class="numSpan">0</span>/<span>不限</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="width-47 clearfix">
                <div class="people-list qblue-border-color border-2px ">
                    <ul class="list-wrapper clearfix" id="owner-wrapper">
                    </ul>
                </div>

            </div>
        </div>
      
    </div>
        
    </div>
    

       <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="http://www.jq22.com/jquery/jquery-ui-1.11.0.js"></script>
    <script src="js/jquery.top-droppable.js"></script>
    <script src="js/sweet-alert.min.js"></script>
    <script>
        $(function() {

            changeData(10,$("#leader-wrapper"),'lead','张三');
            changeData(21,$("#owner-wrapper"),'own','李四');
            changeData(31,$("#other-wrapper"),'other','王二麻子');
            // 放在加载人员的函数里
            changeHeight();
            $(".list-wrapper>li").draggable({
                revert: true
            });
            // 拖拽追加事件
            $(".top-droppable").topDroppable({
                drop: function (e, ui) {
                    var parentNode=$(this).parents(".form-content");
                    var parentNextNode=$(this).parents(".width-53").next().find(".people-list");
                    var jScore=Number($(this).next("div").find(".numSpan").text());
                    var totalScore=Number($(this).next("div").find(".totalNum").text());
                    if($(ui.draggable[0]).attr("data-bs")==parentNode.attr("data-bs")){
                        if($(this).next(".score-xz").hasClass("num-xz")){
                            if((jScore)<totalScore){
                                $(this).next("div").find(".numSpan").html(jScore+1)
                            }else{
                                alert("超出可选人数上限");
                                return
                            }
                        }else{
                            $(this).next("div").find(".numSpan").html(jScore+1)
                        }
                        $(this).parents(".form-content").height("auto");
                        $(this).parents(".width-53").next().find(".people-list").height("auto");
                        $(this).append("<div class='"+$(ui.draggable[0]).attr('id')+"'>"+$(ui.draggable[0]).text()+"<span class='del'></span></div>");
                        $(ui.draggable[0]).hide();
                        changeHeight()
                    }else{
                        alert("不可越界")
                    }
                }
            }).droppable({
                tolerance: "pointer"
            });
            $(".score-wrapper").on("click",".del",function(){
                var parentNode=$(this).parents(".form-content");
                var parentNextNode=$(this).parents(".width-53").next().find(".people-list");
                var jScore=Number($(this).parents(".score-wrapper").find(".score-xz").find(".numSpan").text());
                var totalScore=Number($(this).parents(".score-wrapper").find(".score-xz").find(".totalNum").text());
                $("#"+$(this).parent().attr("class")).show();
                if(jScore>0){
                    $(this).parents(".score-wrapper").find(".score-xz").find(".numSpan").html(jScore-1)
                }
                $(this).parent().remove();
                if(parentNextNode.height()>parentNode.height()){
                    parentNode.height(parentNextNode.height())
                }
            })
            $(window).resize(function(){
                changeHeight()
            })
        });
        function changeData(num,parent,bmName,name) {
            var leadHtml='';
            for(var i=0;i<num;i++){
                leadHtml+='<li id="'+bmName+i+'" data-bs="'+bmName+'">' +
                    '<span class="name">'+name+i+'</span>' +
                    '<span class="infor"></span>' +
                    '</li>'
            }
            $(parent).html(leadHtml);
        }
        // 左右高度相等函数
        function changeHeight(){
            var divGroup=$(".div-group");
            for(var i=0;i<divGroup.length;i++){
                var parentNode=$(divGroup[i]).find(".form-content");
                var parentNextNode=$(divGroup[i]).find(".people-list");
                parentNode.height("auto");
                parentNextNode.height("auto");
                if(parentNode.height()<parentNextNode.height()){
                    parentNode.height(parentNextNode.height())
                }else{
                    parentNextNode.height(parentNode.height())
                }
            }
        }
    </script>            
    

    
        <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>

    


</body></html>
