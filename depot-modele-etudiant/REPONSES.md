# Réponses — Évaluation POO : héritage, polymorphisme, transtypage

- Matricule : ISEPAT202603271
- Nom et prénom :Niang Baba
- N (deux derniers chiffres du matricule) : 71

> Rédigez vos justifications **avec vos propres mots**. Elles serviront de base à l'échange oral.

## Exercice 1 — A. Affichage prédit

Écrivez ci-dessous, entre les deux lignes de trois accents graves, **une ligne par ligne affichée**, dans l'ordre.
Ne modifiez pas les lignes de trois accents graves.

```text
 A vehicule
 F null 0
 E moto 171
 Moto3
 vehicule
 moto
 C3
 C2
 D-vehicule
 A vehicule
 F null 0
 E moto 171
 true false
 true
 A vehicule
 B vehicule
 A vehicule
 B vehicule
 4
 

```

## Exercice 1 — A. Justifications

1. Ligne qui commence par « F » :Le constructeur de vehicule appele demarer(). Grace au polymorphisme cest la methode  redefinie dans moto qui s'execute.Mais aussi je pense que les attribut de moto ne sont peut etre pas initialises.
2. Ligne « C3 » : ici, comme que la method est redefinie dans Moto, il retourn douc C3.
3. Ligne « C2 » : ici grace au cast  v.comparer((Moto)v) appelle comparer (Moto). cette methode est heritie de vehicule donc elle retourne C
4. Ligne qui commence par « D- » : categorie() est une méthode statique. Elle dépend du type de référence Vehicule, et non du type réel Moto.
5. Pourquoi des lignes « A », « F », « E » apparaissent avant « true false » :o.equals(v) retourne true, car les deux références désignent le même objet.

new Moto() crée un deuxième objet. Son constructeur s'exécute avant la comparaison, d'où les trois lignes supplémentaires.

o == new Moto() retourne false, car les références désignent deux objets différents.

Ensuite, toString().startsWith("Moto@") retourne true, car la représentation par défaut de l'objet commence par Moto@.

## Exercice 1 — B. Transtypage

Colonne « Compile ? » : `oui` ou `non`. Colonne « Exécution » : `OK`, `exception` (en précisant laquelle), ou `-` si le code ne compile pas.

| n° | Compile ? | Exécution | Justification |
|----|-----------|-----------|---------------|
| 1  |     oui   |           |  ok           |
| 2  |      non  |           |   -           |
| 3  |      oui  |           |         ok    |
| 4  |  oui      |           |ClassCastException               |
| 5  |     oui   |           |  classCastException             |
| 6  |   oui     |           |   ClassCastException            |
| 7  |    non    |           |          -    |
| 8  |     oui   |           |        ok     |
