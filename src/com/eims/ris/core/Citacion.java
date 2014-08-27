package com.eims.ris.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.trolltech.qt.core.QDateTime;
import com.trolltech.qt.gui.QPainter;
import com.trolltech.qt.gui.QPrinter;
import com.trolltech.qt.gui.QTableWidget;

public class Citacion {
	private long _id;
	private Recepcion _citacion;
	private QDateTime _fechaHora;
	private Funcionario _profesional;
	private RRFFs _rrff;
	private String _estado;
	private String _estadoOriginal;
	private String _observacion;
	private QDateTime _fhDigitacion;
	private String _usuario;
	
	public long getId() {
		return _id;
	}

	public void setId(long id) {
		this._id = id;
	}

	public Recepcion getCitacion() {
		return _citacion;
	}

	public void setCitacion(Recepcion citacion) {
		this._citacion = citacion;
	}

	public QDateTime getHechaHora() {
		return _fechaHora;
	}

	public void setFechaHora(QDateTime fechaHora) {
		this._fechaHora = fechaHora;
	}

	public Funcionario getProfesional() {
		return _profesional;
	}

	public void setProfesional(Funcionario profesional) {
		this._profesional = profesional;
	}

	public RRFFs getRRFF() {
		return _rrff;
	}

	public void setRRFF(RRFFs rrff) {
		this._rrff = rrff;
	}

	public String getEstado() {
		return _estado;
	}

	public void setEstado(String estado) {
		this._estado = estado;
	}

	public String getEstadoOriginal() {
		return _estadoOriginal;
	}

	public void setEstadoOriginal(String estadoOriginal) {
		this._estadoOriginal = estadoOriginal;
	}

	public String getObservacion() {
		return _observacion;
	}

	public void setObservacion(String observacion) {
		this._observacion = observacion;
	}

	public QDateTime getFHDigitacion() {
		return _fhDigitacion;
	}

	public void setFHDigitacion(QDateTime fhDigitacion) {
		this._fhDigitacion = fhDigitacion;
	}

	public String getUsuario() {
		return _usuario;
	}

	public void setUsuario(String usuario) {
		this._usuario = usuario;
	}

