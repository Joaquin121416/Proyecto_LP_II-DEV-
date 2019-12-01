<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="LibTag" prefix="tag"%>

<div id="right-panel" class="right-panel">></div>
	<jsp:include page="/Cabecera.jsp" />
	<!-- Content -->
	<div class="content"></div>
		<div class="animated fadeIn"></div>

			<div class="content">
				<div class="animated fadeIn">


					<div class="row">
						<!--/.col-->


                <div class="row"><!--/.col-->


                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <strong>Actualizar Insumo</strong>
                            </div>
                            <div class="card-body card-block">
                                <form action="/LP_2_Sistema_Venta_3.0/InsumoServlet"  enctype="multipart/form-data" class="form-horizontal">
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label class=" form-control-label">Codigo Insumo:</label></div>
                                        <div class="col-12 col-md-9">
                                            	<input type="text" id="disabled-input" name="txtCodigo"
													 class="form-control" readonly="true" value="${INS_ID}">
                                    </div></div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label">Nombre Insumo:</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="txtNombre" placeholder="obligatorio" class="form-control" value="${INS_NOM}"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label" >Descripcion Insumo :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="txtDescripcion" placeholder="obligatorio" class="form-control" value="${INS_DES}"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="text-input" class=" form-control-label" >Precio Insumo :</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="text-input" name="txtPrecio" placeholder="obligatorio" class="form-control" value="${INS_PRE}"></div>
                                    </div>
									<div class="card-footer">
										<button class="btn btn-primary btn-sm" name="opc" value="agr">
											<i class="fa fa-dot-circle-o"></i> Actualizar 
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
					<div class="col-sm-6 text-right">DiseÃ±ado por Jesus Crais</div>
				</div>
			</div>
		</footer>
		<!-- /.site-footer -->
	</div>
	<!-- /#right-panel -->
