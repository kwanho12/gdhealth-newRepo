<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>물품 관리</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!------------------- favicon start ------------------>
<link type="image/png" sizes="32x32" rel="icon" href="/admin/workoutFavicon.png">
<!------------------- favicon end -------------------->

<!-- Google Fonts
		============================================ -->
<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/bootstrap.min.css">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/font-awesome.min.css">
<!-- owl.carousel CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/owl.carousel.css">
<link rel="stylesheet" href="/admin/css/owl.theme.css">
<link rel="stylesheet" href="/admin/css/owl.transitions.css">
<!-- animate CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/animate.css">
<!-- normalize CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/normalize.css">
<!-- meanmenu icon CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/meanmenu.min.css">
<!-- main CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/main.css">
<!-- educate icon CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/educate-custon-icon.css">
<!-- morrisjs CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/morrisjs/morris.css">
<!-- mCustomScrollbar CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- metisMenu CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/metisMenu/metisMenu.min.css">
<link rel="stylesheet" href="/admin/css/metisMenu/metisMenu-vertical.css">
<!-- calendar CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/calendar/fullcalendar.min.css">
<link rel="stylesheet" href="/admin/css/calendar/fullcalendar.print.min.css">
<!-- style CSS
		============================================ -->
<link rel="stylesheet" href="/admin/style.css">
<!-- responsive CSS
		============================================ -->
<link rel="stylesheet" href="/admin/css/responsive.css">
<!-- modernizr JS
		============================================ -->
<script src="/admin/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>

	<!---------------------- 사이드바 start --------------------->
	<c:import url="/WEB-INF/view/headoffice/include/sideBar.jsp"></c:import>
	<!---------------------- 사이드바 end ----------------------->

	<!-- Start Welcome area -->
	<div class="all-content-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<h1 style="color: #2E64FE; margin-top: 20px;">본사 페이지</h1>
				</div>
			</div>
		</div>
		<div class="header-advance-area">

			<!---------------------- 상단바 start --------------------->
			<c:import url="/WEB-INF/view/headoffice/include/topBar.jsp"></c:import>
			<!---------------------- 상단바 end ----------------------->

			<!-- 검색창 start -->
			<div class="breadcome-area">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="breadcome-list">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="breadcome-menu">
											<table style="margin-top: 8px;">
												<tr>
													<td>
														<select name="type" class="form-control" style="width: 120px; margin-right: 5px;" id="type">
															<option value="search">검색</option>
															<option value="name">이름</option>
															<option value="note">비고</option>
															<option value="writer">작성자</option>
															<option value="isActive">활성화 여부</option>
														</select>
													</td>
													<td id="plus1"></td>
													<td id="plus2"></td>
												</tr>
											</table>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 검색창 end -->

		<!--------------------- start equipmentList, pagination -------------------------->
		<div class="contacts-area mg-b-15" id="fragment"></div>
		<!--------------------- end equipmentList, pagination-------------------------->

	</div>

	<!-- jquery
		============================================ -->
	<script src="/admin/js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script src="/admin/js/bootstrap.min.js"></script>
	<!-- wow JS
		============================================ -->
	<script src="/admin/js/wow.min.js"></script>
	<!-- price-slider JS
		============================================ -->
	<script src="/admin/js/jquery-price-slider.js"></script>
	<!-- meanmenu JS
		============================================ -->
	<script src="/admin/js/jquery.meanmenu.js"></script>
	<!-- owl.carousel JS
		============================================ -->
	<script src="/admin/js/owl.carousel.min.js"></script>
	<!-- sticky JS
		============================================ -->
	<script src="/admin/js/jquery.sticky.js"></script>
	<!-- scrollUp JS
		============================================ -->
	<script src="/admin/js/jquery.scrollUp.min.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script src="/admin/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="/admin/js/scrollbar/mCustomScrollbar-active.js"></script>
	<!-- metisMenu JS
		============================================ -->
	<script src="/admin/js/metisMenu/metisMenu.min.js"></script>
	<script src="/admin/js/metisMenu/metisMenu-active.js"></script>
	<!-- morrisjs JS
		============================================ -->
	<script src="/admin/js/sparkline/jquery.sparkline.min.js"></script>
	<script src="/admin/js/sparkline/jquery.charts-sparkline.js"></script>
	<!-- calendar JS
		============================================ -->
	<script src="/admin/js/calendar/moment.min.js"></script>
	<script src="/admin/js/calendar/fullcalendar.min.js"></script>
	<script src="/admin/js/calendar/fullcalendar-active.js"></script>
	<!-- maskedinput JS
		============================================ -->
	<script src="/admin/js/jquery.maskedinput.min.js"></script>
	<script src="/admin/js/masking-active.js"></script>
	<!-- datepicker JS
		============================================ -->
	<script src="/admin/js/datepicker/jquery-ui.min.js"></script>
	<script src="/admin/js/datepicker/datepicker-active.js"></script>
	<!-- form validate JS
		============================================ -->
	<script src="/admin/js/form-validation/jquery.form.min.js"></script>
	<script src="/admin/js/form-validation/jquery.validate.min.js"></script>
	<script src="/admin/js/form-validation/form-active.js"></script>
	<!-- tab JS
		============================================ -->
	<script src="/admin/js/tab.js"></script>
	<!-- plugins JS
		============================================ -->
	<script src="/admin/js/plugins.js"></script>
	<!-- main JS
		============================================ -->
	<script src="/admin/js/main.js"></script>

