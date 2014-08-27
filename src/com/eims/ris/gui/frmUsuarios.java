package com.eims.ris.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eims.ris.core.DBUtils;
import com.eims.ris.core.Enumeradores;
import com.eims.ris.core.Usuario;
import com.eims.ris.core.Utils;
import com.eims.ris.gui.Ui_frmUsuarios;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QCursor;

public class frmUsuarios extends QDialog {

    /**
	 * @uml.property  name="ui"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Ui_frmUsuarios ui = new Ui_frmUsuarios();
    /**
	 * @uml.property  name="_parent"
	 */
    private QWidget _parent;
    /**
	 * @uml.property  name="_userName"
	 */
    private String _userName;
    /**
	 * @uml.property  name="_Action"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Enumeradores.Action _Action = Enumeradores.Action.None;
    /**
	 * @uml.property  name="_ActiveRow"
	 */
    private int _ActiveRow = -1;
    /**
	 * @uml.property  name="_ClassActiveRow"
	 */
    private int _ClassActiveRow = -1;
    /**
	 * @uml.property  name="_AccessActiveRow"
	 */
    private int _AccessActiveRow = -1;

    public frmUsuarios(String userName) {
        this(userName, null);
    }

    public frmUsuarios(String userName, QWidget parent) {
        super(parent);
        _userName = userName;
        _parent = parent;
        ui.setupUi(this);
        CreateConnect();
        QApplication.restoreOverrideCursor();
    }
    
    @SuppressWarnings("unused")
	private void on_btnNuevo_Clicked(){
    	ui.frmReg.setVisible(true);
    	ui.twUsuarios.setVisible(false);
    	ui.leDesc.setText("");
    	ui.ckbVige.setChecked(false);
    	_Action = Enumeradores.Action.New;
    }
    @SuppressWarnings("unused")
    private void on_btnEditar_Clicked(){
    	ui.frmReg.setVisible(true);
        ui.twUsuarios.setVisible(true);
        /*ui.leNomb.setText(ui.twUsuarios.item(ui.twUsuarios.currentRow(),2).text());
        ui.leAPat.setText(ui.twUsuarios.item(ui.twUsuarios.currentRow(),3).text());
        ui.leAMat.setText(ui.twUsuarios.item(ui.twUsuarios.currentRow(),4).text());
        ui.leDesc.setText(ui.twUsuarios.item(ui.twUsuarios.currentRow(),5).text());
        ui.ckbVige.setChecked(ui.twUsuarios.item(ui.twUsuarios.currentRow(),8).text().equals("Sí"));*/
        //ui.lblStat.setText("Editando\n[Esc] Cancelar");
        //HabilitaAcciones(this,mUserID,objectName(),'E');
    	_Action = Enumeradores.Action.Edit;
    }
    @SuppressWarnings("unused")
    private void on_btnEliminar_Clicked(){
    	
    }
    @SuppressWarnings("unused")
    private void on_btnAceptar_Clicked(){
        if(ui.twUsuarios.isVisible()){
            ui.cmbPerfil.setCurrentIndex(-1);
            if(_Action!=Enumeradores.Action.None){
            	ui.leAcco.setText(ui.twUsuarios.item(_ActiveRow,1).text());
            	ui.leNomb.setText(ui.twUsuarios.item(_ActiveRow,2).text());
            	ui.leAPat.setText(ui.twUsuarios.item(_ActiveRow,3).text());
            	ui.leAMat.setText(ui.twUsuarios.item(_ActiveRow,4).text());
            	ui.leDesc.setText(ui.twUsuarios.item(_ActiveRow,5).text());
                int lTipoUser = Integer.parseInt(ui.twUsuarios.item(_ActiveRow,7).text());
                if(lTipoUser==0)
                    ui.rbUserR.setChecked(true);
                else
                    ui.rbUserA.setChecked(true);
                ui.ckbVige.setChecked(ui.twUsuarios.item(_ActiveRow,8).text().equals("Sí"));
            }else
                ui.rbUserR.setChecked(true);
            ui.twUsuarios.setVisible(false);
            return;
        }
        ui.cmbPerfil.setEnabled(_Action==Enumeradores.Action.New);
        boolean lUpdatePW = true;
        if(_Action!=Enumeradores.Action.Delete){
            if(ui.lePass1.text().isEmpty() && ui.lePass2.text().isEmpty()){
                if(_Action==Enumeradores.Action.New){
                	Utils.MessageBox(Enumeradores.Message.Information,"Debe proporcionar una contraseña válida.\nIntente nuevamente.");
                    ui.lePass1.setFocus();
                    return;
                }else
                    lUpdatePW = false;
            }else{
                if(!ui.lePass1.text().equals(ui.lePass2.text())){
                	Utils.MessageBox(Enumeradores.Message.Information,"Lo siento las contraseñas proporcionadas no coinciden.\nIntente nuevamente.");
                    ui.lePass1.clear();
                    ui.lePass2.clear();
                    ui.lePass1.setFocus();
                    return;
                }
                lUpdatePW = true;
            }
        }
        //int lActiveRow = _ActiveRow;
        boolean result = false;
        QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    	Usuario usuario = new Usuario();
    	if(_Action == Enumeradores.Action.Delete){
    		if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea eliminar el registro?")==StandardButton.Yes.value()){
    			if(ui.leAcco.text().equals("admin")){
    				QApplication.restoreOverrideCursor();
    				Utils.MessageBox(Enumeradores.Message.Error, "¡No es posible eliminar la cuenta de administrador!");
    				return;
    			}else{
		    		usuario.setId(Integer.parseInt(ui.twUsuarios.item(ui.twUsuarios.currentRow(),0).text()));
		    		result = usuario.Eliminar();
    			}
    		}
    	}else{
    		QApplication.restoreOverrideCursor();
    		if(Utils.MessageBox(Enumeradores.Message.Question, "¿Está seguro que desea guardar?")==StandardButton.Yes.value()){
    			QApplication.setOverrideCursor(new QCursor(Qt.CursorShape.WaitCursor));
    			
    			usuario.setAccount(ui.leAcco.text());
    			usuario.setNombres(ui.leNomb.text());
    			usuario.setAPaterno(ui.leAPat.text());
    			usuario.setAMaterno(ui.leAMat.text());
    			usuario.setDescripcion(ui.leDesc.text());
    			usuario.setTipo(ui.rbUserA.isChecked() ? 1 : 0);
    	    	usuario.setVigente(ui.ckbVige.isChecked());
    			if(_Action == Enumeradores.Action.New)	
    	    		result = usuario.Insertar();
    	    	else if(_Action == Enumeradores.Action.Edit){
    	    		usuario.setId(Integer.parseInt(ui.twUsuarios.item(ui.twUsuarios.currentRow(),0).text()));
    	    		result = usuario.Modificar();
    	    	}
    		}else{
    			return;
    		}
    	}    	
    	
