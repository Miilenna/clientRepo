public class MQTT {
    public static void main(String[] args) throws Exception {
        String clientEndpoint = "a2lo7xb2znc79y-ats.iot.us-east-1.amazonaws.com";
        String clientId = "esp32/aws-to-esp32";
        String certificateFile = "./clientCertificados/client1-certificate.pem.crt"; 
        String privateKeyFile = "./clientCertificados/client1-private.pem.key"; 

        KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(certificateFile, privateKeyFile);
        AWSIotMqttClient client = new AWSIotMqttClient(clientEndpoint, clientId, pair.keyStore, pair.keyPassword);

        // Connecta el client
        client1.connect();

        // Subscriu-te al tema
        String topicName = "esp32/esp32-to-aws";
        AWSIotQos qos = AWSIotQos.QOS0;

        MyTopic topic = new MyTopic(topicName, qos);
        client1.subscribe(topic);

        System.out.println("Esperant missatges...");
    }
}
