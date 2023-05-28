package com.pieropan.cursospringaws.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class SnsCreate {

    final AmazonSNS snsClient;

    final String produtoEventosTopico;

    public SnsCreate() {
        snsClient = AmazonSNSClient.builder()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        "http://localhost:4566", Regions.DEFAULT_REGION.name()))
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();

        CreateTopicRequest createTopicRequest = new CreateTopicRequest("produto-eventos");
        produtoEventosTopico = snsClient.createTopic(createTopicRequest).getTopicArn();
        log.info("SNS topic ARN: {}", produtoEventosTopico);
    }

    private static final Logger log = LoggerFactory.getLogger(SnsCreate.class);

    @Bean
    public AmazonSNS snsClient() {
        return this.snsClient;
    }

    @Bean
    public Topic createTopic() {
        return new Topic().withTopicArn(produtoEventosTopico);
    }
}