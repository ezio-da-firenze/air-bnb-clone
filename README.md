# AirBnB Clone - Backend API

A comprehensive hotel booking management system built with Spring Boot, featuring dynamic pricing, inventory management, and secure payment processing.

## 🚀 Features

### User Management
- **Authentication & Authorization**: JWT-based authentication with access and refresh tokens
- **Role-Based Access Control**: Separate roles for guests and hotel managers
- **Profile Management**: Update user profiles with personal information
- **Guest Management**: Create and manage travel companions for bookings

### Hotel Management (Admin)
- **Hotel CRUD Operations**: Create, read, update, and delete hotels
- **Room Management**: Manage different room types with amenities and pricing
- **Hotel Activation**: Activate hotels to make them available for booking
- **Inventory Control**: Manage room availability and pricing for up to a year in advance

### Booking System
- **Multi-Step Booking Flow**:
  1. Initialize booking with room and date selection
  2. Add guest information
  3. Secure payment processing
  4. Booking confirmation
- **Booking States**: Reserved → Guests Added → Payments Pending → Confirmed
- **Cancellation & Refunds**: Cancel confirmed bookings with automatic refund processing
- **Booking History**: View all past and current bookings

### Dynamic Pricing Engine
Implements multiple pricing strategies using the Decorator pattern:
- **Base Pricing**: Starting price based on room type
- **Surge Pricing**: Admin-controlled surge factors
- **Occupancy-Based**: 20% increase when occupancy > 80%
- **Urgency Pricing**: 15% increase for bookings within 7 days
- **Holiday Pricing**: 25% increase during holidays

### Search & Discovery
- **Hotel Search**: Search by city, dates, and number of rooms
- **Availability Checking**: Real-time inventory validation
- **Price Display**: Calculated average prices for date ranges
- **Detailed Hotel Info**: View hotel amenities, room options, and pricing

### Payment Integration
- **Stripe Integration**: Secure payment processing via Stripe Checkout
- **Webhook Handling**: Automatic booking confirmation on successful payment
- **Refund Processing**: Automated refunds for cancellations

### Reporting & Analytics
- **Hotel Reports**: Generate booking and revenue reports
- **Date Range Filtering**: Analyze performance over custom periods
- **Metrics**: Total bookings, total revenue, average revenue per booking

## 🛠️ Technology Stack

- **Framework**: Spring Boot 3.4.0
- **Language**: Java 21
- **Database**: PostgreSQL
- **Security**: Spring Security with JWT
- **Payment**: Stripe API
- **Documentation**: SpringDoc OpenAPI (Swagger)
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven

### Key Dependencies
```xml
<dependencies>
    <!-- Spring Boot Starters -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    
    <!-- JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.12.6</version>
    </dependency>
    
    <!-- Stripe Payment -->
    <dependency>
        <groupId>com.stripe</groupId>
        <artifactId>stripe-java</artifactId>
        <version>28.2.0</version>
    </dependency>
    
    <!-- Database -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
    
    <!-- API Documentation -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.8.3</version>
    </dependency>
</dependencies>
```

## 📋 Prerequisites

- Java 21 or higher
- PostgreSQL 12 or higher
- Maven 3.9+
- Stripe account for payment processing

## ⚙️ Configuration

Create or update `src/main/resources/application.properties`:
```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/airBnb
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server Configuration
server.servlet.context-path=/api/v1

# JWT Configuration
jwt.secretKey=your_secret_key_here_minimum_256_bits

# Stripe Configuration
stripe.secret.key=your_stripe_secret_key
stripe.webhook.secret=your_stripe_webhook_secret

# Frontend URL
frontend.url=http://localhost:3000
```

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd airBnbApp
```

### 2. Set Up Database
```sql
CREATE DATABASE airBnb;
```

### 3. Configure Environment Variables
Update the `application.properties` file with your credentials.

### 4. Build the Project
```bash
./mvnw clean install
```

### 5. Run the Application
```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080/api/v1`

## 📚 API Documentation

Once the application is running, access the Swagger UI documentation at:
```
http://localhost:8080/api/v1/swagger-ui.html
```

### API Endpoints Overview

#### Authentication
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/signup` | Create new account |
| POST | `/auth/login` | Login with credentials |
| POST | `/auth/refresh` | Refresh access token |

