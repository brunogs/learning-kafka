package br.com.learning.kafkalistener.listener;

import br.com.learning.kafkalistener.config.KafkaConsumerConfig;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaFirstListener implements ConsumerSeekAware {

    @KafkaListener(topics = KafkaConsumerConfig.TOPIC_FIRST, groupId = KafkaConsumerConfig.GROUP_TEST)
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }

    @Override
    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback consumerSeekCallback) {
        //if (conditionHere)
        assignments.keySet().stream()
                .filter(partition -> KafkaConsumerConfig.TOPIC_FIRST.equals(partition.topic()))
                .forEach(partition -> consumerSeekCallback.seekToBeginning(KafkaConsumerConfig.TOPIC_FIRST, partition.partition()));
    }

    @Override
    public void registerSeekCallback(ConsumerSeekCallback consumerSeekCallback) {
    }

    @Override
    public void onIdleContainer(Map<TopicPartition, Long> map, ConsumerSeekCallback consumerSeekCallback) {
    }
}
