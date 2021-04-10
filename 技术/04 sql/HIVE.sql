集合数据类型：struct map array

-- 查看表结构
desc table_name;
describe extended table_name;
desc formatted log.fsp_ml_marketing_consumerfinance_pay;  

show partitons table_name partiton(partiton_date='');

## 静态插入
insert overwrite table table_name
partiton (country='us', state = 'or')
select ... ;

## 动态插入
insert overwrite table table_name
partiton (country, state)
select ..., se.cntry, se.st 
from staged_employees se;

cast(0.2 as float)