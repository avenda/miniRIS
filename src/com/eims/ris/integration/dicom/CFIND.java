package com.eims.ris.integration.dicom;

/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is part of dcm4che, an implementation of DICOM(TM) in
 * Java(TM), hosted at http://sourceforge.net/projects/dcm4che.
 *
 * The Initial Developer of the Original Code is
 * Gunter Zeilinger, Huetteldorferstr. 24/10, 1150 Vienna/Austria/Europe.
 * Portions created by the Initial Developer are Copyright (C) 2002-2005
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 * Gunter Zeilinger <gunterze@gmail.com>
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import org.dcm4che2.data.BasicDicomObject;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.data.UID;
import org.dcm4che2.net.Association;
import org.dcm4che2.net.CommandUtils;
import org.dcm4che2.net.ConfigurationException;
import org.dcm4che2.net.Device;
import org.dcm4che2.net.DimseRSP;
import org.dcm4che2.net.NetworkApplicationEntity;
import org.dcm4che2.net.NetworkConnection;
import org.dcm4che2.net.NewThreadExecutor;
import org.dcm4che2.net.NoPresentationContextException;
import org.dcm4che2.net.TransferCapability;
import org.dcm4che2.net.UserIdentity;


/**
 * @author gunter zeilinger(gunterze@gmail.com)
 * @version $Revision: 14419 $ $Date: 2010-11-26 14:22:31 +0100 (Fri, 26 Nov 2010) $
 * @since Mar 18, 2006
 *
 */
public class CFIND {

	
    private static char[] SECRET = { 's', 'e', 'c', 'r', 'e', 't' };

    private static final int[] RETURN_KEYS = {
        Tag.AccessionNumber,
        Tag.ReferringPhysicianName,
        Tag.PatientName,
        Tag.PatientID,
        Tag.PatientBirthDate,
        Tag.PatientSex,
        Tag.PatientWeight,
        Tag.MedicalAlerts,
        Tag.Allergies,
        Tag.PregnancyStatus,
        Tag.StudyInstanceUID,
        Tag.RequestingPhysician,
        Tag.RequestingService,
        Tag.RequestedProcedureDescription,
        Tag.AdmissionID,
        Tag.SpecialNeeds,
        Tag.CurrentPatientLocation,
        Tag.PatientState,
        Tag.RequestedProcedureID,
        Tag.RequestedProcedurePriority,
        Tag.PatientTransportArrangements,
        Tag.PlacerOrderNumberImagingServiceRequest,
        Tag.FillerOrderNumberImagingServiceRequest,
        Tag.ConfidentialityConstraintOnPatientDataDescription,
    };

    private static final int[] SPS_RETURN_KEYS = {
        Tag.Modality,
        Tag.RequestedContrastAgent,
        Tag.ScheduledStationAETitle,
        Tag.ScheduledProcedureStepStartDate,
        Tag.ScheduledProcedureStepStartTime,
        Tag.ScheduledPerformingPhysicianName,
        Tag.ScheduledProcedureStepDescription,
        Tag.ScheduledProcedureStepID,
        Tag.ScheduledStationName,
        Tag.ScheduledProcedureStepLocation,
        Tag.PreMedication,
        Tag.ScheduledProcedureStepStatus
    };

    
    private static final String[] LE_TS = {
        UID.ExplicitVRLittleEndian, 
        UID.ImplicitVRLittleEndian };
  
    private static final byte[] EXT_NEG_INFO_FUZZY_MATCHING = { 1, 1, 1 };
    
    private final Executor executor;
    private final NetworkApplicationEntity remoteAE = new NetworkApplicationEntity();
    private final NetworkConnection remoteConn = new NetworkConnection();
    private final Device device;
    private final NetworkApplicationEntity ae = new NetworkApplicationEntity();
    private final NetworkConnection conn = new NetworkConnection();
    private Association assoc;
    private int priority = 0;
    private int cancelAfter = Integer.MAX_VALUE;
    private final DicomObject keys = new BasicDicomObject();
    private final DicomObject spsKeys = new BasicDicomObject();

    private boolean fuzzySemanticPersonNameMatching;