        if(_Action != Enumeradores.Action.Delete){
        	try{
	    		ResultSet query = DBUtils.getResultSet(String.format("SELECT usu_id FROM miniris.usuarios WHERE usu_acco='%1$s'", ui.leAcco.text()));
	    		query.next();
	    		String lID = query.getString(1);
	            if(lUpdatePW){
	                DBUtils.executeNonQuery(String.format("UPDATE miniris.usuarios SET usu_pass='%1$s' WHERE usu_id=%2$s", DBUtils.encryptMD5(ui.lePass1.text()), lID));
	            }
	            DBUtils.executeNonQuery(String.format("DELETE FROM miniris.user_access WHERE usu_id=%1$s", lID));
	            QTableWidgetItem item0, item2, item3, item4, item5, item6;
	            String sql;
	            for(int i=0;i<ui.twAccesos.rowCount();i++){
	                item0 = ui.twAccesos.item(i,0);
	                item2 = ui.twAccesos.item(i,2);
	                item3 = ui.twAccesos.item(i,3);
	                item4 = ui.twAccesos.item(i,4);
	                item5 = ui.twAccesos.item(i,5);
	                item6 = ui.twAccesos.item(i,6);
	                sql = String.format("INSERT INTO miniris.user_access VALUES (%1$s,'%2$s',%3$s,%4$s,%5$s,%6$s,%7$s)",lID,item0.text().trim(),item2.text().equals("1"),item3.text().equals("1"),item4.text().equals("1"),item5.text().equals("1"),item6.text().equals("1"));
	                //System.out.println(sql);
	                DBUtils.executeNonQuery(sql);
	            }
	            result = true;
        	}catch (SQLException e) {
				e.printStackTrace();
				result = false;
			}
        }
        QApplication.restoreOverrideCursor();
        if(result){
        	Utils.MessageBox(Enumeradores.Message.Information, "¡La operación se ha realizado satisfactoriamente!");
        	if(ui.leAcco.text().trim().equals(this._userName))
        		Utils.HabilitaOpciones(this._parent, this._userName);
        }else
    		Utils.MessageBox(Enumeradores.Message.Error, "¡Se ha producido un error al ejecutar la operación!");
        on_btnCancelar_Clicked();
        _Action = Enumeradores.Action.None;
    }
    
    private void on_btnCancelar_Clicked(){
    	ui.frmReg.setVisible(false);
        ui.twUsuarios.setVisible(false);
        ui.tabWidget.setCurrentIndex(0);
    }
    @SuppressWarnings("unused")
    private void on_tbAdd_Clicked(){
    	if(ui.twClases.rowCount()>0 && ui.twClases.currentRow()>-1){
            ui.twAccesos.insertRow(ui.twAccesos.rowCount());
            QTableWidgetItem item1 = new QTableWidgetItem(ui.twClases.item(ui.twClases.currentRow(), 0).text());
            QTableWidgetItem item2 = new QTableWidgetItem(ui.twClases.item(ui.twClases.currentRow(), 1).text());
            QTableWidgetItem item3 = new QTableWidgetItem("1");
            QTableWidgetItem item4 = new QTableWidgetItem("0");
            QTableWidgetItem item5 = new QTableWidgetItem("0");
            QTableWidgetItem item6 = new QTableWidgetItem("0");
            QTableWidgetItem item7 = new QTableWidgetItem("0");
            ui.twAccesos.setItem(ui.twAccesos.rowCount()-1,0,item1);
            ui.twAccesos.setItem(ui.twAccesos.rowCount()-1,1,item2);
            ui.twAccesos.setItem(ui.twAccesos.rowCount()-1,2,item3);
            ui.twAccesos.setItem(ui.twAccesos.rowCount()-1,3,item4);
            ui.twAccesos.setItem(ui.twAccesos.rowCount()-1,4,item5);
            ui.twAccesos.setItem(ui.twAccesos.rowCount()-1,5,item6);
            ui.twAccesos.setItem(ui.twAccesos.rowCount()-1,6,item7);

            ui.twClases.removeRow(ui.twClases.currentRow());
        }else ui.twAccesos.selectRow(0);
        ui.twAccesos.resizeRowsToContents();
    }
    @SuppressWarnings("unused")
    private void on_tbDel_Clicked(){
    	if(ui.twAccesos.rowCount()>0){
            ui.twClases.insertRow(ui.twClases.rowCount());
            QTableWidgetItem item1 = new QTableWidgetItem(ui.twAccesos.item(ui.twAccesos.currentRow(), 0));
            QTableWidgetItem item2 = new QTableWidgetItem(ui.twAccesos.item(ui.twAccesos.currentRow(), 1));
            ui.twClases.setItem(ui.twClases.rowCount()-1,0,item1);
            ui.twClases.setItem(ui.twClases.rowCount()-1,1,item2);

            ui.twAccesos.removeRow(ui.twAccesos.currentRow());
        }else ui.twClases.selectRow(0);
        ui.twClases.resizeRowsToContents();
    }
    @SuppressWarnings("unused")
    private void on_twUsuarios_CellClicked(int row, int col){
        _ActiveRow = row;
    }
    @SuppressWarnings("unused")
    private void on_twClases_CellClicked(int row, int col){
        _ClassActiveRow = row;
    }
    @SuppressWarnings("unused")
    private void on_twAccesos_CellClicked(int row, int col){
        _AccessActiveRow = row;
        if(_AccessActiveRow>-1){
            ui.gbPrivilegios.setChecked(ui.twAccesos.item(row,2).text().equals("1"));
            ui.ckbAdd.setChecked(ui.twAccesos.item(row,3).text().equals("1"));
            ui.ckbEdit.setChecked(ui.twAccesos.item(row,4).text().equals("1"));
            ui.ckbDel.setChecked(ui.twAccesos.item(row,5).text().equals("1"));
            ui.ckbPrint.setChecked(ui.twAccesos.item(row,6).text().equals("1"));
        }
    }
    @SuppressWarnings("unused")
    private void on_twAccesos_HorizonalHeaderClicked(int col){
    	if(col > 0 && ui.twAccesos.rowCount()>0){
    		for(int i=0; i<ui.twAccesos.rowCount(); i++){
    			ui.twAccesos.item(i, col).setText("1");
    		}
    	}
    }
    @SuppressWarnings("unused")
    private void on_gpPrivilegios_Clicked(boolean state){
        if(ui.twAccesos.rowCount()<1) return;
        ui.twAccesos.item(_AccessActiveRow,2).setText(state?"1":"0");
    }
    @SuppressWarnings("unused")
    private void on_ckbAdd_Clicked(boolean state){
        if(ui.twAccesos.rowCount()<1) return;
        ui.twAccesos.item(_AccessActiveRow,3).setText(state?"1":"0");
    }
    @SuppressWarnings("unused")
    private void on_ckbEdit_Clicked(boolean state){
        if(ui.twAccesos.rowCount()<1) return;
        ui.twAccesos.item(_AccessActiveRow,4).setText(state?"1":"0");
    }
    @SuppressWarnings("unused")
    private void on_ckbDel_Clicked(boolean state){
        if(ui.twAccesos.rowCount()<1) return;
        ui.twAccesos.item(_AccessActiveRow,5).setText(state?"1":"0");
    }
    @SuppressWarnings("unused")
    private void on_ckbPrint_Clicked(boolean state){
        if(ui.twAccesos.rowCount()<1) return;
        ui.twAccesos.item(_AccessActiveRow,6).setText(state?"1":"0");
    }
    @SuppressWarnings("unused")
    private void on_tabWidget_CurrentChanged(int tab){
        if(tab==1){
            LoadAccess();
            LoadClass();
        }
    }
    
    private void CreateConnect(){
    	ui.twUsuarios.cellClicked.connect(this, "on_twUsuarios_CellClicked(int, int)");
    	ui.tabWidget.currentChanged.connect(this, "on_tabWidget_CurrentChanged(int)");
    	ui.twClases.cellClicked.connect(this, "on_twClases_CellClicked(int, int)");
        ui.twAccesos.cellClicked.connect(this, "on_twAccesos_CellClicked(int, int)");
        ui.twAccesos.horizontalHeader().sectionClicked.connect(this, "on_twAccesos_HorizonalHeaderClicked(int)");
        
        ui.gbPrivilegios.clicked.connect(this, "on_gpPrivilegios_Clicked(boolean)");
        ui.ckbAdd.clicked.connect(this, "on_ckbAdd_Clicked(boolean)");
        ui.ckbEdit.clicked.connect(this, "on_ckbEdit_Clicked(boolean)");
        ui.ckbDel.clicked.connect(this, "on_ckbDel_Clicked(boolean)");
        ui.ckbPrint.clicked.connect(this, "on_ckbPrint_Clicked(boolean)");
        
    	ui.btnNuevo.clicked.connect(this, "on_btnNuevo_Clicked()");
    	ui.btnEditar.clicked.connect(this, "on_btnEditar_Clicked()");
    	ui.btnEliminar.clicked.connect(this, "on_btnEliminar_Clicked()");
    	
    	ui.btnAceptar.clicked.connect(this, "on_btnAceptar_Clicked()");
    	ui.btnCancelar.clicked.connect(this, "on_btnCancelar_Clicked()");
    	
    	ui.tbAdd.clicked.connect(this, "on_tbAdd_Clicked()");
    	ui.tbDel.clicked.connect(this, "on_tbDel_Clicked()");
    	
    	ui.frmReg.setVisible(false);
    	LoadData();
    }
    
    private void LoadData(){
        int row = 0;
        ui.twUsuarios.setRowCount(0);
        String sql = String.format("SELECT * FROM miniris.usuarios ORDER BY usu_id");
        try{
	        ResultSet query = DBUtils.getResultSet(sql); 
	        while(query.next()){
	            QTableWidgetItem item = null;
	            ui.twUsuarios.insertRow(row);
	            ui.twUsuarios.setRowHeight(row,20);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("usu_id"));
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignVCenter | Qt.AlignmentFlag.AlignRight);
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignRight);
	            ui.twUsuarios.setItem(row,0,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getString("usu_acco"));
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignLeft);
	            ui.twUsuarios.setItem(row,1,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("usu_nomb"));
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignLeft);
	            ui.twUsuarios.setItem(row,2,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("usu_apat"));
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignLeft);
	            ui.twUsuarios.setItem(row,3,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("usu_amat"));
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignLeft);
	            ui.twUsuarios.setItem(row,4,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("usu_desc"));
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignLeft);
	            ui.twUsuarios.setItem(row,5,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("usu_fuac"));
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignLeft);
	            ui.twUsuarios.setItem(row,6,item);
	            
	            item = new QTableWidgetItem();
	            item.setText(query.getString("usu_tipo"));
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignLeft);
	            ui.twUsuarios.setItem(row,7,item);
	
	            item = new QTableWidgetItem();
	            item.setText(query.getBoolean("usu_vige")?"Sí":"No");
	            //item.setTextAlignment(Qt.AlignmentFlag.AlignCenter);
	            ui.twUsuarios.setItem(row,8,item);
	
	            row++;
	        }
        }catch(SQLException e){
        	e.printStackTrace();
        }
        ui.twUsuarios.resizeColumnsToContents();
        
        ui.twClases.setColumnHidden(0,true);
        ui.twClases.setColumnWidth(1,170);

        ui.twAccesos.setColumnHidden(0,true);
        ui.twAccesos.setColumnWidth(1,168);
        ui.twAccesos.setColumnWidth(2,20);
        ui.twAccesos.setColumnWidth(3,20);
        ui.twAccesos.setColumnWidth(4,20);
        ui.twAccesos.setColumnWidth(5,20);
        ui.twAccesos.setColumnWidth(6,20);

        ui.twClases.selectRow(0);
    }
    
    private void LoadClass()
    {
        ui.twClases.clearContents();
        ui.twClases.setRowCount(0);
        boolean found;
        try{
	        ResultSet query = DBUtils.getResultSet("SELECT cls_id,cls_desc FROM miniris.clases ORDER BY cls_desc");
	        while(query.next()){
	            found = false;
	            for(int i=0;i<ui.twAccesos.rowCount();i++){
	                if(ui.twAccesos.item(i,0).text().equals(query.getString(1))) found = true;
	                //System.out.println(ui.twAccesos.item(i,0).text()+ " - "+query.getString(1));
	            }
	            //System.out.println("" + query.getString(1));
	            if(!found){
	                ui.twClases.insertRow(ui.twClases.rowCount());
	                //ui.twClases.setRowHeight(ui.twClases.rowCount()-1,20);
	                QTableWidgetItem item1 = new QTableWidgetItem(query.getString(1));
	                QTableWidgetItem item2 = new QTableWidgetItem(query.getString(2));
	                ui.twClases.setItem(ui.twClases.rowCount()-1, 0, item1);
	                ui.twClases.setItem(ui.twClases.rowCount()-1, 1, item2);
	            }
	        }
        }catch(SQLException e){
        	e.printStackTrace();
        }
        ui.twClases.resizeRowsToContents();
        ui.twClases.setColumnWidth(1, 160);
    }
    
    private void LoadAccess(){
	    ui.twAccesos.setRowCount(0);
	    String filtro = "0";
	    if(ui.cmbPerfil.currentIndex()==-1){
	    	if(_ActiveRow > -1) 
	    		filtro = ui.twUsuarios.item(_ActiveRow, 0).text();
	    }else
	        filtro = ui.cmbPerfil.itemData(ui.cmbPerfil.currentIndex()).toString();
	    try{
		    ResultSet query = DBUtils.getResultSet(String.format("SELECT ua.cls_id,cls_desc,acc_lect,acc_ins,acc_edit,acc_elim,acc_print FROM miniris.user_access ua INNER JOIN miniris.clases c ON ua.cls_id=c.cls_id WHERE usu_id=%1$s ORDER BY c.cls_desc", filtro));
		    while(query.next()){
		        ui.twAccesos.insertRow(ui.twAccesos.rowCount());
		        ui.twAccesos.setRowHeight(ui.twAccesos.rowCount()-1,20);
		        QTableWidgetItem item1 = new QTableWidgetItem(query.getString(1));
		        QTableWidgetItem item2 = new QTableWidgetItem(query.getString(2));
		        QTableWidgetItem item3 = new QTableWidgetItem(query.getBoolean(3)?"1":"0");
		        QTableWidgetItem item4 = new QTableWidgetItem(query.getBoolean(4)?"1":"0");
		        QTableWidgetItem item5 = new QTableWidgetItem(query.getBoolean(5)?"1":"0");
		        QTableWidgetItem item6 = new QTableWidgetItem(query.getBoolean(6)?"1":"0");
		        QTableWidgetItem item7 = new QTableWidgetItem(query.getBoolean(7)?"1":"0");
		        ui.twAccesos.setItem(ui.twAccesos.rowCount()-1, 0, item1);
		        ui.twAccesos.setItem(ui.twAccesos.rowCount()-1, 1, item2);
		        ui.twAccesos.setItem(ui.twAccesos.rowCount()-1, 2, item3);
		        ui.twAccesos.setItem(ui.twAccesos.rowCount()-1, 3, item4);
		        ui.twAccesos.setItem(ui.twAccesos.rowCount()-1, 4, item5);
		        ui.twAccesos.setItem(ui.twAccesos.rowCount()-1, 5, item6);
		        ui.twAccesos.setItem(ui.twAccesos.rowCount()-1, 6, item7);
		        for(int i=0;i<ui.twClases.rowCount();i++){
		            if(ui.twClases.item(i,0).text()==query.getString(0))
		                ui.twClases.removeRow(i);
		        }
		    }
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
	    ui.twAccesos.resizeRowsToContents();
    }
}
