//variables

let nav = document.getElementById('nav');
let menu = document.getElementById('enlaces');
let abrir = document.getElementById('open');
let botones = document.getElementById('btn-nav');
let cerrado = true;

//funciones

/*MENU DE NAVEGACION*/
function menus() {
	let desplazamiento_actual = window.pageYOffset; /*muestra cuantos pixeles hacia abajo hiciste con el scroll*/
	if(desplazamiento_actual>=250){
		nav.classList.remove('nav1'); /*elimina la clase ingresada como parametro al elemento nav*/
		nav.className = ('nav2'); /*agrega la clase nav2 al elemento nav*/
		nav.style.transition = '0.4s';
		menu.style.top = '100px'; /*aumenta el tamaño a 100px el elemento menu*/
		abrir.style.color = '#000'; /*cambia el color del texto al elemento abrir*/
	}else{
		nav.classList.remove('nav2');
		nav.className = ('nav1');
		nav.style.transition = '0.4s';
		menu.style.top = '90px';
		abrir.style.color = '#fff';
	}
}
function apertura(){
	if(cerrado){
		menu.style.width = '70vw';
		cerrado = false;
	}else{
		menu.style.width = '0%';
		menu.style.overflow = 'hidden';
		cerrado = true;
	}
}

window.addEventListener('scroll',function(){
	menus();
});

abrir.addEventListener('click', function(){
	apertura();
});
window.addEventListener('resize',function(){
	if (screen.width>=700) {
		cerrado=true;
		menu.style.removeProperty('overflow');
		menu.style.removeProperty('width');
	}
});
window.addEventListener('click',function(e){
	if(cerrado==false){
		let span = document.querySelector('span');
		if(e.target !== span && e.target !== abrir){
			menu.style.width='0%';
			menu.style.overflow='hidden';
			cerrado=true;
		}
	}
});




