# Taxation Service

## Overview
This is a Spring Boot REST API for calculating taxation based on different local tax rules for online betting platforms (traders). The service supports two types of taxation:

1. **General Taxation** - Applied on the total return amount.
2. **Winnings Taxation** - Applied only on the winnings portion.

The API allows users to send a betting request with an amount and odds, and it calculates the possible return amount before and after tax, along with the tax rate and tax amount.

---

## Technologies Used
- **Java 11+** (or newer)
- **Spring Boot 3+**
- **Maven** (for dependency management)
- **Spring Web** (for REST API development)
- **Spring Boot Starter Test** (for unit and integration testing)


---

## How to Run the Project
### Prerequisites
- Install **JDK 11+**
- Install **Maven**
- Use **Postman** or **cURL** for testing the endpoints

### Build the project
```sh
mvn clean install
```

### Run the application
```sh
mvn spring-boot:run
```

By default, the service runs on **http://localhost:8080/**.

---

## API Endpoints
The service provides two taxation models: **General Taxation** and **Winnings Taxation**.

### 1. General Taxation
#### POST `/api/tax/general/rate`
- **Description**: Applies taxation as a percentage of the total possible return.
- **Request Body**:
    ```json
    {
      "traderId": 1,
      "playedAmount": 5,
      "odd": 3.2
    }
    ```
- **Response Example**:
    ```json
    {
      "possibleReturnAmount": 16.0,
      "possibleReturnAmountBefTax": 16.0,
      "possibleReturnAmountAfterTax": 14.4,
      "taxRate": 10,
      "taxAmount": 1.6
    }
    ```
- **Test using cURL**:
    ```sh
    curl -X POST \
         -H "Content-Type: application/json" \
         -d '{"traderId":1, "playedAmount":5, "odd":3.2}' \
         http://localhost:8080/api/tax/general/rate
    ```

#### POST `/api/tax/general/amount`
- **Description**: Applies a fixed taxation amount on the total possible return.
- **Test using cURL**:
    ```sh
    curl -X POST \
         -H "Content-Type: application/json" \
         -d '{"traderId":1, "playedAmount":5, "odd":3.2}' \
         http://localhost:8080/api/tax/general/fixed
    ```

---

### 2. Winnings Taxation
#### POST `/api/tax/winnings/rate`
- **Description**: Applies taxation as a percentage on the winnings only.
- **Test using cURL**:
    ```sh
    curl -X POST \
         -H "Content-Type: application/json" \
         -d '{"traderId":1, "playedAmount":5, "odd":3.2}' \
         http://localhost:8080/api/tax/winnings/rate
    ```

#### POST `/api/tax/winnings/amount`
- **Description**: Applies a fixed taxation amount on the winnings only.
- **Test using cURL**:
    ```sh
    curl -X POST \
         -H "Content-Type: application/json" \
         -d '{"traderId":1, "playedAmount":5, "odd":3.2}' \
         http://localhost:8080/api/tax/winnings/fixed
    ```

---

## Testing the API
You can test the API using:
1. **Postman**: Send a `POST` request with the provided JSON body.
2. **cURL**: Use the provided cURL commands to interact with the API.


---

## License
This project is open-source and available for modification and use.

