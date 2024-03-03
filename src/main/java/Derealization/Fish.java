package Derealization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.Color;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fish {
    private Color color;
    private boolean isSwim;
    private FishSize size;
}
