<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>遇見未來團隊系統後臺</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

<!--引入 日期套件 -->
<link rel="stylesheet" href="js/bootstrap-datetimepicker.js"
	rel="external nofollow">
<script src="js/bootstrap-datetimepicker.min.js"></script>

<link href="css/bootstrap-datetimepicker.css" rel="stylesheet"
	media="screen">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"
	media="screen">
<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

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
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>


<%
	String account = (String) session.getAttribute("account");
	if (account == null) {
		response.sendRedirect("sign-in.jsp");
	}
%>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->


	<!-- 客戶左邊欄位 以及上方欄位  -->
	<jsp:include page="sharedField.jsp"></jsp:include>


	<div class="content">

		<div class="header">
			<h1 class="page-title">會員資料</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="users.jsp">Home</a> <span class="divider">/</span></li>
			<li class="active">會員資料</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">

				<div class="btn-toolbar">
					<!--     <button class="btn btn-primary"><i class="icon-plus"></i> New User</button> -->
					<button class="btn btn-primary" data-toggle="modal"
						data-target="#myModal">
						<i class="icon-plus"></i>添加新會員
					</button>
					<!-- 					<button class="btn">Import</button> -->
					<!-- 					<button class="btn">Export</button> -->
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>會員編號</th>
								<th>會員姓名</th>
								<th>會員手機號碼</th>
								<th>會員Email</th>
								<th>會員居住地址</th>
								<th>會員創建日期</th>
								<th>會員到期日期</th>
								<th style="width: 26px;"></th>
							</tr>
						</thead>
						<tbody id="trhead">

						</tbody>
					</table>
				</div>
				<div class="pagination">
					<ul>
						<li><a href="#">Prev</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</div>

				<!-- <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> -->
				<!--     <div class="modal-header"> -->
				<!--         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
				<!--         <h3 id="myModalLabel">Delete Confirmation</h3> -->
				<!--     </div> -->
				<!--     <div class="modal-body"> -->
				<!--         <p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p> -->
				<!--     </div> -->
				<!--     <div class="modal-footer"> -->
				<!--         <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button> -->
				<!--         <button class="btn btn-danger" data-dismiss="modal">Delete</button> -->
				<!--     </div> -->
				<!-- </div> -->


				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">添加新的會員</h4>
							</div>
							<form id="form1" onsubmit="return false" action="##"
								method="post">
								<div class="modal-body">
									<label>會員姓名</label> <input type="text" name="username"
										class="input-xlarge"> <label>會員手機號碼</label> <input
										type="text" name="userPhone" class="input-xlarge"> <label>EMAIL</label>
									<input type="text" name="email" class="input-xlarge"> <label>會員到期日期</label>

									<div class="input-append date form_datetime">
										<input size="16" type="text" value=""
											name="custMemberDataTime" readonly> <span
											class="add-on"><i class="icon-remove"></i></span> <span
											class="add-on"><i class="icon-calendar"></i></span>
									</div>

									<label>地址</label>
									<textarea name="address" rows="3" class="input-xlarge"></textarea>

								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<button type="button" class="btn btn-primary"
										onclick="addmemberInformation()">提交更改</button>
								</div>

							</form>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>





				<div class="modal fade" id="editmember" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">編輯會員資料</h4>
							</div>
							<form id="form2" onsubmit="return false" action="##"
								method="post">
								<div class="modal-body">
									<label>會員姓名</label> <input type="text" name="username"
										class="input-xlarge" id="edditName"> <label>會員手機號碼</label> <input
										type="text" name="userPhone" class="input-xlarge" id="edditPhone"> <label>EMAIL</label>
									<input type="text" name="email" class="input-xlarge" id="edditEmail" > <label>會員到期日期</label>

									<div class="input-append date form_datetime">
										<input size="16" type="text" 
											name="custMemberDataTime" readonly  id="editMemberDataTime"> <span
											class="add-on"><i class="icon-remove"></i></span> <span
											class="add-on"><i class="icon-calendar"></i></span>
									</div>


									<label>地址</label>
									<textarea name="address" rows="3" class="input-xlarge" id="edditaddress"></textarea>
									
										<input size="16" type="text" value="" name="hiddenVal"
								id="hiddenVal" style="display: none" />

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<button type="button" class="btn btn-primary"
										onclick="editInformation()">提交更改</button>
								</div>
							</form>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>


				<div class="modal fade" id="delectMember" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">刪除會員資料</h4>
							</div>
							<div class="modal-body" id="delectNumber"></div>
							<input size="16" type="text" value="" name="hiddenVal"
								id="hiddenVal" style="display: none" />
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary"
									onclick="delectMemberInformation()">確定</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>

				</div>




				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModalRefuse" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h5 class="modal-title" id="myModalLabel">拒绝申请</h5>
							</div>
							<div class="modal-body">
								请输入拒绝申请的原因<span style="color: red">*</span><br>
								<textarea name="refuseTextareaContext" rows="10" cols="30"></textarea>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" id="btnRefuseSave" class="btn btn-primary"
									data-dismiss="modal">保存</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->




				<footer>
				<hr>

				<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
				<p class="pull-right">
					A <a href="http://www.portnine.com/bootstrap-themes"
						target="_blank">Free Bootstrap Theme</a> by <a
						href="http://www.portnine.com" target="_blank">Portnine</a>
				</p>

				<p>
					&copy; 2012 <a href="http://www.portnine.com" target="_blank">Portnine</a>
				</p>
				</footer>

			</div>
		</div>
	</div>



	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});

		function addmemberInformation() {
			$.ajax({
				//几个参数需要注意一下
				type : "POST",//方法类型
				dataType : "json",//预期服务器返回的数据类型
				url : "/mitakeProject/addNewUser",//url
				data : $('#form1').serialize(),
				success : function(result) {
					console.log(result);//打印服务端返回的数据(调试用)

					if (result.code == 0) {
						alert("添加成功");
						$("#editmember .close").click()
						loadingData();
					}
					;
				},
				error : function() {
					alert("异常！");
				}
			});
		}
		
		
		

		
		function editInformation() {
			$.ajax({
				//几个参数需要注意一下
				type : "POST",//方法类型
				dataType : "json",//预期服务器返回的数据类型
				url : "/mitakeProject/editMember",//url
				data : $('#form2').serialize(),
				success : function(result) {
					console.log(result);//打印服务端返回的数据(调试用)

					if (result.code == 0) {
						alert("編輯成功");
						$("#myModal .close").click()
						loadingData();
					}
					;
				},
				error : function() {
					alert("异常！");
				}
			});
		}

		window.onload = function() {
			loadingData();
		}

		function loadingData() {
			$("#trhead").empty();

			var user = {
				"email" : "123456",
				"industry" : 1,
				"corporation" : "hust"
			};
			$
					.ajax({
						type : "POST",
						url : "/mitakeProject/FindUserList",
						dataType : "json",
						contentType : "application/json",
						data : JSON.stringify(user),
						success : function(data) {
							var id = data[0].ID;
							var created = data[0].CREATE_DATE;
							console.log(created + ":" + id);
							// 	            	 TOTAL_ASK_CONTRACT
							// 	            	 TOTAL_ASK_SIZE
							// 	            	 TOTAL_BID_CONTRACT
							// 	            	 TOTAL_BID_SIZE

							for (var i = 0; i < data.length; i++) {
								var str = "";
								var obj = JSON.parse(data[i]);
								var userPhone = obj.UserPhone; //客戶手機
								var customerNumber = obj.customerNumber; //客戶號碼
								var userName = obj.userName; // 客戶名稱
								userName = unicodeToChar(userName);
								var createTime = obj.createTime;
								var address = obj.address; //會員居住地址
								address = unicodeToChar(address);
								var custEmail = obj.custEmail; //會員居住地址
								var customerBenefitExpires = obj.customerBenefitExpires;
								// 								var userID = obj[i].userID; 
								var isMemberValid = obj.isMemberValid;

								if (isMemberValid == "N") {
									str += "<tr  bgcolor='#FFC8B4'>";
								} else {
									str += "<tr>";
								}
								str += "<td >" + i + "</td>";
								str += "<td>" + customerNumber + "</td>"
								str += "<td id='"+customerNumber+"Name'>"
										+ userName + "</td>"
								str += "<td id='"+customerNumber+"Phone'>"
										+ userPhone + "</td>"
								str += "<td id='"+customerNumber+"Email'>"
										+ custEmail + "</td>"
								str += "<td id='"+customerNumber+"address'>"+ address + "</td>"
								str += "<td>" + createTime + "</td>"
								str += "<td id='"+customerNumber+"customerBenefitExpires'>" + customerBenefitExpires
										+ "</td>"
								str += "<td> <a href=''#editmember' role='button'  data-toggle='modal' data-target='#editmember'  id='"
										+ customerNumber
										+ "' onclick='editCustMember("
										+ customerNumber
										+ ")'><i class='icon-pencil' ></i></a>"
								str += "<a href=''#' role='button'   data-toggle='modal' data-target='#delectMember'"
								str += "onclick='editAddress("
								str += "/" + customerNumber + "/"
								str += ")'"
								str += "><i class='icon-remove'></i></a></td> </tr>"

								$('#trhead').append(str);
							}
						},
						error : function(err) {
							alert('AJAX獲取數據失敗' + err);
						}
					});

			// 			$('#trhead').append(str);
		}

		function unicodeToChar(text) {
			return text.replace(/\\u[\dA-F]{4}/gi, function(match) {
				return String.fromCharCode(parseInt(match.replace(/\\u/g, ''),
						16));
			});
		}
	</script>



	<script type="text/javascript">
		$(".form_datetime").datetimepicker({
			format : "dd-MM-yyyy hh:ii",
			autoclose : true,
			todayBtn : true,
			startDate : "02-14-2019 10:00",
			minuteStep : 10
		});

		function editAddress(id, obj) {
			var str = id.toString();
			str = str.substring(0, str.length - 1); //1234567
			str = str.substring(1, str.length);
			var t = $("#" + str + "").prev().html();//结果是：2
			console.log(t);
			$("#hiddenVal").val(str);
			$("#delectNumber").text("您確定要刪除這個帳號嗎? :" + str);
		}

		function delectMemberInformation() {
			var getValue = $("#hiddenVal").val();

			var user = {
				"userNumber" : getValue,
				"cdoe" : "0",
				"message" : "delectnumber"
			};

			$.ajax({
				//几个参数需要注意一下
				type : "POST",//方法类型
				dataType : "json",//预期服务器返回的数据类型
				url : "/mitakeProject/delectUser",//url
				data : JSON.stringify(user),
				success : function(result) {
					console.log(result);//打印服务端返回的数据(调试用)

					if (result.code == 0) {
						alert("刪除成功");
						$("#delectMember .close").click()
						loadingData();
					}
					;
				},
				error : function() {
					alert("异常！");
				}
			});

		}

		// 		  $('#editmember').on('show.bs.modal', function (event,row) {
		// 		        var getIdFromRow = $(event.relatedTarget);
		// 		        var td = $(e.target).closest('td');
		// 		     	alert('15');

		// 		    });

		function editCustMember(obj) {

	
			var objName = obj.id + "Name";
			var objPhone = obj.id + "Phone";
			var objEmail = obj.id + "Email";
			var objaddress = obj.id + "address";
			var objcustomerBenefitExpires = obj.id + "customerBenefitExpires";
			objName = $("#" + objName + "").text();
			objPhone = $("#" + objPhone + "").text();
			objEmail = $("#" + objEmail + "").text();
			objaddress = $("#" + objaddress + "").text();
			objcustomerBenefitExpires = $("#" + objcustomerBenefitExpires + "").text();
		
			$("#edditName").val(objName);
			$("#edditPhone").val(objPhone);
			$("#edditEmail").val(objEmail); 	
			$('#edditaddress').val(objaddress);			
			$("#hiddenVal").val(obj.id);
// 			$('#editMemberDataTime').val("31-July-2020 06:20");

		}
		
		
		function coveDataTimer (datatimer){
			
 			}
	</script>

</body>
</html>