</body>
<script>
	
	// 초기 화면
	pagination(1);
	
	function pagination(pageNum) {
		
		$.ajax({
			url : '${pageContext.request.contextPath}/headoffice/equipment/pagination',
			method : 'get',
			data : {
				pageNum : pageNum
			},
			success : function(result){
				$('#fragment').html(result);
			}			
		});
		
	}
	
	function searchPagination(pageNum, type, keyword) {
		
		$.ajax({
			url : '${pageContext.request.contextPath}/headoffice/equipment/searchPagination',
			method : 'get',
			data : {
				pageNum : pageNum,
				type : type,
				keyword : keyword
			},
			success : function(result){
				$('#fragment').html(result);
			}			
		});
		
	}
	
	//select 태그의 value를 change할 때
	$('#type').change(function(){
		
		if($(this).val() == 'isActive') {
			
			let selectHtml = `
				<select name="keyword" class="form-control" style="width:120px;" id="keyword">
					<option value="">선택</option>
					<option value="Y">활성화</option>
					<option value="N">비활성화</option>
				</select> 
			`;
			
			$('#plus1').html(selectHtml);
			$('#plus2').html('<button style="margin-left:10px; width:50px;" type="button" class="btn" id="searchBtn">검색</button>');
			
		} else if($(this).val() == 'search') {
			$('#plus1').html('');
			$('#plus2').html('');
		} else {
			$('#plus1').html('<input type="text" name="keyword" id="keyword" placeholder="검색어 입력" class="form-control" style="width:170px;">');
			$('#plus2').html('<button style="margin-left:10px; width:50px;" type="button" class="btn" id="searchBtn">검색</button>');
		}
			
	});
	
	// 동적으로 추가된 요소에 대해 이벤트 처리
	// 검색
	$(document).on('click', '#searchBtn', function(e){
		
		e.preventDefault();
		let type = $('#type').val();
		let keyword = $('#keyword').val();
		
		if(type == 'active') {
			
			if(keyword == '') {
				alert('active를 선택하세요.');
				$('#keyword').focus();
				return;
			}
			
		} else if(type == 'gender') {
			
			if(keyword == '') {
				alert('성별을 선택하세요.');
				$('#keyword').focus();
				return;
			}
			
		} else {
		
			if(keyword.trim() == '') {
				alert('검색할 내용을 입력하세요.');
				$('#keyword').focus();
				return;
			}
			
		}
		
		searchPagination(1,type,keyword);
		
	});
	
	// 동적으로 추가된 요소에 대해 이벤트 처리
	// 페이지네이션
	$(document).on('click', '.pageBtn', function(e){
		e.preventDefault();
		let pageNum = $(this).data('page');
		
		pagination(pageNum);
		
	});
	
	// 동적으로 추가된 요소에 대해 이벤트 처리
	// search 후 페이지네이션
	$(document).on('click', '.searchPageBtn', function(e){
		e.preventDefault();
		let pageNum = $(this).data('page');
		let type = $(this).data('type');
		let keyword = $(this).data('keyword');
		
		searchPagination(pageNum,type,keyword);
		
	});
	
	$(document).on('click', '.deactivateBtn', function(){
		
		let deactivateBtn = $(this);
		let equipmentNo = deactivateBtn.data('equipmentno');
		
		$.ajax({
			url : '${pageContext.request.contextPath}/headoffice/equipment/deactivate',
			method : 'post',
			data : {
				equipmentNo : equipmentNo
			},
			success : function(result){
				
				if(result == 1) {
					deactivateBtn.text('비활성화');
					deactivateBtn.removeClass('deactivateBtn').addClass('activateBtn'); // 클래스 변경
					return;
				}
			}			
		});	
		
	});
	
	$(document).on('click', '.activateBtn', function(){
		
		let activateBtn = $(this);
		let equipmentNo = activateBtn.data('equipmentno');
		
		$.ajax({
			url : '${pageContext.request.contextPath}/headoffice/equipment/activate',
			method : 'post',
			data : {
				equipmentNo : equipmentNo
			},
			success : function(result){
				
				if(result == 1) {
					activateBtn.text('활성화');
					activateBtn.removeClass('activateBtn').addClass('deactivateBtn'); // 클래스 변경
					return;
				}
			}			
		});
		
	})

</script>
</html>