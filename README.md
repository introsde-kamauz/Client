# Client

The client interface has been developed in a easy command line software.
The scope is to test all the possible REST calls provided by the process centric service.

## REST calls

- **GET /user/** => to get all the users
- **POST /user/** => to register a new user with a name
- **POST /user/{id}/artist/** => add a new artist to the user preferences
- **DELETE /user/{id}/artist/{name}** => remove an artist from the user preferences
- **GET /user/{id}/artist/recom** => to recommend similar artists from the user preferences
- **GET /user/{id}/event/{origin}** => to recommend events for the artists in the user preferences
- **GET /motivation** => to obtain a random quote
- **GET /user/{id}/artist** => to get user preferences
- **POST /user/{id}/evaluate** => to evaluate a recommended artist from the user
- **GET /user/{id}/evaluate** => to get all the evaluations given from a user to his recommended artists

## Test

```
USER ADDED SUCCESSFULLY
Number of users: 2

PREFERENCES ADDED SUCCESSFULLY
[{"id":"331163","name":"Metallica"},{"id":"306316","name":"Black Stone Cherry"},{"id":"425252","name":"Avenged Sevenfold"}]

PREFERENCES REMOVED SUCCESSFULLY
[{"id":"331163","name":"Metallica"}]

ARTISTS RECOMMENDED SUCCESSFULLY
[{"id":"509644","name":"\"Guns N' Roses\""},{"id":"276130","name":"\"AC/DC\""},{"id":"468146","name":"\"Red Hot Chili Peppers\""},{"id":"438390","name":"\"Iron Maiden\""},{"id":"74172","name":"\"System of a Down\""},{"id":"29315","name":"\"Foo Fighters\""},{"id":"1012485","name":"\"Slipknot\""},{"id":"365190","name":"\"Ozzy Osbourne\""},{"id":"202975","name":"\"Korn\""},{"id":"312553","name":"\"Pearl Jam\""},{"id":"269937","name":"\"Green Day\""},{"id":"224919","name":"\"Aerosmith\""},{"id":"455175","name":"\"Disturbed\""},{"id":"288216","name":"\"Pantera\""},{"id":"422558","name":"\"The Offspring\""},{"id":"337267","name":"\"Kiss\""},{"id":"117140","name":"\"Megadeth\""},{"id":"219230","name":"\"Muse\""},{"id":"449005","name":"\"Def Leppard\""},{"id":"317102","name":"\"Marilyn Manson\""},{"id":"469904","name":"\"Queen\""},{"id":"253846","name":"\"Radiohead\""},{"id":"263609","name":"\"Bon Jovi\""},{"id":"444406","name":"\"Papa Roach\""},{"id":"407601","name":"\"Nickelback\""},{"id":"233074","name":"\"Smashing Pumpkins\""},{"id":"496981","name":"\"Alice In Chains\""},{"id":"185559","name":"\"Van Halen\""},{"id":"295329","name":"\"Scorpions\""},{"id":"379603","name":"\"The Rolling Stones\""},{"id":"11557","name":"\"Rammstein\""},{"id":"468296","name":"\"Limp Bizkit\""},{"id":"99952","name":"\"Deep Purple\""},{"id":"425252","name":"\"Avenged Sevenfold\""},{"id":"36137","name":"\"Slayer\""},{"id":"197928","name":"\"Coldplay\""},{"id":"241755","name":"\"Nine Inch Nails\""},{"id":"212333","name":"\"Evanescence\""},{"id":"555021","name":"\"The Killers\""},{"id":"330423","name":"\"Lynyrd Skynyrd\""},{"id":"69685","name":"\"The Who\""},{"id":"182968","name":"\"Eminem\""},{"id":"109416","name":"\"Mötley Crüe\""},{"id":"479410","name":"\"blink-182\""},{"id":"313183","name":"\"Judas Priest\""},{"id":"479466","name":"\"Queens of the Stone Age\""},{"id":"544909","name":"\"Weezer\""},{"id":"368333","name":"\"Stone Temple Pilots\""},{"id":"246083","name":"\"Rob Zombie\""},{"id":"313388","name":"\"U2\""}]


get recommended events
Response code: 200
4) [{"city":"\"Barcelona, Spain\"","description":null,"distance":"\"731 mi\"","duration":"\"11 hours 36 mins\"","latitude":41.3624135,"longitude":2.1556646,"max_temperature":39.2,"min_temperature":4.0,"name":"\"Metallica with Kvelertak at Palau Sant Jordi (February 7, 2018)\"","precipitations":"\"Sunny\"","startdate":"\"2018-02-07\"","type":"\"Concert\"","venue":"\"Palau Sant Jordi\""},{"city":"\"Turin, Italy\"","description":null,"distance":"\"224 mi\"","duration":"\"3 hours 43 mins\"","latitude":45.0420611,"longitude":7.6525552,"max_temperature":33.8,"min_temperature":1.0,"name":"\"Metallica at Pala Alpitour (February 10, 2018)\"","precipitations":"\"Fog\"","startdate":"\"2018-02-10\"","type":"\"Concert\"","venue":"\"Pala Alpitour\""},{"city":"\"Casalecchio di Reno, Italy\"","description":null,"distance":"\"127 mi\"","duration":"\"2 hours 1 min\"","latitude":44.4856679,"longitude":11.248918,"max_temperature":39.2,"min_temperature":4.0,"name":"\"Metallica at Unipol Arena (February 12, 2018)\"","precipitations":"\"Light drizzle\"","startdate":"\"2018-02-12\"","type":"\"Concert\"","venue":"\"Unipol Arena\""},{"city":"\"Casalecchio di Reno, Italy\"","description":null,"distance":"\"127 mi\"","duration":"\"2 hours 1 min\"","latitude":44.4856679,"longitude":11.248918,"max_temperature":39.2,"min_temperature":4.0,"name":"\"Metallica at Unipol Arena (February 14, 2018)\"","precipitations":"\"Light drizzle\"","startdate":"\"2018-02-14\"","type":"\"Concert\"","venue":"\"Unipol Arena\""},{"city":"\"Mannheim, Germany\"","description":null,"distance":"\"394 mi\"","duration":"\"6 hours 45 mins\"","latitude":49.46475,"longitude":8.51793,"max_temperature":30.2,"min_temperature":-1.0,"name":"\"Metallica at SAP Arena (February 16, 2018)\"","precipitations":"\"Sunny\"","startdate":"\"2018-02-16\"","type":"\"Concert\"","venue":"\"SAP Arena\""},{"city":"\"Herning, Denmark\"","description":null,"distance":"\"896 mi\"","duration":"\"14 hours 22 mins\"","latitude":56.1154879,"longitude":8.9547142,"max_temperature":30.2,"min_temperature":-1.0,"name":"\"Metallica at Jyske Bank Boxen (March 27, 2018)\"","precipitations":"\"Light snow\"","startdate":"\"2018-03-27\"","type":"\"Concert\"","venue":"\"Jyske Bank Boxen\""},{"city":"\"Hamburg, Germany\"","description":null,"distance":"\"689 mi\"","duration":"\"11 hours 5 mins\"","latitude":53.5898403,"longitude":9.8987679,"max_temperature":23.0,"min_temperature":-5.0,"name":"\"Metallica at Barclaycard Arena (March 29, 2018)\"","precipitations":"\"Sunny\"","startdate":"\"2018-03-29\"","type":"\"Concert\"","venue":"\"Barclaycard Arena\""},{"city":"\"Vienna, Austria\"","description":null,"distance":"\"414 mi\"","duration":"\"6 hours 44 mins\"","latitude":48.2011611,"longitude":16.333524,"max_temperature":28.4,"min_temperature":-2.0,"name":"\"Metallica at Wiener Stadthalle (March 31, 2018)\"","precipitations":"\"Patchy snow possible\"","startdate":"\"2018-03-31\"","type":"\"Concert\"","venue":"\"Wiener Stadthalle\""},{"city":"\"Prague, Czech Republic\"","description":null,"distance":"\"465 mi\"","duration":"\"7 hours 32 mins\"","latitude":50.104046,"longitude":14.4885149,"max_temperature":32.0,"min_temperature":0.0,"name":"\"Metallica at O2 Arena (April 2, 2018)\"","precipitations":"\"Overcast\"","startdate":"\"2018-04-02\"","type":"\"Concert\"","venue":"\"O2 Arena\""},{"city":"\"Budapest, Hungary\"","description":null,"distance":"\"552 mi\"","duration":"\"8 hours 30 mins\"","latitude":47.5027458,"longitude":19.1057853,"max_temperature":33.8,"min_temperature":1.0,"name":"\"Metallica at Papp Laszlo Budapest Sportarena (April 5, 2018)\"","precipitations":"\"Sunny\"","startdate":"\"2018-04-05\"","type":"\"Concert\"","venue":"\"Papp Laszlo Budapest Sportarena\""},{"city":"\"Stuttgart, Germany\"","description":null,"distance":"\"318 mi\"","duration":"\"5 hours 40 mins\"","latitude":48.79387,"longitude":9.22772,"max_temperature":28.4,"min_temperature":-2.0,"name":"\"Metallica at Schleyer-Halle (April 7, 2018)\"","precipitations":"\"Partly cloudy\"","startdate":"\"2018-04-07\"","type":"\"Concert\"","venue":"\"Schleyer-Halle\""},{"city":"\"Stuttgart, Germany\"","description":null,"distance":"\"318 mi\"","duration":"\"5 hours 40 mins\"","latitude":48.79387,"longitude":9.22772,"max_temperature":28.4,"min_temperature":-2.0,"name":"\"Metallica at Schleyer-Halle (April 9, 2018)\"","precipitations":"\"Partly cloudy\"","startdate":"\"2018-04-09\"","type":"\"Concert\"","venue":"\"Schleyer-Halle\""},{"city":"\"Geneva, Switzerland\"","description":null,"distance":"\"329 mi\"","duration":"\"5 hours 34 mins\"","latitude":46.2,"longitude":6.16667,"max_temperature":33.8,"min_temperature":1.0,"name":"\"Metallica at Palexpo (April 11, 2018)\"","precipitations":"\"Light drizzle\"","startdate":"\"2018-04-11\"","type":"\"Concert\"","venue":"\"Palexpo\""},{"city":"\"Munich, Germany\"","description":null,"distance":"\"214 mi\"","duration":"\"4 hours 0 mins\"","latitude":48.1714582,"longitude":11.5419624,"max_temperature":28.4,"min_temperature":-2.0,"name":"\"Metallica at Olympiahalle (April 26, 2018)\"","precipitations":"\"Mist\"","startdate":"\"2018-04-26\"","type":"\"Concert\"","venue":"\"Olympiahalle\""},{"city":"\"Krakow, Poland\"","description":null,"distance":"\"705 mi\"","duration":"\"11 hours 10 mins\"","latitude":50.0678186,"longitude":19.9885756,"max_temperature":24.8,"min_temperature":-4.0,"name":"\"Metallica at Tauron Arena Krakow (April 28, 2018)\"","precipitations":"\"Overcast\"","startdate":"\"2018-04-28\"","type":"\"Concert\"","venue":"\"Tauron Arena Krakow\""},{"city":"\"Leipzig, Germany\"","description":null,"distance":"\"485 mi\"","duration":"\"7 hours 43 mins\"","latitude":51.3412854,"longitude":12.3534965,"max_temperature":26.6,"min_temperature":-3.0,"name":"\"Metallica at Arena Leipzig (April 30, 2018)\"","precipitations":"\"Sunny\"","startdate":"\"2018-04-30\"","type":"\"Concert\"","venue":"\"Arena Leipzig\""},{"city":"\"Oslo, Norway\"","description":null,"distance":"\"1,185 mi\"","duration":"\"20 hours 56 mins\"","latitude":59.8995185,"longitude":10.6286999,"max_temperature":15.8,"min_temperature":-9.0,"name":"\"Metallica at Telenor Arena (May 2, 2018)\"","precipitations":"\"Freezing fog\"","startdate":"\"2018-05-02\"","type":"\"Concert\"","venue":"\"Telenor Arena\""},{"city":"\"Stockholm, Sweden\"","description":null,"distance":"\"1,234 mi\"","duration":"\"21 hours 19 mins\"","latitude":59.2941674,"longitude":18.0808159,"max_temperature":19.4,"min_temperature":-7.0,"name":"\"Metallica with Kvelertak at Ericsson Globe Arena (May 5, 2018)\"","precipitations":"\"Sunny\"","startdate":"\"2018-05-05\"","type":"\"Concert\"","venue":"\"Ericsson Globe Arena\""},{"city":"\"Stockholm, Sweden\"","description":null,"distance":"\"1,234 mi\"","duration":"\"21 hours 19 mins\"","latitude":59.2941674,"longitude":18.0808159,"max_temperature":19.4,"min_temperature":-7.0,"name":"\"Metallica with Kvelertak at Ericsson Globe Arena (May 7, 2018)\"","precipitations":"\"Sunny\"","startdate":"\"2018-05-07\"","type":"\"Concert\"","venue":"\"Ericsson Globe Arena\""},{"city":"\"Helsinki, Finland\"","description":null,"distance":"\"1,539 mi\"","duration":"\"1 day 5 hours\"","latitude":60.205274,"longitude":24.9301844,"max_temperature":14.0,"min_temperature":-10.0,"name":"\"Metallica at Hartwall Arena (May 9, 2018)\"","precipitations":"\"Light snow\"","startdate":"\"2018-05-09\"","type":"\"Concert\"","venue":"\"Hartwall Arena\""},{"city":"\"Helsinki, Finland\"","description":null,"distance":"\"1,539 mi\"","duration":"\"1 day 5 hours\"","latitude":60.205274,"longitude":24.9301844,"max_temperature":14.0,"min_temperature":-10.0,"name":"\"Metallica at Hartwall Arena (May 11, 2018)\"","precipitations":"\"Light snow\"","startdate":"\"2018-05-11\"","type":"\"Concert\"","venue":"\"Hartwall Arena\""}]


EVALUATION ADDED SUCCESSFULLY
[{"rate":"4","artistName":"\"Nickelback\"","aid":"407601","userId":"1"}]


RANDOM QUOTE GENERATED SUCCESSFULLY
5) "<p>Complaining is silly. Act or forget.  </p>\n"


GET USER ARTISTS
[{"id":"331163","name":"Metallica"}]
```

## Some possible issues
Depending on the number of recommended artists and on the number of events available in the future, the event recommendations requests can be slow to be processed (the computational cost should be O(nm) where n is the number of artists and m the number of events). Heroku have fixed a timeout for each request to 10-20 seconds so in some cases it is possible to get 503 errors for this reason