#### User Profile
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users/profile` | Get current user profile |
| PATCH | `/users/profile` | Update profile |
| GET | `/users/myBookings` | Get user's bookings |

#### Guest Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users/guests` | List all guests |
| POST | `/users/guests` | Add new guest |
| PUT | `/users/guests/{id}` | Update guest |
| DELETE | `/users/guests/{id}` | Remove guest |

#### Hotel Browsing (Public)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/hotels/search` | Search available hotels |
| GET | `/hotels/{id}/info` | Get hotel details |

#### Booking Flow
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/bookings/init` | Initialize booking |
| POST | `/bookings/{id}/addGuests` | Add guests |
| POST | `/bookings/{id}/payments` | Initiate payment |
| GET | `/bookings/{id}/status` | Check booking status |
| POST | `/bookings/{id}/cancel` | Cancel booking |

#### Admin - Hotel Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/admin/hotels` | Create hotel |
| GET | `/admin/hotels` | List owned hotels |
| GET | `/admin/hotels/{id}` | Get hotel details |
| PUT | `/admin/hotels/{id}` | Update hotel |
| DELETE | `/admin/hotels/{id}` | Delete hotel |
| PATCH | `/admin/hotels/{id}/activate` | Activate hotel |

#### Admin - Room Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/admin/hotels/{hotelId}/rooms` | Create room |
| GET | `/admin/hotels/{hotelId}/rooms` | List rooms |
| GET | `/admin/hotels/{hotelId}/rooms/{roomId}` | Get room |
| PUT | `/admin/hotels/{hotelId}/rooms/{roomId}` | Update room |
| DELETE | `/admin/hotels/{hotelId}/rooms/{roomId}` | Delete room |

#### Admin - Inventory Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/admin/inventory/rooms/{roomId}` | Get inventory |
| PATCH | `/admin/inventory/rooms/{roomId}` | Update inventory |

#### Admin - Reporting
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/admin/hotels/{hotelId}/bookings` | List bookings |
| GET | `/admin/hotels/{hotelId}/reports` | Generate report |

#### Webhooks
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/webhook/payment` | Stripe payment webhook |

## 🏗️ Architecture

### Design Patterns
- **Strategy Pattern**: Dynamic pricing strategies
- **Decorator Pattern**: Composable pricing rules
- **Repository Pattern**: Data access abstraction
- **DTO Pattern**: Data transfer objects for API responses

### Project Structure
```
src/main/java/com/parth/projects/airBnbApp/
├── advice/                      # Global exception handling
│   ├── ApiError.java
│   ├── ApiResponse.java
│   ├── GlobalExceptionHandler.java
│   └── GlobalResponseHandler.java
├── config/                      # Configuration classes
│   ├── CorsConfig.java
│   ├── MapperConfig.java
│   └── StripeConfig.java
├── controller/                  # REST Controllers
│   ├── AuthController.java
│   ├── HotelBookingController.java
│   ├── HotelBrowseController.java
│   ├── HotelController.java
│   ├── InventoryController.java
│   ├── RoomAdminController.java
│   ├── UserController.java
│   └── WebhookController.java
├── dto/                        # Data Transfer Objects
├── entity/                     # JPA Entities
│   ├── Booking.java
│   ├── Guest.java
│   ├── Hotel.java
│   ├── HotelMinPrice.java
│   ├── Inventory.java
│   ├── Payment.java
│   ├── Room.java
│   └── User.java
├── exception/                  # Custom Exceptions
├── repository/                 # JPA Repositories
├── security/                   # Security Configuration
│   ├── AuthService.java
│   ├── JWTAuthFilter.java
│   ├── JWTService.java
│   └── WebSecurityConfig.java
├── service/                    # Business Logic
└── strategy/                   # Pricing Strategies
    ├── BasePricingStrategy.java
    ├── HolidayPricingStrategy.java
    ├── OccupancyPricingStrategy.java
    ├── SurgePricingStrategy.java
    ├── UrgencyPricingStrategy.java
    └── PricingService.java
```

### Key Components

#### Security Layer
- JWT-based authentication filter
- Role-based authorization (GUEST, HOTEL_MANAGER)
- Password encryption with BCrypt
- Stateless session management

#### Service Layer
- **BookingService**: Booking lifecycle management
- **HotelService**: Hotel operations
- **InventoryService**: Room availability management
- **PricingService**: Dynamic price calculation
- **CheckoutService**: Payment processing

#### Background Jobs
- **PricingUpdateService**: Scheduled task (hourly) to update inventory prices and hotel minimum prices

