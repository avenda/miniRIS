package com.eims.ris.integration.hl7;

import java.io.IOException;

import com.eims.ris.core.Recepcion;
import com.eims.ris.core.RecepcionPrestaciones;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
//import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
//import ca.uhn.hl7v2.model.v26.group.ORI_O24_ORDER;
import ca.uhn.hl7v2.model.v26.group.ORM_O01_ORDER;
import ca.uhn.hl7v2.model.v26.group.ORM_O01_ORDER_DETAIL;
import ca.uhn.hl7v2.model.v26.group.ORM_O01_PATIENT;
//import ca.uhn.hl7v2.model.v26.group.ORM_O01_PATIENT_VISIT;
import ca.uhn.hl7v2.model.v26.message.ORM_O01;
import ca.uhn.hl7v2.model.v26.segment.MSH;
//import ca.uhn.hl7v2.model.v26.segment.IPC;
//import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

public class MensajeHL7 {
	
	/**
	 * @uml.property  name="port"
	 */
	int port = 2100;
	
	/**
	 * @uml.property  name="_NombreRIS"
	 */
	private String _NombreRIS;
	/**
	 * @uml.property  name="_IdServicio"
	 */
	private String _IdServicio;
	/**
	 * @uml.property  name="_IdMensaje"
	 */
	private String _IdMensaje;
	
	/**
	 * @uml.property  name="_PATRut"
	 */
	private String _PATRut;
	/**
	 * @uml.property  name="_PATId"
	 */
	private String _PATId;
	/**
	 * @uml.property  name="_PATAPat"
	 */
	private String _PATAPat;
	/**
	 * @uml.property  name="_PATAMat"
	 */
	private String _PATAMat;
	/**
	 * @uml.property  name="_PATNomb"
	 */
	private String _PATNomb;
	/**
	 * @uml.property  name="_PATFNac"
	 */
	private String _PATFNac;
	/**
	 * @uml.property  name="_PATSexo"
	 */
	private String _PATSexo;
	/**
	 * @uml.property  name="_PATDire"
	 */
	private String _PATDire;
	/**
	 * @uml.property  name="_PATCiud"
	 */
	private String _PATCiud;
	/**
	 * @uml.property  name="_PATCPost"
	 */
	private String _PATCPost;
	/**
	 * @uml.property  name="_PATPais"
	 */
	private String _PATPais;
	/**
	 * @uml.property  name="_PATProv"
	 */
	private String _PATProv;
	
	/**
	 * @uml.property  name="_NumOrden"
	 */
	private String _NumOrden;
	/**
	 * @uml.property  name="_IdExamen"
	 */
	private String _IdExamen;
	/**
	 * @uml.property  name="_DescExamen"
	 */
	private String _DescExamen;
	/**
	 * @uml.property  name="_Prioridad"
	 */
	private String _Prioridad;
	/**
	 * @uml.property  name="_Modalidad"
	 */
	private String _Modalidad;
	/**
	 * @uml.property  name="_IdProc"
	 */
	private String _IdProc;
	/**
	 * @uml.property  name="_NumColMed"
	 */
	private String _NumColMed;
	/**
	 * @uml.property  name="_APatMed"
	 */
	private String _APatMed;
	/**
	 * @uml.property  name="_NombMed"
	 */
	private String _NombMed;
	/**
	 * @uml.property  name="_AbreMed"
	 */
	private String _AbreMed;
	/**
	 * @uml.property  name="_ORCLCita"
	 */
	private String _ORCLCita;	
	/**
	 * @uml.property  name="_EstadoProcedure"
	 */
	private String _EstadoProcedure;
	/**
	 * @uml.property  name="_AETitle"
	 */
	private String _AETitle;
	
