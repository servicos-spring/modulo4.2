# Kafka Consumer 2
Possui grupId diferente do consumer 1 apra chegar a mensagens nos dois consumidores

## configuration

ListenerConfig → configura o listener do Kafka, definindo como o consumidor recebe as mensagens vindas do tópico.

## consumer

Consumer → classe responsável por consumir efetivamente as mensagens do Kafka e processá-las quando chegam.

## entity

Person → representa o modelo de dados recebido pelo consumidor, contendo os atributos da pessoa enviados no tópico. (adaptação para possível integração de tudo)
