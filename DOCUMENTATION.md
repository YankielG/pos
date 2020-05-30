Program Obsługi Serwisu

W aplikacji wykorzystano :
- Spring Boot,
- Spring Security,
- Spring Mail,
- JPA,
- Thymeleaf,
- baza danych (MySQL).

Założeniem projektu było, aby stworzyć aplikację umożliwiającą gromadzenie informacji o zgłoszeniach serwisowych oraz ich historii.

W aplikacji zastosowano mechanizm Spring Security który zaadoptowano do potrzeb aplikacji tworząc trzy role : "ADMIN", "MANAGER", "USER".

Zgodnie z założeniem rola "USER" posiada uprawnienia :
- dodanie zgłoszenia do bazy,
- edycja zgłoszenia,
- podgląd detali zgłoszenia,
- podgląd historii zgłoszenia,
- zamknięcie zgłoszenia.

Rola "MANGER" poza w/w jest uprawniona do :
 - przypisania pracownika do usterki,
 - dodawać pracowników,
 - udytować pracowników.
 
 Największe uprawnienia posiada "ADMIN", który poza w/w jest uprawniony do :
 - usuwania usterek z bazy danych,
 - dodawania kategorii zgłoszeń,
 - edycję kategorii zgłoszeń.
 
 Przyjęcie zgłoszenia usterki wymaga od "USERA" podania następujących danych :
 - imię i nazwisko,
 - prawidłowy adres e-mail (walidacja),
 - numeru telefonu (walidacja - tylko cyfry),
 - wyboru typu zgłoszenia (ustawianej uprzednio przez "ADMINA),
 - podania nr seryjnego urządzenia,
 - podania krótkiego opisu usterki.
 
 Po przyjęciu zgłoszenia - zgłoszenie oczekuje na przydzielenie pracownika. Przydziału dokonuje z listy uprzednio wprowadzonych pracowników "MANAGER".
 Po przydzieleniu pracownika - zgłoszenie w bazie otrzymuje status "is_proceed".
 Następnie, po zakończeniu naprawy - następuje zakończenie (zamknięcie) zgłoszenia.
 Odbywa się to poprzez wypełnienie formularza zakończenia zgłoszenia, gdzie po wprowadzeniu opisu dotyczącego naprawy, automatrycznie za pośrednictwem Spring Mail jest wysyłana wiadomość do klienta o zakończeniu naprawy.
 Po zakończeniu naprawy - zgłoszenie zostaje usunięte z listy zgłoszeń i trafia do archiwum.
 
 Na każdym etapie dostępna jest historia oraz szczegóły każdego ze zgłoszeń.
 
 Usunięcie zgłoszenia odbywa się za pośrednictwem zmianu statusu w bazie danych (zgłoszenia nie są usuwane w bazie).
  
