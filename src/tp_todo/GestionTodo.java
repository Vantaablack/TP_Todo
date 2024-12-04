package tp_todo;

import java.util.ArrayList;
import java.util.List;

public class GestionTodo {
    private List<Todo> todos;
    private Long currentId;

    public GestionTodo() {
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
        todos.removeIf(todo -> todo.getId().equals(id));
        System.out.println("Exercice supprimé avec succès : ID " + id);
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
}
