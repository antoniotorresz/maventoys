
<h1 id="openapi-definition">Maven Toys Backend</h1>

Welcome to the API documentation for our Maven Toys System. This system is designed to streamline and automate the various operations involved in managing a toy store, from inventory management to sales tracking and employee relations.

Our API provides a comprehensive suite of services that allow you to interact with the system programmatically. Whether you're looking to integrate our system with your existing e-commerce platform, build a custom user interface, or automate routine tasks, our API has you covered.

This documentation provides detailed information about each API endpoint, including the required parameters, the expected response format, and any potential error codes. All code examples are provided in JavaScript.

The Toy Store Management System is designed to be intuitive and easy to use, but we understand that you might have questions or run into issues. If you do, please don't hesitate to reach out to us. We're here to help you make the most of our system.

Happy coding!


> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.


<!-- Generator: Widdershins v4.0.1 -->

<h1 id="openapi-definition">OpenAPI definition v0</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

Base URLs:

* <a href="http://localhost:8080">http://localhost:8080</a>

<h1 id="openapi-definition-store-controller">store-controller</h1>

## findById

<a id="opIdfindById"></a>

> Code samples

```http
GET http://localhost:8080/stores/{storeId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/stores/{storeId}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/stores/{storeId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/stores/{storeId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /stores/{storeId}`

<h3 id="findbyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|storeId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findbyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## update

<a id="opIdupdate"></a>

> Code samples

```http
PUT http://localhost:8080/stores/{storeId} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "name": "string",
  "city": "string",
  "location": "string",
  "openDate": "2019-08-24T14:15:22Z",
  "active": true
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/stores/{storeId}',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.put('http://localhost:8080/stores/{storeId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/stores/{storeId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /stores/{storeId}`

> Body parameter

```json
{
  "id": 0,
  "name": "string",
  "city": "string",
  "location": "string",
  "openDate": "2019-08-24T14:15:22Z",
  "active": true
}
```

