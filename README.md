

---

# Devices Price Classification System

This project implements a **Devices Price Classification System** using **Python** for the machine learning model and **Spring Boot** for the backend API. The system allows sellers to classify the price range of devices based on their characteristics by leveraging an ML model trained in Python and served via Flask, while the Spring Boot project manages device records and interacts with the Python model.

---

## Table of Contents
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Technologies Used](#technologies-used)
- [How to Run the Project](#how-to-run-the-project)
- [API Endpoints](#api-endpoints)
- [Clean Architecture and File Organization](#clean-architecture-and-file-organization)
- [Important Features for Prediction](#important-features-for-prediction)
- [Testing](#testing)
- [Model Details](#model-details)

---

## Project Structure

The project is split into two main sections:

### Python:
Handles training the machine learning model and providing predictions via a Flask API.

```
/python/
├── app.py                      # Flask API for ML predictions
├── requirements.txt            # Python dependencies
├── data/                       # Dataset directory (contains test.csv and training data)
├── models/                     # Trained models
├── notebooks/                  # Jupyter Notebooks for model training
├── tests/                      # Unit tests for Flask API
└── utils/                      # Helper functions for preprocessing and validation
```

### Spring Boot:
Manages device data, integrates with the Python model for predictions, and stores the results in a PostgreSQL database.

```
/device_predict/
├── src/main/java/              # Source code for the Spring Boot project
│   ├── adapters/               # Communication adapters (repositories, clients)
│   ├── controller/             # REST API controllers
│   ├── domain/                 # Domain models (e.g., Device)
│   ├── infrastructure/         # Infrastructure configuration (e.g., database configuration)
│   └── usecase/                # Business logic and services
├── src/test/java/              # Unit and integration tests
├── pom.xml                     # Maven build configuration
└── target/                     # Compiled Java files
```

---

## Getting Started

### Prerequisites

Ensure that the following are installed:
- **Python 3.8+**
- **Java 21**
- **PostgreSQL**
- **Maven**

### 1. Clone the Repository

```bash
git clone <repository-url>
cd Device_price_classification_system
```

### 2. Setting Up the Python Environment

Navigate to the `python` folder and install Python libraries:

```bash
pip install -r requirements.txt
```

### 3. Setting Up PostgreSQL

Set up PostgreSQL as follows:

```sql
CREATE DATABASE devices_db;
CREATE USER admin WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE devices_db TO admin;
```

Update `application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/devices_db
spring.datasource.username=admin
spring.datasource.password=password
```

### 4. Running Flask

Navigate to the `python` directory and start Flask:

```bash
python app.py
```

Flask will run on `http://127.0.0.1:5000`.

### 5. Running Spring Boot

Navigate to the `device_predict` directory and run Spring Boot:

```bash
mvn clean install
mvn spring-boot:run
```

Spring Boot will run on `http://localhost:8888`.

---

## API Endpoints

### Flask API (Python)

| Endpoint           | Method | Description                        |
|--------------------|--------|------------------------------------|
| `/predict`         | POST   | Predicts the price range based on device specs. |

#### Sample Request:

```json
{
  "battery_power": 1500,
  "ram": 4096,
  "px_width": 1080,
  "px_height": 1920
}
```

### Spring Boot API (Java)

| Endpoint                | Method | Description                        |
|-------------------------|--------|------------------------------------|
| `/api/devices/`          | GET    | Retrieve all devices.              |
| `/api/devices/{id}`      | GET    | Retrieve a device by ID.           |
| `/api/devices`           | POST   | Add a new device.                  |
| `/api/predict/{deviceId}`| POST   | Predict price and save to database. |

---

## Clean Architecture and File Organization

### Java Project (Spring Boot)

The project follows **Clean Architecture**, which separates concerns into different layers:

1. **Domain Layer**:
   Contains the core business logic and models (e.g., `Device` class). This layer is independent of any framework or database. 

2. **Use Case Layer**:
   Manages the application logic, invoking business rules, and orchestrating interactions between different layers.

3. **Adapter Layer**:
   This includes controllers, repositories, and clients. It communicates with external components such as databases or external APIs (e.g., the Flask API).

4. **Infrastructure Layer**:
   Handles configurations like database setup, transaction management, etc.

---

## Important Features for Prediction

Only **important features** are sent to the Flask API for prediction, as these features have the greatest impact on determining the price range:

- **battery_power**: Total battery capacity (mAh)
- **ram**: Random Access Memory (MB)
- **px_width**: Pixel Resolution Width
- **px_height**: Pixel Resolution Height

These features are extracted from the full `Device` object, which contains many other attributes that are not used for prediction but are stored in the database for device management.

---

## Testing

### Flask (Python)
Run unit tests for the Flask API:

```bash
python -m unittest test_app.py
```

### Spring Boot (Java)
Run tests for the Spring Boot API:

```bash
mvn test
```

---

## Model Details

The machine learning model is trained using **scikit-learn** with a focus on the four important features. The model predicts the price range and returns values from 0 (low) to 3 (very high).

If you have any questions or need further information, please feel free to reach out at [ataleb271@gmail.com](mailto:ataleb271@gmail.com).

---
