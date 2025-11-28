# Kafka Consumer do módulo 3 e 4
Para utilizar no módulo 3, utilize o hash da data de entrega, essa vesão é para o módulo 4

Hash do módulo 3 (+2 pontos pela data): https://github.com/servicos-spring/modulo3/tree/3396facb460c3d75802f9db2d7b8846d0643cc72

## configuration

ListenerConfig → configura o listener do Kafka, definindo como o consumidor recebe as mensagens vindas do tópico.

## consumer

Consumer → classe responsável por consumir efetivamente as mensagens do Kafka e processá-las quando chegam.

## entity

Person → representa o modelo de dados recebido pelo consumidor, contendo os atributos da pessoa enviados no tópico. (adaptação para possível integração de tudo)