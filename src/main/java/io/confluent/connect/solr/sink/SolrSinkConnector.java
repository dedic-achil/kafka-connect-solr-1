/**
 * Copyright (C) 2016 Jeremy Custenborder (jcustenborder@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.confluent.connect.solr.sink;

import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class SolrSinkConnector extends SinkConnector {

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }

  Map<String, String> config;

  @Override
  public void start(Map<String, String> map) {
    this.config = map;
  }

  @Override
  public List<Map<String, String>> taskConfigs(int count) {
    List<Map<String, String>> results = new ArrayList<>();

    for(int i=0;i<count;i++){
      results.add(config);
    }

    return results;
  }

  @Override
  public void stop() {

  }
}
