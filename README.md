# Project X - Message Center

## About Project X

Project X is a web application that attempts to tackle the challenges of mass messaging across diverse channels including: e-mail, SMS messaging, mobile app notifications, and native smartphone push notifications.

## Prerequisites

- Git
- Java Development Kit (JDK)

## Installation

1. Clone this repository
2. Create overrides.properties
 - See configuration.properties and jdbc.properties
3. Update `applicationContext.xml`, if necessary
4. Execute `./gradlew assemble` to build `message-center.war`
5. Deploy

## Services

### E-mail

Add the appropriate properties to `overrides.properties`.

### stdout

This service does not have properties to configure.

### Telegram

Add the bot's token to `overrides.properties`

### Other Services

To implement your own messaging service(s)

- Extend `AbstractMessagingService`
- Configure a bean in `applicationContext.xml`
- Add the bean to the `messagingServices` bean (in `applicationContext.xml`)
