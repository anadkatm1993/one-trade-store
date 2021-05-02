# one-trade-store
 

This Project is responsible for storing Trades information

All apis are exposed as rest services and created using Springboot framework.

H2 Database is used to store / fetch trades information

The below functionalities are provided in this api :

-> Fetch existing trades

-> Save new trades

All new trades are saved after performing certain business validations.


###one-trade-store-api local url: 
http://localhost:8888/v1/trade


## API List

| API | Type | URL     | Controller
| --- | ---- | ---     | ----------
| Get All Trades | GET | /v1/trade |  OneTradeStoreController
| Save Trades    | POST | /v1/trade | OneTradeStoreController



## Steps to run one-trade-store application
1. Take the latest copy of the code from the repository.
2. Open Project.
3. Build the Project using Gradle -> one-trade-store -> Tasks -> Build -> Build
4. Once the Project is build successfully , right click on the main class "Application.java"
    and select Run.
5. Once the server is up , the application would be enabled to run on the provided server port as mentioned in the application.properties file.

## Endpoint details 
1. GET : http://localhost:8888/v1/trade

Sample response :

[
{
"id": 1,
"tradeId": "1",
"version": 2,
"counterPartyId": "Dhawan",
"bookId": "123",
"maturityDate": "2021-05-25",
"createdDate": "2020-05-12",
"expired": "Y"
}
]

2. POST : http://localhost:8888/v1/trade

Sample Request Body :

{
"tradeId": "2",
"version": 2,
"counterPartyId": "Dhawan",
"bookId": "123",
"maturityDate": "25/06/2021",
"createdDate": "23/08/2021",
"expired": "Y"
}

Sample Response :

{
"id": 99,
"tradeId": "2",
"version": 2,
"counterPartyId": "Dhawan",
"bookId": "123",
"maturityDate": "2021-06-25",
"createdDate": "2021-08-23",
"expired": "Y"
}

