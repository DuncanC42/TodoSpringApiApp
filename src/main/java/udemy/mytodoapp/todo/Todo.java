package udemy.mytodoapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    public Todo() {

    }

    @Id
    @GeneratedValue
    private long id;
    private String username;
    @Size(min = 10, message = "Enter at least 10 Characters...")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Todo(long id, String username, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    //make me a personnalised and clear toString method
    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, username=%s, description=%s, targetDate=%s, done=%s]", id,
                username, description, targetDate, done);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
