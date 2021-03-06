# Reservation Service
> GET /reservation/availableSearch?checkin=2017-01-01&checkout=2017-01-02&adults=1&children=0
```
Response
{
    "roomType": 1,
    "total": 1
}
```
> GET /reservation/{reservationId}
```
Header
authenticate-token: 324sdf324jj3kn23kj
```
```
Response
{
    "id": 1,
    "checkIn" '2017-01-01',
    "checkOut": '2017-01-02',
    "total": 2,
    "roomType": 1,
    "status": "waiting|completed|cancel",
    "customer": {
        "titleName": "Mr.",
        "fullName": "Abc Def",
        "email": "example@example.com",
        "tel": "0123456789",
        "country": "Thailand",
        "nation": "Thai"
    }
}
```
> POST /reservation/add
```
Request JSON
{
    "checkIn": "2017-01-01",
    "checkOut": "2017-01-12",
    "adults": 1,
    "children": 1,
    "roomType": 2,
    "customer": {
	  	"titleName": "Mr.",
	  	"fullName": "Adisorn Sripakpaisit",
	  	"email": "example@example.com",
	  	"tel": "0890938473",
	  	"country": "Thailand",
	  	"nation": "Thai"
	},
    "creditCard": {
	  	"number": "1234567890",
		"holderName": "Adisorn Sripakpaisit"
		"type": "Visa",
	  	"expiredDate": "2018-01-01",
	  	"cvc": "1234"
	}
}
```
```
Response 
{
    "id": 1,
    "message": "Success"
}
```
> PUT /reservation/{reservationId}/confirm?id=123wwdw22dsfsea
```
Response
{
    "id": 1,
    "message": "Success"
}
```
> PUT /reservation/{reservationId}/cancel?id=123wwdw22dsfsea
```
Response
{
    "id": 1,
    "message": "Success"
}
```
> PUT /reservation/{reservationId}/partialCheckout
```
Header
authenticate-token: 214153dsfwef
```
```
Response
{
    "id": 1,
    "message": "Success"
}
```
