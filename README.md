# Assignment 3 - Adapter and Bridge patterns
## Problem
The system sends university announcements using different delivery channels: Email, Telegram, and SMS.

## Bridge
Bridge separates announcement types from delivery channels. New announcement types and new delivery channels can be added independently.
Bridge alone is not enough because LegacySmsService has an incompatible interface.

## Adapter
LegacySmsAdapter allows LegacySmsService to work as a DeliveryChannel.
LegacySmsService is incompatible because it uses transmit(char[], int, String) instead of send(String, String) and returns an error code instead of throwing DeliveryException.
Adapter alone is not enough because it does not separate announcement types from delivery channels.