### Database Schema

#### Key Entities
- **User**: User accounts with roles (GUEST, HOTEL_MANAGER)
- **Hotel**: Hotel properties with amenities and contact info
- **Room**: Room types in hotels with capacity and amenities
- **Inventory**: Daily room availability and pricing
- **Booking**: Booking records with status tracking
- **Guest**: Travel companions for bookings
- **HotelMinPrice**: Cached minimum daily prices per hotel
- **Payment**: Payment transaction records

#### Entity Relationships
```
User (1) -------- (*) Hotel
User (1) -------- (*) Booking
User (1) -------- (*) Guest
Hotel (1) -------- (*) Room
Hotel (1) -------- (*) Inventory
Room (1) -------- (*) Inventory
Booking (*) -------- (*) Guest
Booking (1) -------- (1) Payment
```

## 🔒 Security

- JWT tokens with 10-minute access token expiry
- 6-month refresh token validity
- HTTP-only cookies for refresh tokens
- Role-based endpoint protection
- Password encryption with BCrypt
- CSRF protection disabled (for API use)
- Stateless session management

### Security Rules
```java
/admin/**        → Requires HOTEL_MANAGER role
/bookings/**     → Requires authentication
/users/**        → Requires authentication
/auth/**         → Public access
/hotels/**       → Public access (browsing)
```

## 🧪 Testing

Run tests with:
```bash
./mvnw test
```

## 📦 Build for Production
```bash
./mvnw clean package -DskipTests
```

The executable JAR will be in `target/airBnbApp-0.0.1-SNAPSHOT.jar`

Run the JAR:
```bash
java -jar target/airBnbApp-0.0.1-SNAPSHOT.jar
```

## 🔄 Scheduled Tasks

The application includes a scheduled job that runs hourly (configurable) to:
- Update inventory prices based on dynamic pricing strategies
- Calculate and cache minimum hotel prices for efficient search

Configuration in `PricingUpdateService.java`:
```java
@Scheduled(cron = "0 0 * * * *")  // Runs every hour
public void updatePrices() {
    // Price update logic
}
```

## 🌐 CORS Configuration

CORS is configured to allow requests from:
- `http://localhost:3000` (React frontend)

Update `CorsConfig.java` to add additional origins:
```java
.allowedOrigins("http://localhost:3000", "https://yourdomain.com")
```

## 📊 Sample Request/Response

### Sign Up
```bash
POST /api/v1/auth/signup
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "password123",
  "name": "John Doe"
}
```

Response:
```json
{
  "timeStamp": "2024-11-01T10:30:00",
  "data": {
    "id": 1,
    "email": "user@example.com",
    "name": "John Doe",
    "gender": null,
    "dateOfBirth": null
  },
  "error": null
}
```

### Search Hotels
```bash
GET /api/v1/hotels/search
Content-Type: application/json

{
  "city": "Mumbai",
  "startDate": "2024-12-01",
  "endDate": "2024-12-05",
  "roomsCount": 2,
  "page": 0,
  "size": 10
}
```

Response:
```json
{
  "timeStamp": "2024-11-01T10:35:00",
  "data": {
    "content": [
      {
        "id": 1,
        "name": "Grand Hotel",
        "city": "Mumbai",
        "photos": ["url1", "url2"],
        "amenities": ["WiFi", "Pool", "Gym"],
        "contactInfo": {
          "address": "123 Main St",
          "phoneNumber": "+91-1234567890",
          "email": "info@grandhotel.com",
          "location": "Mumbai, Maharashtra"
        },
        "price": 5000.0
      }
    ],
    "pageable": {...},
    "totalElements": 1,
    "totalPages": 1
  },
  "error": null
}
```

## 🐛 Known Issues & Future Enhancements

- [ ] Holiday pricing strategy requires integration with holiday API
- [ ] Email notifications for booking confirmations
- [ ] Multi-currency support
- [ ] Advanced search filters (amenities, price range)
- [ ] Review and rating system
- [ ] Image upload functionality
- [ ] Real-time availability updates using WebSockets
- [ ] Mobile app API optimization

## 📝 Best Practices

- Always validate JWT tokens on protected endpoints
- Use pessimistic locking for inventory updates to prevent race conditions
- Handle Stripe webhooks idempotently
- Monitor scheduled tasks for pricing updates
- Implement proper error handling and logging
- Use DTOs to avoid exposing entity details
- Keep sensitive data in environment variables
