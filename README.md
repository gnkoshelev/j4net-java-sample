# j4net-java-sample
Код для выступления на java.ural.Meetup @1 с докладом "Интеграция виртуальных машин .NET и Java"

В примере используется версия **Java 1.8+**.

## Dotnet sample
Для повторения бенчмарков потребуется дополнительно *j4net-dotnet-sample* (https://github.com/gnkoshelev/j4net-dotnet-sample).

## Build
1. Собрать проект с использованием Apache Maven: `mvn clean package`.

## Run
Запускаемыми являются только два модуля: hash-spring-service и hash-grpc-server.

### hash-grpc-server
Это gRPC-сервер, используемый из *j4net-dotnet-sample*.
1. Запустить сервис `java -jar <jar-файл>`.
2. Используемый порт **7999**.

### hash-spring-service
Это HTTP JSON сервис, используемый из *j4net-dotnet-sample*.
1. Запустить сервис `java -jar <jar-файл>`.
2. Используемый порт **7998**.
