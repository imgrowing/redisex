* docker run -p 6379:6379 --name redis_boot -d redis

* Value command
* key 목록 확인 : keys *
* key/value 저장 : set name hong
* key로 value 조회 : get hong
* key로 삭제 : del hong
* TTL 확인 : ttl

* Hash command
* key 목록 : HKEYS "invoicePoints" *
* value 얻기 : HGET "invoicePoints" "1002"
* HMGET "invoicePoints" "1001" "1002"
