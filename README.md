# Build

sdk use java 21-open  

./mvnw liberty:dev

http://localhost:9080/jjug-demoapp/api/hello

# Open Liberty 24.0.0.9-beta 用

sdk use java 21-open  

/opt/openliberty/24.0.0.9-beta/wlp/bin/server run Server01

mvn package

cp target/jjugdemo.war /opt/openliberty/24.0.0.9-beta/wlp/usr/servers/Server01/dropins

- MicroProfile OpenAPI 4.0のため、OpenAPI v3.1 documents をデフォルトで作成してくれる。なお前のバージョンだとv3.0となっている。
http://localhost:9080/openapi/ui/

- 参考

| 特徴                          | v3.0                               | v3.1                               |
| ----------------------------- | ---------------------------------- | ---------------------------------- |
| **JSON Schema**               | 独自拡張, Draft 04 ベース          | 完全互換, Draft 2020-12            |
| **Nullable**                  | `nullable` プロパティ              | `["type", "null"]` で対応          |
| **HTTP ステータスコード範囲** | 個別のステータスコードのみ         | `2XX`, `4XX` など範囲での指定可能  |
| **セキュリティスキーム**      | OAuth 2.0 や OpenID Connect に対応 | OAuth 2.0 と OpenID Connect の改善 |
| **Examples**                  | `example` と `examples` の使い分け | 一貫した仕様に統一                 |
| **format キーワード**         | 補助的であり必須ではない           | より厳密なバリデーション           |
| **Webhooks**                  | 非公式のサポート                   | 正式サポート                       |
| **URL エンコーディング**      | 暗黙の動作                         | より明確な制御が可能               |

http://localhost:9080/jjugdemo/api/hello

http://localhost:9080/jjugdemo/api/metric/timed
ロジックの実行時間をバラバラに実行する処理。

http://localhost:9080/jjugdemo/api/metric/increment
これでメトリクスが増える.MetricController.java

http://localhost:9080/metrics/  
増えたやつはここで確認できる
例：
> # HELP com_example_jjugdemo_metric_MetricController_endpoint_counter_total  
> # TYPE com_example_jjugdemo_metric_MetricController_endpoint_counter_total counter
> com_example_jjugdemo_metric_MetricController_endpoint_counter_total{mp_scope="application",} 15.0

処理時間のメトリクスはここで確認できる

> # TYPE http_server_request_duration_seconds_max gauge
> http_server_request_duration_seconds_max{error_type="",http_request_method="GET",http_response_status_code="200",http_route="/jjugdemo/api/hello",mp_scope="vendor",network_protocol_name="HTTP",network_protocol_version="1.1",server_address="localhost",server_port="9080",url_scheme="http",} 0.020718083
> http_server_request_duration_seconds_max{error_type="",http_request_method="GET",http_response_status_code="200",http_route="/jjugdemo/api/metric/timed",mp_scope="vendor",network_protocol_name="HTTP",network_protocol_version="1.1",server_address="localhost",server_port="9080",url_scheme="http",} 0.993685708
> http_server_request_duration_seconds_max{error_type="",http_request_method="GET",http_response_status_code="200",http_route="/openapi/ui/",mp_scope="vendor",network_protocol_name="HTTP",network_protocol_version="1.1",server_address="localhost",server_port="9080",url_scheme="http",} 0.0
> http_server_request_duration_seconds_max{error_type="",http_request_method="GET",http_response_status_code="404",http_route="/jjug-demoapp/api/metric/timed",mp_scope="vendor",network_protocol_name="HTTP",network_protocol_version="1.1",server_address="localhost",server_port="9080",url_scheme="http",} 0.0
> http_server_request_duration_seconds_max{error_type="",http_request_method="GET",http_response_status_code="200",http_route="/jjugdemo/api/metric/increment",mp_scope="vendor",network_protocol_name="HTTP",network_protocol_version="1.1",server_address="localhost",server_port="9080",url_scheme="http",} 0.043827042
> http_server_request_duration_seconds_max{error_type="",http_request_method="GET",http_response_status_code="404",http_route="/jjugdemoapp/api/metric/timed",mp_scope="vendor",network_protocol_name="HTTP",network_protocol_version="1.1",server_address="localhost",server_port="9080",url_scheme="http",} 0.0