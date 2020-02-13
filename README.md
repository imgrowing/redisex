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
* HGETALL "invoicePoints"

* @RedisHash("students") 사용시
* Sets "students"가 1개 생김
* key가 "a"인 데이터를 1개 추가하면 1레벨에 "students:a" 라는 hash가 1개 생기고, Sets "students"에 "a" 원소가 하나 생긴다. Sets에는 key 값 자체가 원소로 들어가게 된다. value에 해당하는 객체는 1레벨에 hash 형태로 생성된다.
* SMEMBERS "students" 하면 모든 원소(key값)가 조회됨.
 