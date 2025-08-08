package org.example;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class Main {
    public static void main(String[] args) {
        SqsClient sqsClient = SqsClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .build();

        String queueUrl = "https://sqs.ap-northeast-2.amazonaws.com/077672914621/go-queue";

        try {
            SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody("Hello from Java SQS with Gradle by like98100!")
                    .delaySeconds(10)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqsClient.close();
        }


    }
}