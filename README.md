# Exercise
------------------------------------------------------
<h1> I - API Rick&Morty </h1> 
* https://rickandmortyapi.com/documentation/

<h1> II - Ce que j'ai mis en place </h1> 
Acces à l'api Rick&Morty au travers du webclient springboot.
<h2>URl:</h2> 

* http://localhost:8089/v1/TestRM    

* http://localhost:8089/swagger-ui.html

* http://localhost:8089/swagger-ui.html#/rick-morty-controller/


<h2>URl UI:</h2> 
* http://localhost:8089/

* http://localhost:8089/v1/charactersUI

* http://localhost:8089/listOneCharacterInputId

* http://localhost:8089/listOneCharacterInputName


<h1> III - Ce qu'il me reste à faire </h1>
Plein de trucs... :(

1 - TEST - Ajout de tests

2 - TEST - Gestion du profil maven pour execution des tests.
Il faut qu'un server soit Up pour qu'ils puissent tourner.
On aurait pu avoir des tests sans server up avec des mocks, 
discution à avoir pour choisir la meilleure stratégie. 

3 - UI - Ajout du Add et Delete de resources, cf. voir 'IV - questions'

4 - MISC - Ajout de comment sur les méthodes etc...

<h1> IV - Questions </h1>
1 - J'ai utilisé l'api Rick&Morty pour pointé dessus.

Bien évidement il n'y a pas la possibilité de faire du Create ou Delete.

Donc je me suis demandé si il ne fallait pas que j'utilise l'api
pour remplir une DB sur laquelle j'aurai fait pointer mon CRUD REST ? 
