package com.eims.ris.gui;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.eims.ris.core.Ciudad;
import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Paciente;
import com.eims.ris.core.SistSalud;
import com.eims.ris.core.Utils;
import com.eims.ris.core.Enumeradores.Action;
import com.eims.ris.core.Enumeradores.Message;
import com.eims.ris.gui.Ui_frmPacientes;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QKeyEvent;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;

public class frmPacientes extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmPacientes ui = new Ui_frmPacientes();
    
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Action _Action = Action.None;
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_pacID"
	 */
    private int _pacID = -1;
    
    /*public static int ObtenerPacID() throws SQLException{
        int lastID = 1000000000;
        String sql = String.format("SELECT MAX(pac_id) FROM miniris.pacientes");
        ResultSet query = DBUtils.getResultSet(sql);
        //query.exec("SELECT MAX(pac_id) FROM pacientes");
        if(query.next()){
            if(lastID < query.getInt(1))
                lastID = query.getInt(1);
        }
        return lastID + 1;
    }*/

    public frmPacientes(String userName, boolean update) {
        this(userName, update, null);
    }
    
    public frmPacientes(String userName, boolean update, QWidget parent) {
        super(parent);
        ui.setupUi(this);
        _userName = userName;
        ui.frmUpdate.setVisible(update);
        ui.deFNac.setDate(QDate.currentDate());
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    
    public void keyPressEvent(QKeyEvent e)
	{
	    //ui->lblSBar->setText("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\np, li { white-space: pre-wrap; }\n</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; color:#e3e3e3;\"></span></p></body></html>");
	    ui.lblSBar.clear();
	    if(e.key()==Qt.Key.Key_Return.value()){
	        if(focusWidget()==ui.leRUN && !ui.leRUN.text().isEmpty()){
	            //ui.leRUN.setText(String.format("%010d",ui.leRUN.text()));
	            if(!Utils.ValidarRUN(ui.leRUN.text())){
	                Utils.MessageBox(Message.Information, "El RUN ingresado no es válido.\nIntente nuevamente.");
	                return;
	            }
	        }else if(focusWidget()==ui.deFNac)
	            //ui.lblEdad.setText(ObtenerEdad(ui.deFNac.date()));
	        focusNextChild();
	    }else if(!this._Action.equals(Action.None) && e.key() == Qt.Key.Key_Escape.value()){
    		ui.twPacientes.setEnabled(true);
    		on_btnLimpiar_Clicked();
    		ui.twPacientes.setEnabled(true);
    		Utils.HabilitaAcciones(this, _userName, objectName().substring(3), '\0');
    		_Action = Action.None;
    	}
	}
    
    public int getPacID(){
    	return _pacID;
    }

	public void setPacRun(String pacRun) {
		ui.leRUN.setText(pacRun);
	}

	public void setPacFicha(String pacFicha) {
		ui.leFich.setText(pacFicha);
	}

	public String getPacRun() {
		return ui.leRUN.text();
	}

	public String getPacFicha() {
		return ui.leFich.text();
	}
	
	public void on_btnAceptar_Clicked(){
    	accept();
    }
        
    public void on_btnFiltrar_Clicked(){
    	if(ui.leRUN.text().isEmpty() && ui.leFich.text().isEmpty() && ui.leNomb.text().isEmpty() && ui.leAPat.text().isEmpty() && ui.leAMat.text().isEmpty()){
    		return;
    	}
    	QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
        ui.twPacientes.setRowCount(0);
        //ui.twPacientes.sortByColumn(0,Qt.SortOrder.AscendingOrder);
        String filtro1 = "";
        String filtro2 = "";
        int row = 0;
        ui.lblSBar.clear();
        ui.lblAccion.setText("Aplicado el filtro.");

        /*if(ui.ckbFindHIS.isChecked()){
            if(!ui.leRUN.text().isEmpty())
                filtro1 = String.format("SELECT PAC_PAC_Numero FROM PAC_Paciente WHERE PAC_PAC_Rut='%1'", ui.leRUN.text());
            else if(!ui.leFich.text().isEmpty())
                filtro1 = String.format("SELECT PAC_PAC_Numero FROM PAC_Carpeta WHERE PAC_CAR_NumerFicha=%1", ui.leFich.text());
            	ResultSet query = DBUtils.getResultSet(filtro1);
            if(query.next()){
                filtro2 = String.format("SELECT pa.PAC_PAC_Numero,"+
                                        "PAC_PAC_Rut," +
                                        "PAC_CAR_NumerFicha," +
                                        "PAC_PAC_ApellPater," +
                                        "PAC_PAC_ApellMater," +
                                        "PAC_PAC_Nombre," +
                                        "PAC_PAC_Sexo," +
                                        "CONVERT(CHAR(10),PAC_PAC_FechaNacim,111)," +
                                        "PAC_PAC_Fono," +
                                        "PAC_PAC_TelefonoMovil," +
                                        "''," +
                                        "(PAC_PAC_DireccionGralHabit+', '+DVP_COM_Glosa)," +
                                        "'' " +
                                        "FROM PAC_Paciente pa, PAC_Carpeta ca, DVP_Comuna co " +
                                        "WHERE pa.PAC_PAC_Numero=%1 AND pa.PAC_PAC_Numero*=ca.PAC_PAC_Numero AND PAC_PAC_ComunHabit*=DVP_COM_Codigo", query.getInt(1));
                query = DBUtils.getResultSet(filtro2);
                ui.lblSBar.setText("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\np, li { white-space: pre-wrap; }\n</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; color:#e3e3e3;\">Paciente encontrado en HIS...*</span></p></body></html>");
            }else{
                ui.lblSBar.setText("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\np, li { white-space: pre-wrap; }\n</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; color:#e3e3e3;\">El paciente a buscar en HIS no existe. Intente nuevamente...</span></p></body></html>");
                QApplication.restoreOverrideCursor();
                return;
            }
        }else{*/
            if(!ui.leRUN.text().isEmpty())
                filtro1 = String.format("pac_run='%1$s'", ui.leRUN.text().toUpperCase());
            else if(!ui.leFich.text().isEmpty())
                filtro1 = String.format("pac_fich=%1$s", ui.leFich.text());

            if(!ui.leNomb.text().isEmpty())
                filtro2 = String.format("pac_nomb LIKE '%%1$s' AND ",ui.leNomb.text());
            if(!ui.leAPat.text().isEmpty())
                filtro2 += String.format("pac_apat='%1$s' AND ",ui.leAPat.text());
            if(!ui.leAMat.text().isEmpty())
                filtro2 += String.format("pac_amat='%1$s' AND ",ui.leAMat.text());
            
            System.out.println(filtro2);
            if(!filtro2.isEmpty()) filtro2 = filtro2.substring(0, filtro2.length()-5);
            
            if(filtro1.isEmpty() && filtro2.isEmpty()){
            	QApplication.restoreOverrideCursor();
            	return;
            }
          
            //ResultSet query = DBUtils.getResultSet((String.format("SELECT pac_id,,pac_fich,pac_apat,pac_amat,pac_nomb,pac_sexo,pac_fnac,pac_fon1,pac_fon2,pac_mail,pac_dire,ssa_desc FROM pacientes INNER JOIN sist_salud ON pacientes.ssa_id=sist_salud.ssa_id WHERE %1$s %2$s", filtro1,  filtro2)));
        //}
        //qDebug() << "Query: " << query.lastQuery();
        try{
        	String sql = String.format("SELECT pac_id, pac_run, pac_fich, pac_apat, pac_amat, pac_nomb, pac_sexo, pac_fnac, pac_fon1, pac_fon2, pac_mail, pac_dire, p.ciu_id, p.ssa_id FROM miniris.pacientes p INNER JOIN miniris.sist_salud s ON p.ssa_id=s.ssa_id WHERE %1$s %2$s", filtro1,  filtro2);
        	System.out.println(sql);
	        ResultSet query = DBUtils.getResultSet(sql);
	        while(query.next()){
	            ui.twPacientes.insertRow(ui.twPacientes.rowCount());
	            ui.twPacientes.setRowHeight(row,20);
	            QTableWidgetItem item;
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_id"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	            ui.twPacientes.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_run"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,1,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_fich"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	            ui.twPacientes.setItem(row,2,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_apat"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,3,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_amat"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,4,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_nomb"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,5,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_sexo"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
	            ui.twPacientes.setItem(row,6,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_fnac"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
	            ui.twPacientes.setItem(row,7,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_fon1"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,8,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_fon1"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,9,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_mail"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,10,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_dire"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,11,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("ciu_id"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,12,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("ssa_id"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,13,item);
	
	            row++;
	        }
	        query.close();
        }catch (SQLException e) {
        	QApplication.restoreOverrideCursor();
			DBUtils.showSQLException(e);
		}
        ui.twPacientes.resizeColumnsToContents();
        if(row==1) on_twPacientes_CellDoubleClicked(0, 0);
        QApplication.restoreOverrideCursor();
    }
    
    public void on_btnNuevo_Clicked(){
    	on_btnLimpiar_Clicked();
        ui.lblAccion.setText("Agregando nuevo registro...");
        ui.lblSBar.clear();
        _Action = Action.New;
        _pacID = -1;
    }
    
    public void on_btnGuardar_Clicked(){
    	if(_pacID==-1 && _Action.equals(Action.None)){
            ui.lblSBar.setText("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\np, li { white-space: pre-wrap; }\n</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt; color:#e3e3e3;\">Antes de guardar debe tener un registro editado, o crear uno nuevo. Intente nuevamente...</span></p></body></html>");
            return;
        }
        if(ui.cmbSSalud.currentIndex()<0){
            ui.cmbSSalud.showPopup();
            return;
        }
        if(ui.cmbCiud.currentIndex()<0){
            ui.cmbCiud.showPopup();
            return;
        }
        boolean result = false;
        Paciente pac = new Paciente();
        pac.setId(_pacID);
        pac.setRUN(ui.leRUN.text().toUpperCase());
        if(!ui.leFich.text().trim().equals(""))
        	pac.setFicha(Integer.parseInt(ui.leFich.text()));
        pac.setNombre(ui.leNomb.text().toUpperCase());
        pac.setAPaterno(ui.leAPat.text().toUpperCase());
        pac.setAMaterno(ui.leAMat.text().toUpperCase());
        pac.setDireccion(ui.leDire.text().toUpperCase());
        pac.setFechaNacimiento(ui.deFNac.date());
        pac.setFono1(ui.leFon1.text());
        pac.setFono2(ui.leFon2.text());
        pac.setSexo(ui.rbSMas.isChecked()?"M":"F");
        pac.setMail(ui.leMail.text().toLowerCase());
        Ciudad ciudad = new Ciudad();
        ciudad.setId(Integer.parseInt(ui.cmbCiud.itemData(ui.cmbCiud.currentIndex()).toString()));
        ciudad.setDescripcion(ui.cmbCiud.currentText());
        pac.setCiudad(ciudad);
        SistSalud sistSalud = new SistSalud();
        sistSalud.setId(Integer.parseInt(ui.cmbSSalud.itemData(ui.cmbSSalud.currentIndex()).toString()));
        sistSalud.setDescripcion(ui.cmbSSalud.currentText());
        pac.setSistemaSalud(sistSalud);
        if(_Action==Action.New){
        	result = pac.Insertar();
        	//if(_pacID == 0) _pacID = ObtenerPacID();
        }else
        	result = pac.Modificar();
        	//qDebug() << "PacID: " << _pacID;
        if(result){
        	Utils.MessageBox(Message.Information, "¡El registro se ha guardado satisfactoriamente!");
            on_btnLimpiar_Clicked();
            Utils.HabilitaAcciones(this, _userName, objectName().substring(3), 'B');
            _Action = Action.None;
            LoadCombos();
        }else
        	Utils.MessageBox(Message.Error, "¡Se ha producido un error al guardar el registro!");
    }
    
    public void on_btnLimpiar_Clicked(){
        ui.leRUN.setText("");
        ui.leFich.setText("");
        ui.deFNac.setDate(QDate.currentDate());
        ui.lblEdad.setText("");
        ui.leNomb.setText("");
        ui.leAPat.setText("");
        ui.leAMat.setText("");
        ui.leFon1.setText("");
        ui.leFon2.setText("");
        ui.leMail.setText("");
        ui.leDire.setText("");
        ui.rbSMas.setChecked(true);
        ui.cmbSSalud.setCurrentIndex(-1);
        ui.cmbCiud.setCurrentIndex(-1);
        ui.twPacientes.setRowCount(0);
        ui.lblAccion.setText("Limpiados los cuadros de ingreso.");
        ui.lblSBar.setText("");
        LoadData();
    }
    
    public void on_btnEliminar_Clicked(){
        ui.lblSBar.clear();
    	if(Utils.MessageBox(Message.Question, "¿Está seguro que desea eliminar el registro?")==StandardButton.Yes.value()){
	    	Paciente pac = new Paciente();
	    	pac.setId(Integer.parseInt(ui.twPacientes.item(ui.twPacientes.currentRow(), 0).text()));    	
	    	pac.Eliminar();
	    	Utils.HabilitaAcciones(this,_userName, objectName().substring(3), '\n');
	    	_Action = Action.Delete;
	    	LoadData();
    	}
    	_Action = Action.None;
    }
    
    public void on_twPacientes_CellDoubleClicked(int row, int col){
    	if(ui.ckbFindHIS.isChecked())
            on_btnNuevo_Clicked();
        else{
            ui.lblAccion.setText("Editando registro.");
            ui.btnGuardar.setEnabled(true);
            _Action = Action.Edit;
        }
    	
        _pacID = Integer.parseInt(ui.twPacientes.item(row,0).text());
        ui.leRUN.setText(ui.twPacientes.item(row,1).text());
        ui.leFich.setText(ui.twPacientes.item(row,2).text());
        ui.leAPat.setText(ui.twPacientes.item(row,3).text());
        ui.leAMat.setText(ui.twPacientes.item(row,4).text());
        ui.leNomb.setText(ui.twPacientes.item(row,5).text());
        ui.rbSMas.setChecked(ui.twPacientes.item(row,6).text().equals("M"));
        ui.rbSFem.setChecked(ui.twPacientes.item(row,6).text().equals("F"));
        ui.deFNac.setDate(QDate.fromString(ui.twPacientes.item(row,7).text(),"yyyy-MM-dd"));
        ui.leFon1.setText(ui.twPacientes.item(row,8).text());
        ui.leFon2.setText(ui.twPacientes.item(row,9).text());
        ui.leMail.setText(ui.twPacientes.item(row,10).text());
        ui.leDire.setText(ui.twPacientes.item(row,11).text());
        ui.cmbCiud.setCurrentIndex(ui.cmbCiud.findData(ui.twPacientes.item(row,12).text()));
        ui.cmbSSalud.setCurrentIndex(ui.cmbSSalud.findData(ui.twPacientes.item(row,13).text()));
        ui.lblEdad.setText(DBUtils.ObtenerEdad(QDate.fromString(ui.twPacientes.item(row,7).text(),"yyyy-MM-dd")));
        //ui.lblEdad.setText(String.format(ui.twPacientes.item(row,7).text(),"yyyy-MM-dd"));
        //System.out.println(Integer.parseInt(ui.twPacientes.item(row,13).text()));
    }

	private void CreateConnect(){
    	ui.btnAceptar.clicked.connect(this, "on_btnAceptar_Clicked()");
    	ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
    	ui.btnFiltrar.clicked.connect(this, "on_btnFiltrar_Clicked()");
    	ui.btnGuardar.clicked.connect(this, "on_btnGuardar_Clicked()");
    	ui.btnLimpiar.clicked.connect(this, "on_btnLimpiar_Clicked()");
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.twPacientes.cellDoubleClicked.connect(this, "on_twPacientes_CellDoubleClicked(int, int)");
    	LoadData();
    	LoadCombos();
    }
	
    private void LoadData(){
        int row = 0;
		ui.twPacientes.setRowCount(0);
        String sql = String.format("SELECT pac_id,pac_run,pac_fich,pac_apat, pac_amat,pac_nomb,pac_sexo,pac_fnac, pac_fon1, pac_fon2, pac_mail,pac_dire, ciu_id,ssa_id FROM miniris.pacientes d ORDER BY pac_id");
        try{
	        ResultSet query = DBUtils.getResultSet(sql); 
	        while(query.next()){
	            QTableWidgetItem item = null;
	            ui.twPacientes.insertRow(row);
	            ui.twPacientes.setRowHeight(row,20);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_id"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	            ui.twPacientes.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_run"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,1,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_fich"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignRight.value());
	            ui.twPacientes.setItem(row,2,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_apat"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,3,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_amat"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,4,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_nomb"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,5,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_sexo"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
	            ui.twPacientes.setItem(row,6,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_fnac"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value() | Qt.AlignmentFlag.AlignHCenter.value());
	            ui.twPacientes.setItem(row,7,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_fon1"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,8,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_fon1"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,9,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_mail"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,10,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("pac_dire"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,11,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("ciu_id"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,12,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("ssa_id"));
	            item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter.value());
	            ui.twPacientes.setItem(row,13,item);
	
	            row++;
	        }
	        ui.twPacientes.resizeColumnsToContents();
        }catch(SQLException e){
        	e.printStackTrace();
        }
    }        
    
    public void LoadCombos(){
    	DBUtils.loadComboBox(ui.cmbCiud, String.format("SELECT ciu_id, ciu_desc FROM miniris.ciudades"));
    	DBUtils.loadComboBox(ui.cmbSSalud, String.format("SELECT ssa_id,ssa_desc FROM miniris.sist_salud WHERE ssa_vige='1'"));
    }
}