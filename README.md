## Автотесты для API на сайте [reqres.in](https://reqres.in/)
### Технологический стек
________
<img src="images/logo/Java.svg" width="50" height="50"/>   <img src="images/logo/Intelij_IDEA.svg" width="50" height="50"/>   <img src="images/logo/Gradle.svg" width="50" height="50"/>   <img src="images/logo/Rest-Assured.svg" width="50" height="50"/>   <img src="images/logo/JUnit5.svg" width="50" height="50"/>   <img src="images/logo/GitHub.svg" width="50" height="50"/>   <img src="images/logo/Jenkins.svg" width="50" height="50"/>   <img src="images/logo/Allure_Report.svg" width="50" height="50"/>   <img src="images/logo/Allure_TestOps.svg" width="50" height="50"/>   <img src="images/logo/Telegram.svg" width="50" height="50"/>

-----
* Написаны на ``Java`` с использованием фреймворка для модульного тестирования ``JUnit 5`` 
* ``Gradle`` используется для автоматизированной сборки проекта
* Удаленно тест запускается с помощью сервера``Jenkins``
* Система ``Allure Report`` формирует отчет о запуске тестов
* Интеграция с ``Allure TestOps``
* ``Telegram``-бот отправляет уведомление о результатах прохождения тестов

###  Содержание тестов:
1. проверка работы с пользователями
2. проверка работа функционала регистрации

### <img src="images/logo/Jenkins.svg" width="40" height="40"/> Сборка для запуска тестов в [Jenkins](https://jenkins.autotests.cloud/job/016-sun_of_summer-Homework-api-final/) 

<img src="images/screenshots/jenkins_job-new.png" width="80%" height="80%"/>  

### <img src="images/logo/Allure_Report.svg" width="50" height="50"/> Отчёт о прохождении тестов доступен по клику на иконку **"Allure Report"**  

 <img src="images/screenshots/allure-overview-new.PNG" width="80%" height="80%"/>  

 <img src="images/screenshots/allure-behaviors-new.PNG" width="80%" height="80%"/>  

### <img src="images/logo/Allure_TestOps.svg" width="50" height="50"/> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/1970/dashboards)

<img src="images/screenshots/testops-dashboard-new.PNG" width="80%" height="80%"/>

### <img src="images/logo/Telegram.svg" width="30" height="30"/> Уведомления о прохождении тестов в Telegram  

<img src="images/screenshots/telegram-bot-new.PNG" width="30%" height="30%" />  