<h3 id="update-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|storeId|path|integer(int32)|true|none|
|body|body|[Store](#schemastore)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="update-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## deleteById

<a id="opIddeleteById"></a>

> Code samples

```http
DELETE http://localhost:8080/stores/{storeId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/stores/{storeId}',
{
  method: 'DELETE',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.delete('http://localhost:8080/stores/{storeId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/stores/{storeId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`DELETE /stores/{storeId}`

<h3 id="deletebyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|storeId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="deletebyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## find

<a id="opIdfind"></a>

> Code samples

```http
GET http://localhost:8080/stores HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/stores',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/stores', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/stores");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /stores`

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="find-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## save

<a id="opIdsave"></a>

> Code samples

```http
POST http://localhost:8080/stores HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "name": "string",
  "city": "string",
  "location": "string",
  "openDate": "2019-08-24T14:15:22Z",
  "active": true
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/stores',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.post('http://localhost:8080/stores', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/stores");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /stores`

> Body parameter

```json
{
  "id": 0,
  "name": "string",
  "city": "string",
  "location": "string",
  "openDate": "2019-08-24T14:15:22Z",
  "active": true
}
```

<h3 id="save-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Store](#schemastore)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="save-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## findSales

<a id="opIdfindSales"></a>

> Code samples

```http
GET http://localhost:8080/stores/{storeId}/sales HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/stores/{storeId}/sales',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/stores/{storeId}/sales', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/stores/{storeId}/sales");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /stores/{storeId}/sales`

<h3 id="findsales-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|storeId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findsales-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## findRevenue

<a id="opIdfindRevenue"></a>

> Code samples

```http
GET http://localhost:8080/stores/{storeId}/revenue HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/stores/{storeId}/revenue',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/stores/{storeId}/revenue', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/stores/{storeId}/revenue");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /stores/{storeId}/revenue`

<h3 id="findrevenue-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|storeId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findrevenue-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## findEmployees

<a id="opIdfindEmployees"></a>

> Code samples

```http
GET http://localhost:8080/stores/{storeId}/employees HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/stores/{storeId}/employees',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/stores/{storeId}/employees', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/stores/{storeId}/employees");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /stores/{storeId}/employees`

<h3 id="findemployees-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|storeId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findemployees-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-sale-controller">sale-controller</h1>

## find_1

<a id="opIdfind_1"></a>

> Code samples

```http
GET http://localhost:8080/sales HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/sales',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/sales', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/sales");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /sales`

<h3 id="find_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|page|query|integer(int32)|false|none|
|limit|query|integer(int32)|false|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="find_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## update_1

<a id="opIdupdate_1"></a>

> Code samples

```http
PUT http://localhost:8080/sales HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "date": "2019-08-24T14:15:22Z",
  "total": 0.1,
  "employee": {
    "id": 0,
    "firstName": "string",
    "lastName": "string",
    "hireDate": "2019-08-24T14:15:22Z",
    "gender": "string",
    "birthDate": "2019-08-24T14:15:22Z",
    "store": {
      "id": 0,
      "name": "string",
      "city": "string",
      "location": "string",
      "openDate": "2019-08-24T14:15:22Z",
      "active": true
    },
    "active": true
  },
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "invoices": [
    {
      "id": 0,
      "product": {
        "id": 0,
        "name": "string",
        "cost": 0.1,
        "price": 0.1,
        "creationDate": "2019-08-24T14:15:22Z",
        "active": true,
        "category": {
          "id": 0,
          "name": "string",
          "active": true
        }
      },
      "quantity": 0,
      "subtotal": 0.1,
      "discount": 0,
      "status": true
    }
  ]
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/sales',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.put('http://localhost:8080/sales', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/sales");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /sales`

> Body parameter

```json
{
  "id": 0,
  "date": "2019-08-24T14:15:22Z",
  "total": 0.1,
  "employee": {
    "id": 0,
    "firstName": "string",
    "lastName": "string",
    "hireDate": "2019-08-24T14:15:22Z",
    "gender": "string",
    "birthDate": "2019-08-24T14:15:22Z",
    "store": {
      "id": 0,
      "name": "string",
      "city": "string",
      "location": "string",
      "openDate": "2019-08-24T14:15:22Z",
      "active": true
    },
    "active": true
  },
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "invoices": [
    {
      "id": 0,
      "product": {
        "id": 0,
        "name": "string",
        "cost": 0.1,
        "price": 0.1,
        "creationDate": "2019-08-24T14:15:22Z",
        "active": true,
        "category": {
          "id": 0,
          "name": "string",
          "active": true
        }
      },
      "quantity": 0,
      "subtotal": 0.1,
      "discount": 0,
      "status": true
    }
  ]
}
```

<h3 id="update_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Sale](#schemasale)|true|none|

> Example responses

> 200 Response

```json
{
  "id": 0,
  "date": "2019-08-24T14:15:22Z",
  "total": 0.1,
  "employee": {
    "id": 0,
    "firstName": "string",
    "lastName": "string",
    "hireDate": "2019-08-24T14:15:22Z",
    "gender": "string",
    "birthDate": "2019-08-24T14:15:22Z",
    "store": {
      "id": 0,
      "name": "string",
      "city": "string",
      "location": "string",
      "openDate": "2019-08-24T14:15:22Z",
      "active": true
    },
    "active": true
  },
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "invoices": [
    {
      "id": 0,
      "product": {
        "id": 0,
        "name": "string",
        "cost": 0.1,
        "price": 0.1,
        "creationDate": "2019-08-24T14:15:22Z",
        "active": true,
        "category": {
          "id": 0,
          "name": "string",
          "active": true
        }
      },
      "quantity": 0,
      "subtotal": 0.1,
      "discount": 0,
      "status": true
    }
  ]
}
```

<h3 id="update_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[Sale](#schemasale)|

<aside class="success">
This operation does not require authentication
</aside>

## save_1

<a id="opIdsave_1"></a>

> Code samples

```http
POST http://localhost:8080/sales HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "employeeId": 0,
  "storeId": 0,
  "productQuantity": [
    {
      "productId": 0,
      "quantity": 0,
      "discount": 0
    }
  ]
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/sales',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.post('http://localhost:8080/sales', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/sales");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /sales`

> Body parameter

```json
{
  "employeeId": 0,
  "storeId": 0,
  "productQuantity": [
    {
      "productId": 0,
      "quantity": 0,
      "discount": 0
    }
  ]
}
```

<h3 id="save_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[SaleDto](#schemasaledto)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="save_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## findById_1

<a id="opIdfindById_1"></a>

> Code samples

```http
GET http://localhost:8080/sales/{saleId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/sales/{saleId}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/sales/{saleId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/sales/{saleId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /sales/{saleId}`

<h3 id="findbyid_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|saleId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findbyid_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-product-controller">product-controller</h1>

## findById_2

<a id="opIdfindById_2"></a>

> Code samples

```http
GET http://localhost:8080/products/{productId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/products/{productId}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/products/{productId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products/{productId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /products/{productId}`

<h3 id="findbyid_2-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|productId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findbyid_2-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## update_2

<a id="opIdupdate_2"></a>

> Code samples

```http
PUT http://localhost:8080/products/{productId} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "name": "string",
  "cost": 0.1,
  "price": 0.1,
  "creationDate": "2019-08-24T14:15:22Z",
  "active": true,
  "category": {
    "id": 0,
    "name": "string",
    "active": true
  }
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/products/{productId}',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.put('http://localhost:8080/products/{productId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products/{productId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /products/{productId}`

> Body parameter

```json
{
  "id": 0,
  "name": "string",
  "cost": 0.1,
  "price": 0.1,
  "creationDate": "2019-08-24T14:15:22Z",
  "active": true,
  "category": {
    "id": 0,
    "name": "string",
    "active": true
  }
}
```

<h3 id="update_2-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|productId|path|integer(int32)|true|none|
|body|body|[Product](#schemaproduct)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="update_2-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## deleteById_1

<a id="opIddeleteById_1"></a>

> Code samples

```http
DELETE http://localhost:8080/products/{productId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/products/{productId}',
{
  method: 'DELETE',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.delete('http://localhost:8080/products/{productId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products/{productId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`DELETE /products/{productId}`

<h3 id="deletebyid_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|productId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="deletebyid_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## updatePriceCost

<a id="opIdupdatePriceCost"></a>

> Code samples

```http
PATCH http://localhost:8080/products/{productId} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "name": "string",
  "cost": 0.1,
  "price": 0.1,
  "creationDate": "2019-08-24T14:15:22Z",
  "active": true,
  "category": {
    "id": 0,
    "name": "string",
    "active": true
  }
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/products/{productId}',
{
  method: 'PATCH',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.patch('http://localhost:8080/products/{productId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products/{productId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PATCH");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PATCH /products/{productId}`

> Body parameter

```json
{
  "id": 0,
  "name": "string",
  "cost": 0.1,
  "price": 0.1,
  "creationDate": "2019-08-24T14:15:22Z",
  "active": true,
  "category": {
    "id": 0,
    "name": "string",
    "active": true
  }
}
```

<h3 id="updatepricecost-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|productId|path|integer(int32)|true|none|
|body|body|[Product](#schemaproduct)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="updatepricecost-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## bulkCostPriceUpdate

<a id="opIdbulkCostPriceUpdate"></a>

> Code samples

```http
PUT http://localhost:8080/products/bulk-update HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "csvFile": "string"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/products/bulk-update',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.put('http://localhost:8080/products/bulk-update', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products/bulk-update");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /products/bulk-update`

> Body parameter

```json
{
  "csvFile": "string"
}
```

<h3 id="bulkcostpriceupdate-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|object|false|none|
|» csvFile|body|string(binary)|true|none|

> Example responses

> 200 Response

```json
{}
```

<h3 id="bulkcostpriceupdate-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="bulkcostpriceupdate-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## find_2

<a id="opIdfind_2"></a>

> Code samples

```http
GET http://localhost:8080/products HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/products',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/products', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /products`

<h3 id="find_2-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|active|query|boolean|false|none|
|page|query|integer(int32)|false|none|
|limit|query|integer(int32)|false|none|
|name|query|string|false|none|
|category|query|string|false|none|
|low|query|integer(int32)|false|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="find_2-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## create

<a id="opIdcreate"></a>

> Code samples

```http
POST http://localhost:8080/products HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "name": "string",
  "cost": 0.1,
  "price": 0.1,
  "creationDate": "2019-08-24T14:15:22Z",
  "active": true,
  "category": {
    "id": 0,
    "name": "string",
    "active": true
  }
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/products',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.post('http://localhost:8080/products', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /products`

> Body parameter

```json
{
  "id": 0,
  "name": "string",
  "cost": 0.1,
  "price": 0.1,
  "creationDate": "2019-08-24T14:15:22Z",
  "active": true,
  "category": {
    "id": 0,
    "name": "string",
    "active": true
  }
}
```

<h3 id="create-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Product](#schemaproduct)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="create-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## getSales

<a id="opIdgetSales"></a>

> Code samples

```http
GET http://localhost:8080/products/{productId}/sales HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/products/{productId}/sales',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/products/{productId}/sales', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products/{productId}/sales");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /products/{productId}/sales`

<h3 id="getsales-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|productId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="getsales-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## getInventory

<a id="opIdgetInventory"></a>

> Code samples

```http
GET http://localhost:8080/products/{productId}/inventory HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/products/{productId}/inventory',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/products/{productId}/inventory', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products/{productId}/inventory");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /products/{productId}/inventory`

<h3 id="getinventory-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|productId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{}
```

<h3 id="getinventory-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getinventory-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getBestSellers

<a id="opIdgetBestSellers"></a>

> Code samples

```http
GET http://localhost:8080/products/best-sellers HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/products/best-sellers',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/products/best-sellers', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/products/best-sellers");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /products/best-sellers`

<h3 id="getbestsellers-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|category|query|string|false|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="getbestsellers-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-employee-controller">employee-controller</h1>

## findById_3

<a id="opIdfindById_3"></a>

> Code samples

```http
GET http://localhost:8080/employees/{employeeId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/employees/{employeeId}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/employees/{employeeId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/employees/{employeeId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /employees/{employeeId}`

<h3 id="findbyid_3-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|employeeId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findbyid_3-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## update_3

<a id="opIdupdate_3"></a>

> Code samples

```http
PUT http://localhost:8080/employees/{employeeId} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "firstName": "string",
  "lastName": "string",
  "hireDate": "2019-08-24T14:15:22Z",
  "gender": "string",
  "birthDate": "2019-08-24T14:15:22Z",
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "active": true
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/employees/{employeeId}',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.put('http://localhost:8080/employees/{employeeId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/employees/{employeeId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /employees/{employeeId}`

> Body parameter

```json
{
  "id": 0,
  "firstName": "string",
  "lastName": "string",
  "hireDate": "2019-08-24T14:15:22Z",
  "gender": "string",
  "birthDate": "2019-08-24T14:15:22Z",
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "active": true
}
```

<h3 id="update_3-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|employeeId|path|integer(int32)|true|none|
|body|body|[Employee](#schemaemployee)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="update_3-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## deleteById_2

<a id="opIddeleteById_2"></a>

> Code samples

```http
DELETE http://localhost:8080/employees/{employeeId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/employees/{employeeId}',
{
  method: 'DELETE',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.delete('http://localhost:8080/employees/{employeeId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/employees/{employeeId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`DELETE /employees/{employeeId}`

<h3 id="deletebyid_2-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|employeeId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="deletebyid_2-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## patch

<a id="opIdpatch"></a>

> Code samples

```http
PATCH http://localhost:8080/employees/{employeeId} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "firstName": "string",
  "lastName": "string",
  "hireDate": "2019-08-24T14:15:22Z",
  "gender": "string",
  "birthDate": "2019-08-24T14:15:22Z",
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "active": true
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/employees/{employeeId}',
{
  method: 'PATCH',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.patch('http://localhost:8080/employees/{employeeId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/employees/{employeeId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PATCH");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PATCH /employees/{employeeId}`

> Body parameter

```json
{
  "id": 0,
  "firstName": "string",
  "lastName": "string",
  "hireDate": "2019-08-24T14:15:22Z",
  "gender": "string",
  "birthDate": "2019-08-24T14:15:22Z",
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "active": true
}
```

<h3 id="patch-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|employeeId|path|integer(int32)|true|none|
|body|body|[Employee](#schemaemployee)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="patch-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## find_3

<a id="opIdfind_3"></a>

> Code samples

```http
GET http://localhost:8080/employees HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/employees',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/employees', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/employees");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /employees`

<h3 id="find_3-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|page|query|integer(int32)|false|none|
|limit|query|integer(int32)|false|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="find_3-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## save_2

<a id="opIdsave_2"></a>

> Code samples

```http
POST http://localhost:8080/employees HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "firstName": "string",
  "lastName": "string",
  "hireDate": "2019-08-24T14:15:22Z",
  "gender": "string",
  "birthDate": "2019-08-24T14:15:22Z",
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "active": true
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/employees',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.post('http://localhost:8080/employees', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/employees");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /employees`

> Body parameter

```json
{
  "id": 0,
  "firstName": "string",
  "lastName": "string",
  "hireDate": "2019-08-24T14:15:22Z",
  "gender": "string",
  "birthDate": "2019-08-24T14:15:22Z",
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "active": true
}
```

<h3 id="save_2-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Employee](#schemaemployee)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="save_2-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## findSales_1

<a id="opIdfindSales_1"></a>

> Code samples

```http
GET http://localhost:8080/employees/{employeeId}/sales HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/employees/{employeeId}/sales',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/employees/{employeeId}/sales', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/employees/{employeeId}/sales");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /employees/{employeeId}/sales`

<h3 id="findsales_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|employeeId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findsales_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-category-controller">category-controller</h1>

## findById_4

<a id="opIdfindById_4"></a>

> Code samples

```http
GET http://localhost:8080/categories/{categoryId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/categories/{categoryId}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/categories/{categoryId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/categories/{categoryId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /categories/{categoryId}`

*Retrieves a category by its ID*

<h3 id="findbyid_4-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|categoryId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findbyid_4-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## update_4

<a id="opIdupdate_4"></a>

> Code samples

```http
PUT http://localhost:8080/categories/{categoryId}?arg1=id,0,name,string,active,true HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/categories/{categoryId}?arg1=id,0,name,string,active,true',
{
  method: 'PUT',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.put('http://localhost:8080/categories/{categoryId}', params={
  'arg1': {
  "id": 0,
  "name": "string",
  "active": true
}
}, headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/categories/{categoryId}?arg1=id,0,name,string,active,true");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /categories/{categoryId}`

*Updates a category with the given category ID*

<h3 id="update_4-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|categoryId|path|integer(int32)|true|none|
|arg1|query|[Category](#schemacategory)|true|none|

> Example responses

> 200 Response

```json
{}
```

<h3 id="update_4-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="update_4-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## deleteById_3

<a id="opIddeleteById_3"></a>

> Code samples

```http
DELETE http://localhost:8080/categories/{categoryId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/categories/{categoryId}',
{
  method: 'DELETE',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.delete('http://localhost:8080/categories/{categoryId}', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/categories/{categoryId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`DELETE /categories/{categoryId}`

*Deletes a category by its ID*

<h3 id="deletebyid_3-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|categoryId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="deletebyid_3-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## patch_1

<a id="opIdpatch_1"></a>

> Code samples

```http
PATCH http://localhost:8080/categories/{categoryId}?arg1=id,0,name,string,active,true HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/categories/{categoryId}?arg1=id,0,name,string,active,true',
{
  method: 'PATCH',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.patch('http://localhost:8080/categories/{categoryId}', params={
  'arg1': {
  "id": 0,
  "name": "string",
  "active": true
}
}, headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/categories/{categoryId}?arg1=id,0,name,string,active,true");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PATCH");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PATCH /categories/{categoryId}`

*Updates a category with the specified ID using the PATCH method*

<h3 id="patch_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|categoryId|path|integer(int32)|true|none|
|arg1|query|[Category](#schemacategory)|true|none|

> Example responses

> 200 Response

```json
{}
```

<h3 id="patch_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="patch_1-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## find_4

<a id="opIdfind_4"></a>

> Code samples

```http
GET http://localhost:8080/categories HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/categories',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/categories', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/categories");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /categories`

*Retrieves a list of categories*

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="find_4-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## save_3

<a id="opIdsave_3"></a>

> Code samples

```http
POST http://localhost:8080/categories HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "id": 0,
  "name": "string",
  "active": true
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/categories',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.post('http://localhost:8080/categories', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/categories");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /categories`

*Saves a category*

> Body parameter

```json
{
  "id": 0,
  "name": "string",
  "active": true
}
```

<h3 id="save_3-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Category](#schemacategory)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="save_3-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## findProducts

<a id="opIdfindProducts"></a>

> Code samples

```http
GET http://localhost:8080/categories/{categoryId}/products HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/categories/{categoryId}/products',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/categories/{categoryId}/products', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/categories/{categoryId}/products");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /categories/{categoryId}/products`

*Retrieves the products associated with a given category*

<h3 id="findproducts-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|categoryId|path|integer(int32)|true|none|

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="findproducts-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-analitics-controller">analitics-controller</h1>

## getTotalSales

<a id="opIdgetTotalSales"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-total-sales HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-total-sales',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-total-sales', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-total-sales");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-total-sales`

> Example responses

> 200 Response

```json
{}
```

<h3 id="gettotalsales-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="gettotalsales-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getTotalRevenue

<a id="opIdgetTotalRevenue"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-total-revenue HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-total-revenue',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-total-revenue', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-total-revenue");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-total-revenue`

> Example responses

> 200 Response

```json
{}
```

<h3 id="gettotalrevenue-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="gettotalrevenue-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getTotalItemsSold

<a id="opIdgetTotalItemsSold"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-total-items-sold HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-total-items-sold',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-total-items-sold', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-total-items-sold");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-total-items-sold`

> Example responses

> 200 Response

```json
{}
```

<h3 id="gettotalitemssold-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="gettotalitemssold-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getTotalEmployees

<a id="opIdgetTotalEmployees"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-total-employees HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-total-employees',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-total-employees', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-total-employees");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-total-employees`

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="gettotalemployees-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## getTotalActiveProducts

<a id="opIdgetTotalActiveProducts"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-total-active-products HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-total-active-products',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-total-active-products', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-total-active-products");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-total-active-products`

> Example responses

> 200 Response

```json
{}
```

<h3 id="gettotalactiveproducts-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="gettotalactiveproducts-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getStores

<a id="opIdgetStores"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-stores HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-stores',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-stores', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-stores");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-stores`

> Example responses

> 200 Response

```json
{}
```

<h3 id="getstores-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getstores-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getStock

<a id="opIdgetStock"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-stock HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-stock',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-stock', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-stock");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-stock`

<h3 id="getstock-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|low|query|integer(int32)|false|none|

> Example responses

> 200 Response

```json
{}
```

<h3 id="getstock-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getstock-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getRevenueByStore

<a id="opIdgetRevenueByStore"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-revenue-per-store HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-revenue-per-store',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-revenue-per-store', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-revenue-per-store");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-revenue-per-store`

> Example responses

> 200 Response

```json
{}
```

<h3 id="getrevenuebystore-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getrevenuebystore-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getMostSoldCategories

<a id="opIdgetMostSoldCategories"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-most-sold-categories HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-most-sold-categories',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-most-sold-categories', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-most-sold-categories");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-most-sold-categories`

> Example responses

> 200 Response

```json
{}
```

<h3 id="getmostsoldcategories-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getmostsoldcategories-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getLastInvoices

<a id="opIdgetLastInvoices"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-last-invoices HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-last-invoices',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-last-invoices', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-last-invoices");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-last-invoices`

<h3 id="getlastinvoices-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|limit|query|integer(int32)|false|none|

> Example responses

> 200 Response

```json
{}
```

<h3 id="getlastinvoices-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getlastinvoices-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## getEmployeesWithMostSales

<a id="opIdgetEmployeesWithMostSales"></a>

> Code samples

```http
GET http://localhost:8080/analitics/get-employees-with-most-sales HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/get-employees-with-most-sales',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/get-employees-with-most-sales', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/get-employees-with-most-sales");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/get-employees-with-most-sales`

> Example responses

> 200 Response

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}
```

<h3 id="getemployeeswithmostsales-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[CustomApiResponse](#schemacustomapiresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## getBestSellingProducts

<a id="opIdgetBestSellingProducts"></a>

> Code samples

```http
GET http://localhost:8080/analitics/best-selling-products HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/analitics/best-selling-products',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/analitics/best-selling-products', headers = headers)

print(r.json())

```

```java
URL obj = new URL("http://localhost:8080/analitics/best-selling-products");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /analitics/best-selling-products`

> Example responses

> 200 Response

```json
{}
```

<h3 id="getbestsellingproducts-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getbestsellingproducts-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

# Schemas

<h2 id="tocS_Store">Store</h2>
<!-- backwards compatibility -->
<a id="schemastore"></a>
<a id="schema_Store"></a>
<a id="tocSstore"></a>
<a id="tocsstore"></a>

```json
{
  "id": 0,
  "name": "string",
  "city": "string",
  "location": "string",
  "openDate": "2019-08-24T14:15:22Z",
  "active": true
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|name|string|false|none|none|
|city|string|false|none|none|
|location|string|false|none|none|
|openDate|string(date-time)|false|none|none|
|active|boolean|false|none|none|

<h2 id="tocS_CustomApiResponse">CustomApiResponse</h2>
<!-- backwards compatibility -->
<a id="schemacustomapiresponse"></a>
<a id="schema_CustomApiResponse"></a>
<a id="tocScustomapiresponse"></a>
<a id="tocscustomapiresponse"></a>

```json
{
  "status": "string",
  "code": 0,
  "message": "string",
  "data": {}
}

```

Standard response format for API requests.

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|status|string|false|none|The status of the response, typically 'success' or 'error'.|
|code|integer(int32)|false|none|The HTTP status code associated with the response.|
|message|string|false|none|A message providing additional information about the response.|
|data|object|false|none|none|

<h2 id="tocS_Category">Category</h2>
<!-- backwards compatibility -->
<a id="schemacategory"></a>
<a id="schema_Category"></a>
<a id="tocScategory"></a>
<a id="tocscategory"></a>

```json
{
  "id": 0,
  "name": "string",
  "active": true
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|name|string|false|none|none|
|active|boolean|false|none|none|

<h2 id="tocS_Employee">Employee</h2>
<!-- backwards compatibility -->
<a id="schemaemployee"></a>
<a id="schema_Employee"></a>
<a id="tocSemployee"></a>
<a id="tocsemployee"></a>

```json
{
  "id": 0,
  "firstName": "string",
  "lastName": "string",
  "hireDate": "2019-08-24T14:15:22Z",
  "gender": "string",
  "birthDate": "2019-08-24T14:15:22Z",
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "active": true
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|firstName|string|false|none|none|
|lastName|string|false|none|none|
|hireDate|string(date-time)|false|none|none|
|gender|string|false|none|none|
|birthDate|string(date-time)|false|none|none|
|store|[Store](#schemastore)|false|none|none|
|active|boolean|false|none|none|

<h2 id="tocS_Invoice">Invoice</h2>
<!-- backwards compatibility -->
<a id="schemainvoice"></a>
<a id="schema_Invoice"></a>
<a id="tocSinvoice"></a>
<a id="tocsinvoice"></a>

```json
{
  "id": 0,
  "product": {
    "id": 0,
    "name": "string",
    "cost": 0.1,
    "price": 0.1,
    "creationDate": "2019-08-24T14:15:22Z",
    "active": true,
    "category": {
      "id": 0,
      "name": "string",
      "active": true
    }
  },
  "quantity": 0,
  "subtotal": 0.1,
  "discount": 0,
  "status": true
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int64)|false|none|none|
|product|[Product](#schemaproduct)|false|none|none|
|quantity|integer(int32)|false|none|none|
|subtotal|number(double)|false|none|none|
|discount|integer(int32)|false|none|none|
|status|boolean|false|none|none|

<h2 id="tocS_Product">Product</h2>
<!-- backwards compatibility -->
<a id="schemaproduct"></a>
<a id="schema_Product"></a>
<a id="tocSproduct"></a>
<a id="tocsproduct"></a>

```json
{
  "id": 0,
  "name": "string",
  "cost": 0.1,
  "price": 0.1,
  "creationDate": "2019-08-24T14:15:22Z",
  "active": true,
  "category": {
    "id": 0,
    "name": "string",
    "active": true
  }
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|name|string|false|none|none|
|cost|number(double)|false|none|none|
|price|number(double)|false|none|none|
|creationDate|string(date-time)|false|none|none|
|active|boolean|false|none|none|
|category|[Category](#schemacategory)|false|none|none|

<h2 id="tocS_Sale">Sale</h2>
<!-- backwards compatibility -->
<a id="schemasale"></a>
<a id="schema_Sale"></a>
<a id="tocSsale"></a>
<a id="tocssale"></a>

```json
{
  "id": 0,
  "date": "2019-08-24T14:15:22Z",
  "total": 0.1,
  "employee": {
    "id": 0,
    "firstName": "string",
    "lastName": "string",
    "hireDate": "2019-08-24T14:15:22Z",
    "gender": "string",
    "birthDate": "2019-08-24T14:15:22Z",
    "store": {
      "id": 0,
      "name": "string",
      "city": "string",
      "location": "string",
      "openDate": "2019-08-24T14:15:22Z",
      "active": true
    },
    "active": true
  },
  "store": {
    "id": 0,
    "name": "string",
    "city": "string",
    "location": "string",
    "openDate": "2019-08-24T14:15:22Z",
    "active": true
  },
  "invoices": [
    {
      "id": 0,
      "product": {
        "id": 0,
        "name": "string",
        "cost": 0.1,
        "price": 0.1,
        "creationDate": "2019-08-24T14:15:22Z",
        "active": true,
        "category": {
          "id": 0,
          "name": "string",
          "active": true
        }
      },
      "quantity": 0,
      "subtotal": 0.1,
      "discount": 0,
      "status": true
    }
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|date|string(date-time)|false|none|none|
|total|number(double)|false|none|none|
|employee|[Employee](#schemaemployee)|false|none|none|
|store|[Store](#schemastore)|false|none|none|
|invoices|[[Invoice](#schemainvoice)]|false|none|none|

<h2 id="tocS_ProductQuantity">ProductQuantity</h2>
<!-- backwards compatibility -->
<a id="schemaproductquantity"></a>
<a id="schema_ProductQuantity"></a>
<a id="tocSproductquantity"></a>
<a id="tocsproductquantity"></a>

```json
{
  "productId": 0,
  "quantity": 0,
  "discount": 0
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|productId|integer(int32)|false|none|none|
|quantity|integer(int32)|false|none|none|
|discount|integer(int32)|false|none|none|

<h2 id="tocS_SaleDto">SaleDto</h2>
<!-- backwards compatibility -->
<a id="schemasaledto"></a>
<a id="schema_SaleDto"></a>
<a id="tocSsaledto"></a>
<a id="tocssaledto"></a>

```json
{
  "employeeId": 0,
  "storeId": 0,
  "productQuantity": [
    {
      "productId": 0,
      "quantity": 0,
      "discount": 0
    }
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|employeeId|integer(int32)|false|none|none|
|storeId|integer(int32)|false|none|none|
|productQuantity|[[ProductQuantity](#schemaproductquantity)]|false|none|none|

