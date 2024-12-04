package tp_todo;

public class Todo {
    private Long id;
    private String description;
    private Boolean termine;

    public Todo(Long id, String description) {
        this.id = id;
        this.description = description;
        this.termine = false; 
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isTermine() {
        return termine;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setTermine(Boolean termine) {
        this.termine = termine;
    }

    // Marquer comme terminé
    public void terminer() {
        this.termine = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Description: " + description + " | Statut: " + (termine ? "Terminé" : "En cours");
    }
}
