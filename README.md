# NBP App Calculator - based on Spring Boot

Requirements: 
- JAVA VERSION 1.8.0_275
- MYSQL (configuration in file db/nbp.sql)

Example API:
- localhost:8080/addValue
JSON Gets with format: 
```
{
	"baseValue": 100,
	"convertFrom": "EUR",
	"convertTo": "HRK"
}
```

## POST (add data) 
```
curl --request POST \
  --url http://localhost:8080/addValue \
  --header 'Content-Type: application/json' \
  --data '{
	"baseValue": 100,
	"convertFrom": "EUR",
	"convertTo": "HRK"
}'
```
API returns id: 
- Example:
```
{
	"id": 24
}
```
## GET (retrive converted data)
```
curl --request GET \
  --url http://localhost:8080/getValue/24 \
  --header 'Content-Type: application/json'
```
API returns converted value
- Example: 
```
{
	"value": 753.14,
	"currency": "HRK"
}
```



