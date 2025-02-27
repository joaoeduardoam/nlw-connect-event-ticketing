
# 🎟 Event Ticketing System

Project developed during NLW Connect 2025 by Rocketseat.

## 📌 About the Project

The Event Ticketing System is a platform for issuing and managing event tickets. It also generates a referral ranking report, allowing organizers to track which participants have invited the most guests.

## 🚀 Features

    📩 Ticket issuance for events
    📊 Referral ranking report generation
    🔍 Event management
    
## ✅ Functional Requirements

### 📝 Registration

    👤 Users can register for an event using their name and email.

### 🔗 Referral Link Generation

    🔄 Users can generate a unique referral link (one per registrant).

### 🏆 Referral Ranking

    📌 Users can view the ranking of referrals.

### 👥 Viewing Referrals

    📊 Users can see the number of people who registered using their referral link.

### ⚙️ Event CRUD

    ➕ Create a new event
    📜 List all available events
    🔍 Retrieve event details by ID
    🏷️ Retrieve event details by Pretty Name

### 🎫 Complete Registration

    📝 Users can register for an existing event using their name and email.
    🔄 If a user already exists in the database, their data will be retrieved automatically.
    ❌ Users cannot register twice for the same event (conflict error).
    ✅ Upon successful registration, a JSON response with the event registration number is returned.

### 🏅 Generate Ranking of Registrants

    📊 Generate a ranking based on the number of referrals per user.
    🥇 Top 3 users will be highlighted as gold, silver, and bronze winners.

### 📈 Generate Statistics on Referrals

    🔍 Retrieve the number of registrants referred by a particular user (USERID).
    📌 Display their position in the overall ranking.

## 💻Running locally

### ⬇️ Clone the project

```bash
  git clone https://github.com/joaoeduardoam/nlw-connect-event-ticketing.git
```

### 📂 Enter the project directory

```bash
  cd nlw-connect-event-ticketing

```

### 🐳 Start the Application with Docker

```bash
  docker compose up
```


## 📖 API Documentation


### 🆕 Creating a new event

```http
  POST /events
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `title` | `string` | **Mandatory**. Event name |
| `location` | `string` | **Mandatory**. Event location |
| `price` | `double` | **Mandatory**. Event price |
| `startDate` | `string` | Event start date |
| `endDate` | `string` | Event end date |
| `startTime` | `string` | Event start time |
| `endTime` | `string` | Event end time |


##### Request Example
```json
{
  "title": "CodeCraft Summit 2025",
  "location": "Online",
  "price": 0.0,
  "startDate": "16-03-2025",
  "endDate": "20-03-2025",
  "startTime": "19:00:00",
  "endTime": "21:00:00"
}
```
##### Response Example
```json
{
  "id": 1,
  "title":"CodeCraft Summit 2025",
  "prettyName":"codecraft-summit-2025",
  "location":"Online",
  "price":0.0,
  "startDate":"16-03-2025",
  "endDate":"16-03-2025",
  "startTime":"19:00:00"
  "endTime":"21:00:00"
}
```

### 📜 Lists all events

```http
  GET /events
```
##### Response Example
```json
[
  {
    "id": 1,
    "title":"CodeCraft Summit 2025",
    "prettyName":"codecraft-summit-2025",
    "location":"Online",
    "price":0.0,
    "startDate":"16-03-2025",
    "endDate":"16-03-2025",
    "startTime":"19:00:00"
    "endTime":"21:00:00"
  },
  ...
]
```

### 🔍 Retrieves an event by its Pretty Name

```http
  GET /events/${prettyName}
```
##### Response Example
```json
{
  "id": 1,
  "title":"CodeCraft Summit 2025",
  "prettyName":"codecraft-summit-2025",
  "location":"Online",
  "price":0.0,
  "startDate":"16-03-2025",
  "endDate":"16-03-2025",
  "startTime":"19:00:00",
  "endTime":"21:00:00"
}
```

### 📝 Register for the Event  (No Referral)

```http
  POST /subscription/${prettyName}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | **Mandatory**. Registered name |
| `email` | `string` | **Mandatory**. Registered email |

Request Example

```json
{
   "name":"John Doe",
   "email":"john@doe.com"
}
```

Response Example
```json
 
{
  "subscriptionNumber": 1,
  "event": {
      "eventId": 1,
      "title": "CodeCraft Summit 2025",
      "prettyName": "codecraft-summit-2025",
      "location": "Online",
      "price": 0.0,
      "startDate": "2025-03-16",
      "endDate": "2025-03-16",
      "startTime": "19:00:00",
      "endTime": "21:00:00"
  },
  "subscriber": {
      "userId": 1,
      "name": "John Doe",
      "email": "john@doe.com"
  },
  "indication": null,
  "designation": "http://codecraft-summit-2025.com/subscription/indication=1"
}

```

### 🔗 Register for the Event (With Referral)

```http
  POST /subscription/${prettyName}/{userId}
```
Request Example


```json
{
   "name":"John Doe Jr",
   "email":"johnjr@doe.com"
}
```

Response Example
```json
 
{
  "subscriptionNumber": 2,
  "event": {
      "eventId": 1,
      "title": "CodeCraft Summit 2025",
      "prettyName": "codecraft-summit-2025",
      "location": "Online",
      "price": 0.0,
      "startDate": "2025-03-16",
      "endDate": "2025-03-16",
      "startTime": "19:00:00",
      "endTime": "21:00:00"
  },
  "subscriber": {
      "userId": 2,
      "name": "John Doe Jr",
      "email": "johnjr@doe.com"
  },
  "indication": {
      "userId": 1,
      "name": "John Doe",
      "email": "john@doe.com"
  }
  "designation": "http://codecraft-summit-2025.com/subscription/indication=2"
}

```
### 🏆 Generates Ranking of Registrants

```http
  GET /subscription/${prettyName}/ranking
```
##### Response Example
```json
[
    {
        "userId": 1,
        "userName": "John Doe",
        "indications": 4
    },
    {
        "userId": 2,
        "userName": "John Doe Jr",
        "indications": 2
    },
    {
        "userId": 3,
        "userName": "Mary Doe",
        "indications": 1
    }
]
```

### 📊 Retrieves User's Position in the Ranking

```http
  GET /subscription/${prettyName}/ranking/{$userId}
```
##### Response Example
```json
{
    "userName": "John Doe",
    "indications": 4,
    "rankingPosition": 1
}
```


