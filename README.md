# Микросервисное Приложение с OpenFeign и RabbitMQ

## Описание

Это приложение состоит из двух микросервисов:

1. **Client** — отправляет объект `RandomEntity` в `Server` синхронно через OpenFeign и асинхронно через RabbitMQ.
2. **Server** — принимает объект `RandomEntity`, полученный от `Client`, и логирует его.

### Используемые технологии

- **Spring Boot**
- **OpenFeign**
- **RabbitMQ**
- **Spring AMQP**
- **Docker и Docker Compose**

## Архитектура

### Синхронное взаимодействие (OpenFeign)
- `Client` отправляет HTTP POST-запрос с объектом `RandomEntity` в `Service B`.
- `Server` принимает запрос и логирует полученный объект.

### Асинхронное взаимодействие (RabbitMQ)
- `Client` отправляет объект `RandomEntity` в очередь RabbitMQ.
- `Server` слушает эту очередь и логирует полученный объект.

## Запуск приложения
### Требования
- **Docker и Docker Compose**

### Шаги по запуску
Запустите compose файл
```bash
docker-compose up
```



