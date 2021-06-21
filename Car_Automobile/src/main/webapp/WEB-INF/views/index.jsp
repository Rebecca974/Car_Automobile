<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/index.css">
<meta charset="ISO-8859-1">
<title>Cars Selection</title>

	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta content="" name="descriptions">
    <meta content="" name="keywords">
    <link rel="stylesheet" type="text/css" href="style2.css">
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" >

    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.css"> 
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css">
	</head>
<body>
<section class="header" id="header">
	<div class="nav-bar">
		<div class="logo">
			<a href="#">Toyota<span>.</span></a>
			</div>
			<div class ="menu">
				<ul>
					<li><a href="product-input-form/" class="active">Cars</a></li>
					<a href="customer/">Customer Information</a>
					<li><a href="car/">Car Information</a></li>
<!-- 					<li><a href="payment/paymentform">Payment Information</a></li> -->
					<li><a href="sales/">Sales Information</a></li>
					
                </ul>
			</div>
		<div class="social-media">
			<ul>
			<li><a href="#"><i class="fa fa-facebook"></i></a></li>
			<li><a href="#"><i class="fa fa-twitter" ></i></a></li>
			<li><a href="#"><i class="fa fa-instagram" ></i></a></li>		
		</ul>
		<b><a href="logout">Log out</a></b>
		</div>
	</div>

	<div class="hero">
		<div class="row">
			<div class="left-sec">
				<div class="content">
					<h2><span>Toyota</span><br>camaro</h2>
					<p>it is a long established fact that a set reader will distracted by the readable comment
					of a page when looking at its layout technology</p>
				</div>
				<button class ="discover-btn">
					<a href="#">discover</a><span><i class="fa fa-arrow-circle-o-right"></i></span>
				</button>
				<div class="information">
					<div class="production">
						<p>production</p>
						<h2>1966-2021</h2>
					</div>
					<div class="production">
						<p>Designer</p>
						<h2>George Angersbach</h2>
					</div>
				</div>
			</div>
			<div class="right-sec">
				<div class="my-car">
				<div><img src="resources/imgs/cars1.jpg"></div>	
				<div><img src="resources/imgs/cars2.jpg"></div>
				<div><img src="resources/imgs/cars3.jpg"></div>
				<div><img src="resources/imgs/cars4.jpg"></div>
				<div><img src="resources/imgs/cars5.jpg"></div>
				<div><img src="resources/imgs/cars6.jpg"></div>
				<div><img src="resources/imgs/cars7.jpg"></div>
				<div><img src="resources/imgs/cars8.jpg"></div>
				<div><img src="resources/imgs/cars9.jpg"></div>
				<div><img src="resources/imgs/cars10.jpg"></div>
				<div><img src="resources/imgs/cars11.jpg"></div>
				<div><img src="resources/imgs/cars12.jpg"></div>
				<div><img src="resources/imgs/cars13.jpg"></div>
				<div><img src="resources/imgs/cars14.jpg"></div>
				<div><img src="resources/imgs/cars15.jpg"></div>
				<div><img src="resources/imgs/cars16.jpg"></div>
				<div><img src="resources/imgs/cars17.jpg"></div>
				<div><img src="resources/imgs/cars18.jpg"></div>
				<div><img src="resources/imgs/cars19.jpg"></div>
				<div><img src="resources/imgs/cars20.jpg"></div>
				<div><img src="resources/imgs/cars21.jpg"></div>
				<div><img src="resources/imgs/cars22.jpg"></div>
				<div><img src="resources/imgs/cars23.jpg"></div>
				<div><img src="resources/imgs/cars24.jpg"></div>
				<div><img src="resources/imgs/cars25.jpg"></div>
				<div><img src="resources/imgs/cars26.jpg"></div>
				<div><img src="resources/imgs/cars27.jpg"></div>
				<div><img src="resources/imgs/cars28.jpg"></div>
			</div>
			</div>
		</div>
	</div>

</section>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script  src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.js"></script>
<script type="text/javascript">
	
$(document).ready(function(){
	$(".my-car").slick({
		autoplay: true,
		dots: true,
		speed:1000,
		customPaging : function(slider, i){
			var thumb = $ (slider.$slides[i]).data();

			return '<a>'+(i+1)+ '</a>';
		},
	})
});

</script>
</body>
</html>