package Derealization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ear {
    private boolean isEmpty = true;
    private Object content;

    public void setContent(Object content) {
        this.content = content;
        this.isEmpty = false;
    }

}
