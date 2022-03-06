# Sistem-rezervare-bilete-avion

Se cere sa se proiecteze un sistem de rezervare a biletelor de avion care sa indeplineasca urmatoarele cerinte:

a.       companiile aeriene se pot loga intr-o sectiune speciala unde sa-si introduca cursele aeriene proprii, la fiecare cursa specificand:
  1.     codul cursei, tipul avionului si numarul de locuri la fiecare clasa, cu preturile aferente

  2.     traseul complet si orele de sosire/plecare pentru fiecare aeroport

  3.     pentru fiecare cursa exista o lista de zile in care opereaza; turul şi returul se considera curse avand coduri diferite; pentru fiecare zbor se tine o lista separata            cu situatia rezervarilor

  4.     exista doua tipuri de discounturi care pot fi setate şi anume: pentru rezervare zboruri dus-intors şi pentru rezervari de tipul „last minute”. Acestea din urma fiind            valabile pentru zborurile care au loc în 24h de la data rezervarii.

b.      in sistem initierea procesului de rezervare de locuri incepe cu specificarea oraselor de plecare şi destinatie, a datelor de plecare şi de sosire, numarul de locuri dorite, defalcat pe trei categorii: adulti, copii, clasa la care se solicita rezervarea, tipul zborului (dus/dus-intors). Introducerea datei de revenire este necesara doar pentru rezervarile dus-intors. Sistemul face validarea datelor de intrare şi trece la cautarea efectiva doar daca acestea sunt corecte

c.       odata ce s-au introdus datele de cautare sistemul va cauta intr-o prima faza toate zborurile care au ruta intre orasele specificate, dupa care pentru fiecare zbor gasit va testa daca in datele specificate se pot face rezervarile cerute, folosind listele de rezervari specifice fiecarei zile a acelui zbor

d.      daca nu s-au gasit zboruri convenabile, sistemul va afisa un mesaj sugestiv şi va propune o alta cautare

e.      daca s-au gasit zboruri convenabile, se va afisa lista acestora, utilizatorul putand sa selecteze zborul dorit din lista. Lista va contine compania aeriana, codul zborului, zilele si orele de plecare si de sosire si pretul (cu reducerile calculate). La zborurile dus-intors, acolo unde exista retur disponibil la aceeasi companie se va afisa dupa zborul dus si cel de intors

f.        daca utilizatorul selecteaza un zbor, ii vor fi prezentate toate detaliile referitoare la acel zbor, plus un formular in care va trebui sa isi introduca nume, prenume, e-mail, telefon, varsta si detaliie de plata. Plata se poate face online cu carte de credit sau prin virament bancar, pentru fiecare din aceste optiuni existand campurile specific necesare

g.       dupa ce se face validarea datelor de intrare si se verifica faptul ca banii au intreat in cont, sistemul va emite un e-mail catre utilizator cu datele rezervarii si in rezervarile specific acelui zbor si zi va opera retinerea locurilor rezervate

h.      in acelasi timp, sistemul poate fi consultat si de personalul de la aeroporturi, in aceasta situatie pentru detaliile de plata acceptandu-se si optiunea de plata casch
