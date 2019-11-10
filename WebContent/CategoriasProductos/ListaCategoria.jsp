<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="LibTag" prefix="tag"%>
<%@page import="java.util.List"%>
<%@page import="com.sistema.comidas.bean.CategoriaProducto"%>
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
									<strong>Lista Categoria</strong>
								</div>
								<form action="/LP_2_Sistema_Venta_3.0/CategoriaServlet"
									enctype="multipart/form-data">
									<div class="card-body">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">Codigo</th>
													<th scope="col">Nombre</th>
													<th scope="col">Descripcion</th>

												</tr>
											</thead>
											<tbody>
												<%
													List<CategoriaProducto> data = (List<CategoriaProducto>) request.getAttribute("lista");
													if (data != null) {
														for (CategoriaProducto c : data) {
												%>
												<tr>
													<td><%=c.getCat_pro_id()%></td>
													<td><%=c.getCat_pro_nom()%></td>
													<td><%=c.getCat_pro_des()%></td>

												</tr>
												<%
													}
													}
												%>
											</tbody>
										</table>
									</div>

									<div class="card-footer">
										<button class="btn btn-primary btn-sm" name="opc" value="lis">
											<i class="fa fa-dot-circle-o"></i> Listar
										</button>
										<button type="reset" class="btn btn-danger btn-sm">
											<i class="fa fa-ban"></i> Cancelar
										</button>
										<br> <br>
										<p>
											<%
												Object mensaje = pageContext.findAttribute("mensaje");
												if (mensaje != null) {
													out.print(mensaje.toString());

												}
											%>
										</p>
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