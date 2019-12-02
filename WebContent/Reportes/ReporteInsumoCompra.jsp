<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="LibTag" prefix="tag"%>
<%@page import="java.util.List"%>
<%@page import="com.sistema.comidas.bean.CategoriaProductoBean"%>
<%@page import="com.sistema.comidas.util.Wrapper"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="LibTag" prefix="tag"%>
<div id="right-panel" class="right-panel">

	<jsp:include page="/Cabecera.jsp" />
	<!-- Content -->
	<div class="content">
		<div class="animated fadeIn">

			<div class="content">
				<div class="animated fadeIn">


					<div class="row">
						<!--/.col-->


						<div class="col-lg-12">

							<div class="card">
								<div class="card-header">
									<strong>Realizar Reporte de Ventas</strong>
								</div>
								<form action="/LP_2_Sistema_Venta_3.0/ReporteServlet"
									enctype="multipart/form-data">
									<div class="card-body">

										<div class="col-lg-12 col-md-12">
											<div class="card">
												<div class="card-body">
													<div class="stat-widget-five">
														<div class="stat-icon dib flat-color-1">
															<i class="pe-7s-cash"></i>
														</div>
														<div class="stat-content">
															<div class="text-left dib">
																<div class="stat-text">${ventas}</div>
																<div class="stat-heading">Compras</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-12 col-md-12">
											<div class="card">
												<div class="card-body">
													<div class="stat-widget-five">
														<div class="stat-icon dib flat-color-2">
															<i class="pe-7s-cart"></i>
														</div>
														<div class="stat-content">
															<div class="text-left dib">
																<div class="stat-text">
																	${cantidad}
																</div>
																<div class="stat-heading">Cantidad de Compras</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>


									</div>

									<br>
									<p>${mensaje}</p>
									<br>
									<div class="card-footer">
										<button class="btn btn-primary btn-sm" name="opc" value="lis">
											<i class="fa fa-dot-circle-o"></i> Reportar
										</button>

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