	public boolean Insertar(){
		boolean result = true;
		Connection cnn = DBUtils.connectDB();
		try{
			cnn.setAutoCommit(false);
			this.getCitacion().setId(DBUtils.getLastIDRecepcion());
			String sql = String.format("INSERT INTO miniris.prestsol_enc (" +
										"eps_trec," +
										"eps_fhre," +
										"pac_id," +
										"deri_id," +
										"ssa_id," +
										"eps_nurg," +
										"rf_id," +
										"eps_ures," +
										"eps_obse," +
										"eps_user," +
										"eps_erec," +
										"eps_pinf," +
										"eps_info," +
										"eps_pasi," +
										"eps_id) " +
										"VALUES(%1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, '%9$s', '%10$s', %11$s, %12$s, %13$s, %14$s, %15$s);",
										this.getCitacion().getTipo(),
										null,
										this.getCitacion().getPaciente().getId(),
										this.getCitacion().getDerivador().getId(),
										this.getCitacion().getSistemaSalud().getId(),
										this.getCitacion().getNivelUrgencia(),
										this.getRRFF().getId(),
										this.getProfesional().getId(),
										this.getCitacion().getObservacion(),
										this.getUsuario(),
										this.getCitacion().getEstadoRecepcion(),
										this.getCitacion().getParaInformar(),
										this.getCitacion().getInfoAdicional(),
										this.getCitacion().getAsiste(),
										this.getCitacion().getId());
			System.out.println(sql);
			result = DBUtils.executeNonQuery(sql);
			String FHToma = "0000-00-00 00:00:00";
			for(RecepcionPrestaciones rp : this.getCitacion().getRecepcionPrestaciones()){
				if(rp.getFHToma().isValid()) FHToma = rp.getFHToma().toString("yyyy-MM-dd HH:mm:ss");
				if(rp.getEstado().equals("I"))
					sql = String.format("INSERT INTO miniris.prestsol_det VALUES(%1$s, '%2$s', %3$s, %4$s, %5$s, '%6$s');",
										this.getCitacion().getId(),
										rp.getPrestacion().getId(),
										rp.getCantidad(),
										rp.getResponsable().getId(),
										rp.getTomado(),
										Timestamp.valueOf(FHToma));
				else if(rp.getEstado().equals("M"))
					sql = String.format("UPDATE miniris.prestsol_det SET dps_cant=%1$s, fun_id=%2$s, dps_toma=%3Ss, dps_fhto='%4$s' WHERE eps_id=%5$s AND prest_id='%6$s';", 
										rp.getCantidad(),
										rp.getResponsable().getId(),
										rp.getTomado(),
										Timestamp.valueOf(FHToma),
										this.getCitacion().getId(),
										rp.getPrestacion().getId());
				else
					sql = String.format("DELETE miniris.prestsol_det WHERE eps_id=%1$s AND prest_id='%2$s';", 
										this.getCitacion().getId(),
										rp.getPrestacion().getId());
				System.out.println(sql);
				DBUtils.executeNonQuery(sql);
				sql = String.format("UPDATE miniris.citaciones SET eps_id=%1$s, cita_esta='R', cita_obse='%2$s' WHERE cita_id=%3$s;", this.getCitacion().getId(), this.getObservacion(), this.getId());
				System.out.println(sql);
				DBUtils.executeNonQuery(sql);
			}
			cnn.commit();
		}catch(SQLException e) {
			try{
				cnn.rollback();
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
			DBUtils.showSQLException(e);
		}
		return result;
	}
	public boolean Modificar(){
		String sql = String.format("UPDATE miniris.prestsol_enc SET eps_trec=%1$s, eps_fhre='%2$s', pac_id=%3$s, deri_id=%4$s, ssa_id=%5$s, eps_nurg=%6$s, rf_id=%7$s, eps_ures=%8$s, eps_obse='%9$s', eps_user='%10$s', eps_erec=%11$s, eps_pinf=%12$s, eps_info=%13$s, eps_pasi=%14$s WHERE eps_id=%15$s;",
									this.getCitacion().getTipo(),
									Timestamp.valueOf(this.getCitacion().getFechaHora().toString("yyyy-MM-dd HH:mm:ss")),
									this.getCitacion().getPaciente().getId(),
									this.getCitacion().getDerivador().getId(),
									this.getCitacion().getSistemaSalud().getId(),
									this.getCitacion().getNivelUrgencia(),
									this.getRRFF().getId(),
									this.getProfesional().getId(),
									this.getCitacion().getObservacion(),
									this.getUsuario(),
									this.getCitacion().getEstadoRecepcion(),
									this.getCitacion().getParaInformar(),
									this.getCitacion().getInfoAdicional(),
									this.getCitacion().getAsiste(),
									this.getCitacion().getId());
		System.out.println(sql);
		//AGREGAR CODIGO PARA GUARDAR LAS PRESTACIONES DE LA RECEPCION
		return DBUtils.executeNonQuery(sql);
	}

	public static void Printer(QTableWidget tw){
		QPrinter printer = new QPrinter(); //(QPrinter::HighResolution);
        printer.setOutputFormat(QPrinter.OutputFormat.PdfFormat);
        printer.setOutputFileName("/home/pablo/temp/informe.pdf");
        printer.setPageSize(QPrinter.PageSize.Letter);
        QPainter painter = new QPainter();
        if(!painter.begin(printer)){
            //qWarning("Error al abrir el archivo PDF para escritura.");
            return;
        }
        painter.setRenderHint(QPainter.RenderHint.Antialiasing, true);
        // Arreglo utilizado para el header del informe con sus respectivos Widths y Aligns
        String header[][] = new String[2][3];
        header[0][0] = "50"; // Width de la celda
        header[0][1] = "ID"; // Texto de la celda
        header[0][2] = "3";  // Align de la celda
        header[1][0] = "300";
        header[1][1] = "DESCRIPCIÓN";
        header[1][2] = "0";
        String lTitle = "INFORME DE CITACIONES";
        Utils.PrintHeader(painter, lTitle, header, 1, (int)(tw.rowCount() / 44) + 1);
        Utils.PrintTableWidget(printer, painter, lTitle, tw, header);
        
        painter.end(); // finaliza el dibujado y libera el archivo PDF.
        Utils.ShowPDF(printer.outputFileName());
	}

}
