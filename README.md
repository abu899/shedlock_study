# Shedlock

- 분산 스케쥴러가 아닌 단순 Lock
- 병렬로 실행될 준비가 되지 않았지만 안전하게 반복적으로 실행하는 스케쥴러를 대상
- Lock은 시간 기반

## Annotation

### @EnableSchedulerLock

- 스케쥴 잠금을 활성화하기 위한 어노테이션
- SchedulerLock들의 디폴트 시간 설정 가능

### @SchedulerLock

- Lock을 실행할 스케쥴러에 사용하는 어노테이션
- 옵션
  - name
    - Lock의 이름
    - 다른 Lock들과 중복되지 않는 값으로 설정
    - 동일한 name을 가진 스케쥴링이 한번만 동작
  - lockAtMostFor
    - Lock이 유지될 최대 시간
    - 일반적으로 스케쥴러가 실행되는데 소모되는 시간보다 길게 설정
    - 스케쥴링 작업이 문제가 발생하여 종료되지 않을 때를 대비하여 Lock을 해제하는 시간
  - lockAtLeastFor
    - Lock이 유지될 최소 시간
    - 스케쥴링 작업이 매우 빠르게 종료되는 작업인 경우 중복실행을 막기 위한 최소 Lock 유지 시간

## Lock Provider

- 잠금을 제공하는데 사용하는 외부 라이브러리
  - Lock 데이터를 저장하고 해당 데이터를 가지고 Lock을 관리
- 실습에서는 JDBC를 사용했으나 Redis, MongoDB, DynamoDB 등 다양한 데이터베이스를 사용 가능
