package be.plutus.api.response;

public class TransactionDetail{

    //TODO Dit is DTO voor een transactiedetail, bevat... alle details :-) zoals locatie etc

    // Opmerking: Ik weet niet of dit oke manier van werken is.
    /*
    * De lijst van transacties moet veel minder details bevatten dan wanneer een transactiedetail opgevraagd wordt.
    * Eerste waar ik aan denk: DTO voor een transactie in de lijst met minder klassevariabelen, én een DTO voor een
    * transactiedetail met meerdere klassevariabelen (vb locatie, wat niet in de lijst moet staan).
    *
    * Dit is waarschijnlijk beter, maar weet niet of het mogelijk is: deze klasse verwijderen, alle variabelen aanmaken
    * in Transaction.java en via de controller beslissen welke klassevariabelen geprint moeten worden in de JSON. Op
    * die manier kan wanneer een detail opgevraagd wordt, elke variabele geprint worden; wanneer een lijst opgevraagd
    * wordt, alleen titel, amount, name van location (niet description, coordinaten etc etc).
    * */
}
