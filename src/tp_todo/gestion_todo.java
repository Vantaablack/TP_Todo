package tp_todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gestion_todo {
    private List<Todo> todos;
    private Long currentId;

    public gestion_todo() {
        this.todos = new ArrayList<>();
        this.currentId = 1L;
    }

    public void ajouterTodo(String description) {
        Todo newTodo = new Todo(currentId, description);
        todos.add(newTodo);
        System.out.println("Nouvel exercice ajouté avec succès : " + newTodo);
        currentId++;
    }

    public void modifierTodo(Long id, String newDescription) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                todo.setDescription(newDescription);
                System.out.println("Exercice modifié : " + todo);
                return;
            }
        }
        System.out.println("Aucun exercice trouvé avec cet identifiant : " + id);
    }

    public void supprimerTodo(Long id) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                todos.remove(todo);
                System.out.println("Exercice supprimé avec succès : ID " + id);
                return;
            }
        }
        System.out.println("Aucun exercice trouvé avec cet identifiant : " + id);
    }

    public void listerTodos() {
        if (todos.isEmpty()) {
            System.out.println("Il n'y a actuellement aucun exercice enregistré.");
        } else {
            System.out.println("Liste des exercices en cours :");
            for (Todo todo : todos) {
                System.out.println(todo);
            }
        }
    }

    public void terminerTodo(Long id) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                todo.terminer();
                System.out.println("L'exercice suivant a été marqué comme terminé : " + todo);
                return;
            }
        }
        System.out.println("Aucun exercice trouvé avec cet identifiant : " + id);
    }

    public static void main(String[] args) {
        gestion_todo app = new gestion_todo();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Programme de Gestion des Exercices ===");

        while (running) {
            System.out.println("\nVeuillez choisir une option :");
            System.out.println("1. Ajouter un nouvel exercice");
            System.out.println("2. Modifier un exercice");
            System.out.println("3. Terminer un exercice");
            System.out.println("4. Supprimer un exercice");
            System.out.println("5. Afficher tous les exercices");
            System.out.println("6. Quitter l'application");

            System.out.print("Votre sélection : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // consomme la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez la description de l'exercice : ");
                    String description = scanner.nextLine();
                    app.ajouterTodo(description);
                    break;
                case 2:
                    System.out.print("Entrez l'identifiant de l'exercice à modifier : ");
                    Long idModif = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Entrez la nouvelle description : ");
                    String newDescription = scanner.nextLine();
                    app.modifierTodo(idModif, newDescription);
                    break;
                case 3:
                    System.out.print("Entrez l'identifiant de l'exercice à terminer : ");
                    Long idTerminer = scanner.nextLong();
                    app.terminerTodo(idTerminer);
                    break;
                case 4:
                    System.out.print("Entrez l'identifiant de l'exercice à supprimer : ");
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
