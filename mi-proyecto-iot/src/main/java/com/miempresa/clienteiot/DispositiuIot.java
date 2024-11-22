package main.java.com.miempresa.clienteiot;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.sample.SampleUtil.SampleUtil;
import com.amazonaws.services.iot.client.sample.SampleUtil.SampleUtil.KeyStorePasswordPair;

public class DispositiuIot{
    private static final String FICHER_CLAU_PRIVADA = "./clientCertificados/client1-private.pem.key";
    private static final String FICHERO_CERTIFICADO_DISPOSITIVO_IOT = "./client1-certificate.pem.cert";
    private static final String ENDPOINT = "a2lo7xb2znc79y-ats.iot.us-east-1.amazonaws.com";
    
    public static final String TOPIC = "miempresa/#";
    public static final String CLIENT_ID = "client1";
    public static final AWSIotQos TOPIC_QOS = AWSIotQos.QOS0;
    
    private static AWSIotMqttClient awsIotClient;

    public static void setClient(AWSIotMqttClient cli) {
        awsIotClient = cli;
    }

    public static void initClient() {
        String cliEP = ENDPOINT;
        String cliId = CLIENT_ID;

        String certFile = FICHERO_CERTIFICADO_DISPOSITIVO_IOT;
        String pKFile = FICHER_CLAU_PRIVADA;

        if(awsIotClient == null && certFile != null && pKFile != null) {
            KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(certFile, pKFile, algorithm);

            awsIotClient = new AWSIotMqttClient(cliEP, cliId, pair.keyStore, pair.keyPassword);
        }

        if(awsIotClient == null) {
            throw new IllegalArgumentException("Error a construir client amb el certificat o les credencials");
        }
    }

    public void conecta() {
        initClient();
        awsIotClient.connect();
    }
    public void subscriu() {
        initClient();
        awsIotClient.connect();
    }
}


