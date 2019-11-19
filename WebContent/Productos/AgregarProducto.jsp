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
                                <strong>Agregar Producto</strong>
                            </div>
                            <div class="card-body card-block">
                                <form action="crud-producto"  enctype="multipart/form-data" class="form-horizontal">
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
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label" >Descripcion :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="txtDescripcion" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label" >Precio :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="txtPrecio" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Categoria :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="txtCategoria" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Imagen :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="" placeholder="obligatorio" class="form-control"></div>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-primary btn-sm" id="bEnviar" name="opc" value="reg">
                                    <i class="fa fa-dot-circle-o"></i> Agregar				
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