# spring-boot-mongodb-migration

```shell
curl -X 'POST' \
  'http://localhost:8080/api/employees' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "ID001",
  "firstName": "ITADORI",
  "lastName": "YUJI",
  "email": "yuji@ypmail.com",
  "salary": 150,
  "department": {
    "id": "DP001",
    "code": "DP001",
    "name": "HRD"
  }
}'
```
