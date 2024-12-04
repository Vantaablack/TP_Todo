package tp_todo;

import java.util.Scanner;

public class AppTodo {
    public static void main(String[] args) {
        GestionTodo app = new GestionTodo();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Programme de Gestion des Tâches ===");

        while (running) {
            System.out.println("\nVeuillez choisir une option :");
            System.out.println("1. Ajouter une nouvelle tâche");
            System.out.println("2. Modifier une tâche");
            System.out.println("3. Terminer une tâche");
            System.out.println("4. Supprimer une tâche");
            System.out.println("5. Afficher toutes les tâches");
            System.out.println("6. Quitter l'application");

            System.out.print("Votre sélection : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez la description de la tâche : ");
                    String description = scanner.nextLine();
                    app.ajouterTodo(description);
                    break;
                case 2:
                    System.out.print("Entrez l'identifiant de la tâche à modifier : ");
                    Long idModif = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Entrez la nouvelle description : ");
                    String newDescription = scanner.nextLine();
                    app.modifierTodo(idModif, newDescription);
                    break;
                case 3:
                    System.out.print("Entrez l'identifiant de la tâche à terminer : ");
                    Long idTerminer = scanner.nextLong();
                    app.terminerTodo(idTerminer);
                    break;
                case 4:
                    System.out.print("Entrez l'identifiant de la tâche à supprimer : ");
                    Long idSupprimer = scanner.nextLong();
                    app.supprimerTodo(idSupprimer);
                    break;
                case 5:
                    app.listerTodos();
                    break;
                case 6:
                    System.out.println("Fermeture de l'application. À bientôt !");
                    running = false;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez entrer un numéro valide.");
            }
        }
        scanner.close();
    }
}
