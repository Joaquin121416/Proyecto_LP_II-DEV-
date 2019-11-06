package com.sistema.comidas.bean;

public class GenericoBean {
	
		protected long   codigo; 
		protected String estado;
			
		// Auditoria
		
		protected String audTipo;
		protected long   audIdUsuario; 
		protected String audSession;
		protected String audIp;
		protected String audFecha;
		
		
	    public GenericoBean() {
			super();
		}

		public long getCodigo() {
			return codigo;
		}

		public void setCodigo(long codigo) {
			this.codigo = codigo;
		}

		public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }

		public String getAudTipo() {
			return audTipo;
		}

		public void setAudTipo(String audTipo) {
			this.audTipo = audTipo;
		}

		public long getAudIdUsuario() {
			return audIdUsuario;
		}

		public void setAudIdUsuario(long audIdUsuario) {
			this.audIdUsuario = audIdUsuario;
		}

		public String getAudSession() {
			return audSession;
		}

		public void setAudSession(String audSession) {
			this.audSession = audSession;
		}

		public String getAudIp() {
			return audIp;
		}

		public void setAudIp(String audIp) {
			this.audIp = audIp;
		}

		public String getAudFecha() {
			return audFecha;
		}

		public void setAudFecha(String audFecha) {
			this.audFecha = audFecha;
		}

		
		@Override
		public String toString() {
			return "GenericoBean [codigo=" + codigo + ", estado=" + estado + ", audTipo=" + audTipo + ", audIdUsuario="
					+ audIdUsuario + ", audSession=" + audSession + ", audIp=" + audIp + ", audFecha=" + audFecha + "]";
		}

	    
}
