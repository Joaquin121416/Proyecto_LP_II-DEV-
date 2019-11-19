package com.sistema.comidas.tags;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class ModalTag extends TagSupport {
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();

		try {
			out.println("			<div class='modal fade' id='exampleModalScrollable' tabindex='-1' role='dialog' aria-labelledby='exampleModalScrollableTitle' aria-hidden='true'>\r\n" + 
					"			  <div class='modal-dialog modal-dialog-scrollable modal-lg' role='document'>\r\n" + 
					"			    <div class='modal-content'>\r\n" + 
					"			      <div class='modal-header'>\r\n" + 
					"			        <h5 class='modal-title' id='exampleModalScrollableTitle'><span id='#ClienteNom'>Fasty</span> - Nuestra Carta</h5>\r\n" + 
					"			        <div class='pestañas'>\r\n" + 
					"			        	<ul class='nav nav-tabs' id='myTab' role='tablist'>\r\n" + 
					"					 	 	<li class='nav-item'>\r\n" + 
					"					    	<a class='nav-link active' id='carta-tab' data-toggle='tab' href='#carta' role='tab' aria-controls='carta' aria-selected='true'>Carta</a>\r\n" + 
					"						 	</li>\r\n" + 
					"					 		<li class='nav-item'>\r\n" + 
					"					   		<a class='nav-link' id='pedido-tab' data-toggle='tab' href='#pedido' role='tab' aria-controls='pedido' aria-selected='false'>Pedido</a>\r\n" + 
					"				  			</li>\r\n" + 
					"				  			<li class='nav-item'>\r\n" + 
					"					   		<a class='nav-link' id='carrito-tab' data-toggle='tab' href='#carrito' role='tab' aria-controls='carrito' aria-selected='false'>Carrito</a>\r\n" + 
					"				  			</li>\r\n" + 
					"						</ul>\r\n" + 
					"			        </div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"			        <button type='button' class='close' data-dismiss='modal' aria-label='Close'>\r\n" + 
					"			          <span aria-hidden='true'>&times;</span>\r\n" + 
					"			        </button>\r\n" + 
					"			      </div>\r\n" + 
					"\r\n" + 
					"			    <div class='modal-body'>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"				<div class='tab-content' id='myTabContent'>\r\n" + 
					"				  <div class='tab-pane fade show active' id='carta' role='tabpanel' aria-labelledby='carta-tab'>\r\n" + 
					"\r\n" + 
					"			      	<div class='banner-modal'>\r\n" + 
					"			      		<img src='img/clientes-img/pizza.jpg' style='height: 300px'>\r\n" + 
					"			      	</div>\r\n" + 
					"			      	<div class='contenedor-box'>\r\n" + 
					"			      		<!--	GRID PROMOCIONES -->\r\n" + 
					"							<div class='contenido-prod'>\r\n" + 
					"			      			<br>\r\n" + 
					"			      			<div class='container'>\r\n" + 
					"			      				<h4 class='cabecera-h4'>PROMOCIONES</h4>\r\n" + 
					"								  <div class='row justify-content-around'>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 '>\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto.</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								       <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								   </div>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 justify-content-around'>\r\n" + 
					"								    	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								      <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								    </div>\r\n" + 
					"\r\n" + 
					"								  </div>\r\n" + 
					"								</div>\r\n" + 
					"			      		</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"			      		<!--	GRID LASAÑAS -->\r\n" + 
					"							<div class='contenido-prod'>\r\n" + 
					"			      			<br>\r\n" + 
					"			      			<div class='container'>\r\n" + 
					"			      				<h4 class='cabecera-h4'>LASAÑAS</h4>\r\n" + 
					"								  <div class='row justify-content-around'>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 '>\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src=img/modal-cli-img/pizzeria/pizza.jpg>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto.</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src=img/modal-cli-img/pizzeria/pizza.jpg>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								       <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src=img/modal-cli-img/pizzeria/pizza.jpg>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								   </div>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 justify-content-around'>\r\n" + 
					"								    	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src=img/modal-cli-img/pizzeria/pizza.jpg>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								      <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src=img/modal-cli-img/pizzeria/pizza.jpg>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src=img/modal-cli-img/pizzeria/pizza.jpg>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								    </div>\r\n" + 
					"\r\n" + 
					"								  </div>\r\n" + 
					"								</div>\r\n" + 
					"			      		</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"			      	<!--	GRID WRAPS -->\r\n" + 
					"							<div class='contenido-prod'>\r\n" + 
					"			      			<br>\r\n" + 
					"			      			<div class='container'>\r\n" + 
					"			      				<h4 class='cabecera-h4'>PIZZAS</h4>\r\n" + 
					"								  <div class='row justify-content-around'>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 '>\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto.</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								       <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								   </div>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 justify-content-around'>\r\n" + 
					"								    	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								      <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								    </div>\r\n" + 
					"\r\n" + 
					"								  </div>\r\n" + 
					"								</div>\r\n" + 
					"			      		</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"			      		<!--	GRID JUGOS -->\r\n" + 
					"							<div class='contenido-prod'>\r\n" + 
					"			      			<br>\r\n" + 
					"			      			<div class='container'>\r\n" + 
					"			      				<h4 class='cabecera-h4'>ESPECIALES</h4>\r\n" + 
					"								  <div class='row justify-content-around'>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 '>\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto.</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								       <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								   </div>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 justify-content-around'>\r\n" + 
					"								    	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								      <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								    </div>\r\n" + 
					"\r\n" + 
					"								  </div>\r\n" + 
					"								</div>\r\n" + 
					"			      		</div>\r\n" + 
					"\r\n" + 
					"			      		<!--	GRID BEBIDAS -->\r\n" + 
					"							<div class='contenido-prod'>\r\n" + 
					"			      			<br>\r\n" + 
					"			      			<div class='container'>\r\n" + 
					"			      				<h4 class='cabecera-h4'>BEBIDAS</h4>\r\n" + 
					"								  <div class='row justify-content-around'>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 '>\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto.</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								       <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								   </div>\r\n" + 
					"\r\n" + 
					"								    <div class='col-sm-5 justify-content-around'>\r\n" + 
					"								    	<div class='row' >\r\n" + 
					"\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								      <div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"\r\n" + 
					"								     	<div class='row' >\r\n" + 
					"								     		<div class='col-sm-12' >\r\n" + 
					"								     			<div class='venta-box'>\r\n" + 
					"			      										<div class='row row-content'>\r\n" + 
					"			      											<div class='img-ven'>\r\n" + 
					"			      												<img src='img/modal-cli-img/pizzeria/pizza.jpg'>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-descripcion'>\r\n" + 
					"			      												<b>Nombre del producto</b>\r\n" + 
					"			      												<p>Descripcion del producto</p>\r\n" + 
					"			      											</div>\r\n" + 
					"			      											<div class='item-precio'>\r\n" + 
					"			      												<b class='precios'>99.00</b>\r\n" + 
					"			      											</div>\r\n" + 
					"			      										</div>\r\n" + 
					"			      								</div>\r\n" + 
					"								     		</div>	\r\n" + 
					"\r\n" + 
					"								     	</div>\r\n" + 
					"								    </div>\r\n" + 
					"\r\n" + 
					"								  </div>\r\n" + 
					"								</div>\r\n" + 
					"			      		</div>\r\n" + 
					"\r\n" + 
					"			      </div>\r\n" + 
					"\r\n" + 
					"				  </div>\r\n" + 
					"				  <!--PESTAÑA DEL PEDIDO-->\r\n" + 
					"				  <div class='tab-pane fade' id='pedido' role='tabpanel' aria-labelledby='pedido-tab'>\r\n" + 
					"				  		<!--GENERADO SEGUN EL PRODUCTO-->\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"				  </div>\r\n" + 
					"				  <!--PESTAÑA DEL CARRITO-->\r\n" + 
					"				  <div class='tab-pane fade' id='carrito' role='tabpanel' aria-labelledby='carrito-tab'>\r\n" + 
					"				  		\r\n" + 
					"				  </div>\r\n" + 
					"				</div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"			      <div class='modal-footer'>\r\n" + 
					"			        <button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>\r\n" + 
					"			      </div>\r\n" + 
					"			    </div>\r\n" + 
					"			  </div>\r\n" + 
					"			</div>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
