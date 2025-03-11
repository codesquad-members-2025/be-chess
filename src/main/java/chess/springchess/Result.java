package chess.springchess;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"isSuccess", "message", "result"})
public class Result<T> {
    private boolean isSuccess;
    String message;
    T result;

    private Result(boolean isSuccess, String message, T result) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.result = result;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public T getResult() {
        return result;
    }

    public static <T> Result<T> onSuccess(T result, String message){
        return new Result<T>(true, message, result);
    }
}
