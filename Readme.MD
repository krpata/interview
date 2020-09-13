# aura-interview 
Projekt sloužící k pohovorům pro ověření znalostí uchazečů.

Skládá se z několika části rozdělených do balíků:
* Basic - cz.aura.interview.basic.phonebook
* JPA - cz.aura.interview.jpa.mediaLibrary
* Spring - cz.aura.interview.spring.zoo







## Basic
Jedná se o malou aplikaci telefonního seznamu s předchystanými jUnit testy nacházející se v balíku cz.aura.interview.basic.phoneboook. S telefonním seznamem se pracuje v paměti a umožnuje jeho stav uložit do DB a načíst z DB. 

### Úkoly
* Máme nového zákazníka, který nechce používat DB, ale rád by si kontakty ukládal a načítal z/do souboru.

### Směřování
* Navrhnout strukturu tříd a refaktorovat v rámci objektově orientovaného návrhu (dědičnost, polymorfismus, zapouzdření, rozhraní, abstraktiní třídy, ...)
* Otestovat chování pomocí PhoneBookTest

#### Vhodné otázky nad řešením:
* Otázky týkající se objektového návrhu (proč rozhraní, abstraktní třída, proč něco nepoužít...)
* Práce se soubory (zavírání zdrojů, try-with-resources)
* Práce s výjimkami (jestli vhodně použil, jaké zná - kontrolované, nekontrolované, try, catch, finally)
* Metoda equals/hashCode (jak funguje defaultní equals? Jak upravit? Různá úskalí)








## JPA
Jedná se o malou aplikaci nad in-memory databází s předchystanými jUnit testy nacházející se v balíku cz.aura.interview.jpa.mediaLibrary

### Úkoly:
* Doplnit ORM mapování pro entity Music a Song
* Implementovat metody LibraryJPAImpl tak, aby prošli testy v LibraryJPAImpleTest

#### Vhodné otázky nad řešením:
* Jakými způsoby lze mapovat objekty na relace
* Jaké anotace jsou nezbytné
* Mapování vazeb OneToMany, ManyToOne
* Jak lze mapovat enum
* Generování primárních klíčů
* Anotace Version
* Metody equals & hashcode
* Fetch strategie
* Cascade strategie
* Použítí parametrů při psaní JPQL
* Životní cyklus entity (lze dobře rozebrat u metody remove)
* Hlavní metody entityManagera pro práci s entitami
