package fr.eql.autom13.demo.java.inheritance;

/*
Une interface est une sorte de classe au contenu
entièrement abstrait.
Tous les attributs si présents, doivent être statiques,
mais il est recommandé de ne pas en mettre.
 */
public interface IntelligentAnimal {

    /*
    Toutes les méthodes d'une interface sont publiques
    et abstraites.
    Il n'est donc pas nécessaire d'écrire ces mots-clé.
     */
    void useTool(String tool);
}
