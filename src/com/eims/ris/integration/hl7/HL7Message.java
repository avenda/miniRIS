package com.eims.ris.integration.hl7;

import java.io.IOException;

import com.eims.ris.core.Recepcion;
import com.eims.ris.core.RecepcionPrestaciones;
import com.eims.ris.core.Utils;

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
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

public class HL7Message {
	
	/**
	 * @uml.property  name="port"
	 */
	int port = 2575;
	/**
	 * @uml.property  name="_Modalidad"
	 */
	private String _Modalidad;
	/**
	 * @uml.property  name="_IdProc"
	 */
	private String _userName;
	private Recepcion recepcion;
	public void setRecepcion(Recepcion recepcion){
		this.recepcion= recepcion;
	}
	public Recepcion getRecepcion(){
		return recepcion;
	}
	public boolean Enviar() throws HL7Exception, LLPException, IOException{
		int num=0;
		for(RecepcionPrestaciones rp : this.recepcion.getRecepcionPrestaciones()){
			//Se crea un tipo de dato segun el mensaje, en este caso ORM^O01
			ORM_O01 orm = new ORM_O01();
			/***************************************************************************************************************/
			MSH MSH = orm.getMSH();
			MSH.getFieldSeparator().setValue("|");
			MSH.getEncodingCharacters().setValue("^~\\&");
			MSH.getSendingApplication().getNamespaceID().setValue("EIMSRISV1");
			MSH.getSendingFacility().getNamespaceID().setValue(""+this.getRecepcion().getDerivador().getId());
			MSH.getDateTimeOfMessage().getDay();
			MSH.getMessageType().getMessageCode().setValue("ORM");
			MSH.getMessageType().getTriggerEvent().setValue("O01");
			MSH.getMessageControlID().setValue(""+this.getRecepcion().getId());
			MSH.getProcessingID().getProcessingID().setValue("P");
			MSH.getVersionID().getVersionID().setValue("2.6");
			ORM_O01_PATIENT PAT = orm.getPATIENT();
			PAT.getPID().getSetIDPID();
			PAT.getPID().getPatientID().getIDNumber().setValue(this.getRecepcion().getPaciente().getRUN());
			PAT.getPID().insertPid3_PatientIdentifierList(0).getCx1_IDNumber().setValue(""+this.getRecepcion().getPaciente().getId());
			PAT.getPID().getPatientName(0).getFamilyName().getSurname().setValue(this.getRecepcion().getPaciente().getAPaterno()+
																					" "+this.getRecepcion().getPaciente().getAMaterno());
			PAT.getPID().getPatientName(0).getGivenName().setValue(this.getRecepcion().getPaciente().getNombre());
			//PAT.getPID().getDateTimeOfBirth().setValue(this.getRecepcion().getPaciente().getFechaNacimiento().toString("yyyyMMdd"));
			PAT.getPID().getAdministrativeSex().setValue(this.getRecepcion().getPaciente().getSexo());
			PAT.getPID().getPatientAddress(0).getStreetAddress().getStreetOrMailingAddress().setValue(this.getRecepcion().getPaciente().getDireccion());
			PAT.getPID().getPatientAddress(0).getCity().setValue(this.getRecepcion().getPaciente().getCiudad().getDescripcion());
			ORM_O01_ORDER segmentoORDEN = orm.getORDER();
			segmentoORDEN.getORC().getOrc1_OrderControl().setValue("NW");
			segmentoORDEN.getORC().getPlacerOrderNumber().getEntityIdentifier().setValue(""+rp.getResponsable().getId());
			segmentoORDEN.getORC().getFillerOrderNumber().getEntityIdentifier().setValue(rp.getPrestacion().getId());
			segmentoORDEN.getORC().getEnteredBy(0).getIDNumber().setValue(this.getRecepcion().getUsuario());
			segmentoORDEN.getORC().getOrderingProvider(0).getIDNumber().setValue(this.getRecepcion().getResponsable().getIniciales());
			segmentoORDEN.getORC().getOrderingProvider(0).getFamilyName().getSurname().setValue(this.getRecepcion().getResponsable().getAPaterno());
			segmentoORDEN.getORC().getOrderingProvider(0).getGivenName().setValue(this.getRecepcion().getResponsable().getNombre());
			segmentoORDEN.getORC().getOrderingProvider(0).getPrefixEgDR().setValue(this.getRecepcion().getResponsable().getProfesion().getAbreviacion());
			segmentoORDEN.getORC().getEntererSLocation().getPointOfCare().setValue(""+this.getRecepcion().getIDCitacion());
			ORM_O01_ORDER_DETAIL segmentoORDEND = orm.getORDER().getORDER_DETAIL();
			segmentoORDEND.getOBR().getObr2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue("EIMSRIS");
			segmentoORDEND.getOBR().getObr4_UniversalServiceIdentifier().getText().setValue(rp.getPrestacion().getDescripcion());
			segmentoORDEND.getOBR().getObr4_UniversalServiceIdentifier().getNameOfCodingSystem().setValue(""+
																					rp.getPrestacion().getRRFFxDefecto().getId());		
			segmentoORDEND.getOBR().getObr4_UniversalServiceIdentifier().getAlternateIdentifier().setValue(rp.getPrestacion().getDescripcion());
			segmentoORDEND.getOBR().getObr18_PlacerField1().setValue(""+this.getRecepcion().getId());
			segmentoORDEND.getOBR().getObr19_PlacerField2().setValue(this.getRecepcion().getId()+""+rp.getPrestacion().getId());
			segmentoORDEND.getOBR().getObr20_FillerField1().setValue(rp.getPrestacion().getId());
			segmentoORDEND.getOBR().getObr24_DiagnosticServSectID().setValue(rp.getPrestacion().getRRFFxDefecto().getModalidad().getDescripcion());
			segmentoORDEND.getOBR().getObr44_ProcedureCode().getText().setValue(rp.getPrestacion().getDescripcion());
			segmentoORDEND.getOBR().getObr44_ProcedureCode().getCne1_Identifier().setValue(rp.getPrestacion().getId());
			segmentoORDEN.getMessage().addNonstandardSegment("ZDS");
			Terser t = new Terser(orm);
			t.set("ZDS-1-1","1.2.826.0.1.3680043.9.88");
			Parser parser = new PipeParser();
		    String encodedMessage = parser.encode(orm);
		    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		    String    ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		    String output = encodedMessage;
		    for (int i=0; i<original.length(); i++) {
		        output = output.replace(original.charAt(i), ascii.charAt(i));
		    }
		    System.out.println("Printing ER7 Encoded Message:");
		    System.out.println(output);
		    Parser p = new GenericParser();
		    Message adt = parser.parse(output);
		    ConnectionHub connectionHub = ConnectionHub.getInstance();
		    // A connection object represents a socket attached to an HL7 server
		    Connection connection = connectionHub.attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);
		    // The initiator is used to transmit unsolicited messages
		    Initiator initiator = connection.getInitiator();
		    Message response = initiator.sendAndReceive(adt);
		    String responseString = parser.encode(response);
		    System.out.println("Received response:\n" + responseString);
		    // Close the connection
		    //....
		    connection.close();
		    //connection2.close();
		    num++;
		}
		return false;
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