    private String keyStoreURL = "resource:tls/test_sys_1.p12";
    
    private char[] keyStorePassword = SECRET; 

    private char[] keyPassword; 
    
    private String trustStoreURL = "resource:tls/mesa_certs.jks";
    
    private char[] trustStorePassword = SECRET; 
    
    public CFIND(String name) {
        device = new Device(name);
        executor = new NewThreadExecutor(name);
        remoteAE.setInstalled(true);
        remoteAE.setAssociationAcceptor(true);
        remoteAE.setNetworkConnection(new NetworkConnection[] { remoteConn });

        device.setNetworkApplicationEntity(ae);
        device.setNetworkConnection(conn);
        ae.setNetworkConnection(conn);
        ae.setAssociationInitiator(true);
        ae.setAETitle(name);
        for (int i = 0; i < RETURN_KEYS.length; i++) {
            keys.putNull(RETURN_KEYS[i], null);
        }        
        keys.putNestedDicomObject(Tag.RequestedProcedureCodeSequence,
                new BasicDicomObject());
        keys.putNestedDicomObject(Tag.ScheduledProcedureStepSequence, spsKeys);
        for (int i = 0; i < SPS_RETURN_KEYS.length; i++) {
            spsKeys.putNull(SPS_RETURN_KEYS[i], null);
        }
        spsKeys.putNestedDicomObject(Tag.ScheduledProtocolCodeSequence,
                new BasicDicomObject());
    }

    public final void setLocalHost(String hostname) {
        conn.setHostname(hostname);
    }

    public final void setRemoteHost(String hostname) {
        remoteConn.setHostname(hostname);
    }

    public final void setRemotePort(int port) {
        remoteConn.setPort(port);
    }

    public final void setTlsProtocol(String[] tlsProtocol) {
        conn.setTlsProtocol(tlsProtocol);
    }

    public final void setTlsWithoutEncyrption() {
        conn.setTlsWithoutEncyrption();
        remoteConn.setTlsWithoutEncyrption();
    }

    public final void setTls3DES_EDE_CBC() {
        conn.setTls3DES_EDE_CBC();
        remoteConn.setTls3DES_EDE_CBC();
    }

    public final void setTlsAES_128_CBC() {
        conn.setTlsAES_128_CBC();
        remoteConn.setTlsAES_128_CBC();
    }
    
    public final void setTlsNeedClientAuth(boolean needClientAuth) {
        conn.setTlsNeedClientAuth(needClientAuth);
    }  

    public final void setKeyStoreURL(String url) {
        keyStoreURL = url;
    }
    
    public final void setKeyStorePassword(String pw) {
        keyStorePassword = pw.toCharArray();
    }
    
    public final void setKeyPassword(String pw) {
        keyPassword = pw.toCharArray();
    }
    
    public final void setTrustStorePassword(String pw) {
        trustStorePassword = pw.toCharArray();
    }
    
    public final void setTrustStoreURL(String url) {
        trustStoreURL = url;
    }

    public final void setCalledAET(String called) {
        remoteAE.setAETitle(called);
    }

    public final void setCalling(String calling) {
        ae.setAETitle(calling);
    }

    public final void setUserIdentity(UserIdentity userIdentity) {
        ae.setUserIdentity(userIdentity);
    }

    public final void setPriority(int priority) {
        this.priority = priority;
    }

    public final void setConnectTimeout(int connectTimeout) {
        conn.setConnectTimeout(connectTimeout);
    }

    public final void setMaxPDULengthReceive(int maxPDULength) {
        ae.setMaxPDULengthReceive(maxPDULength);
    }

    public final void setPackPDV(boolean packPDV) {
        ae.setPackPDV(packPDV);
    }

    public final void setAssociationReaperPeriod(int period) {
        device.setAssociationReaperPeriod(period);
    }

    public final void setDimseRspTimeout(int timeout) {
        ae.setDimseRspTimeout(timeout);
    }

    public final void setTcpNoDelay(boolean tcpNoDelay) {
        conn.setTcpNoDelay(tcpNoDelay);
    }

