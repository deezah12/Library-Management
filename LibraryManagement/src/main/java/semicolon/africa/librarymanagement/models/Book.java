package semicolon.africa.librarymanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
public class Book {
    @JsonIgnore
    @Id private String id;
    private String isbn;
    private String title;
    private String description;
    private int quantity;
    private boolean available;
    @DBRef
    private Publisher  publisher;
    @DBRef
    private Author author;
    @DBRef
    private Category category;

    public  boolean getAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }
}
