<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="LibTag" prefix="tag"%>
<%@page import="java.util.List"%>
<%@page import="com.sistema.comidas.bean.CategoriaProductoBean"%>
<%@page import="com.sistema.comidas.util.Wrapper"  %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
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
									
									
									<display:table  clearStatus="" summary="" requestURI="/LP_2_Sistema_Venta_3.0/CategoriaServlet" class="table" name="${ lista }" pagesize="10" export="false" decorator="com.sistema.comidas.util.Wrapper">
										
										<display:column title="Codigo" property="cat_pro_id" ></display:column>
            							<display:column title="Nombre" property="cat_pro_nom"></display:column>
            							<display:column title="Descripcion" property="cat_pro_des"></display:column>
            							<display:column title="Actualizar" property="seleccionaCategoria"></display:column>
            							<display:column title="Eliminar" property="eliminaCategoria" ></display:column>
            							
									</display:table>
									
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