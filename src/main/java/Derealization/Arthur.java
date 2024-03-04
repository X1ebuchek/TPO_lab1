package Derealization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Arthur {
    private boolean isConfident;
    private Ear ear = new Ear();

    public boolean lookAt(Object object) {
        if (object.getClass().getSimpleName().equals("PackageCereal")) {
            return true;
        }
        return false;
    }

    public void lookAround(List<Object> env) {
        boolean isFind = false;

        for (var e : env) {
            if (lookAt(e)) {
                isFind = true;
            }
        }
        setConfident(isFind);
    }

    public boolean putFishInEar(Bottle<Fish> fishBottle) {
        if (fishBottle.getContent().getSize().equals(FishSize.SMALL) && isConfident) {
            Fish fish = fishBottle.flush();
            fish.setSwim(false);
            ear.setContent(fish);
            return true;
        }
        return false;
    }

}