	/**
	 * @uml.property  name="_userName"
	 */
	private String _userName;
	private Recepcion recepcion;
	private RecepcionPrestaciones recepcionpaciente;
	public void setMsj(Recepcion recepcion){
		this.recepcion = recepcion;
	}
	public boolean Enviar(){

		//Se crea un tipo de dato segun el mensaje, en este caso ORM^O01
		ORM_O01 orm = new ORM_O01();
		/***************************************************************************************************************/
		MSH MSH = orm.getMSH();
		try {
			MSH.getFieldSeparator().setValue("|");
		
		MSH.getEncodingCharacters().setValue("^~\\&");
		MSH.getSendingApplication().getNamespaceID().setValue(this._NombreRIS);
		MSH.getSendingFacility().getNamespaceID().setValue(this._IdServicio);
		MSH.getDateTimeOfMessage().getDay();
		MSH.getMessageType().getMessageCode().setValue("ORM");
		MSH.getMessageType().getTriggerEvent().setValue("O01");
		MSH.getMessageControlID().setValue(this.get_NumOrden());
		MSH.getProcessingID().getProcessingID().setValue("P");
		MSH.getVersionID().getVersionID().setValue("2.6");
		/***************************************************************************************************************/
		ORM_O01_PATIENT PAT = orm.getPATIENT();
		PAT.getPID().getSetIDPID();
		PAT.getPID().getPatientID().getIDNumber().setValue(this.get_PATRut());
		try {
			PAT.getPID().insertPid3_PatientIdentifierList(0).getCx1_IDNumber().setValue(this.get_PATId());
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PAT.getPID().getPatientName(0).getFamilyName().getSurname().setValue(this.get_PATAPat()+" "+this.get_PATAMat());
		PAT.getPID().getPatientName(0).getGivenName().setValue(this.get_PATNomb());
		PAT.getPID().getDateTimeOfBirth().setValue(this.get_PATFNac());
		PAT.getPID().getAdministrativeSex().setValue(this.get_PATSexo());
		PAT.getPID().getPatientAddress(0).getStreetAddress().getStreetOrMailingAddress().setValue(this.get_PATDire());
		PAT.getPID().getPatientAddress(0).getCity().setValue(this.get_PATCiud());
		PAT.getPID().getPatientAddress(0).getStateOrProvince().setValue(this.get_PATProv());
		PAT.getPID().getPatientAddress(0).getZipOrPostalCode().setValue(this.get_PATCPost());
		PAT.getPID().getPatientAddress(0).getCountry().setValue(this.get_PATPais());
		/***************************************************************************************************************/
		/********************************/
		//3: ORM_O01_ORDER (a Group object) repeating
		ORM_O01_ORDER segmentoORDEN = orm.getORDER();
		//3.1: ORC
		segmentoORDEN.getORC().getOrc1_OrderControl().setValue("NW");
		segmentoORDEN.getORC().getPlacerOrderNumber().getEntityIdentifier().setValue(this.get_NumOrden());
		segmentoORDEN.getORC().getFillerOrderNumber().getEntityIdentifier().setValue(this.get_IdExamen());
		//segmentoORDEN.getORC().getOrderStatus().setValue("");
		//segmentoORDEN.getORC().getResponseFlag().setValue("");
		/*
	 	<xsl:call-template name="procedurePriority">
        <xsl:with-param name="priority" select="string(field[7]/component[5]/text())"/>
    	</xsl:call-template>
		<xsl:when test="$priority = 'S'">STAT</xsl:when>
        <xsl:when test="$priority = 'A' or $priority = 'P' or $priority = 'C' ">HIGH</xsl:when>
        <xsl:when test="$priority = 'R'">ROUTINE</xsl:when>
        <xsl:when test="$priority = 'T'">MEDIUM</xsl:when>
        </xsl:choose>
		 */
		segmentoORDEN.getORC().getEnteredBy(0).getIDNumber().setValue(this.get_userName());
		segmentoORDEN.getORC().getOrderingProvider(0).getIDNumber().setValue(this.get_NumColMed());
		segmentoORDEN.getORC().getOrderingProvider(0).getFamilyName().getSurname().setValue(this.get_APatMed());
		segmentoORDEN.getORC().getOrderingProvider(0).getGivenName().setValue(this.get_NombMed());
		segmentoORDEN.getORC().getOrderingProvider(0).getPrefixEgDR().setValue(this.get_AbreMed());
		segmentoORDEN.getORC().getEntererSLocation().getPointOfCare().setValue(this.get_ORCLCita());
		/********************************/
		
		/***************************************************************************************************************/
		//3.2: OBR
		ORM_O01_ORDER_DETAIL segmentoORDEND = orm.getORDER().getORDER_DETAIL();
		segmentoORDEND.getOBR().getObr2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue(this.get_AETitle());
		segmentoORDEND.getOBR().getObr4_UniversalServiceIdentifier().getText().setValue(this.get_DescExamen());
		segmentoORDEND.getOBR().getObr4_UniversalServiceIdentifier().getNameOfCodingSystem().setValue(this.get_DescExamen());		
		/********************************/
		/*
			<!-- Scheduled Procedure Step Description -->
        	<xsl:call-template name="attr">
            <xsl:with-param name="tag" select="'00400007'"/>
            <xsl:with-param name="vr" select="'LO'"/>
            <xsl:with-param name="val" select="substring(field[4]/component[4]/text(),1,64)"/>
        	</xsl:call-template>
        	(eg, all steps scheduled for a specific scanner, all steps scheduled for all magnetic resonance [MR] imagers)
        	Cuando especifica todos los pasos para un scanner especifico, no es de relevancia.
		*/
		segmentoORDEND.getOBR().getObr4_UniversalServiceIdentifier().getAlternateIdentifier().setValue(this.get_DescExamen());
		/********************************/
		/*
			<!-- Accession Number -->
    		<xsl:call-template name="attr">
        	<xsl:with-param name="tag" select="'00080050'"/>
        	<xsl:with-param name="vr" select="'SH'"/>
        	<xsl:with-param name="val" select="string(field[18]/text())"/>
    		</xsl:call-template>
		*/
		segmentoORDEND.getOBR().getObr18_PlacerField1().setValue(this.get_IdMensaje());
		/********************************/
		/*
			<!-- Requested Procedure ID -->
        	<xsl:call-template name="attr">
            <xsl:with-param name="tag" select="'00401001'"/>
            <xsl:with-param name="vr" select="'SH'"/>
            <xsl:with-param name="val" select="string(field[19]/text())"/>
        	</xsl:call-template>
		*//*********IMPORTANTE************/
		segmentoORDEND.getOBR().getObr19_PlacerField2().setValue(this.get_NumOrden()+"-"+this.get_IdExamen());
		/********************************/
		/*
			<!-- Scheduled Procedure Step ID -->
        	<xsl:call-template name="attr">
            <xsl:with-param name="tag" select="'00400009'"/>
            <xsl:with-param name="vr" select="'SH'"/>
            <xsl:with-param name="val" select="string(field[20]/text())"/>
        	</xsl:call-template>
		 */
		segmentoORDEND.getOBR().getObr20_FillerField1().setValue(this.get_IdExamen());
		/********************************/
		/********************************/
		/*
			<!-- Modality -->
        	<xsl:call-template name="attr">
            <xsl:with-param name="tag" select="'00080060'"/>
            <xsl:with-param name="vr" select="'CS'"/>
            <xsl:with-param name="val" select="string(field[24]/text())"/>
        	</xsl:call-template> 
		*/
		segmentoORDEND.getOBR().getObr24_DiagnosticServSectID().setValue(this.get_Modalidad());
		/********************************/
		/*
			<!-- Requested Procedure Description -->
    		<xsl:call-template name="attr">
        	<xsl:with-param name="tag" select="'00321060'"/>
        	<xsl:with-param name="vr" select="'LO'"/>
        	<xsl:with-param name="val" select="field[44]/component[1]"/>
    		</xsl:call-template>
		 */
		segmentoORDEND.getOBR().getObr44_ProcedureCode().getText().setValue(this.get_DescExamen());
		segmentoORDEND.getOBR().getObr44_ProcedureCode().getCne1_Identifier().setValue(this.get_IdExamen());
		/********************************/
		//3.3: ZDS
		
		Terser t = new Terser(orm);
		try {
			t.set("ZDS-1-1","1.2.826.0.1.3680043.9.88");
			segmentoORDEN.getMessage().addNonstandardSegment("ZDS");
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/********************************/

		Parser parser = new PipeParser();
	    String encodedMessage;
		try {
			encodedMessage = parser.encode(orm);
			String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		    String    ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		    String output = encodedMessage;
		    for (int i=0; i<original.length(); i++) {
		        // Reemplazamos los caracteres especiales.
		        output = output.replace(original.charAt(i), ascii.charAt(i));
		    }//for i
		    /////////////////////////////////////////////////////////////
		    System.out.println("Printing ER7 Encoded Message:");
		    System.out.println(output);
//		    Parser p = new GenericParser();
		    Message adt = parser.parse(output);
		 // The connection hub connects to listening servers
		    ConnectionHub connectionHub = ConnectionHub.getInstance();
		    // A connection object represents a socket attached to an HL7 server
		    Connection connection = connectionHub.attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);
		    // The initiator is used to transmit unsolicited messages
		    Initiator initiator = connection.getInitiator();
		    Message response;
			try {
				response = initiator.sendAndReceive(adt);
				String responseString = parser.encode(response);
			    System.out.println("Received response:\n" + responseString);
			} catch (LLPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    // Close the connection
		    //....
		    connection.close();
		    //connection2.close();
		    return true;
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    /////////////////////////////////////////////////////////////
	    
	    
		} catch (DataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean enviar2(){
		
		return true;
	}
	/**
	 * @return
	 * @uml.property  name="_PATRut"
	 */
	public String get_PATRut() {
		return _PATRut;
	}
	/**
	 * @param patRut
	 * @uml.property  name="_PATRut"
	 */
	public void set_PATRut(String patRut) {
		_PATRut = patRut;
	}
	/**
	 * @return
	 * @uml.property  name="_PATId"
	 */
	public String get_PATId() {
		return _PATId;
	}
	/**
	 * @param patId
	 * @uml.property  name="_PATId"
	 */
	public void set_PATId(String patId) {
		_PATId = patId;
	}
	/**
	 * @return
	 * @uml.property  name="_PATAPat"
	 */
	public String get_PATAPat() {
		return _PATAPat;
	}
	/**
	 * @param pataPat
	 * @uml.property  name="_PATAPat"
	 */
	public void set_PATAPat(String pataPat) {
		_PATAPat = pataPat;
	}
	/**
	 * @return
	 * @uml.property  name="_PATAMat"
	 */
	public String get_PATAMat() {
		return _PATAMat;
	}
	/**
	 * @param pataMat
	 * @uml.property  name="_PATAMat"
	 */
	public void set_PATAMat(String pataMat) {
		_PATAMat = pataMat;
	}
	/**
	 * @return
	 * @uml.property  name="_PATNomb"
	 */
	public String get_PATNomb() {
		return _PATNomb;
	}
	/**
	 * @param patNomb
	 * @uml.property  name="_PATNomb"
	 */
	public void set_PATNomb(String patNomb) {
		_PATNomb = patNomb;
	}
	/**
	 * @return
	 * @uml.property  name="_PATFNac"
	 */
	public String get_PATFNac() {
		return _PATFNac;
	}
	/**
	 * @param patfNac
	 * @uml.property  name="_PATFNac"
	 */
	public void set_PATFNac(String patfNac) {
		_PATFNac = patfNac;
	}
	/**
	 * @return
	 * @uml.property  name="_PATSexo"
	 */
	public String get_PATSexo() {
		return _PATSexo;
	}
	/**
	 * @param patSexo
	 * @uml.property  name="_PATSexo"
	 */
	public void set_PATSexo(String patSexo) {
		_PATSexo = patSexo;
	}
	/**
	 * @return
	 * @uml.property  name="_PATDire"
	 */
	public String get_PATDire() {
		return _PATDire;
	}
	/**
	 * @param patDire
	 * @uml.property  name="_PATDire"
	 */
	public void set_PATDire(String patDire) {
		_PATDire = patDire;
	}
	/**
	 * @return
	 * @uml.property  name="_PATCiud"
	 */
	public String get_PATCiud() {
		return _PATCiud;
	}
	/**
	 * @param patCiud
	 * @uml.property  name="_PATCiud"
	 */
	public void set_PATCiud(String patCiud) {
		_PATCiud = patCiud;
	}
	/**
	 * @return
	 * @uml.property  name="_PATCPost"
	 */
	public String get_PATCPost() {
		return _PATCPost;
	}
	/**
	 * @param patcPost
	 * @uml.property  name="_PATCPost"
	 */
	public void set_PATCPost(String patcPost) {
		_PATCPost = patcPost;
	}
	/**
	 * @return
	 * @uml.property  name="_PATPais"
	 */
	public String get_PATPais() {
		return _PATPais;
	}
	/**
	 * @param patPais
	 * @uml.property  name="_PATPais"
	 */
	public void set_PATPais(String patPais) {
		_PATPais = patPais;
	}
	/**
	 * @return
	 * @uml.property  name="_PATProv"
	 */
	public String get_PATProv() {
		return _PATProv;
	}
	/**
	 * @param patProv
	 * @uml.property  name="_PATProv"
	 */
	public void set_PATProv(String patProv) {
		_PATProv = patProv;
	}

	/**
	 * @return
	 * @uml.property  name="_ORCLCita"
	 */
	public String get_ORCLCita() {
		return _ORCLCita;
	}

	/**
	 * @param orclCita
	 * @uml.property  name="_ORCLCita"
	 */
	public void set_ORCLCita(String orclCita) {
		_ORCLCita = orclCita;
	}

	/**
	 * @return
	 * @uml.property  name="_NombreRIS"
	 */
	public String get_NombreRIS() {
		return _NombreRIS;
	}

	/**
	 * @param nombreRIS
	 * @uml.property  name="_NombreRIS"
	 */
	public void set_NombreRIS(String nombreRIS) {
		_NombreRIS = nombreRIS;
	}

	/**
	 * @return
	 * @uml.property  name="_IdServicio"
	 */
	public String get_IdServicio() {
		return _IdServicio;
	}

	/**
	 * @param idServicio
	 * @uml.property  name="_IdServicio"
	 */
	public void set_IdServicio(String idServicio) {
		_IdServicio = idServicio;
	}

	/**
	 * @return
	 * @uml.property  name="_IdMensaje"
	 */
	public String get_IdMensaje() {
		return _IdMensaje;
	}

	/**
	 * @param idMensaje
	 * @uml.property  name="_IdMensaje"
	 */
	public void set_IdMensaje(String idMensaje) {
		_IdMensaje = idMensaje;
	}

	/**
	 * @return
	 * @uml.property  name="_NumOrden"
	 */
	public String get_NumOrden() {
		return _NumOrden;
	}

	/**
	 * @param numOrden
	 * @uml.property  name="_NumOrden"
	 */
	public void set_NumOrden(String numOrden) {
		_NumOrden = numOrden;
	}

	/**
	 * @return
	 * @uml.property  name="_IdExamen"
	 */
	public String get_IdExamen() {
		return _IdExamen;
	}

	/**
	 * @param idExamen
	 * @uml.property  name="_IdExamen"
	 */
	public void set_IdExamen(String idExamen) {
		_IdExamen = idExamen;
	}

	/**
	 * @return
	 * @uml.property  name="_DescExamen"
	 */
	public String get_DescExamen() {
		return _DescExamen;
	}

	/**
	 * @param descExamen
	 * @uml.property  name="_DescExamen"
	 */
	public void set_DescExamen(String descExamen) {
		_DescExamen = descExamen;
	}

	/**
	 * @return
	 * @uml.property  name="_Prioridad"
	 */
	public String get_Prioridad() {
		return _Prioridad;
	}

	/**
	 * @param prioridad
	 * @uml.property  name="_Prioridad"
	 */
	public void set_Prioridad(String prioridad) {
		_Prioridad = prioridad;
	}

	/**
	 * @return
	 * @uml.property  name="_Modalidad"
	 */
	public String get_Modalidad() {
		return _Modalidad;
	}

	/**
	 * @param modalidad
	 * @uml.property  name="_Modalidad"
	 */
	public void set_Modalidad(String modalidad) {
		_Modalidad = modalidad;
	}

	/**
	 * @return
	 * @uml.property  name="_IdProc"
	 */
	public String get_IdProc() {
		return _IdProc;
	}

	/**
	 * @param idProc
	 * @uml.property  name="_IdProc"
	 */
	public void set_IdProc(String idProc) {
		_IdProc = idProc;
	}

	/**
	 * @return
	 * @uml.property  name="_NumColMed"
	 */
	public String get_NumColMed() {
		return _NumColMed;
	}

	/**
	 * @param numColMed
	 * @uml.property  name="_NumColMed"
	 */
	public void set_NumColMed(String numColMed) {
		_NumColMed = numColMed;
	}

	/**
	 * @return
	 * @uml.property  name="_APatMed"
	 */
	public String get_APatMed() {
		return _APatMed;
	}

	/**
	 * @param aPatMed
	 * @uml.property  name="_APatMed"
	 */
	public void set_APatMed(String aPatMed) {
		_APatMed = aPatMed;
	}

	/**
	 * @return
	 * @uml.property  name="_NombMed"
	 */
	public String get_NombMed() {
		return _NombMed;
	}

	/**
	 * @param nombMed
	 * @uml.property  name="_NombMed"
	 */
	public void set_NombMed(String nombMed) {
		_NombMed = nombMed;
	}

	/**
	 * @return
	 * @uml.property  name="_AbreMed"
	 */
	public String get_AbreMed() {
		return _AbreMed;
	}

	/**
	 * @param abreMed
	 * @uml.property  name="_AbreMed"
	 */
	public void set_AbreMed(String abreMed) {
		_AbreMed = abreMed;
	}

	/**
	 * @return
	 * @uml.property  name="_EstadoProcedure"
	 */
	public String get_EstadoProcedure() {
		return _EstadoProcedure;
	}

	/**
	 * @param estadoProcedure
	 * @uml.property  name="_EstadoProcedure"
	 */
	public void set_EstadoProcedure(String estadoProcedure) {
		_EstadoProcedure = estadoProcedure;
	}

	/**
	 * @return
	 * @uml.property  name="_AETitle"
	 */
	public String get_AETitle() {
		return _AETitle;
	}

	/**
	 * @param aeTitle
	 * @uml.property  name="_AETitle"
	 */
	public void set_AETitle(String aeTitle) {
		_AETitle = aeTitle;
	}

	/**
	 * @return
	 * @uml.property  name="_userName"
	 */
	public String get_userName() {
		return _userName;
	}

	/**
	 * @param userName
	 * @uml.property  name="_userName"
	 */
	public void set_userName(String userName) {
		_userName = userName;
	}    
}
