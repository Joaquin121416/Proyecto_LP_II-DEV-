$(function() {
	/*FILTROS DE LOS PRODUCTOS*/
	$('.filter').click(function(){
		$(this).addClass('active').siblings().removeClass('active'); /*al hacer click en un elemento, le agrega la clase activo y elimina la clase activo de sus hermanos*/
		let valor = $(this).attr('data-nombre'); //obtiene el valor de el data-nombre
		if(valor == 'todos'){
			$('.cont-prod').show('1000');
		}else{
			$('.cont-prod').not('.'+valor).hide('1000');
			$('.cont-prod').filter('.'+valor).show('1000');
		}
	});

	let promos = $('#promos').offset().top,
		servicios = $('#servicio').offset().top,
		clientes = $('#clientes').offset().top,
		contactos = $('#contactos').offset().top;

	window.addEventListener('resize', function(){
		let promos = $('#promos').offset().top,
		servicios = $('#servicio').offset().top,
		clientes = $('#clientes').offset().top,
		contactos = $('#contactos').offset().top;
	});
	$("#testimonial-slider").owlCarousel({
        items:3,
        itemsDesktop:[1000,3],
        itemsDesktopSmall:[979,2],
        itemsTablet:[768,2],
        itemsMobile:[650,1],
        pagination:true,
        autoPlay:true
    });
	/*evento en los Enalces*/
	$('#enlace-inicio').on('click', function(e){
		e.preventDefault();
		$('html,body').animate({
			scrollTop:0
		},600);
	});

	$('#enlace-promociones').on('click', function(e){
		e.preventDefault();
		$('html,body').animate({
			scrollTop:promos-100
		},600);
	});

	$('#enlace-servicios').on('click', function(e){
		e.preventDefault();
		$('html,body').animate({
			scrollTop:servicios+490
		},600);
	});

	$('#enlace-clientes').on('click', function(e){
		e.preventDefault();
		$('html,body').animate({
			scrollTop:clientes+490
		},600);
	});

	$('#enlace-clientes2').on('click', function(e){
		e.preventDefault();
		$('html,body').animate({
			scrollTop:clientes+490
		},600);
	});

	$('#enlace-contactos').on('click', function(e){
		e.preventDefault();
		$('html,body').animate({
			scrollTop:contactos+490
		},600);
	});

	/*POPOVER*/
	
 	$('[data-toggle="popover"]').popover();
 	$('.example-popover').popover({
    	container: 'body'
  	});


});