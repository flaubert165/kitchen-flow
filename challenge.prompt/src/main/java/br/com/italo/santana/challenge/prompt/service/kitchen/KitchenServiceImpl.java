package br.com.italo.santana.challenge.prompt.service.kitchen;

import br.com.italo.santana.challenge.prompt.domain.Order;
import br.com.italo.santana.challenge.prompt.enums.EventType;
import br.com.italo.santana.challenge.prompt.interfaces.delivery.CourierService;
import br.com.italo.santana.challenge.prompt.interfaces.kitchens.KitchenService;
import br.com.italo.santana.challenge.prompt.interfaces.shelves.ShelfService;
import br.com.italo.santana.challenge.prompt.util.PrintUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class that receives orders to cook and to notify the couriers.
 */
@Service
public class KitchenServiceImpl implements KitchenService {

    private final static Logger LOG = LoggerFactory.getLogger(KitchenService.class.getSimpleName());
    private ShelfService shelvesService;
    private CourierService courierService;

    @Autowired
    public KitchenServiceImpl(ShelfService shelvesService, CourierService courierService) {
        this.shelvesService = shelvesService;
        this.courierService = courierService;
    }

    public void cook(Order order) throws InterruptedException {

        PrintUtil.PrintShelvesContent(LOG, EventType.ORDER_RECEIVED_BY_THE_KITCHEN.label, order,
                this.shelvesService.getHotShelf(), this.shelvesService.getColdShelf(), this.shelvesService.getFrozenShelf(), this.shelvesService.getOverflowShelf());

        notifyCouriers();

        this.shelvesService.allocateOrderInAppropriateShelf(order);
    }

    /**
     * Kitchen notify couriers when received an order.
     * @throws InterruptedException
     */
    public void notifyCouriers() throws InterruptedException {
        this.courierService.sendCourier(this.shelvesService.getColdShelf(), this.shelvesService.getHotShelf(),
                                        this.shelvesService.getFrozenShelf(), this.shelvesService.getOverflowShelf());
    }
}
