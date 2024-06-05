Сделано на основе статьи: https://www.baeldung.com/spring-cloud-bootstrapping

Разработана система из WEB приложения магазин и двух REST микросервисов резервирования на складе и оплаты товара.  
Использован АОП для регистрации действий в системе и измерений времени выполнения методов (в микросервисе shop-service).  
Использовано управление транзакциями при резервировании товара на складе и переводах средств между счетами.
Добавлены ApiGateWay, Eureka и spring config server.
Связь между микросервисами - на spring cloud openfeign
Сделано модульное и интеграционное тестирование (сделаны для bank-service и storage-service). 
Сделано нагрузочное тестирование на всю систему (без WEB части) покупки товара в целом (JMETER).
Использован Spring Actuator.
Кастомные метрики реализованы для shop-service (количество доступов к домашней странице и количество покупок).
Визуализация - Prometheus и Grafana.
Добавлен Spring Integration (сохранение запросов от пользователя в файл)

# Примечание

Папка с настройками application-config должна быть в домашней папке пользователя.
Все настройки микросервисов находятся в ней, в том числе настройки Actuator.  

Рабочая страничка: http://localhost:8080/shop-service

# Для справки

## Запуск Prometheus в Docker 

sudo docker run -d --name=prometheus -p 9090:9090 prom/prometheus

Далее заходим в контейнер: sudo docker exec -it prometheus /bin/sh

Вручную исправляем конфигурацию: vi /etc/prometheus/prometheus.yml

В последней строке вручную меняем IP адрес своего хоста.

Останавливаем контейнер: sudo docker stop prometheus

Запускаем контейнер: sudo docker start prometheus

## Запуск Grafana в Docker

sudo docker run -d --name=grafana -p 3000:3000 grafana/grafana

Стандартные логин/пароль: admin/admin

При настройке соединения также необходимо использовать фактический IP адрес хоста