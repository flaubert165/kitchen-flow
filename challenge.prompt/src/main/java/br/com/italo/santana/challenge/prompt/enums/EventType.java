package br.com.italo.santana.challenge.prompt.enums;

/**
 * Entity that represents events to log.
 *
 * @author italosantana
 */
public enum EventType {
    ORDER_RECEIVED_BY_THE_KITCHEN("ORDER_RECEIVED_BY_THE_KITCHEN"),
    ORDER_ALLOCATED_ON_THE_HOT_SHELF("ORDER_ALLOCATED_ON_THE_HOT_SHELF"),
    ORDER_ALLOCATED_ON_THE_COLD_SHELF("ORDER_ALLOCATED_ON_THE_COLD_SHELF"),
    ORDER_ALLOCATED_ON_THE_FROZEN_SHELF("ORDER_ALLOCATED_ON_THE_FROZEN_SHELF"),
    ORDER_ALLOCATED_ON_THE_OVERFLOW_SHELF("ORDER_ALLOCATED_ON_THE_OVERFLOW_SHELF"),
    A_COURIER_WAS_NOTIFIED("A_COURIER_WAS_NOTIFIED"),
    COURIER_HAS_PICKED_UP_THE_ORDER("COURIER_HAS_PICKED_UP_THE_ORDER"),
    ORDER_WAS_DISCARDED("ORDER_WAS_DISCARDED");

    public final String label;

    private EventType(String label) {
        this.label = label;
    }
}
