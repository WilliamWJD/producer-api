package com.ms.user.producers;

import com.ms.user.domain.User;
import com.ms.user.dto.EmailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.queue}")
    private String routingKey;

    public void publishMessageEmail(User user){
        var emailDto = new EmailDto();
        emailDto.setUserId(user.getUserId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubjetc("Cadastro realizado com sucesso!");
        emailDto.setText(user.getName()+", seja bem vindo(a)! \nagradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
