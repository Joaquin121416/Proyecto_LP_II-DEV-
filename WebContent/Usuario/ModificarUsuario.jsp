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


                <div class="row"><!--/.col-->


                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <strong>Modificar Usuario</strong>
                            </div>
                           <form action="/LP_2_Sistema_Venta_3.0/UsuarioServlet"
									enctype="multipart/form-data"
									class="form-horizontal">
									<div class="card-body card-block">

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
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="nom"
													placeholder="obligatorio" class="form-control" value="${nom}" required>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Apellido
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="txtape"
													placeholder="obligatorio" class="form-control" value="${ape}" required>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="selectSm" class=" form-control-label">Tipo
													de Documento :</label>
											</div>
											<div class="col-12 col-md-9">
												<tag:tagDocumentos value="${val}" ></tag:tagDocumentos>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Documento
													de identidad :</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="doc"
													placeholder="obligatorio" class="form-control" value="${docIde}" required>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="selectSm" class=" form-control-label">Rol
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<tag:tagRoles value="${rol}" ></tag:tagRoles>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="email-input" class=" form-control-label">Usuario
													:</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="email-input" name="usu"
													placeholder="obligatorio" class="form-control" value="${usu}" required>
											</div>
										</div>										
									</div>
									<div class="card-footer">
										<button class="btn btn-primary btn-sm"
											name="opc" value="act2">
											<i class="fa fa-dot-circle-o"></i> Actualizar
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
		
                    

        </div><!-- .animated -->
    </div>


</div><!-- .animated -->
</div>		
		<!-- /.content -->
		<div class="clearfix"></div>
		<!-- Footer -->
		<footer class="site-footer">
			<div class="footer-inner bg-white">
				<div class="row">
					<div class="col-sm-6">Copyright &copy; 2019 Joaquin Cunorana</div>
					<div class="col-sm-6 text-right">
						Diseñado por Jesus Crais
					</div>
				</div>
			</div>
		</footer>
		<!-- /.site-footer -->
	</div>
	<!-- /#right-panel -->