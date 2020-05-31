Instrucja uruchomienia aplikacji.

1) Proszę utworzyć bazę danych o dowolnej nazwie.
2) W przypadku bazy POSTGRESQL do utorzonej bazy danych proszę zaimportować dane z pliku postgres_baza.sql
3) Zaimportować projekt do IDE
4) Wypełnić danymi db-template.properties oraz mail-template.properties zmieniając ich nazwy odpowiednia na db.properties i mail.properties.
5) W pliku POM dodać odpowiednie dependency dla używanej bazy danych.
6) W konsoli uruchomić polecenie "mvn clean install"
7) Uruchomić przeglądarkę internetową podając adres : "localhost:8080",
8) Zalogować się do aplikacji w zależności od roli:
 - rola "ADMIN" - username : admin, hasło : admin
 - rola "MANAGER" - username : manager, hasło : manager
 - rola "USER" - username : user1, hasło : user1
