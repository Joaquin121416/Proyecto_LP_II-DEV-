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
									<strong>Agregar Usuario</strong>
								</div>
								<form action="/LP_2_Sistema_Venta_3.0/UsuarioServlet"
									enctype="application/x-www-form-urlencoded"
									class="form-horizontal">
									<div class="card-body card-block">

										<div class="row form-group">
											<div class="col col-md-3">
												<label class=" form-control-label">Codigo :</label>
											</div>
											<div class="col-12 col-md-9">
												<tag:tagCodigos tabla="TB_USUARIO" campo="USU_ID"></tag:tagCodigos>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label" >Nombre
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="nom"
													placeholder="obligatorio" class="form-control" value="${nom }">
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label" >Apellido
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="ape"
													placeholder="obligatorio" class="form-control" value="${ape }">
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="selectSm" class=" form-control-label">Tipo
													de Documento :</label>
											</div>
											<div class="col-12 col-md-9">
												<tag:tagDocumentos></tag:tagDocumentos>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Documento
													de identidad :</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="doc"
													placeholder="obligatorio" class="form-control" value="${docIde }">
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="selectSm" class=" form-control-label">Rol
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<tag:tagRoles></tag:tagRoles>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="file-input" class=" form-control-label">Elige
													Imagen :</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="file" id="file-input" name="img"  value="Upload"
													class="form-control-file"  formenctype="application/x-www-form-urlencoded">
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="email-input" class=" form-control-label" >Usuario
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="email-input" name="usu"
													placeholder="obligatorio" class="form-control" value="${usu }">
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="password-input" class=" form-control-label">Contraseña
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="password" id="password-input" name="pwd"
													placeholder="obligatorio" class="form-control">
											</div>
										</div>
									</div>
									<div class="card-footer">
										<button class="btn btn-primary btn-sm"
											name="opc" value="agr">
											<i class="fa fa-dot-circle-o"></i> Agregar
										</button>
										<button type="reset" class="btn btn-danger btn-sm">
											<i class="fa fa-ban"></i> Cancelar
										</button>

										<br>
										<p>${mensaje}</p>
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
					<div class="col-sm-6 text-right">DiseÃ±ado por Jesus Crais</div>
				</div>
			</div>
		</footer>
		<!-- /.site-footer -->
	</div>
	<!-- /#right-panel -->