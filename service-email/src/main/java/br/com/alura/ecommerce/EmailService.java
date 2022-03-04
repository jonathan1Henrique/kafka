package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class EmailService {

    public static void main(String[] args) {
        var emailService = new EmailService();
        try(var service = new KafkaService("ECOMMERCE_SEND_EMAIL",
                emailService::parse,
                EmailService.class.getSimpleName(),
                Email.class,
                Map.of())){

            service.run();
        }


    }

    private void parse(ConsumerRecord<String, Email> record) {
        System.out.println("-------------------------------- Result --------------------------------");
        System.out.println("Send email");
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Email send");
    }





}
