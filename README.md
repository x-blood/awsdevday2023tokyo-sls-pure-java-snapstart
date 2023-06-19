# awsdevday2023tokyo-sls-pure-java-snapstart

## Result of K6

```
     data_received..................: 1.2 MB 341 kB/s
     data_sent......................: 168 kB 49 kB/s
     http_req_blocked...............: avg=274.23ms min=210.69ms med=264.25ms max=367.18ms p(90)=337.72ms p(95)=344.55ms
     http_req_connecting............: avg=13.54ms  min=7.02ms   med=11.8ms   max=20.69ms  p(90)=19.52ms  p(95)=19.81ms 
     http_req_duration..............: avg=1.6s     min=1.22s    med=1.62s    max=2.11s    p(90)=1.83s    p(95)=1.9s    
       { expected_response:true }...: avg=1.6s     min=1.22s    med=1.62s    max=2.11s    p(90)=1.83s    p(95)=1.9s    
     http_req_failed................: 0.00%  ✓ 0         ✗ 200  
     http_req_receiving.............: avg=169.97µs min=7µs      med=31µs     max=1.36ms   p(90)=748µs    p(95)=1.1ms   
     http_req_sending...............: avg=49.55µs  min=18µs     med=43µs     max=249µs    p(90)=71.2µs   p(95)=91.19µs 
     http_req_tls_handshaking.......: avg=235.72ms min=179.45ms med=227.61ms max=328.9ms  p(90)=297.6ms  p(95)=307.3ms 
     http_req_waiting...............: avg=1.6s     min=1.22s    med=1.62s    max=2.11s    p(90)=1.83s    p(95)=1.9s    
     http_reqs......................: 200    58.346529/s
     iteration_duration.............: avg=2.87s    min=2.5s     med=2.91s    max=3.42s    p(90)=3.08s    p(95)=3.15s   
     iterations.....................: 200    58.346529/s
     vus............................: 69     min=69      max=200
     vus_max........................: 200    min=200     max=200
```

## Result of CloudWatch Logs Insights

```
filter @message like "REPORT"
| filter @message not like "RESTORE_REPORT"
| filter @message like "Restore Duration"
| parse @message "Restore Duration:* ms" as restoreTime
| fields @duration + restoreTime as duration
| stats count(*) as count, pct(duration, 50) as p50, pct(duration, 90) as p90, pct(duration, 99) as p99, max(duration) as max, avg(duration) as avg
```
---
| count | p50      | p90       | p99     | max     | avg      |
|-------|----------|-----------|---------|---------|----------|
| 200   | 970.2578 | 1063.7076 | 1194.47 | 1311.87 | 965.1371 |
---
