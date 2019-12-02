
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                                <strong>Agregar Proveedor</strong>
                            </div>
                            <div class="card-body card-block">
                                <form action="ProveedorServlet" method="post" enctype="multipart/form-data" class="form-horizontal">
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label class=" form-control-label">Codigo :</label></div>
                                        <div class="col-12 col-md-9">
                                            <p class="form-control-static">Codigo</p>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Nombre :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="txtNombre" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label" >Apellido :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="txtApellido" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Numero de RUC:</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="txtRuc" placeholder="obligatorio" class="form-control"></div>
                                    </div>                            
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="email-input" class=" form-control-label">Telefono :</label></div>
                                        <div class="col-12 col-md-9"><input type="email" id="email-input" name="txtTelefono" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="email-input" class=" form-control-label">estado :</label></div>
                                        <div class="col-12 col-md-9"><input type="email" id="email-input" name="txtEstado" placeholder="obligatorio" class="form-control"></div>
                                   
                                      </div>
                                        <div class="row form-group">
                                        <div class="col col-md-3"><label for="email-input" class=" form-control-label">Tipo :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="email-input" name="email-input" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                     <div class="row form-group">
                                        <div class="col col-md-3"><label for="email-input" class=" form-control-label">ID usuario :</label></div>
                                        <div class="col-12 col-md-9"><input type="email" id="email-input" name="email-input" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                     <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Secion :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="text-input" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                    
                                     <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">fecha :</label></div>
                                        <div class="col-12 col-md-9"><input type="date" id="text-input" name="text-input" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                      <div class="row form-group">
                                        <div class="col col-md-3"><label for="email-input" class=" form-control-label">ID Auditoria :</label></div>
                                        <div class="col-12 col-md-9"><input type="email" id="email-input" name="email-input" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="password-input" class=" form-control-label">Correo :</label></div>
                                        <div class="col-12 col-md-9"><input type="password" id="password-input" name="password-input" placeholder="obligatorio" class="form-control"></div>
                                    </div>                 
                                </form>
                            </div>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-primary btn-sm">
                                    <i class="fa fa-dot-circle-o"></i> Agregar				
                                </button>
                                <button type="reset" class="btn btn-danger btn-sm">
                                    <i class="fa fa-ban"></i> Cancelar
                                </button>
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