package Derealization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bottle <T> {
    private T content = null;

    public boolean isEmpty() {
        return content == null;
    }

    public T flush() {
        T buf = content;
        content = null;
        return buf;
    }
}
