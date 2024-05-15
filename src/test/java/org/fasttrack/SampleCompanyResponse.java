package org.fasttrack;

interface SampleCompanyResponse {

    default String getSampleCompanyResponse() {
        return """
                {
                     "odpis": {
                         "rodzaj": "Aktualny",
                         "naglowekA": {
                             "rejestr": "RejP",
                             "numerKRS": "0000121862",
                             "dataCzasOdpisu": "15.05.2024 20:20:16",
                             "stanZDnia": "22.08.2023",
                             "dataRejestracjiWKRS": "08.07.2002",
                             "numerOstatniegoWpisu": 79,
                             "dataOstatniegoWpisu": "14.07.2023",
                             "sygnaturaAktSprawyDotyczacejOstatniegoWpisu": "RDF/540052/23/943",
                             "oznaczenieSaduDokonujacegoOstatniegoWpisu": "SYSTEM",
                             "stanPozycji": 1
                         },
                         "dane": {
                             "dzial1": {
                                 "danePodmiotu": {
                                     "formaPrawna": "SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA",
                                     "identyfikatory": {
                                         "regon": "00200376400000",
                                         "nip": "5260202393"
                                     },
                                     "nazwa": "JEDEN SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA",
                                     "daneOWczesniejszejRejestracji": {
                                         "nazwaPoprzedniegoRejestru": "RHB",
                                         "numerWPoprzednimRejestrze": "21971",
                                         "sadProwadzacyRejestr": "SĄD REJONOWY DLA M.ST. WARSZAWY XVI WYDZIAŁ GOSPODARCZY-REJESTROWY"
                                     },
                                     "czyProwadziDzialalnoscZInnymiPodmiotami": false,
                                     "czyPosiadaStatusOPP": false
                                 },
                                 "siedzibaIAdres": {
                                     "siedziba": {
                                         "kraj": "POLSKA",
                                         "wojewodztwo": "MAZOWIECKIE",
                                         "powiat": "WARSZAWA",
                                         "gmina": "WARSZAWA",
                                         "miejscowosc": "WARSZAWA"
                                     },
                                     "adres": {
                                         "ulica": "UL. INFLANCKA",
                                         "nrDomu": "4A",
                                         "miejscowosc": "WARSZAWA",
                                         "kodPocztowy": "00-189",
                                         "poczta": "WARSZAWA",
                                         "kraj": "POLSKA"
                                     }
                                 },
                                 "umowaStatut": {
                                     "informacjaOZawarciuZmianieUmowyStatutu": [
                                         {
                                             "zawarcieZmianaUmowyStatutu": "AKT NOTARIALNY SPORZĄDZONY W PAŃSTWOWYM BIURZE NOTARIALNYM W MIKOŁOWIE W DNIU 14 MARCA 1990 ROKU REP. A-2503/90.\\nAKT NOTARIALNY SPORZĄDZONY PRZEZ NOTARIUSZA ANDRZEJA PRZYBYŁĘ, PROWADZĄCEGO KANCELARIĘ NOTARIALNĄ W WARSZAWIE W DNIU 29 MAJA 2002 ROKU, NR. REP. A-2608/2002, ZMIANA PAR.5, PAR.8, PAR.9, PAR.14 PKT 4, PAR.16 PKT 2, PAR.17, UCHYLENIE PAR.21, ZMIANA PAR.22, UCHWALENIE TEKSTU JEDNOLITEGO."
                                         },
                                         {
                                             "zawarcieZmianaUmowyStatutu": "AKT NOTARIALNY SPORZĄDZONY W DNIU 21.04.2004R. PRZEZ NOTARIUSZA ANDRZEJA PRZYBYŁĘ PROWADZĄCEGO KANCELARIĘ NOTARIALNĄ W WARSZAWIE PRZY UL.WSPÓLNEJ 65 M.21, REP.A NR 3486/2004\\nZMIANA § 2 UMOWY SPÓŁKI ORAZ UCHWALENIE TEKSTU JEDNOLITEGO UMOWY SPÓŁKI"
                                         },
                                         {
                                             "zawarcieZmianaUmowyStatutu": "AKT NOTARIALNY SPORZĄDZONY W DNIU 30.06.2004 R. PRZEZ NOTARIUSZA ANDRZEJA PRZYBYŁĘ, PROWADZĄCEGO KANCELARIE NOTARIALNĄ W WARSZAWIE PRZY UL. WSPÓLNEJ 65 L. 21, REP. A-6028/2004, ZMIANA PAR. 5"
                                         },
                                         {
                                             "zawarcieZmianaUmowyStatutu": "1) 26 STYCZNIA 2007 ROKU, REPERTORIUM A - 514/2007, NOTARIUSZ ANDRZEJ PRZYBYŁA, KANCELARIA NOTARIALNA W WARSZAWIE PRZY UL.WSPÓLNEJ 65 M.21\\nNUMERY ZMIENIONYCH PARAGRAFÓW: §5 (DODANIE PKT.15), ZMIANA §9, §10, §13, §14, SKREŚLENIE §16 UST.1 I 2, ZMIANA §17\\n2) 31 STYCZNIA 2007 ROKU, REPERTORIUM A - 621/2007, NOTARIUSZ ANDRZEJ PRZYBYŁA, KANCELARIA NOTARIALNA W WARSZAWIE PRZY UL.WSPÓLNEJ 65 M.21\\nNUMERY ZMIENIONYCH PARAGRAFÓW: §14, §8 ORAZ §18"
                                         },
                                         {
                                             "zawarcieZmianaUmowyStatutu": "AKT NOTARIALNY SPORZĄDZONY DNIA 12.05.2009 R., PRZED NOTARIUSZEM JANEM JODŁOWSKIM PROWADZĄCYM KANCELARIĘ NOTARIALNĄ W WARSZAWIE PRZY ULICY WSPÓLNEJ NUMER 35 LOKAL 14, REPERTORIUM A NR 6486/2009, NUMERY ZMIENIONYCH PARAGRAFÓW §5, §20, UCHWALONY TEKST JEDNOLITY UMOWY SPÓŁKI"
                                         },
                                         {
                                             "zawarcieZmianaUmowyStatutu": "12.02.2020, REP. A NR 1726/2020, NOTARIUSZ JAN JODŁOWSKI, KANCELARIA NOTARIALNA W WARSZAWIE, ZMIANA: § 9 UMOWY SPÓŁKI, UCHWALENIE TEKSTU JEDNOLITEGO UMOWY SPÓŁKI."
                                         },
                                         {
                                             "zawarcieZmianaUmowyStatutu": "29.11.2022 R., REP. A NR 11557/2022, NOTARIUSZ FABIAN WAWRZYNIAK, KANCELARIA NOTARIALNA W WARSZAWIE PRZY UL. PROSTEJ 32, ZMIENIONO §20 UMOWY SPÓŁKI."
                                         }
                                     ]
                                 },
                                 "pozostaleInformacje": {
                                     "czasNaJakiUtworzonyZostalPodmiot": "NIEOZNACZONY",
                                     "informacjaOLiczbieUdzialow": "WIĘKSZĄ LICZBĘ UDZIAŁÓW"
                                 },
                                 "wspolnicySpzoo": [
                                     {
                                         "nazwa": "KPMG CEE HOLDING, A.S.",
                                         "identyfikator": {},
                                         "krs": {
                                             "krs": "0000000000"
                                         },
                                         "posiadaneUdzialy": "125 UDZIAŁÓW O ŁĄCZNEJ WARTOŚCI 1.289.125,00 ZŁOTYCH",
                                         "czyPosiadaCaloscUdzialow": true
                                     }
                                 ],
                                 "kapital": {
                                     "wysokoscKapitaluZakladowego": {
                                         "wartosc": "1289125,00",
                                         "waluta": "PLN"
                                     },
                                     "wniesioneAporty": {
                                         "okreslenieWartosciUdzialowObjetychZaAport": [
                                             {
                                                 "wartosc": "9875,00",
                                                 "waluta": "PLN"
                                             }
                                         ]
                                     }
                                 }
                             },
                             "dzial2": {
                                 "reprezentacja": {
                                     "nazwaOrganu": "ZARZĄD",
                                     "sposobReprezentacji": "DO SKŁADANIA OŚWIADCZEŃ I PODPISYWANIA W IMIENIU UPOWAŻNIONY JEST KAŻDY Z CZŁONKÓW ZARZĄDU SAMODZIELNIE.",
                                     "sklad": [
                                         {
                                             "nazwisko": {
                                                 "nazwiskoICzlon": "L****"
                                             },
                                             "imiona": {
                                                 "imie": "S****"
                                             },
                                             "identyfikator": {
                                                 "pesel": "7**********"
                                             },
                                             "funkcjaWOrganie": "PREZES ZARZĄDU",
                                             "czyZawieszona": false
                                         }
                                     ]
                                 },
                                 "prokurenci": [
                                     {
                                         "nazwisko": {
                                             "nazwiskoICzlon": "S*****"
                                         },
                                         "imiona": {
                                             "imie": "M*********"
                                         },
                                         "identyfikator": {
                                             "pesel": "6**********"
                                         },
                                         "rodzajProkury": "SAMOISTNA"
                                     }
                                 ]
                             },
                             "dzial3": {
                                 "przedmiotDzialalnosci": {
                                     "przedmiotPrzewazajacejDzialalnosci": [
                                         {
                                             "opis": "DZIAŁALNOŚĆ FIRM CENTRALNYCH (HEAD OFFICES) I HOLDINGÓW, Z WYŁĄCZENIEM HOLDINGÓW FINANSOWYCH",
                                             "kodDzial": "70",
                                             "kodKlasa": "10",
                                             "kodPodklasa": "Z"
                                         }
                                     ],
                                     "przedmiotPozostalejDzialalnosci": [
                                         {
                                             "opis": "STOSUNKI MIĘDZYLUDZKIE (PUBLIC RELATIONS) I KOMUNIKACJA",
                                             "kodDzial": "70",
                                             "kodKlasa": "21",
                                             "kodPodklasa": "Z"
                                         },
                                         {
                                             "opis": "DZIAŁALNOŚĆ RACHUNKOWO-KSIĘGOWA; DORADZTWO PODATKOWE",
                                             "kodDzial": "69",
                                             "kodKlasa": "20",
                                             "kodPodklasa": "Z"
                                         },
                                         {
                                             "opis": "DZIAŁALNOŚĆ ZWIĄZANA Z WYSZUKIWANIEM MIEJSC PRACY I POZYSKIWANIEM PRACOWNIKÓW",
                                             "kodDzial": "78",
                                             "kodKlasa": "10",
                                             "kodPodklasa": "Z"
                                         },
                                         {
                                             "opis": "DZIAŁALNOŚĆ PORTALI INTERNETOWYCH",
                                             "kodDzial": "63",
                                             "kodKlasa": "12",
                                             "kodPodklasa": "Z"
                                         },
                                         {
                                             "opis": "BADANIE RYNKU I OPINII PUBLICZNEJ",
                                             "kodDzial": "73",
                                             "kodKlasa": "20",
                                             "kodPodklasa": "Z"
                                         },
                                         {
                                             "opis": "DZIERŻAWA WŁASNOŚCI INTELEKTUALNEJ I PODOBNYCH PRODUKTÓW, Z WYŁĄCZENIEM PRAC CHRONIONYCH PRAWEM AUTORSKIM",
                                             "kodDzial": "77",
                                             "kodKlasa": "40",
                                             "kodPodklasa": "Z"
                                         },
                                         {
                                             "opis": "DZIAŁALNOŚĆ HOLDINGÓW FINANSOWYCH",
                                             "kodDzial": "64",
                                             "kodKlasa": "20",
                                             "kodPodklasa": "Z"
                                         },
                                         {
                                             "opis": "DZIAŁALNOŚĆ USŁUGOWA ZWIĄZANA Z ADMINISTRACYJNĄ OBSŁUGĄ BIURA",
                                             "kodDzial": "82",
                                             "kodKlasa": "11",
                                             "kodPodklasa": "Z"
                                         },
                                         {
                                             "opis": "WYKONYWANIE FOTOKOPII, PRZYGOTOWYWANIE DOKUMENTÓW I POZOSTAŁA SPECJALISTYCZNA DZIAŁALNOŚĆ WSPOMAGAJĄCA PROWADZENIE BIURA",
                                             "kodDzial": "82",
                                             "kodKlasa": "19",
                                             "kodPodklasa": "Z"
                                         }
                                     ]
                                 },
                                 "wzmiankiOZlozonychDokumentach": {
                                     "wzmiankaOZlozeniuRocznegoSprawozdaniaFinansowego": [
                                         {
                                             "dataZlozenia": "03.06.2002",
                                             "zaOkresOdDo": "01.07.2000 - 30.06.2001"
                                         },
                                         {
                                             "dataZlozenia": "07.05.2003",
                                             "zaOkresOdDo": "01.07.2001 - 30.06.2002"
                                         },
                                         {
                                             "dataZlozenia": "23.04.2004",
                                             "zaOkresOdDo": "01.07.2002 - 30.06.2003"
                                         },
                                         {
                                             "dataZlozenia": "16.12.2004",
                                             "zaOkresOdDo": "01.07.2003-30.06.2004"
                                         },
                                         {
                                             "dataZlozenia": "22.02.2006",
                                             "zaOkresOdDo": "01.07.2004 - 30.06.2005"
                                         },
                                         {
                                             "dataZlozenia": "21.12.2006",
                                             "zaOkresOdDo": "01.07.2005 - 30.06.2006"
                                         },
                                         {
                                             "dataZlozenia": "28.12.2007",
                                             "zaOkresOdDo": "01.07.2006 - 30.06.2007"
                                         },
                                         {
                                             "dataZlozenia": "25.02.2009",
                                             "zaOkresOdDo": "01.07.2007 - 30.06.2008"
                                         },
                                         {
                                             "dataZlozenia": "27.11.2009",
                                             "zaOkresOdDo": "01.07.2008-30.06.2009"
                                         },
                                         {
                                             "dataZlozenia": "20.06.2011",
                                             "zaOkresOdDo": "01.07.2009 - 31.12.2010"
                                         },
                                         {
                                             "dataZlozenia": "20.07.2012",
                                             "zaOkresOdDo": "01.01.2011-31.12.2011"
                                         },
                                         {
                                             "dataZlozenia": "02.08.2013",
                                             "zaOkresOdDo": "01.01.2012-31.12.2012"
                                         },
                                         {
                                             "dataZlozenia": "01.07.2014",
                                             "zaOkresOdDo": "OD 01.01.2013 DO 31.12.2013"
                                         },
                                         {
                                             "dataZlozenia": "01.07.2015",
                                             "zaOkresOdDo": "OD 01.01.2014 DO 31.12.2014"
                                         },
                                         {
                                             "dataZlozenia": "29.06.2016",
                                             "zaOkresOdDo": "OD 01.01.2015 DO 31.12.2015"
                                         },
                                         {
                                             "dataZlozenia": "28.06.2017",
                                             "zaOkresOdDo": "OD 01.01.2016 DO 31.12.2016"
                                         },
                                         {
                                             "dataZlozenia": "24.07.2018",
                                             "zaOkresOdDo": "OD 01.01.2017 DO 31.12.2017"
                                         },
                                         {
                                             "dataZlozenia": "27.06.2019",
                                             "zaOkresOdDo": "OD 01.01.2018 DO 31.12.2018"
                                         },
                                         {
                                             "dataZlozenia": "02.07.2020",
                                             "zaOkresOdDo": "OD 01.01.2019 DO 31.12.2019"
                                         },
                                         {
                                             "dataZlozenia": "13.10.2021",
                                             "zaOkresOdDo": "OD 01.01.2020 DO 31.12.2020"
                                         },
                                         {
                                             "dataZlozenia": "11.10.2022",
                                             "zaOkresOdDo": "OD 01.01.2021 DO 31.12.2021"
                                         },
                                         {
                                             "dataZlozenia": "14.07.2023",
                                             "zaOkresOdDo": "OD 01.01.2022 DO 31.12.2022"
                                         }
                                     ],
                                     "wzmiankaOZlozeniuOpiniiBieglegoRewidentaSprawozdaniaZBadania": [
                                         {
                                             "zaOkresOdDo": "01.07.2000 - 30.06.2001"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2001 - 30.06.2002"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2003-30.06.2004"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2004 - 30.06.2005"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2005 - 30.06.2006"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2006 - 30.06.2007"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2007 - 30.06.2008"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2008-30.06.2009"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2009 - 31.12.2010"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2011-31.12.2011"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2012-31.12.2012"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2013 DO 31.12.2013"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2015 DO 31.12.2015"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2016 DO 31.12.2016"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2017 DO 31.12.2017"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2018 DO 31.12.2018"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2019 DO 31.12.2019"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2020 DO 31.12.2020"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2021 DO 31.12.2021"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2022 DO 31.12.2022"
                                         }
                                     ],
                                     "wzmiankaOZlozeniuUchwalyPostanowieniaOZatwierdzeniuRocznegoSprawozdaniaFinansowego": [
                                         {
                                             "zaOkresOdDo": "01.07.2000 - 30.06.2001"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2001 - 30.06.2002"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2002 - 30.06.2003"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2003-30.06.2004"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2004 - 30.06.2005"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2005 - 30.06.2006"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2006 - 30.06.2007"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2007 - 30.06.2008"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2008-30.06.2009"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2009 - 31.12.2010"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2011-31.12.2011"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2012-31.12.2012"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2013 DO 31.12.2013"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2014 DO 31.12.2014"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2015 DO 31.12.2015"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2016 DO 31.12.2016"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2017 DO 31.12.2017"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2018 DO 31.12.2018"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2019 DO 31.12.2019"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2020 DO 31.12.2020"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2021 DO 31.12.2021"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2022 DO 31.12.2022"
                                         }
                                     ],
                                     "wzmiankaOZlozeniuSprawozdaniaZDzialalnosci": [
                                         {
                                             "zaOkresOdDo": "01.07.2000 - 30.06.2001"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2001 - 30.06.2002"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2002 - 30.06.2003"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2003-30.06.2004"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2004 - 30.06.2005"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2005 - 30.06.2006"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2006 - 30.06.2007"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2007 - 30.06.2008"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2008-30.06.2009"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2009 - 31.12.2010"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2011-31.12.2011"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2012-31.12.2012"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2013 DO 31.12.2013"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2014 DO 31.12.2014"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2015 DO 31.12.2015"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2016 DO 31.12.2016"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2017 DO 31.12.2017"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2018 DO 31.12.2018"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2019 DO 31.12.2019"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2020 DO 31.12.2020"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2021 DO 31.12.2021"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2022 DO 31.12.2022"
                                         }
                                     ]
                                 },
                                 "sprawozdaniaGrupyKapitalowej": {
                                     "wzmiankaOZlozeniuSkonsolidowanegoRocznegoSprawozdaniaFinansowego": [
                                         {
                                             "dataZlozenia": "22.02.2007",
                                             "zaOkresOdDo": "01.07.2005-30.06.2006"
                                         },
                                         {
                                             "dataZlozenia": "29.07.2009",
                                             "zaOkresOdDo": "01.07.2006-30.06.2007"
                                         },
                                         {
                                             "dataZlozenia": "25.08.2009",
                                             "zaOkresOdDo": "01.07.2007 - 30.06.2008"
                                         },
                                         {
                                             "dataZlozenia": "07.01.2010",
                                             "zaOkresOdDo": "01.07.2008 - 30.06.2009"
                                         },
                                         {
                                             "dataZlozenia": "13.07.2011",
                                             "zaOkresOdDo": "01.07.2009-31.12.2010"
                                         },
                                         {
                                             "dataZlozenia": "20.07.2012",
                                             "zaOkresOdDo": "01.01.2011-31.12.2011"
                                         },
                                         {
                                             "dataZlozenia": "02.08.2013",
                                             "zaOkresOdDo": "01.01.2012-31.12.2012"
                                         },
                                         {
                                             "dataZlozenia": "10.07.2014",
                                             "zaOkresOdDo": "OD 01.01.2013 DO 31.12.2013"
                                         },
                                         {
                                             "dataZlozenia": "07.08.2015",
                                             "zaOkresOdDo": "OD 01.01.2014 DO 31.12.2014"
                                         },
                                         {
                                             "dataZlozenia": "29.06.2016",
                                             "zaOkresOdDo": "OD 01.01.2015 DO 31.12.2015"
                                         },
                                         {
                                             "dataZlozenia": "11.07.2017",
                                             "zaOkresOdDo": "OD 01.01.2016 DO 31.12.2016"
                                         },
                                         {
                                             "dataZlozenia": "24.07.2018",
                                             "zaOkresOdDo": "OD 01.01.2017 DO 31.12.2017"
                                         },
                                         {
                                             "dataZlozenia": "27.06.2019",
                                             "zaOkresOdDo": "OD 01.01.2018 DO 31.12.2018"
                                         },
                                         {
                                             "dataZlozenia": "02.07.2020",
                                             "zaOkresOdDo": "OD 01.01.2019 DO 31.12.2019"
                                         },
                                         {
                                             "dataZlozenia": "17.11.2021",
                                             "zaOkresOdDo": "OD 01.10.2019 DO 30.09.2020"
                                         }
                                     ],
                                     "wzmiankaOZlozeniuOpiniiBieglegoRewidentaSprawozdaniaZBadania": [
                                         {
                                             "zaOkresOdDo": "01.07.2005-30.06.2006"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2006-30.06.2007"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2007 - 30.06.2008"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2008 - 30.06.2009"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2009-31.12.2010"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2011-31.12.2011"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2012-31.12.2012"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2013 DO 31.12.2013"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2014 DO 01.01.2014"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2015 DO 31.12.2015"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2016 DO 31.12.2016"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2017 DO 31.12.2017"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2018 DO 31.12.2018"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2019 DO 31.12.2019"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.10.2019 DO 30.09.2020"
                                         }
                                     ],
                                     "wzmiankaOZlozeniuUchwalyPostanowieniaOZatwierdzeniuSkonsolidowanegoRocznegoSprawozdaniaFinansowego": [
                                         {
                                             "zaOkresOdDo": "01.07.2005-30.06.2006"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2006-30.06.2007"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2007 - 30.06.2008"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2008 - 30.06.2009"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2009-31.12.2010"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2011-31.12.2011"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2012-31.12.2012"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2013 DO 31.12.2013"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2014 DO 01.01.2014"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2015 DO 31.12.2015"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2016 DO 31.12.2016"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2017 DO 31.12.2017"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2018 DO 31.12.2018"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2019 DO 31.12.2019"
                                         }
                                     ],
                                     "wzmiankaOZlozeniuSprawozdaniaZDzialalnosciSpolkiDominujacej": [
                                         {
                                             "zaOkresOdDo": "01.07.2005-30.06.2006"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2006-30.06.2007"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2007 - 30.06.2008"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2008 - 30.06.2009"
                                         },
                                         {
                                             "zaOkresOdDo": "01.07.2009-31.12.2010"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2011-31.12.2011"
                                         },
                                         {
                                             "zaOkresOdDo": "01.01.2012-31.12.2012"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2013 DO 31.12.2013"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2014 DO 01.01.2014"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2015 DO 31.12.2015"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2016 DO 31.12.2016"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2017 DO 31.12.2017"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2018 DO 31.12.2018"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.01.2019 DO 31.12.2019"
                                         },
                                         {
                                             "zaOkresOdDo": "OD 01.10.2019 DO 30.09.2020"
                                         }
                                     ]
                                 },
                                 "informacjaODniuKonczacymRokObrotowy": {
                                     "dzienKonczacyPierwszyRokObrotowy": "30.09.2024"
                                 }
                             },
                             "dzial4": {},
                             "dzial5": {},
                             "dzial6": {}
                         }
                     }
                 }
                """.trim();
    }
}
