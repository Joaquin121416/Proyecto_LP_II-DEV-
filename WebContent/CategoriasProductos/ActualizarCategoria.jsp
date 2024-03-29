<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
									<strong>Actualizar Categoria</strong>
								</div>
								<form action="/LP_2_Sistema_Venta_3.0/CategoriaServlet"
									enctype="multipart/form-data">
									<div class="card-body card-block">
				
										<class="form-horizontal">
										<div class="row form-group">
											<div class="col col-md-3">
											
												<label class=" form-control-label">Codigo :</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="disabled-input" name="cod"
													 class="form-control" readonly="true" value="${cod}">
												 
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Nombre
													: </label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="nom"
													 class="form-control" value="${nom}">
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="textarea-input" class=" form-control-label">Descripcion
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<textarea name="des" id="textarea-input" rows="9"
													 class="form-control" >${des}</textarea>
												
											</div>
										</div>
									</div>
									<div class="card-footer">
										<button class="btn btn-primary btn-sm" name="opc" value="act2">
											<i class="fa fa-dot-circle-o"></i> Actualizar
										</button>
										<button type="reset" class="btn btn-danger btn-sm">
											<i class="fa fa-ban"></i> Cancelar
										</button>
										<br>
										<br>
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