package fairyShop.models;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {

        List<Instrument> instruments = helper.getInstruments().stream().filter(i -> !i.isBroken()).collect(Collectors.toList());

        while (helper.canWork() && instruments.iterator().hasNext()) {

            Instrument currentInstrument = instruments.iterator().next();
           // instruments.remove(currentInstrument);
            while (!present.isDone()) {
                helper.work();
                present.getCrafted();
                currentInstrument.use();

                if (!helper.canWork()) {
                    break;
                }
                if (currentInstrument.isBroken()) {
                    currentInstrument = instruments.iterator().next();
                   /* if (instruments.size() >= 1) {
                        currentInstrument = instruments.iterator().next();
                        instruments.remove(currentInstrument);
                    } else {
                        break;
                    }*/
                }
            }
            if (present.isDone()) {
                break;
            }
        }
    }
}
