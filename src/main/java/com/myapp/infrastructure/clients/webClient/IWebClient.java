package com.myapp.infrastructure.clients.webClient;

import java.util.List;

public interface IWebClient {

    List<String> getDataFromExternalApi(String url /*HttpMethod method, Headers, RequestBody*/);
}