    public final void setAcceptTimeout(int timeout) {
        conn.setAcceptTimeout(timeout);
    }

    public final void setReleaseTimeout(int timeout) {
        conn.setReleaseTimeout(timeout);
    }

    public final void setSocketCloseDelay(int timeout) {
        conn.setSocketCloseDelay(timeout);
    }

    public final void setMaxPDULengthSend(int maxPDULength) {
        ae.setMaxPDULengthSend(maxPDULength);
    }

    public final void setReceiveBufferSize(int bufferSize) {
        conn.setReceiveBufferSize(bufferSize);
    }

    public final void setSendBufferSize(int bufferSize) {
        conn.setSendBufferSize(bufferSize);
    }

    public final void setCancelAfter(int limit) {
        this.cancelAfter = limit;
    }

    public static String[] getLeTs() {
		return LE_TS;
	}

	public void addMatchingKey(int[] tagPath, String value) {
        keys.putString(tagPath, null, value);
    }

    public void addReturnKey(int[] tagPath) {
        keys.putNull(tagPath, null);
    }

    public void addSpsMatchingKey(int tag, String value) {
        spsKeys.putString(tag, null, value);
    }

    public void setFuzzySemanticPersonNameMatching(boolean b) {
        this.fuzzySemanticPersonNameMatching = b;
    }

    public void setTransferSyntax(String[] ts) {
        TransferCapability tc = new TransferCapability(
                UID.ModalityWorklistInformationModelFIND, ts,
                TransferCapability.SCU);
        if (fuzzySemanticPersonNameMatching)
            tc.setExtInfo(EXT_NEG_INFO_FUZZY_MATCHING);
        ae.setTransferCapability(new TransferCapability[]{tc});
    }
    
    public void open() throws IOException, ConfigurationException,
            InterruptedException {
        assoc = ae.connect(remoteAE, executor);
    }

    public void close() throws InterruptedException {
        assoc.release(true);
    }
    public List<DicomObject> query() throws IOException, InterruptedException {
        TransferCapability tc = assoc.getTransferCapabilityAsSCU(
                UID.ModalityWorklistInformationModelFIND);
        if (tc == null) {
            throw new NoPresentationContextException(
                    "Modality Worklist not supported by "
                    + remoteAE.getAETitle());
        }
        System.out.println("Send Query Request:");
        System.out.println(keys.toString());
        DimseRSP rsp = assoc.cfind(UID.ModalityWorklistInformationModelFIND,
                priority, keys, tc.getTransferSyntax()[0], cancelAfter);
        List<DicomObject> result = new ArrayList<DicomObject>();
        while (rsp.next()) {
            DicomObject cmd = rsp.getCommand();
            if (CommandUtils.isPending(cmd)) {
                DicomObject data = rsp.getDataset();
                result.add(data);
                System.out.println("\nReceived Query Response #"
                        + result.size() + ":");
                System.out.println(data.toString());
            }
        }
        return result;
    }

    
    public void initTLS() throws GeneralSecurityException, IOException {
        KeyStore keyStore = loadKeyStore(keyStoreURL, keyStorePassword);
        KeyStore trustStore = loadKeyStore(trustStoreURL, trustStorePassword);
        device.initTLS(keyStore,
                keyPassword != null ? keyPassword : keyStorePassword,
                trustStore);
    }
    
    private static KeyStore loadKeyStore(String url, char[] password)
            throws GeneralSecurityException, IOException {
        KeyStore key = KeyStore.getInstance(toKeyStoreType(url));
        InputStream in = openFileOrURL(url);
        try {
            key.load(in, password);
        } finally {
            in.close();
        }
        return key;
    }

    private static InputStream openFileOrURL(String url) throws IOException {
        if (url.startsWith("resource:")) {
            return CFIND.class.getClassLoader().getResourceAsStream(
                    url.substring(9));
        }
        try {
            return new URL(url).openStream();
        } catch (MalformedURLException e) {
            return new FileInputStream(url);
        }
    }

    private static String toKeyStoreType(String fname) {
        return fname.endsWith(".p12") || fname.endsWith(".P12")
                 ? "PKCS12" : "JKS";
    }
}

