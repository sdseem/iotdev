# Как проверить  
  
## Запуск
Запустить проект в task7 и task7source (необходим JDK17)  
Первый проект запускается на порту 8095, второй на 8094
## Запрос
Отслылаем Get-запрос на порт 8095 и получаем данные из другого сервиса, с которым он общается.  
Например ```curl http://localhost:8095/user-info?user_id=1```