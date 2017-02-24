### Rakennekuvaus
Sovellus koostuu neljästä logiikkaluokasta, kahdesta käyttöliittymäluokasta ja sovelluksen käynnistävästä Main luokasta.

Main luokka luo ennalta määrättyjen arvojen perusteella logiikka luokan oliot.

Logiikkaluokat on jaettu seuraavasti:
- GameField, joka toimii pelin tärkeimpänä luokkana hoitaen kirjanpitoa.
- HighScores, joka pitää kirjaa pelituloksista.
- Randomizer, (ei vielä toteutettu)
- Ship, joka muodostaa ship olioita joita GameField käyttää hyväkseen.

Käyttöliittymäluokkia on kaksi:
- Game, joka sisältää varsinaisen pelin.
- Menu, jonka kautta käyttäjä voi määrittää nimensä ja aloittaa uuden pelin.

GameField luokka omistaa 1-10 laivaa, joita Game-käyttöliittymäluokka käyttää hyväkseen esim. laivojen piirtämisessä.

Menu luokka omistaa HighScores olion, jotta se voi käyttää HighScores luokan metodeja.
