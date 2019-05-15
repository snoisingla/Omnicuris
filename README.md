# Omnicuris

## CRUD operations on items

1. Add item :
```
curl -X POST \
  http://localhost:8080/items \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 19e2929d-8248-4b01-a43e-e08397331081' \
  -H 'cache-control: no-cache' \
  -d '{   "name" : "item8",
	"price" : 10,
	"quantity" : 10
}'
```

Response : `201` (Empty)

2. Get item :
```
curl -X GET \
  http://localhost:8080/items/41 \
  -H 'Postman-Token: 77c5271d-acdc-44bf-bd4a-b56bf0f2c704' \
  -H 'cache-control: no-cache'
```

Response : `200` 
```
{
    "name": "item2",
    "price": 10,
    "quantity": 10
}
```
3. Update item :
```
curl -X PUT \
  http://localhost:8080/items/41 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 38b2d05b-07f7-4e1b-9cf7-f4342e911ba1' \
  -H 'cache-control: no-cache' \
  -d '{"quantity" : 30, "name" : "testUser", "price" : 40}'
```

Response : `200` (Empty)

4. Delete item
```
curl -X DELETE \
  http://localhost:8080/items/41 \
  -H 'Postman-Token: 36d7b624-eed2-4f41-886d-2f241d243e51' \
  -H 'cache-control: no-cache'
```
Response : `200` (Empty)

## All items listing

```
curl -X GET \
  http://localhost:8080/items \
  -H 'Postman-Token: 9591fe66-efce-4231-a04c-f80cbc626b14' \
  -H 'cache-control: no-cache'
```

Response : `200`

```
[
    {
        "name": "item2",
        "price": 10,
        "quantity": 10
    },
    {
        "name": "item3",
        "price": 10,
        "quantity": 10
    },
    {
        "name": "item1",
        "price": 10,
        "quantity": 3
    }
]
```

## Single & bulk ordering 

### Single

```
curl -X POST \
  http://localhost:8080/orders \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 986c68e3-ab1a-49a1-a118-75ce8e1947a1' \
  -H 'cache-control: no-cache' \
  -d '{
	"userEmail" : "snoi",
	"items" : [{"id" : 42, "quantity" : 1}]
}'
```
Response : `201` 

### Bulk
```
curl -X POST \
  http://localhost:8080/orders \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: f6392106-1712-4736-a7ac-786bbc121711' \
  -H 'cache-control: no-cache' \
  -d '{
	"userEmail" : "snoi",
	"items" : [{"id" : 42, "quantity" : 1},{"id" : 40, "quantity" : 1}]
}'
```

Response : `201` 

## All orders

```
curl -X GET \
  http://localhost:8080/orders \
  -H 'Postman-Token: 7c607990-c3e9-4a65-b8d6-dcb24fe232d7' \
  -H 'cache-control: no-cache'
 ```
 Response : `200` 

```
[
    {
        "id": 43,
        "userEmail": "snoi",
        "orderItems": [
            {
                "item": {
                    "name": "item1",
                    "price": 10,
                    "quantity": 2
                },
                "quantity": 7
            }
        ]
    },
    {
        "id": 46,
        "userEmail": "snoi",
        "orderItems": [
            {
                "item": {
                    "name": "item1",
                    "price": 10,
                    "quantity": 2
                },
                "quantity": 1
            },
            {
                "item": {
                    "name": "item3",
                    "price": 10,
                    "quantity": 8
                },
                "quantity": 1
            }
        ]
    },
    {
        "id": 49,
        "userEmail": "snoi",
        "orderItems": [
            {
                "item": {
                    "name": "item3",
                    "price": 10,
                    "quantity": 8
                },
                "quantity": 1
            }
        ]
    }
]
```
-------------------------------------------

## Backend : e-commerce website
This is the backend application for Omnicuris Assignment(e-commerce website). This application is built using Spring boot.

## Database
PostgreSQL is being used for persistent storage.

### Step 1: Install and setup PostgreSQL :
1. Install psql
2. Create username postgres and password admin
3. Create database omnicuris and connect to this database

```
psql -U postgres
admin
create database omnicuris
\connect omnicuris
```

### Step 2: Run service using Eclipse IDE :
1. Download and install Eclipse Java EE IDE for Web Developers.
2. Clone the project
3. Run Eclipse. Go to File -> Import -> Maven -> Existing Maven Projects and select the cloned folder
4. Use Eclipse -> Run to start the server


