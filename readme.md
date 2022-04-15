Spring Enterprise приложение
========================

Приложение представляет собой дневник веса. Так же пользователь может рассчитать свою дневную норму калорий

### Используемые технологии:

- SpringMVC
- SpringSecurity(авторизация через базу данных, доступ на основе ролей)
- SpringDataJpa
- Postgres, HSQL
- JUnit, SpringTest
- Maven
- Bootstrap

### Для запуска проекта:

Скачивем архив
Разархивируем архив
Для создания и заполнения базы данных запускаем initPostgres.sql, populateDB.sql
Переходим в корень и открываем консоль  
Выполняем в cmd: mvn clean install 
Запускаем tomcat  
По адресу http://localhost:8080/manager выбираем наш war и развертывем  
Адрес по которому будет доступна страница : http://localhost:8080/
Для того что бы зайти в роли админа используйте логин mail@Mail.com и пароль 12345
Страница админа будет доступна по адресу http://localhost:8080/admin/users