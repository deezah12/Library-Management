package semicolon.africa.librarymanagement.dto.response;
import lombok.Data;

@Data
public class ApiResponse {
    boolean isSuccessful;
    Object data;

    public ApiResponse(boolean isSuccessful, Object data){
        this.isSuccessful = isSuccessful;
        this.data = data;
    }
    public ApiResponse(boolean isSuccessful){
        this.isSuccessful = isSuccessful;
    }
}
