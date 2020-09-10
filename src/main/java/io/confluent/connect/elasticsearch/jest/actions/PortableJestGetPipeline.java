/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.connect.elasticsearch.jest.actions;

import io.searchbox.action.GenericResultAbstractAction;
import io.searchbox.client.config.ElasticsearchVersion;

public class PortableJestGetPipeline extends GenericResultAbstractAction {

  private String pipeline;

  public PortableJestGetPipeline(String pipeline) {
    this.pipeline = pipeline;
  }

  @Override
  public String getRestMethodName() {
    return "GET";
  }

  @Override
  protected String buildURI(ElasticsearchVersion elasticsearchVersion) {
    return String.format(
        "%s/_ingest/pipeline/%s",
        super.buildURI(elasticsearchVersion),
        pipeline
    );
  }
}
