package Derealization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ford {
    private final String model = "Transit";
    private Bottle<Fish> fishBottle;

    public void askToPutFish(Arthur arthur) {
        arthur.putFishInEar(fishBottle);
    }
}
