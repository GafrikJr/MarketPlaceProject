@echo off
echo Запуск Maven проекта с Hibernate...

REM Перейти в папку проекта (замени путь на свой)
cd /d "C:\Users\Тимур\Documents\GitHub\MarketPlaceProject"

REM Очистить и собрать проект
mvn clean install

REM Запустить main-класс
mvn exec:java -Dexec.mainClass="com.example.Main"

pause
