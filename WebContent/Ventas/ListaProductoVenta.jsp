<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="LibTag" prefix="tag"%>
<%@page import="java.util.List"%>
<%@page import="com.sistema.comidas.bean.CategoriaProductoBean"%>
<%@page import="com.sistema.comidas.util.Wrapper"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div id="right-panel" class="right-panel">
	<jsp:include page="/Cabecera.jsp" />
	<!-- Content -->
	<div class="content">
		<div class="animated fadeIn">

			<div class="content">
				<div class="animated fadeIn">


					<div class="row">
						<!--/.col-->


						<div class="col-lg-6">

							<div class="card">
								<div class="card-header">
									<strong>Realizar Venta de Productos</strong>
								</div>
								<form action="/LP_2_Sistema_Venta_3.0/VentaServlet"
									enctype="multipart/form-data">
									<div class="card-body">


										<display:table clearStatus="" summary=""
											requestURI="/LP_2_Sistema_Venta_3.0/VentaServlet"
											class="table" name="${ lista }" pagesize="10" export="false"
											decorator="com.sistema.comidas.wrapper.VentasWrapper">
											<display:column title="Codigo" property="PRO_ID"></display:column>
											<display:column title="Nombre" property="PRO_NOM"></display:column>
											<display:column title="Imagen" property="img"></display:column>
											<display:column title="Cantidad" property="cantidad"></display:column>
											<display:column title="Agregar" property="agregar"></display:column>
										</display:table>

									</div>

									<br>
									<p>${mensaje}</p>
									<br>
									<div class="card-footer">
										<button class="btn btn-primary btn-sm" name="opc" value="lis">
											<i class="fa fa-dot-circle-o"></i> Listar
										</button>

									</div>

								</form>
							</div>
						</div>
						<div class="col-lg-6">

							<div class="card">
								<div class="card-header">
									<strong>Carrito de Venta de Productos</strong>
								</div>
								<form action="/LP_2_Sistema_Venta_3.0/VentaServlet"
									enctype="multipart/form-data">
									<div class="card-body">


										<display:table clearStatus="" summary=""
											requestURI="/LP_2_Sistema_Venta_3.0/VentaServlet"
											class="table" name="${ lista }" pagesize="10" export="false"
											decorator="com.sistema.comidas.wrapper.VentasWrapper">
											<display:column title="Codigo" property="PRO_ID"></display:column>
											<display:column title="Nombre" property="PRO_NOM"></display:column>
											<display:column title="Imagen" property="img"></display:column>
										</display:table>

									</div>

									<div class="col col-md-4">
										<label for="text-input" class=" form-control-label">Nro
											de Pedido :</label>
									</div>
									<div class="col-12 col-md-8">
										<p>${mensaje}</p>
									</div>
									<br>
									<div class="col col-md-4">
										<label for="text-input" class=" form-control-label">SubTotal
											:</label>
									</div>
									<div class="col-12 col-md-8">
										<p>${mensaje}</p>
									</div>
									<br>
									<div class="col col-md-4">
										<label for="text-input" class=" form-control-label">Total
											:</label>
									</div>
									<div class="col-12 col-md-8">
										<p>${mensaje}</p>
									</div>

									<div class="card-footer">
										<button class="btn btn-primary btn-sm" name="opc" value="lis">
											<i class="fa fa-dot-circle-o"></i> Listar
										</button>
										<button type="reset" class="btn btn-danger btn-sm">
											<i class="fa fa-ban"></i> Limpiar
										</button>
										<br> <br>
										<p></p>
									</div>

								</form>
							</div>
						</div>



					</div>
					<!-- .animated -->
				</div>


			</div>
			<!-- .animated -->
		</div>
		<!-- /.content -->
		<div class="clearfix"></div>
		<!-- Footer -->
		<footer class="site-footer">
			<div class="footer-inner bg-white">
				<div class="row">
					<div class="col-sm-6">Copyright &copy; 2019 Joaquin Cunorana</div>
					<div class="col-sm-6 text-right">Diseñado por Jesus Crais</div>
				</div>
			</div>
		</footer>
		<!-- /.site-footer -->
	</div>
	<!-- /#right-panel -->